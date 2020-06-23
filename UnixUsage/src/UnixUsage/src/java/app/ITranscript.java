package app;

/**
 *
 * @author Miftachut Ekasetya
 */
public interface ITranscript {

    //gettter
    public String getUserId();
    public int getCourseId();
    public int getScore();

    //setter
    public void setUserId(String userId);
    public void setCourseId(int courseId);
    public void setScore(int score);
}
