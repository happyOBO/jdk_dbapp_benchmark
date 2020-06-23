/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

/**
 *
 * @author Farooq
 */

//Implementor class for Interface ICourseInfo
public class CourseInfo implements ICourseInfo {
    
    private int _courseId, _deptId, _grad;
    private String _name;

    CourseInfo(int courseId, String courseName, int offeredDept, int grad)
    {
        _courseId = courseId;
        _name = courseName;
        _deptId = offeredDept;
        _grad = grad;
    }

    public int getCourseId() {
        return _courseId;
    }

    public void setCourseId(int courseId) {
        _courseId = courseId;
    }

    public String getCourseName() {
        return _name;
    }

    public void setCourseName(String courseName) {
        _name = courseName;
    }

    public int getDeptId() {
        return _deptId;
    }

    public void setDeptId(int offeredDept) {
        _deptId = offeredDept;
    }

    public void setGradLevel(int gradLevel) {
        _grad = gradLevel;
    }

    public int getGradLevel() {
        return _grad;
    }

}
