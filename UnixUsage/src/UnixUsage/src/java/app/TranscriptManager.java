package app;

import java.util.*;
import java.sql.*;

/**
 *
 * @author Miftachut Ekasetya
 */

///Manager class for all actions related Transcripts.
public class TranscriptManager {

    private static boolean isTranscriptExist(String userId, int courseId) throws Exception {
        return TranscriptDAL.transcriptExist(userId, courseId);
    }

    //private constructor
    private TranscriptManager() {
    }

    public static List<ITranscript> getAllTranscripts() throws Exception {
        return TranscriptDAL.retrieveAllTranscripts();
    }

    public static ITranscript getTranscript(String userId, int courseId) throws Exception {
        if (CourseInfoManager.isCourseIdValid(courseId)) //formatting
        {
            if (CourseInfoManager.courseIdExists(courseId)) //should exist in database
            {
                if (UserInfoManager.doesUserIdExist(userId)) {
                    return TranscriptDAL.getTranscript(courseId, userId);
                }
            }
        }
        //a filler return statement.
        return null;
    }

    public static boolean isCourseIdExist(int courseId) throws Exception {
        return TranscriptDAL.courseIdExists(courseId);
    }

    public static boolean isUserIdExist(String userId) throws Exception {
        if (isUserIdValidFormat(userId)) {
            return TranscriptDAL.userIdExists(userId);
        } else {
            return false;
        }
    }

    public static boolean isUserIdValidFormat(String userId) throws Exception {
        if (userId == null || userId.length() == 0 || userId.equals("")) {
            throw new IllegalArgumentException("Invalid User ID. User ID " +
                    "cannot be empty or null.");
        } else {
            return true;
        }
    }

    public static boolean isCourseIdValidFormat(int courseId) throws Exception {
        if (courseId < 0) {
            throw new IllegalArgumentException("Invalid Course ID. Course ID " +
                    "cannot be less than zero");
        } else {
            return true;
        }
    }

    public static boolean isScoreValidFormat(int score) throws Exception {
        if (score < 0) {
            throw new IllegalArgumentException("Invalid score. Score " +
                    "cannot be less than zero");
        } else {
            return true;
        }
    }

    public static boolean addTranscript(String userId, int courseId, int score) throws Exception {

        if (!isTranscriptExist(userId, courseId)) {
            if (isUserIdValidFormat(userId)) {
                if (isCourseIdValidFormat(courseId)) {
                    if (isScoreValidFormat(score)) {
                        //this returns false as there is nothing returned so show true
                        if (!TranscriptDAL.insertTranscript(userId, courseId, score)) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean editTranscript(String userId, int courseId, int score) throws Exception {

        if (isUserIdValidFormat(userId)) {
            if (isTranscriptExist(userId, courseId)) {
                if (isCourseIdValidFormat(courseId)) {
                    if (isCourseIdExist(courseId)) {
                        if (isScoreValidFormat(score)) {
                            if (!TranscriptDAL.updateTranscript(userId, courseId, score)) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    /*
     * Inner class for DataAccess
     * */
    private static class TranscriptDAL {

        private static ResultSet rs;

        private static List<ITranscript> retrieveAllTranscripts() throws Exception {
            List<ITranscript> allTranscripts = new ArrayList<ITranscript>();
            rs = DBUtil.executeQuery("SELECT * FROM TRANSCRIPT " +
                    "ORDER BY USER_ID ASC, COURSE_ID, SCORE");
            while (rs.next()) {
                String userId = rs.getString("USER_ID");
                int courseId = rs.getInt("COURSE_ID");
                int score = rs.getInt("SCORE");
                allTranscripts.add(new Transcript(userId, courseId, score));
            }
            //close resultset
            rs.close();

            return allTranscripts;
        }

        private static boolean userIdExists(String userId) throws Exception {
            rs = DBUtil.executeQuery("SELECT USER_ID FROM TRANSCRIPT WHERE USER_ID = '" + userId + "'");
            String _userId = null;

            while (rs.next()) {
                _userId = rs.getString("USER_ID");
            }

            //close the resultset
            rs.close();

            if (_userId == null) {
                return false;
            } else {
                return true;
            }
        }

        private static boolean courseIdExists(int courseId) throws Exception {
            rs = DBUtil.executeQuery("SELECT COURSE_ID FROM COURSE_INFO WHERE COURSE_ID =" + courseId);
            int _courseId = -1;

            while (rs.next()) {
                _courseId = rs.getInt("COURSE_ID");
            }

            //close the resultset
            rs.close();

            if (_courseId == -1) {
                return false;
            } else {
                return true;
            }
        }

        private static boolean insertTranscript(String userId, int courseId, int score) throws Exception {
            return DBUtil.execute("INSERT INTO TRANSCRIPT (USER_ID, COURSE_ID , SCORE) VALUES ('" + userId + "'," + courseId + "," + score + ")");
        }

        private static boolean updateTranscript(String userId, int courseId, int score) throws Exception {
            return DBUtil.execute("UPDATE TRANSCRIPT SET SCORE = " + score + " WHERE USER_ID = '" + userId + "' AND COURSE_ID = " + courseId);
        }

        private static boolean transcriptExist(String userId, int courseId) throws Exception {
            rs = DBUtil.executeQuery("SELECT USER_ID FROM TRANSCRIPT WHERE USER_ID = '" + userId + "' AND COURSE_ID = " + courseId);
            String _userId = null;

            while (rs.next()) {
                _userId = rs.getString("USER_ID");
            }

            //close the resultset
            rs.close();

            if (_userId == null) {
                return false;
            } else {
                return true;
            }

        }

        private static ITranscript getTranscript(int courseId, String userId) throws Exception {
            rs = DBUtil.executeQuery("SELECT USER_ID,COURSE_ID,SCORE FROM TRANSCRIPT WHERE COURSE_ID =" + courseId + " AND USER_ID ='" + userId + "'");

            while (rs.next()) {
                return new Transcript(rs.getString("USER_ID"), rs.getInt("COURSE_ID"), rs.getInt("SCORE"));
            }

            return null;
        }
    }
}
