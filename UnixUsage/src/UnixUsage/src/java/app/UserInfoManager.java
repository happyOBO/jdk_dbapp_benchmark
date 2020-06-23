package app;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Naeem Q.
 */
public class UserInfoManager {
    private UserInfoManager() {}


    /**
     * Adds a new IUserInfo to the database
     * @param myUser IUserInfo Object passed in.
     * @return IUserInfo The added UserInfo Object
     * @throws app.InvalidDataException, Exception
     */
    public static IUserInfo addUserInfo(IUserInfo myUser) throws InvalidDataException, Exception {
        validateUserInfo(myUser,false);
        return UserInfoDAL.addUserInfo(myUser);
    }

    /**
     * Adds a new User
     * @param firstname The user's firstname.
     * @param lastname The users's lastname.
     * @param sex The users's gender.
     * @param departmentId The Deparment ID that the user belongs to.
     * @param officeId The Office Id that the user belongs to.
     * @parm graduate Indicates which graduate level the user belongs to.
     * @param raceId The raceId which the user is belongs to.
     * @param password The user's password.
     * @param yearsUsingUnix The number of years the user has been using Unix.
     * @param enrollDate The user's enroll date.
     * @return IUserInfo The added UserInfo Object
     * @throws app.InvalidDataException, Exception
     */
    public static IUserInfo addUserInfo(String firstname ,String lastname, String sex, int departmentId, int officeId, int graduate, int raceId, String password, int yearsUsingUnix, Date enrollDate) throws InvalidDataException, Exception {
        return addUserInfo(new UserInfo(firstname
                , lastname
                , sex
                , departmentId
                , officeId
                , graduate
                , raceId
                , password
                , yearsUsingUnix
                , enrollDate));
    }

    /**
     * Edits an existing user's information
     * @param myUser IUserInfo Object passed in.
     * @return IUserInfo The edited UserInfo Object
     * @throws app.InvalidDataException, Exception
     */
    public static IUserInfo editUserInfo(IUserInfo myUser) throws InvalidDataException, Exception {
        validateUserInfo(myUser,true);
        return UserInfoDAL.editUserInfo(myUser);
    }

    /**
     * Edits an existing user's information
     * @param userId The user's user id.
     * @param firstname The user's firstname.
     * @param lastname The users's lastname.
     * @param sex The users's gender.
     * @param departmentId The Deparment ID that the user belongs to.
     * @param officeId The Office Id that the user belongs to.
     * @parm graduate Indicates which graduate level the user belongs to.
     * @param raceId The raceId which the user is belongs to.
     * @param password The user's password.
     * @param yearsUsingUnix The number of years the user has been using Unix.
     * @param enrollDate The user's enroll date.
     * @return IUserInfo The edited UserInfo Object
     * @throws app.InvalidDataException, Exception
     */
    public static IUserInfo editUserInfo(String userId, String firstname ,String lastname, String sex, int departmentId, int officeId, int graduate, int raceId, String password, int yearsUsingUnix, Date enrollDate) throws InvalidDataException, Exception {
        return editUserInfo(
                new UserInfo(
                  userId
                , firstname
                , lastname
                , sex
                , departmentId
                , officeId
                , graduate
                , raceId
                , password
                , yearsUsingUnix
                , enrollDate));
    }


    /**
     * Gets an existing user's information from the database
     * @param userId User's ID.
     * @return IUserInfo The user's Info
     * @throws Exception
     */
    public static IUserInfo getUserBy(String userId) throws Exception {
        if (userId == null || userId.trim().equals(""))
            throw new Exception("User Id is empty or null");
        return UserInfoDAL.getUserInfoBy(userId);
    }

    /**
     * Checks to see if a user exists within the database
     * @param userId User's ID.
     * @return boolean True/False
     * @throws app.InvalidDataException, Exception
     */
    public static boolean doesUserIdExist(String userId) throws InvalidDataException, Exception {
        if (userId == null || userId.trim().equals(""))
            return false;
        return UserInfoDAL.doesUserIdExist(userId);
    }

    /**
     * Query 3. Given the list of user names, compare usages of the printers by these users.
     * @param userIds A list of user id's.
     * @return HashMap A hashmap with the key as users and the value as their printer usage count.
     * @throws Exception
     */
    public static HashMap<String,Integer> getPrinterUsage(List<String> userIds) throws Exception {
            if (userIds == null || userIds.isEmpty())
                throw new Exception("No User Id's passed in.");
            return UserInfoDAL.getPrinterUsage(userIds);
    }

    /**
     * Query 4. Given the range of student scores, compute how student workload changes (number
     * of commands that they execute).
     * @param startScore The start score.
     * @param endScore The end score.
     * @return HashMap A hashmap with the key as the score and the value as their workload.
     * @throws app.InvalidDataException, Exception
     */
    public static HashMap<String,Integer> getWorkloadByScore(int startScore, int endScore) throws InvalidDataException, Exception {
        if (startScore < 0)
            throw new InvalidDataException("Start score must be greater than 0.");
        if (startScore > endScore)
            throw new InvalidDataException("Start score must be less than End Score.");
        return UserInfoDAL.getWorkloadByScore(startScore, endScore);
    }


/**
     * Query 7. Find the differences in workloads for students who have the GPAs from 3.4 and up versus the rest of students
     * Gets all the workload thats greater than or equal to the specified GPA
     * @param inGPA The gpa
     * @return int The workload
     * @throws app.InvalidDataException, Exception
     */
    public static int getWorkloadGreaterThanEqualToGPA(float inGPA) throws Exception {
         if (inGPA < 0.0)
            throw new InvalidDataException("The GPA must be greater than 0.");
        return UserInfoDAL.getWorkloadGreaterThanEqualToGPA(inGPA);
    }


    /**
     * Query 7. Find the differences in workloads for students who have the GPAs from 3.4 and up versus the rest of students
     * Gets all the workload thats less specified GPA
     * @param inGPA The gpa
     * @return int The workload
     * @throws app.InvalidDataException, Exception
     */
     public static int getWorkloadLessThanGPA(float inGPA) throws InvalidDataException, Exception {
         if (inGPA < 0.0)
            throw new InvalidDataException("The GPA must be greater than 0.");
        return UserInfoDAL.getWorkloadLessThanGPA(inGPA);
    }


    /**
     * Gets a list of all of the user's in the databasse
     * @return List A list of all of the user's information.
     * @throws Exception
     */
    public static List<IUserInfo> getListOfUserInfo() throws Exception {
        return UserInfoDAL.getListOfUserInfo();
    }

    /**
     * Query 9. Find the workload differences for graduate versus undergraduate students
     * @parm graduate The graduate level.
     * @return int Workload
     * @throws Exception
     */
    public static int getWorkloadByGraduateLevel(int graduate) throws Exception {
        validateGraduate(graduate);
        return UserInfoDAL.getWorkloadByGraduateLevel(graduate);
    }

    /**
     * Query 17 - Partition and output names of users based on categories of the commands that these users used.
     * Gets a list of users by command category
     * @return Hashmap A hashmap with the key as the command category and the value as a list of users.
     * @throws Exception
     */

    public static HashMap<String,List<String>> getUsersByCommandCategory() throws Exception {
        return UserInfoDAL.getUsersByCommandCategory();
    }

    /**
     * Query 21. Output the average ratio of password length for users who used the command latex versus those who
     * never used it.
     * @return float ratio
     * @throws Exception
     */
    public static float computeLatexToNoLatexPasswordLengthRatio() throws Exception {
        return UserInfoDAL.computeLatexToNoLatexPasswordLengthRatio();
    }

    // ------------------------------
    // Validation Methods
    // ------------------------------
    private static void validateUserInfo(IUserInfo myUser, boolean validateUserId) throws InvalidDataException, Exception {
        if (myUser == null)
            throw new Exception("Validation error with UserInfo - Null Object sent in.");
        if (validateUserId)
            validateUserId(myUser.getUserId());
        validateFirstname(myUser.getFirstname());
        validateLastname(myUser.getLastname());
        validateSex(myUser.getSex());
        validateDepartmentId(myUser.getDepartmentId());
        validateOfficeId(myUser.getOfficeId());
        validateGraduate(myUser.getGraduate());
        validateRaceId(myUser.getRaceId());
        validatePassword(myUser.getPassword());
        validateYearsUsingUnix(myUser.getYearsUsingUnix());
        validateEnrollDate(myUser.getEnrollDate());
    }

    private static void validateUserId(String userId) throws InvalidDataException, Exception {
         if (userId == null || userId.trim().equals(""))
            throw new InvalidDataException("UserId must not be null or an empty String.");
         if (!doesUserIdExist(userId))
             throw new InvalidDataException("Invalid UserId - User ID does not exist.");
    }

    private static void validateFirstname(String firstname) throws InvalidDataException {
        if (firstname == null || firstname.trim().equals(""))
            throw new InvalidDataException("Firstname must not be null or an empty String ");
        if (firstname.trim().length() > 50)
            throw new InvalidDataException("The length of the Firstname must be less than or equal to 50 characters");
    }

    private static void validateLastname(String lastname) throws InvalidDataException {
        if (lastname == null || lastname.trim().equals(""))
            throw new InvalidDataException("Lastname must not be null or an empty String ");
        if (lastname.trim().length() > 50)
            throw new InvalidDataException("The length of the Lastname must be less than or equal to 50 characters");
    }

    private static void validateSex(String sex) throws InvalidDataException {
        if (sex == null || sex.trim().equals(""))
            throw new InvalidDataException("Sex Field must not be null or an empty String ");
        if (sex.trim().length() > 1)
            throw new InvalidDataException("The length of the Sex Field must be 1 character in length");
        if (!sex.trim().equals("M") && !sex.trim().equals("F"))
            throw new InvalidDataException("The valid input fields for Sex are M and F");
    }

    private static void validateDepartmentId(int departmentId) throws InvalidDataException, Exception {
        if(!UserInfoDAL.isDepartmentIdValid(departmentId))
            throw new InvalidDataException("Invalid department id");
    }
    
    private static void validateOfficeId(int officeId) throws InvalidDataException, Exception {
        if(!UserInfoDAL.isOfficeIdValid(officeId))
            throw new InvalidDataException("Invalid office id input - Office Id does not exist.");
    }
    
    private static void validateGraduate(int graduate) throws InvalidDataException {
        if (graduate != 0 && graduate != 1)
            throw new InvalidDataException("Invalid Graduate Input - Valid values are 0 and 1");
    }

    private static void validateRaceId(int raceId) throws InvalidDataException, Exception {
        if(!UserInfoDAL.isRaceIdValid(raceId))
            throw new InvalidDataException("Invalid Race Id");
    }
     
    private static void validatePassword(String password) throws InvalidDataException {
         if (password == null || password.trim().equals(""))
            throw new InvalidDataException("Password must not be null or an empty String ");
        if (password.trim().length() > 50)
            throw new InvalidDataException("The length of the Password must be less than or equal to 50 characters");
    }
    
    private static void validateYearsUsingUnix(int yearsUsingUnix) throws InvalidDataException {
        if (yearsUsingUnix<0)
            throw new InvalidDataException("Invalid Years Using Unix. Must be greater than or equal to 0.");
    }
     
    private static void validateEnrollDate(Date enrollDate) throws InvalidDataException {
        if (enrollDate == null)
            throw new InvalidDataException("Invalid Enroll Date - Enroll Data was null.");
    }


    // Inner DAL class
    private static class UserInfoDAL {

        private static IUserInfo addUserInfo(IUserInfo myUser) throws Exception {
            String userId = "user" + getNextIdNum();

            StringBuilder sb = new StringBuilder();

            sb.append("INSERT INTO USER_INFO ");
            sb.append("(USER_ID, FIRST_NAME, LAST_NAME, SEX, DEPT_ID, OFFICE_ID, GRADUATE ");
            sb.append(", RACE, PASSWORD, YEARS_USING_UNIX, ENROLL_DATE) ");
            sb.append("VALUES ( ");
            sb.append("  '" + userId + "'");
            sb.append(", '" + myUser.getFirstname() + "' ");
            sb.append(", '" + myUser.getLastname() + "' ");
            sb.append(", '" + myUser.getSex() + "' ");
            sb.append(", " + myUser.getDepartmentId());
            sb.append(", " + myUser.getOfficeId());
            sb.append(", " + myUser.getGraduate());
            sb.append(", " + myUser.getRaceId());
            sb.append(", '" + myUser.getPassword() + "' ");
            sb.append(", " + myUser.getYearsUsingUnix());
            sb.append(", '" + new SimpleDateFormat("MM/dd/yyyy").format(myUser.getEnrollDate())  + "'");
            sb.append(")");

            DBUtil.execute(sb.toString());

            return getUserInfoBy(userId);
        }

        private static IUserInfo editUserInfo(IUserInfo myUser) throws Exception {
            if (myUser == null  || myUser.getUserId() == null || myUser.getUserId().equals(""))
                throw new Exception("Error in EditUserInfo - User Id passed in was null or an empty string");

            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE USER_INFO ");
            sb.append(" SET FIRST_NAME='" + myUser.getFirstname() + "'");
            sb.append(" , LAST_NAME = '" + myUser.getLastname() + "'");
            sb.append(" , SEX = '" + myUser.getSex() + "'");
            sb.append(" , DEPT_ID = " + myUser.getDepartmentId());
            sb.append(" , OFFICE_ID = " + myUser.getOfficeId());
            sb.append(" , GRADUATE = " + myUser.getGraduate());
            sb.append(" , RACE = " + myUser.getRaceId());
            sb.append(" , PASSWORD = '" + myUser.getPassword() + "'");
            sb.append(" , YEARS_USING_UNIX = " + myUser.getYearsUsingUnix());
            sb.append(" , ENROLL_DATE = '" + new SimpleDateFormat("MM/dd/yyyy").format(myUser.getEnrollDate())  + "'");
            sb.append(" WHERE USER_ID='" + myUser.getUserId() + "'");
            DBUtil.execute(sb.toString());

            return getUserInfoBy(myUser.getUserId());

        }

        private static List<IUserInfo> getListOfUserInfo() throws Exception {

            String sql = "SELECT USER_ID, FIRST_NAME, LAST_NAME, SEX, DEPT_ID, OFFICE_ID, GRADUATE "
                         + ", RACE, PASSWORD, YEARS_USING_UNIX, ENROLL_DATE "
                         + " FROM USER_INFO ";

            ResultSet rs = DBUtil.executeQuery(sql);

            List<IUserInfo> myUsers = new ArrayList<IUserInfo>();


            while(rs.next())
            {
                myUsers.add(new UserInfo(
                              rs.getString("USER_ID")
                            , rs.getString("FIRST_NAME")
                            , rs.getString("LAST_NAME")
                            , rs.getString("SEX")
                            , rs.getInt("DEPT_ID")
                            , rs.getInt("OFFICE_ID")
                            , rs.getInt("GRADUATE")
                            , rs.getInt("RACE")
                            , rs.getString("PASSWORD")
                            , rs.getInt("YEARS_USING_UNIX")
                            , rs.getDate("ENROLL_DATE")));
            }

            rs.close();
            return myUsers;
        }

        private static IUserInfo getUserInfoBy(String inUserId) throws Exception {
            if (inUserId == null || inUserId.trim().equals(""))
                throw new Exception("The UserId passed into GetUserInfo was either null or empty");

            String sql = "SELECT USER_ID, FIRST_NAME, LAST_NAME, SEX, DEPT_ID, OFFICE_ID, GRADUATE "
                         + ", RACE, PASSWORD, YEARS_USING_UNIX, ENROLL_DATE "
                         + " FROM USER_INFO "
                         + " WHERE USER_ID='" + inUserId + "'";

            ResultSet rs = DBUtil.executeQuery(sql);

            List<IUserInfo> myUsers = new ArrayList<IUserInfo>();

            while(rs.next())
            {
                myUsers.add(new UserInfo(
                              rs.getString("USER_ID")
                            , rs.getString("FIRST_NAME")
                            , rs.getString("LAST_NAME")
                            , rs.getString("SEX")
                            , rs.getInt("DEPT_ID")
                            , rs.getInt("OFFICE_ID")
                            , rs.getInt("GRADUATE")
                            , rs.getInt("RACE")
                            , rs.getString("PASSWORD")
                            , rs.getInt("YEARS_USING_UNIX")
                            , rs.getDate("ENROLL_DATE")));
            }

            rs.close();

            IUserInfo myUser = null;
            if (myUsers != null && !myUsers.isEmpty())
               myUser = myUsers.get(0);
            return myUser;
        }

        private static boolean doesUserIdExist(String userId) throws Exception {
            int count = -1;
            boolean doesExist = false;

            String sql = "SELECT COUNT(*) as COUNT"
                        + " FROM USER_INFO"
                        + " WHERE USER_ID='" + userId + "'";
            ResultSet rs = DBUtil.executeQuery(sql);
            rs.next();
            if (rs.getInt("COUNT")>0)
                doesExist = true;
            rs.close();

            return doesExist;
        }

        private static HashMap<String,Integer> getPrinterUsage(List<String> userIds) throws Exception {
            HashMap<String,Integer> myMap = new HashMap<String,Integer>();
            StringBuilder sb = new StringBuilder();
            int counter = 0;
            sb.append("SELECT  ui.FIRST_NAME || ' ' || ui.LAST_NAME FULLNAME, COUNT(uh.COMMAND) as COUNT");
            sb.append(" FROM UNIX_COMMAND uc, USER_INFO ui, USAGE_HISTORY uh");
            sb.append(" WHERE ui.USER_ID = uh.USER_ID");
            sb.append(" AND uc.CATEGORY = 'PRINT'");
            sb.append(" AND uc.UNIX_COMMAND = uh.COMMAND");
            sb.append(" AND ui.USER_ID in (");
            for(String userId : userIds)
            {
                if (counter == 0)
                    sb.append("'" + userId + "'");
                else
                    sb.append(", '" + userId + "'");
                counter++;
            }
            sb.append(")");
            sb.append(" GROUP BY ui.FIRST_NAME, ui.LAST_NAME");
            ResultSet rs = DBUtil.executeQuery(sb.toString());

            while (rs.next())
                myMap.put(rs.getString("FULLNAME"), rs.getInt("COUNT"));
            rs.close();
            return myMap;
        }

        private static HashMap<String,Integer> getWorkloadByScore(int startScore, int endScore) throws Exception {
            HashMap<String,Integer> myMap = new HashMap<String,Integer>();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT ui.FIRST_NAME || ' ' ||  ui.LAST_NAME STUDENTNAME, COUNT(uh.COMMAND) as WORKLOAD");
            sb.append(" FROM USER_INFO ui, TRANSCRIPT t, USAGE_HISTORY uh");
            sb.append(" WHERE ui.USER_ID = t.USER_ID");
            sb.append(" AND t.USER_ID=uh.USER_ID ");
            sb.append(" and t.SCORE BETWEEN " + startScore + " AND " + endScore);
            sb.append(" GROUP BY ui.FIRST_NAME,ui.LAST_NAME");
            sb.append(" ORDER BY COUNT(uh.COMMAND) DESC");
            ResultSet rs = DBUtil.executeQuery(sb.toString());

            while (rs.next())
                myMap.put(rs.getString("STUDENTNAME"), rs.getInt("WORKLOAD"));
            rs.close();

            return myMap;
        }

        private static HashMap<String,Float> getGPAForAllUsers() throws Exception {
            HashMap<String,Float> myMap = new HashMap<String,Float>();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT ui.USER_ID, t.SCORE ");
            sb.append(" FROM USER_INFO ui, TRANSCRIPT t ");
            sb.append(" WHERE ui.USER_ID = t.USER_ID ");
            sb.append(" ORDER BY ui.USER_ID ");

            ResultSet rs = DBUtil.executeQuery(sb.toString());
            String lastUserId =  "";
            float gpTot = 0.0f;
            int counter = 0;
            StringBuilder userIds = new StringBuilder();

            while(rs.next())
            {
                if (lastUserId.equals(""))
                        lastUserId = rs.getString("USER_ID");
                else if (!rs.getString("USER_ID").equals(lastUserId))
                {
                    if (counter>0)
                        myMap.put(lastUserId, (float)(gpTot/counter));
                    else
                        myMap.put(lastUserId, 0.0f);

                    lastUserId = rs.getString("USER_ID");
                    gpTot = 0.0f;
                    counter = 0;
                }
                gpTot += getGPFromScore(rs.getInt("SCORE"));
                counter++;
            }

            if (counter>0)
                myMap.put(lastUserId, (float)(gpTot/counter));
            else
                myMap.put(lastUserId, 0.0f);

            return myMap;
        }

        private static int getWorkloadGreaterThanEqualToGPA(float inGPA) throws Exception {
            if(inGPA < 0.0f)
                throw new IllegalArgumentException("Invalid GPA");

            StringBuilder userIds = new StringBuilder();
            HashMap<String,Float> myUsersGPA = getGPAForAllUsers();
            Iterator it = myUsersGPA.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry)it.next();
                if (Float.parseFloat(pairs.getValue().toString()) >= inGPA) {
                    if (userIds.toString().equals(""))
                         userIds.append("'" + pairs.getKey() + "'");
                    else
                         userIds.append(", '" + pairs.getKey() + "'");
                }
            }

            if (userIds.toString().trim().equals(""))
                return 0;
            System.out.println(userIds.toString());
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT COUNT(COMMAND) as WORKLOAD ");
            sb.append(" FROM USAGE_HISTORY ");
            sb.append(" WHERE USER_ID in (" + userIds.toString() + ")");
            ResultSet rs = DBUtil.executeQuery(sb.toString());
            rs.next();
            int workload = rs.getInt("WORKLOAD");
            rs.close();
            return workload;
        }

         private static int getWorkloadLessThanGPA(float inGPA) throws Exception {
            StringBuilder userIds = new StringBuilder();
            HashMap<String,Float> myUsersGPA = getGPAForAllUsers();
            Iterator it = myUsersGPA.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry)it.next();
                if (Float.parseFloat(pairs.getValue().toString()) < inGPA) {
                    if (userIds.toString().equals(""))
                         userIds.append("'" + pairs.getKey() + "'");
                    else
                         userIds.append(", '" + pairs.getKey() + "'");
                }
            }

            if (userIds.toString().trim().equals(""))
                return 0;

            if (userIds.toString().trim().equals(""))
                return 0;
            System.out.println(userIds);
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT COUNT(COMMAND) as WORKLOAD ");
            sb.append(" FROM USAGE_HISTORY ");
            sb.append(" WHERE USER_ID in (" + userIds.toString() + ")");
            ResultSet rs = DBUtil.executeQuery(sb.toString());
            rs.next();
            int workload = rs.getInt("WORKLOAD");
            rs.close();

            return workload;
        }



        private static float getGPFromScore(int score) {
            float gp = 0.0f;
            if (score>=90)
                gp = 4.0f;
            else if (score >= 80 && score < 90)
                gp = 3.0f;
            else if (score >= 70 && score < 80)
                gp = 2.0f;
            else if (score >= 60 && score < 70)
                gp = 1.0f;
            else
                gp = 0.0f;
            return gp;
        }

        private static int getWorkloadByGraduateLevel(int graduate) throws Exception {

            StringBuilder sb = new StringBuilder();
            sb.append("SELECT COUNT(UH.COMMAND) WORKLOAD ");
            sb.append(" FROM USER_INFO ui, USAGE_HISTORY uh ");
            sb.append(" WHERE uh.USER_ID = ui.USER_ID ");
            sb.append(" AND ui.GRADUATE=" + graduate);

            ResultSet rs = DBUtil.executeQuery(sb.toString());
            rs.next();
            int workload = rs.getInt("WORKLOAD");
            rs.close();

            return workload;
        }

        private static HashMap<String,List<String>> getUsersByCommandCategory() throws Exception {
            HashMap<String, List<String>> myMap = new HashMap<String, List<String>>();
            String sql = "SELECT distinct uc.CATEGORY ,ui.USER_ID ,ui.FIRST_NAME || ' ' || ui.LAST_NAME as FULLNAME"
                       + " FROM UNIX_COMMAND uc, USAGE_HISTORY uh, USER_INFO ui"
                       + " WHERE ui.USER_ID = uh.USER_ID "
                       + " AND uh.COMMAND = uc.UNIX_COMMAND"
                       + " ORDER BY 1, 3";

            ResultSet rs = DBUtil.executeQuery(sql);
            List<String> users = new ArrayList<String>();
            String lastCategory = "";
            while (rs.next())
            {
                // First time through the loop
                if (lastCategory.equals(""))
                    lastCategory = rs.getString("CATEGORY");
                // When Category Changes
                else if (!lastCategory.equals("") && !rs.getString("CATEGORY").equals(lastCategory))
                {
                    myMap.put(lastCategory, users);
                    lastCategory = rs.getString("CATEGORY");
                    users = new ArrayList<String>();
                }
                users.add(rs.getString("FULLNAME"));
            }
            return myMap;
        }

        private static float computeLatexToNoLatexPasswordLengthRatio() throws Exception {

            String sql = "SELECT DISTINCT uh.USER_ID, LENGTH(ui.PASSWORD) as PASSWORD_LENGTH"
                       + " FROM USAGE_HISTORY uh, USER_INFO ui"
                       + " WHERE uh.COMMAND='latex'"
                       + " AND uh.USER_ID=ui.USER_ID";


            ResultSet rs = DBUtil.executeQuery(sql);

            StringBuilder users = new StringBuilder();
            int latexUsersLength = 0;
            int lCounter = 0;

            while(rs.next())
            {
                latexUsersLength += rs.getInt("PASSWORD_LENGTH");
                if (lCounter==0)
                    users.append("'");
                else
                    users.append(", '");
                users.append(rs.getString("USER_ID"));
                users.append("'");
                lCounter++;
            }

            if (latexUsersLength == 0)
                return 0.0f;

            float avgLatexUsersLength = (float) latexUsersLength / lCounter;

            sql = "SELECT DISTINCT LENGTH(ui.PASSWORD) as PASSWORD_LENGTH"
                + " FROM USER_INFO ui"
                + " WHERE USER_ID not in (" + users.toString() + ")";

            rs = DBUtil.executeQuery(sql);

            int nonLatexUsersLength = 0;
            int nlCounter = 0;

            while(rs.next())
            {
                nonLatexUsersLength += rs.getInt("PASSWORD_LENGTH");
                nlCounter++;
            }

            if (nonLatexUsersLength == 0)
                return 0.0f;

            float avgNonLatexUsersLength = (float) nonLatexUsersLength / nlCounter;

            if (avgNonLatexUsersLength == 0.0f)
                throw new Exception("Cannot divide by 0");

            return avgLatexUsersLength/avgNonLatexUsersLength;
        }

        private static int getNextIdNum() throws Exception {
            int nextId = -1;
            try {
                String sql = "SELECT MAX(CAST(Substr(USER_ID,5,length(USER_ID)) as int)) as NextID"
                            + " FROM USER_INFO";
                ResultSet rs = DBUtil.executeQuery(sql);
                rs.next();
                nextId = rs.getInt("NextID");
                rs.close();
                return nextId + 1;
            } catch (Exception ex) {
                return 0;
            }
        }

        private static boolean isDepartmentIdValid(int departmentId) throws Exception {
            int count = -1;
            boolean doesExist = false;
            String sql = "SELECT COUNT(*) as COUNT"
                        + " FROM DEPT_INFO"
                        + " WHERE DEPT_ID=" + departmentId;
            ResultSet rs = DBUtil.executeQuery(sql);
            rs.next();
            if (rs.getInt("COUNT")>0)
                doesExist = true;
            rs.close();
            return doesExist;
        }

        private static boolean isOfficeIdValid(int officeId) throws Exception {
            int count = -1;
            boolean doesExist = false;

            String sql = "SELECT COUNT(*) as COUNT"
                        + " FROM OFFICE_INFO"
                        + " WHERE OFFICE_ID=" + officeId;

            ResultSet rs = DBUtil.executeQuery(sql);
            rs.next();
            if (rs.getInt("COUNT")>0)
                doesExist = true;
            return doesExist;
        }

        private static boolean isRaceIdValid(int raceId) throws Exception {
            int count = -1;
            boolean doesExist = false;

            String sql = "SELECT COUNT(*) as COUNT"
                        + " FROM RACE_INFO"
                        + " WHERE RACE_CODE=" + raceId;
            ResultSet rs = DBUtil.executeQuery(sql);
            rs.next();
            if (rs.getInt("COUNT")>0)
                doesExist = true;
            rs.close();
            return doesExist;
        }

    }
}
