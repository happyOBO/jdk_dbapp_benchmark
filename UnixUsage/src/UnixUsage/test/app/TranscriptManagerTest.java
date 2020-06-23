/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Miftachut Ekasetya
 */
public class TranscriptManagerTest extends TestCase {
    
    public TranscriptManagerTest(String testName) {
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
     * Test of getAllTranscripts method, of class TranscriptManager.
     */
    public void testGetAllTranscripts() throws Exception {
        boolean expResult = true;
        List result = TranscriptManager.getAllTranscripts();
        assertEquals(expResult, result != null);
    }

    /**
     * Test of isCourseIdExist method, of class TranscriptManager.
     */
    public void testIsCourseIdExist() throws Exception {
        int courseId = 2;
        boolean expResult = true;
        boolean result = TranscriptManager.isCourseIdExist(courseId);
        assertEquals(expResult, result);
    }

    /**
     * Test of isUserIdExist method, of class TranscriptManager.
     */
    public void testIsUserIdExist() throws Exception {
        String userId = "user0";
        boolean expResult = true;
        boolean result = TranscriptManager.isUserIdExist(userId);
        assertEquals(expResult, result);
    }

    /**
     * Test of isUserIdValidFormat method, of class TranscriptManager.
     */
    public void testIsUserIdValidFormat() throws Exception {
        String userId = "user0";
        boolean expResult = true;
        boolean result = TranscriptManager.isUserIdValidFormat(userId);
        assertEquals(expResult, result);
    }

    /**
     * Test of isCourseIdValidFormat method, of class TranscriptManager.
     */
    public void testIsCourseIdValidFormat() throws Exception {
        int courseId = 2;
        boolean expResult = true;
        boolean result = TranscriptManager.isCourseIdValidFormat(courseId);
        assertEquals(expResult, result);
    }

    /**
     * Test of isScoreValidFormat method, of class TranscriptManager.
     */
    public void testIsScoreValidFormat() throws Exception {
        int score = 100;
        boolean expResult = true;
        boolean result = TranscriptManager.isScoreValidFormat(score);
        assertEquals(expResult, result);
    }

    /**
     * Test of addTranscript method, of class TranscriptManager.
     */
    public void testAddTranscript() throws Exception {
        String userId = "user0";
        int courseId = 3;
        int score = 100;
        boolean expResult = true;
        boolean result = TranscriptManager.addTranscript(userId, courseId, score);
        assertEquals(expResult, result);
    }

    /**
     * Test of editTranscript method, of class TranscriptManager.
     */
    public void testEditTranscript() throws Exception {
        String userId = "user0";
        int courseId = 3;
        int score = 70;
        boolean expResult = true;
        boolean result = TranscriptManager.editTranscript(userId, courseId, score);
        assertEquals(expResult, result);
    }

    public void testGetTranscript() throws Exception {
        ITranscript t= TranscriptManager.getTranscript("user0", 2);
        assertEquals(70, t.getScore());
    }

}
