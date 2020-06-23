/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import junit.framework.TestCase;
import java.util.List;

/**
 *
 * @author farooqb
 */
public class RaceInfoManagerTest extends TestCase {

    private IRaceInfo raceInfo;

    public RaceInfoManagerTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testGetAllRaces() throws Exception {
        List result = RaceInfoManager.getAllRaces();
        assertEquals(true, result != null);
    }


    public void testAddRaceInfo() throws Exception {
        //will pass the first time, second time will throw exception
        try {
            assertEquals(true, RaceInfoManager.addRaceInfo(6, "South East Asian"));
        } catch (IllegalArgumentException ie) //already exists will be caught here
        {
        }

    }

    public void testEditRaceInfo() throws Exception {
        try {
            assertEquals(true, RaceInfoManager.addRaceInfo(6, "East Asian"));
        } catch (IllegalArgumentException ie) //already exists will be caught here
        {
        }

    }

    public void testAddRaceInfoIDExists() throws Exception
    {
       try {
            assertEquals(true, RaceInfoManager.addRaceInfo(1, "Test"));
        } catch (IllegalArgumentException ie) //id exists will be caught here
        {
            
        }
    }

    public void testAddRaceInfoIDInvalid() throws Exception
    {
       try {
            assertEquals(true, RaceInfoManager.addRaceInfo(-1, "Test"));
        } catch (IllegalArgumentException ie) //id exists will be caught here
        {

        }
    }

    public void testAddRaceInfoRaceInvalid() throws Exception
    {
       try {
            assertEquals(true, RaceInfoManager.addRaceInfo(8, ""));
        } catch (IllegalArgumentException ie) //id exists will be caught here
        {

        }
    }

     public void testAddRaceInfoRaceNull() throws Exception
    {
       try {
            assertEquals(true, RaceInfoManager.addRaceInfo(8, null));
        } catch (IllegalArgumentException ie) //id exists will be caught here
        {

        }
    }

}
