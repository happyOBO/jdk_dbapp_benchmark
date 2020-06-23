/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

/**
 *
 * @author Farooq
 */
public interface ICourseInfo {
    int getCourseId();
    void setCourseId(int courseId);
    String getCourseName();
    void setCourseName(String courseName);
    int getDeptId();
    void setDeptId(int deptId);
    void setGradLevel(int gradlLevel);
    int getGradLevel();
}
