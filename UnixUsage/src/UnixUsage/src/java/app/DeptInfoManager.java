/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.*;
import java.sql.*;

/**
 *
 * @author FarooqB
 *
 */

//Manager class for all actions related to the Departments.
public class DeptInfoManager {

    private DeptInfoManager() //private constructor
    {
    }

    //Get all the Departments for display
    public static List<IDeptInfo> getAllDepartments() throws Exception {
        return DeptInfoDAL.retrieveAllDepartments();
    }

    //checks if a Department already exists
    public static boolean deptIdExists(int deptId) throws Exception {
        if (isDeptIdValid(deptId)) {
            return DeptInfoDAL.deptIDExists(deptId);
        }

        return false;
    }

    //checks if the Department Name exists to avoid duplication
    private static boolean deptNameExists(String deptName) throws Exception {
        if (isDeptNameValid(deptName)) {
            return DeptInfoDAL.deptNameExists(deptName);
        }

        return false;
    }

    //checks if the department id provided is a valid input
    public static boolean isDeptIdValid(int deptId) throws Exception {
        if (deptId <= 0) {
            throw new IllegalArgumentException("Invalid Department ID");
        }

        return true;
    }

    //returns a Department Id by passing in the name only if the name already exists in the database
    public static int getDepartmentIDByName(String deptName) throws Exception {

        if (isDeptNameValid(deptName)) {
            return DeptInfoDAL.getDepartmentIDByName(deptName);
        }

        return -1;

    }

    //returns a department name by passing in the department id if the department id is valid
    public static String getDepartmentNameByID(int deptID) throws Exception {

        if (isDeptIdValid(deptID)) {
            return DeptInfoDAL.getDepartmentNameByID(deptID);
        }

        return null;
    }

    private static boolean isDeptNameValid(String deptName) {

        if (deptName == null) {
            throw new IllegalArgumentException("Department Name cannot be null");
        }
        if (deptName.equals("")) {
            throw new IllegalArgumentException("Department Name cannot be blank");
        }

        if (deptName.replace(" ", "").length() == 0) {
            throw new IllegalArgumentException("Name length should be greater than 0");
        }

        if (deptName.length() > 50) {
            throw new IllegalArgumentException("Name length should be less than or equal to 50");
        }

        return true;
    }

    //Main function for adding a department to the database.  This also checks the validity of the inputs provided
    public static boolean addDepartment(int deptID, String deptName) throws Exception {

        if (isDeptIdValid(deptID)) //formatting
        {
            //does this id already exist?
            if (!deptIdExists(deptID)) //already in the database
            {
                if (isDeptNameValid(deptName)) //formatting
                {
                    //check for '
                    deptName = deptName.replace("'", "''");
                    if (!deptNameExists(deptName)) //if the department name does not exist then proceed else throw exception
                    {
                        //this returns false as there is nothing returned so show true
                        boolean result = DeptInfoDAL.insertDepartment(deptID, deptName);
                        if (result == false) {
                            return true;
                        } else {
                            return result;
                        }
                    }
                    else
                        throw new IllegalArgumentException("Department name already exists.");
                }
            }
            else
                throw new IllegalArgumentException("Department ID already exists.");
        }
        return true;
    }

    //Main function for editing a department.  This also checks the validity of the inputs provided.
    public static boolean editDepartment(int deptID, String deptName) throws Exception {
        //Does department Id meet valid criteria, not null, 0 etc?
        if (isDeptIdValid(deptID)) //formatting
        {
            //this id should already exist for editing
            if (deptIdExists(deptID)) {
                if (isDeptNameValid(deptName)) //formatting
                {
                    //check for '
                    deptName = deptName.replace("'", "''");
                    //the name should not exist in the database as it would be a duplicate
                    if (!deptNameExists(deptName)) {
                        //reverse false to true as there are no results returned even though the row is updated.
                        boolean result = DeptInfoDAL.updateDepartment(deptID, deptName);
                        if (result == false) {
                            return true;
                        } else {
                            return result;
                        }

                    }
                    else
                        throw new IllegalArgumentException("This Department name already exists.");
                }
            }
            else
                throw new IllegalArgumentException("This Department Id does not exist.");
        }
        return true;
    }

    /**
     * Query 5. Find the workload for students who belong to a given department
     * @param deptId The ID of a given department
     * @return Dictionary A Dictionary of student name and workload
     * @throws java.lang.Exception
     */
    public static Dictionary<String, Integer> getWorkloadForStudentsInDept(int deptId) throws Exception {
        if (isDeptIdValid(deptId)) {
            return DeptInfoDAL.getWorkloadForStudentsInDept(deptId);
        }
        return null;
    }

    /**
     * Query 11. Given the input as a department name and a date, output the normalized ratio of commands
     * that users who work at that department execute before and after that date
     * @param deptid The ID of a given department
     * @param date The date to use for the before/after comparison
     * @return float Ratio of commands before and after a given date.
     * @throws java.lang.Exception
     */
    public static float computeBeforeAndAfterRatioByDept(int deptid, String date) throws Exception {
        if (deptid <= 0) {
            throw new IllegalArgumentException("Invalid Department ID");
        }

        if (date == null || date.length() == 0 || date.replace(" ", "").length() == 0 || date.length() > 10) {
            throw new IllegalArgumentException("Invalid Date");
        }

        return DeptInfoDAL.computeBeforeAfterRatioByDept(deptid, date);

    }

    /**
     * Query 13. Given the input value of as a department name, compute the ratio of females
     * to males who study in that department.
     * @param deptid The ID of a given department
     * @return float Ratio of females to males
     * @throws java.lang.Exception
     */
    public static float computeFemaleToMaleRatio(int deptid) throws Exception {
        if (isDeptIdValid(deptid)) {
            return DeptInfoDAL.computeFemaleToMaleRatio(deptid);
        }
        return -1.0f;
    }


    /**
     * Query 14. Given a department name, output the top three commands that the users in
     * that department submitted.
     * @param deptid The ID of a given department
     * @return List A list of the top three commands
     * @throws java.lang.Exception
     */
    public static List<String> getTopThreeCommands(int deptid) throws Exception {
        if (isDeptIdValid(deptid)) {
            return DeptInfoDAL.getTopCommands(deptid);
        }

        return null;
    }

    /**
     * Query 18. Compute the ratio of FILE versus NETWORK commands that students who belong to the 
     * department of computer science used.
     * @param deptId The ID of a given department
     * @return float Ratio of FILE to NETWORK commands
     * @throws java.lang.Exception
     */
    public static float computeFileToNetworkRatioForDept(int deptId) throws Exception {
        if (isDeptIdValid(deptId)) {
            return DeptInfoDAL.computeFileToNetworkRatioForDept(deptId);
        }

        return -1.0f;
    }

    /**
     * Query 19. Using 18, compare ratios for different departments.
     * @return Dictionary A Dictionary containing department name and a ratio of FILE to NETWORK commands
     * @throws java.lang.Exception
     */
    public static Dictionary<String, Float> computeFileToNetworkRatioForAllDepts() throws Exception {
        return DeptInfoDAL.computeFileToNetworkRatioForAllDepts();
    }

    /**
     * Query 20. Output the average ratio of password length for users who belong to the department of
     * computer science versus the other departments.
     * @return Dictionary A Dictionary containing department name and an average password length
     * @throws java.lang.Exception
     */
    public static Dictionary<String, Float> computeCSToOtherDeptsPasswordLengthRatio() throws Exception {
        return DeptInfoDAL.computeCSToOtherDeptsPasswordLengthRatio();
    }

    //get a IDeptInfo object
    public static IDeptInfo getDeptInfo(int deptId) throws Exception {
        if (isDeptIdValid(deptId)) {
            if (deptIdExists(deptId)) {
                return DeptInfoDAL.getDeptInfo(deptId);
            }
            else
                throw new IllegalArgumentException("Department Id does not exist");
        }
        return null;
    }


    /*
     * Inner class for DataAccess
     * */
    private static class DeptInfoDAL {
        //Data Access Functions

        private static ResultSet rs;

        private static List<IDeptInfo> retrieveAllDepartments() throws Exception {
            List<IDeptInfo> allDepts = new ArrayList<IDeptInfo>();
            rs = DBUtil.executeQuery("SELECT * FROM DEPT_INFO ORDER BY DEPT_ID ASC");
            while (rs.next()) {
                int deptID = rs.getInt("DEPT_ID");
                String deptName = rs.getString("DEPT_NAME");
                allDepts.add(new DeptInfo(deptID, deptName));
            }
            return allDepts;
        }

        private static boolean deptIDExists(int deptid) throws Exception {
            rs = DBUtil.executeQuery("Select DEPT_ID FROM DEPT_INFO WHERE DEPT_ID =" + deptid);
            int d = -1;

            while (rs.next()) {
                d = rs.getInt("DEPT_ID");
            }

            //close the resultset
            rs.close();

            if (d == -1) {
                return false;
            }

            return true;
        }

        private static boolean deptNameExists(String name) throws Exception {
            rs = DBUtil.executeQuery("Select DEPT_NAME FROM DEPT_INFO WHERE DEPT_NAME ='" + name + "'");
            String s = null;

            while (rs.next()) {
                s = rs.getString("DEPT_NAME");
            }

            //close the resultset
            rs.close();

            if (s == null) {
                return false;
            }
            return true;
        }

        private static boolean insertDepartment(int deptId, String deptName) throws Exception {
            return DBUtil.execute("INSERT INTO DEPT_INFO (DEPT_ID,DEPT_NAME) VALUES (" + deptId + ",'" + deptName + "')");
        }

        private static boolean updateDepartment(int deptId, String deptName) throws Exception {
            return DBUtil.execute("UPDATE DEPT_INFO SET DEPT_NAME = '" + deptName + "' WHERE DEPT_ID = " + deptId + " ");
        }

        private static Dictionary<String, Integer> getWorkloadForStudentsInDept(int deptId) throws Exception {
            String SQL = "SELECT U.FIRST_NAME,U.LAST_NAME, COUNT(UH.COMMAND) WORKLOAD " + "FROM DEPT_INFO D JOIN USER_INFO U ON U.DEPT_ID = D.DEPT_ID " + "JOIN USAGE_HISTORY UH ON UH.USER_ID = U.USER_ID WHERE U.DEPT_ID =" + deptId + " " + "GROUP BY U.FIRST_NAME, U.LAST_NAME ORDER BY COUNT(UH.COMMAND) DESC";

            rs = DBUtil.executeQuery(SQL);
            Dictionary<String, Integer> results = new Hashtable<String, Integer>();
            while (rs.next()) {
                String name = rs.getString("FIRST_NAME") + " " + rs.getString("LAST_NAME");
                int commandCount = rs.getInt("WORKLOAD");
                results.put(name, commandCount);
            }
            return results;
        }

        private static float computeBeforeAfterRatioByDept(int deptid, String date) throws Exception {
            String SQL = "SELECT COUNT(UH.COMMAND) WORKLOAD " + "FROM DEPT_INFO D JOIN USER_INFO U ON U.DEPT_ID = D.DEPT_ID " + "JOIN USAGE_HISTORY UH ON UH.USER_ID = U.USER_ID " + " WHERE U.DEPT_ID =" + deptid + " AND U.ENROLL_DATE <= '" + date + "' " + "GROUP BY U.FIRST_NAME, U.LAST_NAME";

            rs = DBUtil.executeQuery(SQL);
            int before = 0;
            while (rs.next()) {
                before += rs.getInt("WORKLOAD");
            }

            if (before == 0)
                    return 0.0f;

            SQL = "SELECT COUNT(UH.COMMAND) WORKLOAD " + "FROM DEPT_INFO D JOIN USER_INFO U ON U.DEPT_ID = D.DEPT_ID " + "JOIN USAGE_HISTORY UH ON UH.USER_ID = U.USER_ID " + " WHERE U.DEPT_ID =" + deptid + " AND U.ENROLL_DATE > '" + date + "' " + "GROUP BY U.FIRST_NAME, U.LAST_NAME";

            rs = DBUtil.executeQuery(SQL);
            int after = 0;
            while (rs.next()) {
                after += rs.getInt("WORKLOAD");
            }

            if(after==0)
                return 0.0f;

            float f = (float) before / after;
            java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
            return Float.valueOf(df.format(f));

        }

        private static float computeFemaleToMaleRatio(int deptid) throws Exception {
            String SQL = "SELECT COUNT(U.SEX) FEMALE FROM DEPT_INFO D JOIN USER_INFO U ON U.DEPT_ID = D.DEPT_ID WHERE U.DEPT_ID =" + deptid + " AND U.SEX = 'F' GROUP BY U.SEX";

            rs = DBUtil.executeQuery(SQL);
            int female = 0;
            while (rs.next()) {
                female += rs.getInt("FEMALE");
            }

            SQL = "SELECT COUNT(U.SEX) MALE FROM DEPT_INFO D JOIN USER_INFO U ON U.DEPT_ID = D.DEPT_ID WHERE U.DEPT_ID =" + deptid + " AND U.SEX = 'M' GROUP BY U.SEX";

            rs = DBUtil.executeQuery(SQL);
            int male = 0;
            while (rs.next()) {
                male += rs.getInt("MALE");
            }

            float f = (float) female / male;
            java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
            return Float.valueOf(df.format(f));

        }

        private static List<String> getTopCommands(int deptid) throws Exception {

            List<String> lst = new ArrayList<String>();

            String SQL = "SELECT UH.COMMAND FROM USAGE_HISTORY UH WHERE UH.USER_ID IN (SELECT USER_ID FROM USER_INFO WHERE DEPT_ID =" + deptid + ") GROUP BY UH.COMMAND ORDER BY COUNT(UH.COMMAND) DESC";

            rs = DBUtil.executeQuery(SQL, 3);
            while (rs.next()) {
                lst.add(rs.getString("COMMAND"));
            }

            return lst;
        }

        private static int getDepartmentIDByName(String name) throws Exception {
            String sql = "SELECT DEPT_ID FROM DEPT_INFO WHERE DEPT_NAME = '" + name + "'";
            rs = DBUtil.executeQuery(sql);

            while (rs.next()) {
                return rs.getInt("DEPT_ID");
            }

            return -1;

        }

        private static String getDepartmentNameByID(int id) throws Exception {
            String sql = "SELECT DEPT_NAME FROM DEPT_INFO WHERE DEPT_ID = " + id + "";
            rs = DBUtil.executeQuery(sql);

            while (rs.next()) {
                return rs.getString("DEPT_NAME");
            }
            return null;
        }

        private static float computeFileToNetworkRatioForDept(int deptId) throws Exception {
            int filecmd = 0;
            int networkcmd = 0;

            String SQL = "SELECT COUNT(UH.COMMAND) FILECMD FROM USAGE_HISTORY UH WHERE UH.USER_ID IN (SELECT USER_ID FROM USER_INFO WHERE DEPT_ID =" + deptId + ") AND UH.COMMAND IN (SELECT UNIX_COMMAND FROM UNIX_COMMAND WHERE CATEGORY = 'FILE') GROUP BY UH.COMMAND ORDER BY COUNT(UH.COMMAND) DESC";


            rs = DBUtil.executeQuery(SQL);
            while (rs.next()) { //sum all counts
                filecmd += rs.getInt("FILECMD");
            }

            if (filecmd == 0) {
                return 0.0f;
            }

            SQL = "SELECT COUNT(UH.COMMAND) NETWORKCMD FROM USAGE_HISTORY UH WHERE UH.USER_ID IN (SELECT USER_ID FROM USER_INFO WHERE DEPT_ID =" + deptId + ") AND UH.COMMAND IN (SELECT UNIX_COMMAND FROM UNIX_COMMAND WHERE CATEGORY = 'NETWORK') GROUP BY UH.COMMAND ORDER BY COUNT(UH.COMMAND) DESC";

            rs = DBUtil.executeQuery(SQL);
            while (rs.next()) { //sum all counts
                networkcmd += rs.getInt("NETWORKCMD");
            }

            if (networkcmd == 0) {
                return 0.0f;
            }

            float f = (float) filecmd / networkcmd; //divide both aggregates and get the ratio
            java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
            return Float.valueOf(df.format(f));
        }

        private static Dictionary<String, Float> computeFileToNetworkRatioForAllDepts() throws Exception {
            Dictionary<String, Float> results = new Hashtable<String, Float>();

            List<IDeptInfo> lst = retrieveAllDepartments();

            if (lst != null) {

                for (IDeptInfo d : lst) {
                    float f = computeFileToNetworkRatioForDept(d.getDeptId());
                    results.put(d.getDeptName(), f);
                }
            }

            return results;

        }

        private static Dictionary<String, Float> computeCSToOtherDeptsPasswordLengthRatio() throws Exception {
            String SQL = "SELECT D.DEPT_NAME, AVG(CAST(LENGTH(U.PASSWORD) AS FLOAT)) AVERAGEPASSWORDLENGTH FROM USER_INFO U JOIN DEPT_INFO D ON D.DEPT_ID = U.DEPT_ID GROUP BY D.DEPT_NAME ORDER BY D.DEPT_NAME DESC ";

            rs = DBUtil.executeQuery(SQL);
            Dictionary<String, Float> results = new Hashtable<String, Float>();
            while (rs.next()) {
                String name = rs.getString("DEPT_NAME");
                float commandCount = rs.getFloat("AVERAGEPASSWORDLENGTH");
                java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
                commandCount=  Float.valueOf(df.format(commandCount));
                results.put(name, commandCount);
            }
            return results;
        }

        private static IDeptInfo getDeptInfo(int deptId) throws Exception {
            rs = DBUtil.executeQuery("SELECT * FROM DEPT_INFO WHERE DEPT_ID=" + deptId + "");

            while (rs.next()) {
                return new DeptInfo(rs.getInt("DEPT_ID"), rs.getString("DEPT_NAME"));
            }

            return null;
        }
    }
}
