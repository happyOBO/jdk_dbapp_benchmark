package app;

/**
 *
 * @author Miftachut Ekasetya
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import junit.framework.TestCase;

public class OfficeInfoManagerTest extends TestCase {
    
    public OfficeInfoManagerTest(String testName) {
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
     * Test of getAllOffices method, of class OfficeInfoManager.
     */
    public void testGetAllOffices() throws Exception {
        boolean expResult = true;
        List result = OfficeInfoManager.getAllOffices();
        assertEquals(expResult, result != null);
    }


    /**
     * Test of addOffice method, of class OfficeInfoManager.
     */
    public void testAddOffice() throws Exception {
        //first time will work, next time will throw an exception
        try
        {
            int officeId = 99;
            String officeName = "TEST-1 OFFICE";
            short hasPrinter = 0;
            OfficeInfoManager.addOffice(officeId, officeName, hasPrinter);
        }
        catch(IllegalArgumentException ie)
        {
            System.out.println(ie.getMessage());
        }
        
        
    }

    /**
     * Test of editOffice method, of class OfficeInfoManager.
     */
    public void testEditOffice() throws Exception {
        //first time will edit, subsequent edits will give an error saying office id already exists
        try
        {
            int officeId = 99;
            String officeName = "TEST-2 OFFICE (UPDATED)";
            short hasPrinter = 0;
            OfficeInfoManager.editOffice(officeId, officeName, hasPrinter);
        }
        catch(IllegalArgumentException ie)
        {
            System.out.println(ie.getMessage());
        }
    }

    public void testGetPrinterUsage() throws Exception {
        List officeIds = new ArrayList();
        officeIds.add(1);
        officeIds.add(2);
                
        boolean expResult = true;
        Map<String, Integer> result = OfficeInfoManager.getPrinterUsage(officeIds);
        assertEquals(expResult, result != null);
    }

    public void testUserWorkLoadForOffices() throws Exception {
        List officeIds = new ArrayList();
        officeIds.add(1);
        officeIds.add(2);

        boolean expResult = true;
        Map<String, Integer> result = OfficeInfoManager.getUserWorkloadForOffices(officeIds);
        assertEquals(expResult, result != null);
    }


    public void testGetOfficeInfoDoesNotExist() throws Exception
    {
        try
        {
            IOfficeInfo i = OfficeInfoManager.getOfficeInfo(2000);
        }
        catch (IllegalArgumentException ie)
        {
            System.out.println(ie.getMessage());
        }
        
    }

}
