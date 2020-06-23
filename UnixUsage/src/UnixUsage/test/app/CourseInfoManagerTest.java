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
public class CourseInfoManagerTest extends TestCase {

    public CourseInfoManagerTest(String testName) {
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

    public void testAddCourseInvalidCourseId() throws Exception {
        try {
            boolean result = CourseInfoManager.addCourse(-1, "test", 1, 0);
            assertEquals(true, result);
        } catch (IllegalArgumentException ie) //course already exists
        {
            assertEquals("Invalid Course ID", ie.getMessage());
        }
    }

    public void testAddCourseInvalidCourseNameIsNull() throws Exception {
        try {
            boolean result = CourseInfoManager.addCourse(45, null, 1, 0);
            assertEquals(true, result);
        } catch (IllegalArgumentException ie) //course name is null so will fail
        {
            System.out.println(ie.getMessage());
        }
    }

    public void testAddCourseInvalidOfferedDeptDoesNotExist() throws Exception {
        //will fail because the departmentid 2000 does not exist
        try
        {
            CourseInfoManager.addCourse(50, "farooq", 2000, 0);
        }
        catch(IllegalArgumentException ie)
        {
            System.out.println(ie.getMessage());
        }
        
        

    }

    public void testAddCourseOfferedDeptIsZero() throws Exception {
        //will fail because the departmentid is 0
        try {
            boolean result = CourseInfoManager.addCourse(50, "farooq", 0, 0);
        } catch (IllegalArgumentException ie) {
            assertEquals("Invalid Department ID", ie.getMessage());
        }

    }

    public void testAddCourseInvalidGradLevel() throws Exception {
        //will fail because the Graduate level should be 0 or 1
        try {
            boolean result = CourseInfoManager.addCourse(50, "farooq", 1, 2);
        } catch (IllegalArgumentException ie) {
            assertEquals("Invalid graduate level", ie.getMessage());
        }

    }

    public void testAddCourse() throws Exception {
        //Add course, will work first time, second time will cause and exception that is caught
        try {
            CourseInfoManager.addCourse(45, "test", 1, 0);
        } catch (IllegalArgumentException ie) {
        }

    }

    /**
     * Test of EditCourse method, of class CourseInfoManager.
     */
    public void testEditCourse() throws Exception {
        boolean result = CourseInfoManager.editCourse(45, "testchanged", 1, 1);
        assertEquals(true, result);

    }

    public void testEditCourseInvalidGradlevel() throws Exception {
        //editing course fails because of an invalid grad level
        try {
            CourseInfoManager.editCourse(45, "testchanged", 1, 2);
        } catch (IllegalArgumentException ie) {
            assertEquals("Invalid graduate level", ie.getMessage());
        }

    }

}
