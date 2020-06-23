/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

/**
 *
 * @author meka2
 */
//Implementor class for Interface ITranscript
public class Transcript implements ITranscript {

    String _userId;
    int _courseId;
    int _score;

    public Transcript(String userId, int courseId, int score) {
        _userId = userId;
        _courseId = courseId;
        _score = score;
    }

    public String getUserId() {
        return _userId;
    }

    public int getCourseId() {
        return _courseId;
    }

    public int getScore() {
        return _score;
    }

    public void setUserId(String userId) {
        _userId = userId;
    }

    public void setCourseId(int courseId) {
        _courseId = courseId;
    }

    public void setScore(int score) {
        _score = score;
    }
}
