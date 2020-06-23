/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Dictionary;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Farooq
 */
public class DeptInfoManagerTest extends TestCase {

    public DeptInfoManagerTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of GetAllDepartments method, of class DeptInfoManager.
     */
    public void testGetAllDepartments() throws Exception {
        List result = DeptInfoManager.getAllDepartments();
        assertEquals(true, result != null);
    }

    /**
     * Test of DeptIdExists method, of class DeptInfoManager.
     */
    public void testDeptIdExists() throws Exception {
        assertEquals(true, DeptInfoManager.deptIdExists(1));
    }

    /**
     * Test of IsDeptIdValid method, of class DeptInfoManager.
     */
    public void testIsDeptIdValid() throws Exception {
        assertEquals(true, DeptInfoManager.isDeptIdValid(1));

    }


    /**
     * Test of AddDepartment method, of class DeptInfoManager.
     */
    public void testAddDepartment() throws Exception {
        //will pass the first time, second time will throw an exception
        try {
            DeptInfoManager.addDepartment(70, "Principal's Office");
        } catch (IllegalArgumentException ie) {
        }

    }

    /**
     * Test of EditDepartment method, of class DeptInfoManager.
     */
    public void testEditDepartment() throws Exception {
        //will pass the first time, will fail second time as it would say the office exists
        try {
            DeptInfoManager.editDepartment(70, "Farooq's Office");
        } catch (IllegalArgumentException ie) {
        }
    }


    /**
     * Test of ComputeFileToNetworkRatioForDept method, of class DeptInfoManager.
     */
    public void testComputeFileToNetworkRatioForDeptFail() throws Exception {
        //this will fail as the dept is not valid
        try {
            DeptInfoManager.computeFileToNetworkRatioForDept(0);
        } catch (IllegalArgumentException ie) {
        }
    }

}
