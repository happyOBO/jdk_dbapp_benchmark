package app;

import java.util.*;
import java.sql.*;

/**
 *
 * @author Miftachut Ekasetya
 */

//Manager class for all actions related to the Offices.
public class OfficeInfoManager {

    //private constructor
    private OfficeInfoManager() {
    }

    /**
     * Query 2. Given the list of offices, compare the usages of printers that are located in these offices.
     * @param officeIds A list of office Ids
     * @return Map A Map of office names and number of print commands issued
     * @throws java.lang.Exception
     */
    public static Map<String, Integer> getPrinterUsage(List<Integer> officeIds) throws Exception {
        if (officeIds == null || officeIds.isEmpty()) {
            throw new Exception("Office ID cannot be null or empty.");
        }

        return OfficeInfoDAL.printerUsage(officeIds);
    }


    /**
     * Query 8. Find the workload for students who reside in given offices
     * @param officeIds
     * @return Map A Map of student names and workloads
     * @throws java.lang.Exception
     */
    public static Map<String, Integer> getUserWorkloadForOffices(List<Integer> officeIds) throws Exception {
        if (officeIds == null || officeIds.isEmpty()) {
            throw new Exception("Office ID cannot be null or empty.");
        }
        return OfficeInfoDAL.userWorkLoadForOffices(officeIds);

    }

    public static List<IOfficeInfo> getAllOffices() throws Exception {
        return OfficeInfoDAL.retrieveAllOffices();
    }

    public static IOfficeInfo getOfficeInfo(int officeId) throws Exception {
        if (isOfficeIdValid(officeId)) {
            if (isOfficeIdExist(officeId)) {
                return OfficeInfoDAL.getOfficeInfo(officeId);
            } else {
                throw new IllegalArgumentException("This office id does not exist.");
            }
        }
        return null;

    }

    private static boolean isOfficeIdExist(int officeId) throws Exception {
        if (isOfficeIdValid(officeId)) {
            return OfficeInfoDAL.officeIdExists(officeId);
        } else {
            return false;
        }
    }

    private static boolean isOfficeNameExists(String officeName) throws Exception {
        if (isOfficeNameValid(officeName)) {
            return OfficeInfoDAL.officeNameExists(officeName);
        } else {
            return false;
        }
    }

    private static boolean isOfficeIdValid(int officeId) throws Exception {
        if (officeId <= 0) {
            throw new IllegalArgumentException("Invalid Office ID. Office ID " +
                    "cannot be less than or equal to zero.");
        } else {
            return true;
        }
    }

    public static int getOfficeIdByName(String officeName) throws Exception {
        if (isOfficeNameValid(officeName)) {
            return OfficeInfoDAL.getOfficeIdByName(officeName);
        } else {
            return -1;
        }
    }

    public static String getOfficeNameById(int officeId) throws Exception {
        if (isOfficeIdValid(officeId)) {
            return OfficeInfoDAL.getOfficeNameById(officeId);
        } else {
            return null;
        }
    }

    private static boolean isOfficeNameValid(String officeName) {
        if (officeName == null) {
            throw new IllegalArgumentException("Office Name cannot be null.");
        }
        if (officeName.equals("")) {
            throw new IllegalArgumentException("Office Name cannot be blank.");
        }
        if (officeName.replace(" ", "").length() == 0) {
            throw new IllegalArgumentException("Office Name length should be " +
                    "greater than 0");
        }

        if (officeName.length() > 50) {
            throw new IllegalArgumentException("Office Name length should be " +
                    "less than or equal to 50");
        }

        return true;
    }

    private static boolean isHasPrinterValid(short hasPrinter) {
        if (hasPrinter >= 0 && hasPrinter <= 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean addOffice(int officeId, String officeName, short hasPrinter) throws Exception {
        if (isOfficeIdValid(officeId)) //formatting
        {
            //does this id already exist?
            if (!isOfficeIdExist(officeId)) //already in the database
            {
                if (isOfficeNameValid(officeName)) //formatting
                {
                    //check for '
                    officeName = officeName.replace("'", "''");
                    if (!isOfficeNameExists(officeName)) //already in the database
                    {
                        if (isHasPrinterValid(hasPrinter)) //formating
                        {
                            //this returns false as there is nothing returned so show true
                            if (!OfficeInfoDAL.insertOffice(officeId, officeName, hasPrinter)) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("This office name already exists.");
                    }
                }
            } else {
                throw new IllegalArgumentException("This office id already exists.");
            }
        }
        return true;
    }

    public static boolean editOffice(int officeId, String officeName, short hasPrinter) throws Exception {
        //Does office Id meet valid criteria, not null, 0 etc?
        if (isOfficeIdValid(officeId)) //formatting
        {
            //this id should already exist for editing
            if (isOfficeIdExist(officeId)) {
                if (isOfficeNameValid(officeName)) //formatting
                {
                    //check for '
                    officeName = officeName.replace("'", "''");
                    //the name should not exist in the database as it would be
                    //a duplicate
                        if (!OfficeInfoDAL.updateOffice(officeId, officeName, hasPrinter)) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("This office id does not exist.");
            }
        return true;
        }
        
    

    /*
     * Inner class for DataAccess
     * */
    private static class OfficeInfoDAL {

        private static ResultSet rs;

        private static List<IOfficeInfo> retrieveAllOffices() throws Exception {
            List<IOfficeInfo> allOffices = new ArrayList<IOfficeInfo>();
            rs = DBUtil.executeQuery("SELECT * FROM OFFICE_INFO ORDER BY OFFICE_ID ASC");
            while (rs.next()) {
                int officeId = rs.getInt("OFFICE_ID");
                String officeName = rs.getString("OFFICE_NAME");
                allOffices.add(new OfficeInfo(officeId, officeName));
            }
            return allOffices;
        }

        private static boolean officeIdExists(int officeId) throws Exception {
            rs = DBUtil.executeQuery("SELECT OFFICE_ID FROM OFFICE_INFO WHERE OFFICE_ID =" + officeId);
            int d = -1;

            while (rs.next()) {
                d = rs.getInt("OFFICE_ID");
            }

            //close the resultset
            rs.close();

            if (d == -1) {
                return false;
            } else {
                return true;
            }
        }

        private static boolean officeNameExists(String officeName) throws Exception {
            rs = DBUtil.executeQuery("SELECT OFFICE_NAME FROM OFFICE_INFO WHERE OFFICE_NAME ='" + officeName + "'");
            String s = null;

            while (rs.next()) {
                s = rs.getString("OFFICE_NAME");
            }

            //close the resultset
            rs.close();

            if (s == null) {
                return false;
            }
            return true;
        }

        private static boolean insertOffice(int officeId, String officeName, short hasPrinter) throws Exception {
            return DBUtil.execute("INSERT INTO OFFICE_INFO (OFFICE_ID,OFFICE_NAME,HAS_PRINTER) VALUES (" + officeId + ",'" + officeName.trim() + "'," + hasPrinter + ")");
        }

        private static boolean updateOffice(int officeId, String officeName, short hasPrinter) throws Exception {
            return DBUtil.execute("UPDATE OFFICE_INFO SET OFFICE_NAME = '" + officeName.trim() + "', HAS_PRINTER = " + hasPrinter + " WHERE OFFICE_ID = " + officeId);
        }

        private static int getOfficeIdByName(String officeName) throws Exception {
            String sql = "SELECT OFFICE_ID FROM OFFICE_INFO WHERE OFFICE_NAME = '" + officeName + "'";
            rs = DBUtil.executeQuery(sql);

            while (rs.next()) {
                return rs.getInt("OFFICE_ID");
            }

            return -1;
        }

        private static String getOfficeNameById(int officeId) throws Exception {
            String sql = "SELECT OFFICE_NAME FROM OFFICE_INFO WHERE OFFICE_ID = " + officeId;
            rs = DBUtil.executeQuery(sql);

            while (rs.next()) {
                return rs.getString("OFFICE_NAME");
            }
            return null;
        }

        private static Map<String, Integer> printerUsage(List<Integer> officeIds) throws Exception {
            Map<String, Integer> map = new HashMap<String, Integer>();
            StringBuilder sb = new StringBuilder();
            int counter = 0;
            sb.append("SELECT  o.OFFICE_NAME, COUNT(uh.COMMAND) as COUNT");
            sb.append(" FROM UNIX_COMMAND uc, USER_INFO ui, USAGE_HISTORY uh, OFFICE_INFO o");
            sb.append(" WHERE ui.USER_ID = uh.USER_ID");
            sb.append(" AND uc.CATEGORY = 'PRINT'");
            sb.append(" AND uc.UNIX_COMMAND = uh.COMMAND");
            sb.append(" AND o.OFFICE_ID = ui.OFFICE_ID");
            sb.append(" AND ui.OFFICE_ID in (");
            for (Integer _officeId : officeIds) {
                if (counter == 0) {
                    sb.append(_officeId.toString());
                } else {
                    sb.append(", " + _officeId.toString());
                }
                counter++;
            }
            sb.append(")");
            sb.append(" GROUP BY ui.OFFICE_ID, o.OFFICE_NAME");
            rs = DBUtil.executeQuery(sb.toString());

            while (rs.next()) {
                map.put(rs.getString("OFFICE_NAME"), rs.getInt("COUNT"));
            }
            rs.close();
            return map;
        }

        private static Map<String, Integer> userWorkLoadForOffices(List<Integer> officeIds) throws Exception {
            Map<String, Integer> map = new HashMap<String, Integer>();
            StringBuilder sb = new StringBuilder();
            int counter = 0;

            sb.append("SELECT UI.FIRST_NAME || ' ' || UI.LAST_NAME AS NAME, COUNT(UH.COMMAND) WORKLOAD");
            sb.append(" FROM OFFICE_INFO OI");
            sb.append(" JOIN USER_INFO UI ON UI.OFFICE_ID = OI.OFFICE_ID");
            sb.append(" JOIN USAGE_HISTORY UH ON UH.USER_ID = UI.USER_ID");
            sb.append(" WHERE UI.OFFICE_ID IN (");
            for (Integer _officeId : officeIds) {
                if (counter == 0) {
                    sb.append(_officeId.toString());
                } else {
                    sb.append(", " + _officeId.toString());
                }
                counter++;
            }
            sb.append(")");
            sb.append(" GROUP BY UI.FIRST_NAME, UI.LAST_NAME");
            sb.append(" ORDER BY COUNT(UH.COMMAND) ASC");
            rs = DBUtil.executeQuery(sb.toString());

            while (rs.next()) {
                map.put(rs.getString("NAME"), rs.getInt("WORKLOAD"));
            }
            rs.close();
            return map;
        }

        private static IOfficeInfo getOfficeInfo(int officeId) throws Exception {
            rs = DBUtil.executeQuery("SELECT * FROM OFFICE_INFO WHERE OFFICE_ID = " + officeId + " ");
            OfficeInfo o= null;
            while (rs.next()) {
                 o =  new OfficeInfo(rs.getInt("OFFICE_ID"), rs.getString("OFFICE_NAME"));
                 o.setHasPrinter(rs.getShort("HAS_PRINTER"));
            }
            return o;
        }
    }
}
