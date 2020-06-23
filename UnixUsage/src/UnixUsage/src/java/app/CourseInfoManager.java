/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author FarooqB
 */

//Manager class responsible for all actions related to courses.
public class CourseInfoManager {

    private CourseInfoManager() {
    }

    //Item 17//
    public static List<String> getOutputUserName(String category) throws Exception {
        return CourseInfoDAL.outputUserName(category);
    }

    public static List<ICourseInfo> getAllCourses() throws Exception {
        return CourseInfoDAL.retrieveAllCourses();
    }

    public static boolean courseIdExists(int courseId) throws Exception {
        return CourseInfoDAL.courseIdExists(courseId);
    }

    //graduate level should only be 0 or 1
    private static boolean isGradLevelValid(int gradLevel) {
        if (gradLevel < 0 || gradLevel > 1) {
            throw new IllegalArgumentException("Invalid graduate level");
        }
        return true;
    }

    //Checks against the database if the course name exists
    private static boolean courseNameExists(String courseName) throws Exception {
        if (isCourseNameValid(courseName)) {
            return CourseInfoDAL.courseNameExists(courseName);
        }
        return false;
    }

    //is the course id valid?
    public static boolean isCourseIdValid(int courseId) throws Exception {
        if (courseId <= 0) {
            throw new IllegalArgumentException("Invalid Course ID");
        }

        return true;
    }

    //is the session id valid?
    private static boolean isSessionIdValid(int startSession, int endSession) {
        if (startSession < 0) {
            throw new IllegalArgumentException("Start Session is not valid");
        }

        if (endSession < 0) {
            throw new IllegalArgumentException("End Session is not valid");
        }

        if (startSession > endSession) {
            throw new IllegalArgumentException("Start Session cannot be greater than end session");
        }

        return true;
    }

    //gets the course ID by passing in the name
    public static int getCourseIDByName(String courseName) throws Exception {

        if (isCourseNameValid(courseName)) {
            return CourseInfoDAL.getCourseIDByName(courseName);
        }
        return -1;
    }

    //gets the course name by passing in the ID
    public static String getCourseNameByID(int courseID) throws Exception {

        if (isCourseIdValid(courseID)) {
            return CourseInfoDAL.getCourseNameByID(courseID);
        }

        return null;
    }

    //is the course name valid, checks the formatting
    private static boolean isCourseNameValid(String courseName) {

        if (courseName == null) {
            throw new IllegalArgumentException("Course Name cannot be null");
        }
        if (courseName.equals("")) {
            throw new IllegalArgumentException("Course Name cannot be blank");
        }

        if (courseName.replace(" ", "").length() == 0) {
            throw new IllegalArgumentException("Name length should be greater than 0");
        }

        if (courseName.length() > 50) {
            throw new IllegalArgumentException("Name length should be less than or equal to 50");
        }

        return true;
    }

    //response for adding the course to the database, checks all the inputs for validity and duplicates
    public static boolean addCourse(int courseID, String courseName, int offeredDept, int gradLevel) throws Exception {

        if (isCourseIdValid(courseID)) //formatting
        {
            if (!courseIdExists(courseID)) //already exists?
            {
                if (isCourseNameValid(courseName)) //formatting
                {
                    if (!courseNameExists(courseName)) //already exists?
                    {
                        if (DeptInfoManager.isDeptIdValid(offeredDept)) //formatting
                        {
                            if (DeptInfoManager.deptIdExists(offeredDept)) //should already exist
                            {
                                if (isGradLevelValid(gradLevel)) //formatting
                                {
                                    boolean result = CourseInfoDAL.insertCourse(courseID, courseName, offeredDept, gradLevel); //insert
                                    if (result == false) //successful
                                    {
                                        return true;
                                    } else {
                                        return result; //unsuccessful
                                    }
                                }
                            } else {
                                throw new IllegalArgumentException("This Offered Department does not exist.");
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("This course name already exists.");
                    }
                }
            } else {
                throw new IllegalArgumentException("This course already exists.");
            }
        }
        return false;
    }

    //editing an existing course, checks for validity of all the inputs.
    public static boolean editCourse(int courseID, String courseName, int offeredDept, int gradLevel) throws Exception {

        //formatting
        if (isCourseIdValid(courseID)) {
            //already exists
            if (courseIdExists(courseID)) {
                //formatting
                if (isCourseNameValid(courseName)) {
                    //formatting
                    if (DeptInfoManager.isDeptIdValid(offeredDept)) {
                        //should already exist
                        if (DeptInfoManager.deptIdExists(offeredDept)) {
                            //formatting
                            if (isGradLevelValid(gradLevel)) {
                                boolean result = CourseInfoDAL.updateCourse(courseID, courseName, offeredDept, gradLevel);
                                if (result == false) {
                                    return true;
                                } else {
                                    return result;
                                }
                            }
                        } else {
                            throw new IllegalArgumentException("This offered department does not exist.");
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("This course Id does not exist.");
            }
        }
        return false;
    }
    /**
     * Query 6. Find the workload for students who enrolled to certain courses
     * @param courseId The ID of a given course
     * @return Dictionary A Dictionary of student name and workload
     * @throws java.lang.Exception
     */
    
    public static Dictionary<String, Integer> getWorkloadForStudentsInCourse(int courseId) throws Exception {
        if (isCourseIdValid(courseId)) {
            return CourseInfoDAL.getWorkloadForStudentsInCourse(courseId);
        }

        return null;
    }

    /**
     * Query 10 Given a course name and a session range (2 session ids that indicate whether it is before, 
     * during, or after the course), output the ratio between FILE and NETWORK commands used by the students 
     * who has taken the course.
     * @param courseId The ID of a given course
     * @param startSession The starting session number
     * @param endSession The ending session number
     * @return float The ratio of FILE to NETWORK commands
     * @throws java.lang.Exception
     */
    public static float computeFileToNetworkRatioForCourseAndSessions(int courseId, int startSession, int endSession) throws Exception {
        if (isCourseIdValid(courseId)) {
            if (isSessionIdValid(startSession, endSession)) {
                return CourseInfoDAL.computeFileToNetworkRatioForCourseAndSessions(courseId, startSession, endSession);
            }
        }

        return 0.0f;
    }

    /**
     * Query 15. Given the course name, the department name that offers this course, and a threshold of score,
     * output the top five commands that the users who took the course and obtain a score. 
     * @param courseId The ID of a given course
     * @param score The score to use as a threshold
     * @return List A list of the top 5 commands executed
     * @throws java.lang.Exception
     */
    public static List<String> getTopFiveCommands(int courseId, int score) throws Exception {
        return CourseInfoDAL.getTopCommands(courseId, score);
    }

    //get a courseInfo object
    public static ICourseInfo getCourseInfo(int courseId) throws Exception {
        if (isCourseIdValid(courseId)) {
            if (courseIdExists(courseId)) {
                return CourseInfoDAL.getCourseInfo(courseId);
            }
        }
        return null;
    }

    //This is an inner class responsible for Data Access to get and set data for courses, only accessible by CourseInfoManager Class.
    private static class CourseInfoDAL {

        private static ResultSet rs;

        private static List<ICourseInfo> retrieveAllCourses() throws Exception {
            List<ICourseInfo> allCourses = new ArrayList<ICourseInfo>();
            rs = DBUtil.executeQuery("SELECT * FROM COURSE_INFO ORDER BY COURSE_ID ASC");
            while (rs.next()) {
                allCourses.add(new CourseInfo(rs.getInt("COURSE_ID"), rs.getString("COURSE_NAME"), rs.getInt("OFFERED_DEPT"), rs.getInt("GRADUATE_LEVEL")));
            }
            //close resultset
            rs.close();

            return allCourses;
        }

        private static boolean courseIdExists(int courseId) throws Exception {
            rs = DBUtil.executeQuery("Select * FROM COURSE_INFO WHERE COURSE_ID =" + courseId);
            while (rs.next()) {
                return true;
            }
            //close resultset
            rs.close();

            return false;
        }

        private static boolean courseNameExists(String courseName) throws Exception {
            rs = DBUtil.executeQuery("Select * FROM COURSE_INFO WHERE COURSE_NAME ='" + courseName + "'");
            while (rs.next()) {
                return true;
            }
            //close resultset
            rs.close();

            return false;
        }

        private static int getCourseIDByName(String courseName) throws Exception {
            rs = DBUtil.executeQuery("SELECT COURSE_ID FROM COURSE_INFO WHERE COURSE_NAME = '" + courseName + "'");
            while (rs.next()) {
                return rs.getInt("COURSE_ID");
            }
            //close resultset
            rs.close();

            return -1;
        }

        private static String getCourseNameByID(int courseId) throws Exception {
            rs = DBUtil.executeQuery("SELECT COURSE_NAME FROM COURSE_INFO WHERE COURSE_ID = " + courseId + "");
            while (rs.next()) {
                return rs.getString("COURSE_NAME");
            }
            //close resultset
            rs.close();

            return null;
        }

        private static boolean insertCourse(int courseId, String courseName, int offeredDept, int gradLevel) throws Exception {
            return DBUtil.execute("INSERT INTO COURSE_INFO (COURSE_ID,COURSE_NAME,OFFERED_DEPT,GRADUATE_LEVEL) VALUES (" + courseId + ",'" + courseName + "'," + offeredDept + "," + gradLevel + ")");
        }

        private static boolean updateCourse(int courseId, String courseName, int offeredDept, int gradLevel) throws Exception {
            return DBUtil.execute("UPDATE COURSE_INFO SET COURSE_NAME = '" + courseName + "',OFFERED_DEPT = " + offeredDept + ",GRADUATE_LEVEL=" + gradLevel + " WHERE COURSE_ID = " + courseId + " ");
        }

        private static Dictionary<String, Integer> getWorkloadForStudentsInCourse(int courseId) throws Exception {
            rs = DBUtil.executeQuery("SELECT U.FIRST_NAME , U.LAST_NAME , COUNT(UH.COMMAND) COMMANDCOUNT FROM USER_INFO U JOIN USAGE_HISTORY UH ON UH.USER_ID = U.USER_ID JOIN COURSE_INFO C ON C.OFFERED_DEPT = U.DEPT_ID WHERE C.COURSE_ID =" + courseId + " GROUP BY U.FIRST_NAME, U.LAST_NAME ORDER BY COUNT(UH.COMMAND) DESC");
            Dictionary<String, Integer> results = new Hashtable<String, Integer>();
            while (rs.next()) {
                results.put(rs.getString("FIRST_NAME") + " " + rs.getString("LAST_NAME"), rs.getInt("COMMANDCOUNT"));
            }
            //close resultset
            rs.close();

            return results;

        }

        private static float computeFileToNetworkRatioForCourseAndSessions(int courseId, int startSession, int endSession) throws Exception {
            int file = 0;
            int network = 0;

            String sql = "SELECT COUNT(UH.COMMAND) COMMANDCOUNT,UX.CATEGORY FROM USAGE_HISTORY UH " + "JOIN UNIX_COMMAND UX ON UX.UNIX_COMMAND = UH.COMMAND WHERE UH.USER_ID IN " +
                    "(SELECT USER_ID FROM USER_INFO WHERE DEPT_ID IN " +
                    "(SELECT OFFERED_DEPT FROM COURSE_INFO WHERE COURSE_ID =" + courseId + "))" +
                    "AND UH.SESSION_ID BETWEEN " + startSession + " AND " + endSession + "AND UX.CATEGORY = 'FILE' GROUP BY UX.CATEGORY";
            rs = DBUtil.executeQuery(sql);

            while (rs.next()) {
                file = rs.getInt("COMMANDCOUNT");
            }

            if (file == 0) {
                return 0.0f;
            }

            sql = "SELECT COUNT(UH.COMMAND) COMMANDCOUNT,UX.CATEGORY FROM USAGE_HISTORY UH " + "JOIN UNIX_COMMAND UX ON UX.UNIX_COMMAND = UH.COMMAND WHERE UH.USER_ID IN " +
                    "(SELECT USER_ID FROM USER_INFO WHERE DEPT_ID IN " +
                    "(SELECT OFFERED_DEPT FROM COURSE_INFO WHERE COURSE_ID =" + courseId + "))" +
                    "AND UH.SESSION_ID BETWEEN " + startSession + " AND " + endSession + "AND UX.CATEGORY = 'NETWORK' GROUP BY UX.CATEGORY";

            rs = DBUtil.executeQuery(sql);

            while (rs.next()) {
                network = rs.getInt("COMMANDCOUNT");
            }

            //close resultset
            rs.close();

            if (network == 0) {
                return 0.0f;
            }

            float f = (float) file / network; //divide both aggregates and get the ratio
            java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
            return Float.valueOf(df.format(f));

        }

        private static List<String> getTopCommands(int courseId, int score) throws Exception {

            List<String> lst = new ArrayList<String>();

            String SQL = "SELECT UH.COMMAND, COUNT(UH.COMMAND) COMMANDCOUNT FROM USAGE_HISTORY UH " +
                    "WHERE USER_ID IN (SELECT USER_ID FROM TRANSCRIPT WHERE COURSE_ID = " + courseId + " AND SCORE >=" + score + ") " +
                    "GROUP BY UH.COMMAND ORDER BY COUNT(UH.COMMAND) DESC";

            rs = DBUtil.executeQuery(SQL, 5); //give the top 5 commands
            while (rs.next()) {
                lst.add(rs.getString("COMMAND"));
            }

            //close resultset
            rs.close();

            return lst;
        }

        //Item 17//
        private static List<String> outputUserName(String category) throws Exception {
            List<String> lst = new ArrayList<String>();

            String SQL = "SELECT DISTINCT UI.USER_ID, UI.LAST_NAME || ', ' || UI.FIRST_NAME AS NAME " +
                    "FROM USAGE_HISTORY UH, USER_INFO UI " +
                    "WHERE UH.USER_ID = UI.USER_ID AND UH.COMMAND IN " +
                    "(SELECT DISTINCT UNIX_COMMAND FROM UNIX_COMMAND WHERE CATEGORY = '" + category + "') " +
                    "ORDER BY NAME";

            rs = DBUtil.executeQuery(SQL);
            while (rs.next()) {
                lst.add(rs.getString("NAME").trim());//added trim here and removed it from the SQL statement as it was throwing an error
            }
            rs.close();

            return lst;
        }

        private static ICourseInfo getCourseInfo(int courseId) throws Exception {
            rs = DBUtil.executeQuery("SELECT * FROM COURSE_INFO WHERE COURSE_ID =" + courseId + "");

            while (rs.next()) {
                return new CourseInfo(rs.getInt("COURSE_ID"), rs.getString("COURSE_NAME"), rs.getInt("OFFERED_DEPT"), rs.getInt("GRADUATE_LEVEL"));
            }

            return null;
        }
    }
}
