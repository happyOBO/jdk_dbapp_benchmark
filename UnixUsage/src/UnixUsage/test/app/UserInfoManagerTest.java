package app;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Naeem Q.
 */
public class UserInfoManagerTest extends TestCase {
    
    public UserInfoManagerTest(String testName) {
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


    public void testAddUserInfo_IUserInfo_NullObject() {
        IUserInfo myUser = null;
        IUserInfo expResult = null;
        try  {

            expResult = UserInfoManager.addUserInfo(myUser);
            fail("testAddUserInfo_IUserInfo_NullObject - Allowed Adding of a null User Object.");
        } catch (Exception ex) {
             assertEquals(expResult, null);
        }
    }

    public void testAddUserInfo_IUserInfo_BadLastName_Null() {
        IUserInfo expResult = null;
        String firstname = "test_first_name";
        String lastname = null;
        String sex = "M";
        int departmentId = 1;
        int officeId = 1;
        int graduate = 1;
        int raceId = 1;
        String password = "password";
        int yearsUsingUnix = 1;
        Date enrollDate = new Date("01/01/2009");
        try  {
            expResult = UserInfoManager.addUserInfo(firstname, lastname, sex, departmentId, officeId, graduate, raceId, password, yearsUsingUnix, enrollDate);
            fail("testAddUserInfo_IUserInfo_BadLastName_Null - Allowed invalid lastname to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }

    public void testAddUserInfo_IUserInfo_BadLastName_EmptyString() {
        IUserInfo expResult = null;
        String firstname = "test_first_name";
        String lastname = "";
        String sex = "M";
        int departmentId = 1;
        int officeId = 1;
        int graduate = 1;
        int raceId = 1;
        String password = "password";
        int yearsUsingUnix = 1;
        Date enrollDate = new Date("01/01/2009");
        try  {
            expResult = UserInfoManager.addUserInfo(firstname, lastname, sex, departmentId, officeId, graduate, raceId, password, yearsUsingUnix, enrollDate);
            fail("testAddUserInfo_IUserInfo_BadLastName_EmptyString - Allowed invalid lastname to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }

     public void testAddUserInfo_IUserInfo_BadFirstName_Null() {
        IUserInfo expResult = null;
        String firstname = null;
        String lastname = "test_last_name";
        String sex = "M";
        int departmentId = 1;
        int officeId = 1;
        int graduate = 1;
        int raceId = 1;
        String password = "password";
        int yearsUsingUnix = 1;
        Date enrollDate = new Date("01/01/2009");
        try  {
            expResult = UserInfoManager.addUserInfo(firstname, lastname, sex, departmentId, officeId, graduate, raceId, password, yearsUsingUnix, enrollDate);
            fail("testAddUserInfo_IUserInfo_BadFirstName_Null - Allowed invalid firstname to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }

    public void testAddUserInfo_IUserInfo_BadFirstName_EmptyString() {
        IUserInfo expResult = null;
        String firstname = "";
        String lastname = "test_last_name";
        String sex = "M";
        int departmentId = 1;
        int officeId = 1;
        int graduate = 1;
        int raceId = 1;
        String password = "password";
        int yearsUsingUnix = 1;
        Date enrollDate = new Date("01/01/2009");
        try  {
            expResult = UserInfoManager.addUserInfo(firstname, lastname, sex, departmentId, officeId, graduate, raceId, password, yearsUsingUnix, enrollDate);
            fail("testAddUserInfo_IUserInfo_BadFirstName_EmptyString - Allowed invalid firstname to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }


    public void testAddUserInfo_IUserInfo_BadSex() {
        IUserInfo expResult = null;
        String firstname = "test_first_name";
        String lastname = "test_last_name";
        String sex = "";
        int departmentId = 1;
        int officeId = 1;
        int graduate = 1;
        int raceId = 1;
        String password = "password";
        int yearsUsingUnix = 1;
        Date enrollDate = new Date("01/01/2009");
        try  {
            expResult = UserInfoManager.addUserInfo(firstname, lastname, sex, departmentId, officeId, graduate, raceId, password, yearsUsingUnix, enrollDate);
            fail("testAddUserInfo_IUserInfo_BadSex - Allowed invalid sex to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }

    public void testAddUserInfo_IUserInfo_BadDepartmentId() {
        IUserInfo expResult = null;
        String firstname = "test_first_name";
        String lastname = "test_last_name";
        String sex = "";
        int departmentId = 0;
        int officeId = 1;
        int graduate = 1;
        int raceId = 1;
        String password = "password";
        int yearsUsingUnix = 1;
        Date enrollDate = new Date("01/01/2009");
        try  {
            expResult = UserInfoManager.addUserInfo(firstname, lastname, sex, departmentId, officeId, graduate, raceId, password, yearsUsingUnix, enrollDate);
            fail("testAddUserInfo_IUserInfo_BadDepartmentId - Allowed invalid department id to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }


    public void testAddUserInfo_IUserInfo_BadOfficeId() {
        IUserInfo expResult = null;
        String firstname = "test_first_name";
        String lastname = "test_last_name";
        String sex = "";
        int departmentId = 1;
        int officeId = 0;
        int graduate = 1;
        int raceId = 1;
        String password = "password";
        int yearsUsingUnix = 1;
        Date enrollDate = new Date("01/01/2009");
        try  {
            expResult = UserInfoManager.addUserInfo(firstname, lastname, sex, departmentId, officeId, graduate, raceId, password, yearsUsingUnix, enrollDate);
            fail("testAddUserInfo_IUserInfo_BadOfficeId - Allowed invalid office id to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }

    public void testAddUserInfo_IUserInfo_BadGraduate() {
        IUserInfo expResult = null;
        String firstname = "test_first_name";
        String lastname = "test_last_name";
        String sex = "";
        int departmentId = 1;
        int officeId = 1;
        int graduate = -1;
        int raceId = 1;
        String password = "password";
        int yearsUsingUnix = 1;
        Date enrollDate = new Date("01/01/2009");
        try  {
            expResult = UserInfoManager.addUserInfo(firstname, lastname, sex, departmentId, officeId, graduate, raceId, password, yearsUsingUnix, enrollDate);
            fail("testAddUserInfo_IUserInfo_BadGraduate - Allowed invalid graduate to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }

    public void testAddUserInfo_IUserInfo_BadRaceId() {
        IUserInfo expResult = null;
        String firstname = "test_first_name";
        String lastname = "test_last_name";
        String sex = "";
        int departmentId = 1;
        int officeId = 1;
        int graduate = 1;
        int raceId = 0;
        String password = "password";
        int yearsUsingUnix = 1;
        Date enrollDate = new Date("01/01/2009");
        try  {
            expResult = UserInfoManager.addUserInfo(firstname, lastname, sex, departmentId, officeId, graduate, raceId, password, yearsUsingUnix, enrollDate);
            fail("testAddUserInfo_IUserInfo_BadRaceId - Allowed invalid race id to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }

    public void testAddUserInfo_IUserInfo_BadPassword() {
        IUserInfo expResult = null;
        String firstname = "test_first_name";
        String lastname = "test_last_name";
        String sex = "";
        int departmentId = 1;
        int officeId = 1;
        int graduate = 1;
        int raceId = 1;
        String password = "";
        int yearsUsingUnix = 1;
        Date enrollDate = new Date("01/01/2009");
        try  {
            expResult = UserInfoManager.addUserInfo(firstname, lastname, sex, departmentId, officeId, graduate, raceId, password, yearsUsingUnix, enrollDate);
            fail("testAddUserInfo_IUserInfo_BadPassword - Allowed invalid password to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }

    public void testAddUserInfo_IUserInfo_BadYearsUsingUnix() {
        IUserInfo expResult = null;
        String firstname = "test_first_name";
        String lastname = "test_last_name";
        String sex = "";
        int departmentId = 1;
        int officeId = 1;
        int graduate = 1;
        int raceId = 1;
        String password = "password";
        int yearsUsingUnix = -1;
        Date enrollDate = new Date("01/01/2009");
        try  {
            expResult = UserInfoManager.addUserInfo(firstname, lastname, sex, departmentId, officeId, graduate, raceId, password, yearsUsingUnix, enrollDate);
            fail("testAddUserInfo_IUserInfo_BadYearsUsingUnix - Allowed invalid years using unix to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }

    public void testAddUserInfo_IUserInfo_BadEnrollDate() {
        IUserInfo expResult = null;
        String firstname = "test_first_name";
        String lastname = "test_last_name";
        String sex = "";
        int departmentId = 1;
        int officeId = 1;
        int graduate = 1;
        int raceId = 1;
        String password = "password";
        int yearsUsingUnix = 1;
        Date enrollDate = null;
        try  {
            expResult = UserInfoManager.addUserInfo(firstname, lastname, sex, departmentId, officeId, graduate, raceId, password, yearsUsingUnix, enrollDate);
            fail("testAddUserInfo_IUserInfo_BadEnrollDate - Allowed invalid enroll date to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }

    public void testAddUserInfo_IUserInfo_GoodValues() {
        IUserInfo expResult = null;
        String firstname = "test_first_name";
        String lastname = "test_last_name";
        String sex = "M";
        int departmentId = 1;
        int officeId = 1;
        int graduate = 1;
        int raceId = 1;
        String password = "password";
        int yearsUsingUnix = 1;
        Date enrollDate = new Date("01/01/2009");
        try  {
            expResult = UserInfoManager.addUserInfo(firstname, lastname, sex, departmentId, officeId, graduate, raceId, password, yearsUsingUnix, enrollDate);
            assertTrue("Firstname not the same", expResult.getFirstname().equals(firstname));
            assertTrue("Lastname not the same", expResult.getLastname().equals(lastname));
            assertTrue("Sex not the same", expResult.getSex().equals(sex));
            assertTrue("Department Id not the same", expResult.getDepartmentId()==departmentId);
            assertTrue("Office Id not the same", expResult.getOfficeId()==officeId);
            assertTrue("Graduate not the same", expResult.getGraduate()==graduate);
            assertTrue("Race Id not the same", expResult.getRaceId()==raceId);
            assertTrue("Password not the same", expResult.getPassword().equals(password));
            assertTrue("Years Using Unix not the same", expResult.getYearsUsingUnix()==yearsUsingUnix);
            assertTrue("Enroll Date not the same", expResult.getEnrollDate().equals(enrollDate));

        } catch (Exception ex) {
             fail("Error in testAddUserInfo_IUserInfo_GoodValues - The object inserted is not the same as the object sent in.");
        }
    }


    // ----------------------------------------------------------------------------------------------------------------------------
    //                 Edit User Info Test Cases
    // ----------------------------------------------------------------------------------------------------------------------------

    public void testEditUserInfo_IUserInfo_NullObject() {
        IUserInfo myUser = null;
        IUserInfo expResult = null;
        try  {
            expResult = UserInfoManager.editUserInfo(myUser);
            fail("testEditUserInfo_IUserInfo_NullObject - Allowed Editing of a null User Object.");
        } catch (Exception ex) {
             assertEquals(expResult, null);
        }
    }

    public void testEditUserInfo_IUserInfo_BadLastName_Null() {
        IUserInfo myUser = null;
        IUserInfo expResult = null;
        String lastname = null;
        try  {
            myUser = UserInfoManager.getUserBy("user8");
            expResult = UserInfoManager.editUserInfo(myUser.getUserId()
                    , myUser.getFirstname()
                    , lastname
                    , myUser.getSex()
                    , myUser.getDepartmentId()
                    , myUser.getOfficeId()
                    , myUser.getGraduate()
                    , myUser.getRaceId()
                    , myUser.getPassword()
                    , myUser.getYearsUsingUnix()
                    , myUser.getEnrollDate());
            fail("testAddUserInfo_IUserInfo_BadLastName_Null - Allowed invalid lastname to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }

    public void testEditUserInfo_IUserInfo_BadLastName_EmptyString() {
        IUserInfo myUser = null;
        IUserInfo expResult = null;
        String lastname = "";
        try  {
            myUser = UserInfoManager.getUserBy("user8");
            expResult = UserInfoManager.editUserInfo(myUser.getUserId()
                    , myUser.getFirstname()
                    , lastname
                    , myUser.getSex()
                    , myUser.getDepartmentId()
                    , myUser.getOfficeId()
                    , myUser.getGraduate()
                    , myUser.getRaceId()
                    , myUser.getPassword()
                    , myUser.getYearsUsingUnix()
                    , myUser.getEnrollDate());
            fail("testEditUserInfo_IUserInfo_BadLastName_EmptyString - Allowed invalid lastname to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }


    public void testEditUserInfo_IUserInfo_BadFirstName_Null() {
        IUserInfo myUser = null;
        IUserInfo expResult = null;
        String firstname = null;
        try  {
            myUser = UserInfoManager.getUserBy("user8");
            expResult = UserInfoManager.editUserInfo(myUser.getUserId()
                    , firstname
                    , myUser.getLastname()
                    , myUser.getSex()
                    , myUser.getDepartmentId()
                    , myUser.getOfficeId()
                    , myUser.getGraduate()
                    , myUser.getRaceId()
                    , myUser.getPassword()
                    , myUser.getYearsUsingUnix()
                    , myUser.getEnrollDate());
            fail("testEditUserInfo_IUserInfo_BadFirstName_Null - Allowed invalid firstname to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }

    public void testEditUserInfo_IUserInfo_BadFirstName_EmptyString() {
        IUserInfo myUser = null;
        IUserInfo expResult = null;
        String firstname = "";
        try  {
            myUser = UserInfoManager.getUserBy("user8");
            expResult = UserInfoManager.editUserInfo(myUser.getUserId()
                    , firstname
                    , myUser.getLastname()
                    , myUser.getSex()
                    , myUser.getDepartmentId()
                    , myUser.getOfficeId()
                    , myUser.getGraduate()
                    , myUser.getRaceId()
                    , myUser.getPassword()
                    , myUser.getYearsUsingUnix()
                    , myUser.getEnrollDate());
            fail("testEditUserInfo_IUserInfo_BadFirstName_EmptyString - Allowed invalid firstname to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }


    public void testEditUserInfo_IUserInfo_BadSex() {
        IUserInfo myUser = null;
        IUserInfo expResult = null;
        String sex = "";
        try  {
            myUser = UserInfoManager.getUserBy("user8");
            expResult = UserInfoManager.editUserInfo(myUser.getUserId()
                    , myUser.getFirstname()
                    , myUser.getLastname()
                    , sex
                    , myUser.getDepartmentId()
                    , myUser.getOfficeId()
                    , myUser.getGraduate()
                    , myUser.getRaceId()
                    , myUser.getPassword()
                    , myUser.getYearsUsingUnix()
                    , myUser.getEnrollDate());
            fail("testEditUserInfo_IUserInfo_BadSex - Allowed invalid sex to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }

    public void testEditUserInfo_IUserInfo_BadDepartmentId() {
        IUserInfo myUser = null;
        IUserInfo expResult = null;
        int departmentId = 0;
        try  {
            myUser = UserInfoManager.getUserBy("user8");
            expResult = UserInfoManager.editUserInfo(myUser.getUserId()
                    , myUser.getFirstname()
                    , myUser.getLastname()
                    , myUser.getSex()
                    , departmentId
                    , myUser.getOfficeId()
                    , myUser.getGraduate()
                    , myUser.getRaceId()
                    , myUser.getPassword()
                    , myUser.getYearsUsingUnix()
                    , myUser.getEnrollDate());
            fail("testEditUserInfo_IUserInfo_BadDepartmentId - Allowed invalid department id to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }


    public void testEditUserInfo_IUserInfo_BadOfficeId() {
        IUserInfo myUser = null;
        IUserInfo expResult = null;
        int officeId = 0;
        try  {
            myUser = UserInfoManager.getUserBy("user8");
            expResult = UserInfoManager.editUserInfo(myUser.getUserId()
                    , myUser.getFirstname()
                    , myUser.getLastname()
                    , myUser.getSex()
                    , myUser.getDepartmentId()
                    , officeId
                    , myUser.getGraduate()
                    , myUser.getRaceId()
                    , myUser.getPassword()
                    , myUser.getYearsUsingUnix()
                    , myUser.getEnrollDate());
            fail("testEditUserInfo_IUserInfo_BadOfficeId - Allowed invalid office id to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }

    public void testEditUserInfo_IUserInfo_BadGraduate() {
        IUserInfo myUser = null;
        IUserInfo expResult = null;
        int graduate = 2;
        try  {
            myUser = UserInfoManager.getUserBy("user8");
            expResult = UserInfoManager.editUserInfo(myUser.getUserId()
                    , myUser.getFirstname()
                    , myUser.getLastname()
                    , myUser.getSex()
                    , myUser.getDepartmentId()
                    , myUser.getOfficeId()
                    , graduate
                    , myUser.getRaceId()
                    , myUser.getPassword()
                    , myUser.getYearsUsingUnix()
                    , myUser.getEnrollDate());
            fail("testEditUserInfo_IUserInfo_BadGraduate - Allowed invalid graduate to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }

    public void testEditUserInfo_IUserInfo_BadRaceId() {
        IUserInfo myUser = null;
        IUserInfo expResult = null;
        int raceId = 0;
        try  {
            myUser = UserInfoManager.getUserBy("user8");
            expResult = UserInfoManager.editUserInfo(myUser.getUserId()
                    , myUser.getFirstname()
                    , myUser.getLastname()
                    , myUser.getSex()
                    , myUser.getDepartmentId()
                    , myUser.getOfficeId()
                    , myUser.getGraduate()
                    , raceId
                    , myUser.getPassword()
                    , myUser.getYearsUsingUnix()
                    , myUser.getEnrollDate());
            fail("testEditUserInfo_IUserInfo_BadRaceId - Allowed invalid race id to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }

    public void testEditUserInfo_IUserInfo_BadPassword() {
        IUserInfo myUser = null;
        IUserInfo expResult = null;
        String password = "";
        try  {
            myUser = UserInfoManager.getUserBy("user8");
            expResult = UserInfoManager.editUserInfo(myUser.getUserId()
                    , myUser.getFirstname()
                    , myUser.getLastname()
                    , myUser.getSex()
                    , myUser.getDepartmentId()
                    , myUser.getOfficeId()
                    , myUser.getGraduate()
                    , myUser.getRaceId()
                    , password
                    , myUser.getYearsUsingUnix()
                    , myUser.getEnrollDate());
            fail("testEditUserInfo_IUserInfo_BadPassword - Allowed invalid password to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }

    public void testEditUserInfo_IUserInfo_BadYearsUsingUnix() {
        IUserInfo myUser = null;
        IUserInfo expResult = null;
        int yearsUsingUnix = -1;
        try  {
            myUser = UserInfoManager.getUserBy("user8");
            expResult = UserInfoManager.editUserInfo(myUser.getUserId()
                    , myUser.getFirstname()
                    , myUser.getLastname()
                    , myUser.getSex()
                    , myUser.getDepartmentId()
                    , myUser.getOfficeId()
                    , myUser.getGraduate()
                    , myUser.getRaceId()
                    , myUser.getPassword()
                    , yearsUsingUnix
                    , myUser.getEnrollDate());
            fail("testEditUserInfo_IUserInfo_BadYearsUsingUnix - Allowed invalid years using unix to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }

    public void testEditUserInfo_IUserInfo_BadEnrollDate() {
        IUserInfo myUser = null;
        IUserInfo expResult = null;
        Date enrollDate = null;
        try  {
            myUser = UserInfoManager.getUserBy("user8");
            expResult = UserInfoManager.editUserInfo(myUser.getUserId()
                    , myUser.getFirstname()
                    , myUser.getLastname()
                    , myUser.getSex()
                    , myUser.getDepartmentId()
                    , myUser.getOfficeId()
                    , myUser.getGraduate()
                    , myUser.getRaceId()
                    , myUser.getPassword()
                    , myUser.getYearsUsingUnix()
                    , enrollDate);
            fail("testEditUserInfo_IUserInfo_BadEnrollDate - Allowed invalid enroll date to be set.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }

    public void testEditUserInfo_IUserInfo_GoodValues() {
        IUserInfo myUser = null;
        IUserInfo expResult = null;
        String firstname = "edited_first_name";
        String lastname = "edited_last_name";
        String sex = "F";
        int departmentId = 2;
        int officeId = 3;
        int graduate = 1;
        int raceId = 2;
        String password = "edited_password";
        int yearsUsingUnix = 65;
        Date enrollDate = new Date("01/01/2009");
        try  {
            myUser = UserInfoManager.getUserBy("user8");
            expResult = UserInfoManager.editUserInfo(myUser.getUserId()
                    , firstname
                    , lastname
                    , sex
                    , departmentId
                    , officeId
                    , graduate
                    , raceId
                    , password
                    , yearsUsingUnix
                    , enrollDate);
            assertTrue("Firstname not the same", expResult.getFirstname().equals(firstname));
            assertTrue("Lastname not the same", expResult.getLastname().equals(lastname));
            assertTrue("Sex not the same", expResult.getSex().equals(sex));
            assertTrue("Department Id not the same", expResult.getDepartmentId()==departmentId);
            assertTrue("Office Id not the same", expResult.getOfficeId()==officeId);
            assertTrue("Graduate not the same", expResult.getGraduate()==graduate);
            assertTrue("Race Id not the same", expResult.getRaceId()==raceId);
            assertTrue("Password not the same", expResult.getPassword().equals(password));
            assertTrue("Years Using Unix not the same", expResult.getYearsUsingUnix()==yearsUsingUnix);
            assertTrue("Enroll Date not the same", expResult.getEnrollDate().equals(enrollDate));

        } catch (Exception ex) {
           fail("Error in testEditUserInfo_IUserInfo_GoodValues." + ex.getMessage());
        }
    }



    // ----------------------------------------------------------------------------------------------------------------------------
    //                 Get User By Test Cases
    // ----------------------------------------------------------------------------------------------------------------------------

    public void testGetUserBy_BadId_Null()  {
        IUserInfo myUser = null;
        IUserInfo expResult = null;
        try  {
            myUser = UserInfoManager.getUserBy(null);
            fail("testEditUserInfo_IUserInfo_BadEnrollDate - Allowed invalid input param to be null.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }

    public void testGetUserBy_BadId_EmptyString() {
        IUserInfo myUser = null;
        IUserInfo expResult = null;
        try  {
            myUser = UserInfoManager.getUserBy("");
            fail("testGetUserBy_BadId_EmptyString - Allowed invalid input param to be empty string.");

        } catch (Exception ex) {
           assertTrue(expResult==null);
        }
    }


    public void testGetUserBy_GoodId()  {
        IUserInfo myUser = null;
        String userId = "user1";
        try  {
            myUser = UserInfoManager.getUserBy(userId);
            assertTrue(myUser!=null);
            assertTrue(myUser.getUserId().equals(userId));
        } catch (Exception ex) {
           fail("failed in testGetUserBy_GoodId. " + ex.getMessage());

        }
    }

    // ----------------------------------------------------------------------------------------------------------------------------
    //                 Does User Id Exist Test Case
    // ----------------------------------------------------------------------------------------------------------------------------

    public void testDoesUserIdExist_False() {
        String userId = "";
        boolean expResult = false;
        try {
            boolean result = UserInfoManager.doesUserIdExist(userId);
            assertEquals(expResult, result);
        } catch (Exception ex) {
            fail("failed in testDoesUserIdExist_False");
        }
    }

    public void testDoesUserIdExist_True() {
        String userId = "user1";
        boolean expResult = true;
        try {
            boolean result = UserInfoManager.doesUserIdExist(userId);
            assertEquals(expResult, result);
        } catch (Exception ex) {
            fail("failed in testDoesUserIdExist_True");
        }
    }

    /**
     * Test of GetPrinterUsage method, of class UserInfoManager.
     */

    public void testGetPrinterUsage_BadInput() {
        List<String> userIds = null;
        HashMap expResult = null;
        try {
            expResult = UserInfoManager.getPrinterUsage(userIds);
            fail("failed in testGetPrinterUsage_BadInput - Allowed null list of id's as param.");
        } catch (Exception ex) {
            assertTrue(expResult==null);
        }
    }

    public void testGetPrinterUsage_GoodInput() {
        List<String> userIds = new ArrayList<String>();
        userIds.add("user1");
        HashMap expResult = null;
        try {
            expResult = UserInfoManager.getPrinterUsage(userIds);
            assertTrue(expResult!=null);
        } catch (Exception ex) {
           fail("failed in testGetPrinterUsage_GoodInput - " + ex.getMessage());
        }
    }

    /**
     * Test of GetWorkloadByScore method, of class UserInfoManager.
     */

    public void testGetWorkloadByScore_BadInput() {
        int startScore = 30;
        int endScore = 1;
        HashMap expResult = null;
        try {
            expResult = UserInfoManager.getWorkloadByScore(startScore, endScore);
            fail("failed in testGetWorkloadByScore_BadInput - invalid score range.");
        } catch (Exception ex) {
            assertTrue(expResult==null);
        }
    }

    public void testGetWorkloadByScore_GoodInput() {
        int startScore = 0;
        int endScore = 100;
        HashMap expResult = null;
        try {
            expResult = UserInfoManager.getWorkloadByScore(startScore, endScore);
            assertTrue(expResult!=null);
        } catch (Exception ex) {
            fail("failed in testGetWorkloadByScore_GoodInput - " + ex.getMessage());
        }
    }

    /**
     * Test of GetWorkloadGreaterThanEqualToGPA method, of class UserInfoManager.
     */
    public void testGetWorkloadGreaterThanEqualToGPA_BadInput()  {
        
        float inGPA = -1.0F;
        int expResult = 0;
        try {
            expResult = UserInfoManager.getWorkloadGreaterThanEqualToGPA(inGPA);
            fail("testGetWorkloadGreaterThanEqualToGPA_BadInput - Allowed invalid gpa as input");
        }
        catch (Exception ex) {
            assertEquals(expResult, 0);
        }
    }

    public void testGetWorkloadGreaterThanEqualToGPA_GoodInput() {
        
        float inGPA = 0.0F;
        int expResult = 0;
        try {
            expResult = UserInfoManager.getWorkloadGreaterThanEqualToGPA(inGPA);
            assertTrue(expResult>0);
        }
        catch (Exception ex) {
            fail("testGetWorkloadGreaterThanEqualToGPA_GoodInput - " + ex.getMessage());
        }
    }

    /**
     * Test of GetWorkloadLessThanGPA method, of class UserInfoManager.
     */
   public void testGetWorkloadLessThanGPA_BadInput()  {
        float inGPA = -1.0F;
        int expResult = 0;

        try {
            expResult = UserInfoManager.getWorkloadLessThanGPA(inGPA);
            fail("testGetWorkloadLessThanGPA_BadInput - Allowed invalid gpa as input");
        }
        catch (Exception ex) {
            assertEquals(expResult, 0);
        }
    }

    public void testGetWorkloadLessThanGPA_GoodInput() {
        float inGPA = 4.0F;
        int expResult = 0;
        try {
            expResult = UserInfoManager.getWorkloadLessThanGPA(inGPA);
            assertTrue(expResult>0);
        }
        catch (Exception ex) {
            fail("testGetWorkloadLessThanGPA_GoodInput - " + ex.getMessage());
        }
    }

    /**
     * Test of GetListOfUserInfo method, of class UserInfoManager.
     */
    public void testGetListOfUserInfo()  {
        List expResult = null;
        try {
            expResult = UserInfoManager.getListOfUserInfo();
            assertTrue(expResult != null);
        } catch (Exception ex) {
            fail("testGetListOfUserInfo - " + ex.getMessage());
        }
    }

    /**
     * Test of GetWorkloadByGraduateLevel method, of class UserInfoManager.
     */

    public void testGetWorkloadByGraduateLevel_BadInput()  {
        int graduate = 3;
        int expResult = 0;
        try {
            expResult = UserInfoManager.getWorkloadByGraduateLevel(graduate);
            fail("testGetWorkloadByGraduateLevel_BadInput - invalid graduate level allowed as input param");
        } catch (Exception ex) {
            assertTrue(expResult==0);
        }
    }

    public void testGetWorkloadByGraduateLevel_GoodInput() {
        int graduate = 0;
        int expResult = 0;
        try {
            expResult = UserInfoManager.getWorkloadByGraduateLevel(graduate);
            assertTrue(expResult>0);
        } catch (Exception ex) {
            fail("testGetWorkloadByGraduateLevel_GoodInput - " + ex.getMessage());
        }
    }

    /**
     * Test of GetUsersByCommandCategory method, of class UserInfoManager.
     */
    public void testGetUsersByCommandCategory(){
        HashMap expResult = null;
        try {
            expResult = UserInfoManager.getUsersByCommandCategory();
            assertTrue(expResult != null);
        } catch (Exception ex) {
            fail("testGetUsersByCommandCategory - " + ex.getMessage());
        }
    }

    /**
     * Test of ComputeLatexToNoLatexPasswordLengthRatio method, of class UserInfoManager.
     */
    public void testComputeLatexToNoLatexPasswordLengthRatio() {
        float expResult = 0.0F;
        try {
            expResult = UserInfoManager.computeLatexToNoLatexPasswordLengthRatio();
            assertTrue(expResult>0.0f);
        } catch (Exception ex) {
            fail("testComputeLatexToNoLatexPasswordLengthRatio - " + ex.getMessage());
        }
    }

}
