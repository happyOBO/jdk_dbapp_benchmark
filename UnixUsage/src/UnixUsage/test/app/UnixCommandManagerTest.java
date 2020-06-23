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
public class UnixCommandManagerTest extends TestCase {
    
    public UnixCommandManagerTest(String testName) {
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

    public void testGetAllCommands() throws Exception {
        List result = UnixCommandManager.getAllCommands();
        assertEquals(true, result != null);
    }

    public void testCommandExists() throws Exception {
        assertEquals(true,UnixCommandManager.commandExists("mkdir"));
    }

    public void testCategoryExists() throws Exception {
        assertEquals(true,UnixCommandManager.categoryExists("FILE"));
    }

    public void testGetCategoryByCommand() throws Exception {
        assertEquals("FILE",UnixCommandManager.getCategoryByCommand("mkdir"));
    }

    public void testGetCommandsByCategory() throws Exception {
        List commands = UnixCommandManager.getCommandsByCategory("FILE");
        assertEquals(true,commands.contains("mkdir"));
    }

    public void testAddUnixCommand() throws Exception {
        //first time will succeed, subsequent attempts will cause an error of a command already existing
        try
        {
            assertEquals(true,UnixCommandManager.addUnixCommand("test", "test"));
        }
        catch(IllegalArgumentException ie)
        {
            System.out.println(ie.getMessage());
        }
    }

    public void testEditCommand() throws Exception {
        //will edit the first time, subsequent edits will result in an exception
        try
        {
            assertEquals(true,UnixCommandManager.editUnixCommand("test1", "test2"));
        }
        catch (IllegalArgumentException ie)
        {
            System.out.println(ie.getMessage());
        }
        
    }

    public void testEditCategory() throws Exception {
        //will edit the first time, subsequent edits will result in an exception
        try
        {
            UnixCommandManager.editUnixCategory("test", "test1", "test1");
        }
        catch (IllegalArgumentException ie)
        {
            System.out.println(ie.getMessage());
        }
    }

    public void testGetUnixCommand() throws Exception {
        IUnixCommand u = UnixCommandManager.getUnixCommand("mkdir");
        assertEquals("FILE",u.getCategory());
    }
    

}
