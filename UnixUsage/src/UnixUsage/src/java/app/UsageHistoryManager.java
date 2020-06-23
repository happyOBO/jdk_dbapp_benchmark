package app;

/**
 *
 * @author Miftachut Ekasetya
 * 
 */

import java.util.*;
import java.sql.*;
import java.util.StringTokenizer;

//Manager class for all actions related to the Usage History.
public class UsageHistoryManager {

    //private constructor
    private UsageHistoryManager() {

    }

    /**
     * Query 16. Given a unix command and a graduate level, output commands that share the same category
     * with the given command and users at the same graduate level who used these commands.
     * @param command A given Unix command
     * @param graduateLevel A given graduate level. 0 for undergraduate, 1 for graduate
     * @return
     * @throws java.lang.Exception
     */
    public static List<String> getSharedCommandCategory(String command, int graduateLevel) throws Exception {
        return UsageHistoryDAL.getSharedCommandCategory(command, graduateLevel);
    }

    public static int getMaxLineNo(String userId, int sessionId) throws Exception {
        return UsageHistoryDAL.retrieveMaxLineNo(userId, sessionId);
    }

    public static int getMaxSequenceNo(String userId, int sessionId) throws Exception {
        return UsageHistoryDAL.retrieveMaxSequenceNo(userId, sessionId);
    }

    public static boolean isSessionIdValid(int sessionId) {
        if (sessionId >= 0) {
            return true;
        } else {
            throw new IllegalArgumentException("Invalid Session ID. Session ID " +
                    "cannot be negative value.");
        }
    }

    public static List<IUsageHistory> getUsageHistoriesById(String userId) throws Exception {
        return UsageHistoryDAL.retrieveUsageHistoriesById(userId);
    }

    public static boolean isUserIdExist(String userId) throws Exception {
        if (isUserIdFormatValid(userId)) {
            return UsageHistoryDAL.userIdExists(userId);
        } else {
            return false;
        }
    }

    public static boolean isUserIdFormatValid(String userId) throws Exception {
        if (userId == null || userId.length()==0 || userId.equals("")) //check if empty
        {
            throw new IllegalArgumentException("Invalid User ID. User ID " +
                    "cannot be empty or null.");
        } else {
            return true;
        }
    }

    public static boolean isCommandExists(String command) throws Exception {
        if (isCommandFormatValid(command)) {
            return UsageHistoryDAL.commandExists(command);
        } else {
            return false;
        }
    }
   
    public static boolean isCommandFormatValid(String command) {
        if (command == null || command.length()==0 || command.equals("")) {
            throw new IllegalArgumentException("Command cannot be empty or null.");
        } else {
            return true;
        }
    }

    public static boolean addUsageHistory(String userId, int sessionId, String command)
            throws Exception {
        if (isUserIdFormatValid(userId)) //formatting
        {
            //does this id already exist?
            if (isUserIdExist(userId)) //already in the database
            {
                if (isSessionIdValid(sessionId)) //formatting
                {
                    if (isCommandFormatValid(command)) //formatting
                    {
                        int lineNo = (getMaxLineNo(userId, sessionId)) + 1;
                        int commandSeq = (getMaxSequenceNo(userId, sessionId));

                        StringTokenizer st = new StringTokenizer(command.trim()," ");

                        String _command = null;
                        while(st.hasMoreTokens()) {
                            _command = st.nextToken(" ");
                            commandSeq = commandSeq + 1;

                            // assign <1> if command doesn't exist
                            if (!isCommandExists(_command)) {
                                _command = "<1>";
                            }
                            if (!UsageHistoryDAL.insertUsageHistory(userId, sessionId, lineNo, commandSeq, _command)) {
                                //do nothing
                            } else {
                                return false;
                            }        
                        }
                    } 
                } 
            }
            else
                throw new IllegalArgumentException("This user id already exists.");
        }
        return true;
    }

    /**
     * Query 12. Given the department name and a race of the users as inputs, output the most popular
     * commands executed by users who work at that department and belong to this race.
     * @param raceCode The ID of a given race
     * @param deptID The ID of a given department
     * @return Dictionary A dictionary of commands and # of executions
     * @throws java.lang.Exception
     */
    public static Dictionary<String, Integer> GetCmdCountByRaceAndDept(int raceCode, int deptID) throws Exception
    {
        return UsageHistoryDAL.RetrieveCmdCountByRaceAndDept(raceCode, deptID);
    }
    
    ///////////////////
    // Inner class   //
    ///////////////////
    private static class UsageHistoryDAL {

        private static ResultSet res;

        private static Dictionary<String, Integer> RetrieveCmdCountByRaceAndDept(int raceCode, int deptID) throws Exception
        {
            String sql = "SELECT UC.UNIX_COMMAND AS COMMAND, COUNT(UC.UNIX_COMMAND) AS CMD_COUNT FROM USAGE_HISTORY UH "
                         + "INNER JOIN UNIX_COMMAND UC "
                         + "ON UH.COMMAND = UC.UNIX_COMMAND "
                         + "INNER JOIN USER_INFO UI "
                         + "ON UH.USER_ID = UI.USER_ID "
                         + "WHERE UI.RACE = " + raceCode + " "
                         + "AND UI.DEPT_ID = " + deptID + " "
                         + "GROUP BY UC.UNIX_COMMAND "
                         + "ORDER BY COUNT(UC.UNIX_COMMAND) DESC";
            ResultSet rs = DBUtil.executeQuery(sql);
            Dictionary<String, Integer> results = new Hashtable<String, Integer>();
            while(rs.next())
            {
                String command = rs.getString("COMMAND");
                int commandCount = rs.getInt("CMD_COUNT");
                results.put(command, commandCount);
            }
            //close result sets
            rs.close();
            return results;
        }

        private static List<IUsageHistory> retrieveUsageHistoriesById(String userId) throws Exception {
            List<IUsageHistory> usageHistoriesById = new ArrayList<IUsageHistory>();
            res = DBUtil.executeQuery("SELECT * FROM USAGE_HISTORY WHERE USER_ID = '" + userId + "'" +
                    "ORDER BY USER_ID ASC");
            while (res.next()) {
                String _userId = res.getString("USER_ID");
                int sessionId = res.getInt("SESSION_ID");
                int lineNo = res.getInt("LINE_NO");
                int commandSeq = res.getInt("COMMAND_SEQ");
                String command = res.getString("COMMAND");
                usageHistoriesById.add(new UsageHistory(_userId, sessionId, lineNo, commandSeq, command));
            }
            //close the resultset
            res.close();
            
            return usageHistoriesById;
        }

        private static boolean userIdExists(String userId) throws Exception {
            res = DBUtil.executeQuery("SELECT USER_ID FROM USER_INFO WHERE USER_ID = '" + userId + "'");
            String d = null;

            while (res.next()) {
                d = res.getString("USER_ID");
            }

            //close the resultset
            res.close();

            if (d==null) {
                return false;
            } else {
                return true;
            }
        }

        private static boolean commandExists(String command) throws Exception {
            res = DBUtil.executeQuery("SELECT UNIX_COMMAND FROM UNIX_COMMAND WHERE UNIX_COMMAND ='" + command + "'");
            String s = null;

            while (res.next()) {
                s = res.getString("UNIX_COMMAND");
            }

            //close the resultset
            res.close();

            if (s == null) {
                return false;
            }
            return true;
        }

        private static boolean insertUsageHistory(String userId, int sessionId, int lineNo, int commandSeq, String command) throws Exception {
            return DBUtil.execute("INSERT INTO USAGE_HISTORY (USER_ID, SESSION_ID, LINE_NO, COMMAND_SEQ, COMMAND) VALUES ('" + userId + "', " + sessionId + ", " + lineNo + ", " + commandSeq + ", '" + command + "')");
        }

        private static int retrieveMaxLineNo(String userId, int sessionId) throws Exception {
            String SQL = "SELECT MAX(LINE_NO) AS LINE_NO FROM USAGE_HISTORY WHERE USER_ID = '" + userId + "' AND SESSION_ID = " + sessionId;
            res = DBUtil.executeQuery(SQL);

            int _lineNo = 0;
            while(res.next()) {
                _lineNo = res.getInt("LINE_NO");
            }

            //close the resultset
            res.close();

            return _lineNo;
        }

        private static int retrieveMaxSequenceNo(String userId, int sessionId) throws Exception {
            String SQL = "SELECT MAX(COMMAND_SEQ) AS COMMAND_SEQ FROM USAGE_HISTORY WHERE USER_ID = '" + userId + "' AND SESSION_ID = " + sessionId;
            res = DBUtil.executeQuery(SQL);

            int _sequenceNo = 0;
            while(res.next()) {
                _sequenceNo = res.getInt("COMMAND_SEQ");
            }

            //close the resultset
            res.close();

            return _sequenceNo;
        }

        private static List<String> getSharedCommandCategory(String command, int graduateLevel) throws Exception {
            List<String> sharedCommandCategory = new ArrayList<String>();

            String SQL = "SELECT UNIX_COMMAND FROM UNIX_COMMAND " +
                    "WHERE CATEGORY IN (SELECT CATEGORY FROM UNIX_COMMAND " +
                    "WHERE UNIX_COMMAND = '" + command + "') AND " +
                    "UNIX_COMMAND IN (SELECT COMMAND FROM USAGE_HISTORY " +
                    "WHERE USER_ID IN (SELECT USER_ID FROM USER_INFO " +
                    "WHERE GRADUATE = " + graduateLevel + ")) AND UNIX_COMMAND <> '" + command + "' " +
                    "ORDER BY UNIX_COMMAND ASC";

            res = DBUtil.executeQuery(SQL);
            while(res.next()) {
                String _command = res.getString("UNIX_COMMAND");
                sharedCommandCategory.add(_command);
            }

            //close the resultset
            res.close();

            return sharedCommandCategory;   
        }
    }
}
