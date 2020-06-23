package app;

/**
 *
 * @author Miftachut Ekasetya
 * 
 */

import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author meka2
 */
public class UsageHistoryManagerTest extends TestCase {
    
    public UsageHistoryManagerTest(String testName) {
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
     * Test of getMaxLineNo method, of class UsageHistoryManager.
     */
    public void testGetMaxLineNo() throws Exception {
        int expResult = UsageHistoryManager.getMaxLineNo("user0", 1);
        int result = UsageHistoryManager.getMaxLineNo("user0", 1);
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaxSequenceNo method, of class UsageHistoryManager.
     */
    public void testGetMaxSequenceNo() throws Exception {
        String userId = "user0";
        int sessionId = 1;
        int expResult = UsageHistoryManager.getMaxSequenceNo(userId, sessionId);
        int result = UsageHistoryManager.getMaxSequenceNo(userId, sessionId);
        assertEquals(expResult, result);
    }

    /**
     * Test of isSessionIdValid method, of class UsageHistoryManager.
     */
    public void testIsSessionIdValid() {
        assertEquals(true, UsageHistoryManager.isSessionIdValid(1));
    }

    /**
     * Test of getUsageHistoriesById method, of class UsageHistoryManager.
     */
    public void testGetAllUsageHistories() throws Exception {
        List result = UsageHistoryManager.getUsageHistoriesById("user0");
        assertEquals(true, result != null);
    }

    /**
     * Test of isUserIdFormatValid method, of class UsageHistoryManager.
     */
    public void testIsUserIdFormatValid() throws Exception {
        String userId = "user0";
        boolean expResult = true;
        boolean result = UsageHistoryManager.isUserIdFormatValid(userId);
        assertEquals(expResult, result);
    }

    /**
     * Test of isCommandFormatValid method, of class UsageHistoryManager.
     */
    public void testIsCommandFormatValid() {
        String command = "vim";
        boolean expResult = true;
        boolean result = UsageHistoryManager.isCommandFormatValid(command);
        assertEquals(expResult, result);
    }

    /**
     * Test of addUsageHistory method, of class UsageHistoryManager.
     */
    public void testAddUsageHistory_3args() throws Exception {
        String userId = "user0";
        int sessionId = 1;
        String command = "ls /depaul/se549/java mv ./depaul/";
        boolean expResult = true;
        boolean result = UsageHistoryManager.addUsageHistory(userId, sessionId, command);
        assertEquals(expResult, result);
    }

}
