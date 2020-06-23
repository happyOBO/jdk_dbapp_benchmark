/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author FarooqB
 */

//Implementor class for Inteface IDeptInfo
public class DeptInfo implements IDeptInfo {

    private int _deptId;
    private String _name;

    DeptInfo(int deptId, String name) {
        _deptId = deptId;
        _name = name;
    }

    public int getDeptId() {
        return _deptId;
    }

    public void setDeptId(int deptId) {
        _deptId = deptId;
    }

    public String getDeptName() {
        return _name;
    }

    public void setDeptName(String deptName) {
        _name = deptName;
    }
}
