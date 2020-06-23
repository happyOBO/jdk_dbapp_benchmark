/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.*;
import java.sql.*;

/**
 *
 * @author farooqb
 */
//Manager class for all actions related to Unix Command.
public class UnixCommandManager {

    private UnixCommandManager() //private constructor cannot be instantiated
    {
    }

    //Get all the commands for display
    public static List<IUnixCommand> getAllCommands() throws Exception {
        return UnixCommandDAL.retrieveAllCommands();
    }

    //checks if a command already exists
    public static boolean commandExists(String command) throws Exception {
        return UnixCommandDAL.commandExists(command);
    }

    //checks if the category already exists to avoid duplication
    public static boolean categoryExists(String category) throws Exception {
        if (isValid(category)) {
            return UnixCommandDAL.categoryExists(category);
        }

        return false;
    }

    //returns which category the command belongs to by passing in the command name
    public static String getCategoryByCommand(String command) throws Exception {

        if (isValid(command)) {
            return UnixCommandDAL.getCategoryByCommand(command);
        }

        return null;

    }

    //returns commands by passing in the category
    public static List getCommandsByCategory(String category) throws Exception {

        if (isValid(category)) {
            List results = UnixCommandDAL.getCommandsByCategory(category);
            return results;
        }

        return null;
    }

    //checks the passed in string if its valid in terms of null, blank, length etc.
    private static boolean isValid(String item) {

        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (item.equals("")) {
            throw new IllegalArgumentException("Item cannot be blank");
        }

        if (item.replace(" ", "").length() == 0) {
            throw new IllegalArgumentException("Item length should be greater than 0");
        }

        if (item.length() > 50) {
            throw new IllegalArgumentException("Item length should be less than or equal to 50");
        }

        return true;
    }

    //Main function for adding a Unix Command to the database.  This also checks the validity of the inputs provided
    public static boolean addUnixCommand(String command, String category) throws Exception {

        if (isValid(command)) //formatting
        {
            //does this command already exist?
            if (!commandExists(command))
            {
                if (isValid(category)) //formatting
                {//this returns false as there is nothing returned so show true
                    boolean result = UnixCommandDAL.insertUnixCommand(command, category);
                    if (result == false) {
                        return true;
                    } else {
                        return result;
                    }
                }
            }
            else
                throw new IllegalArgumentException("Command already exists in the database");
        }
        return false;
    }

    //Main function for editing commands.  This also checks the validity of the inputs provided.
    public static boolean editUnixCommand(String oldCommand, String newCommand) throws Exception {
        if (isValid(oldCommand)) //formatting
        {
            //this should already exist for editing
            if (commandExists(oldCommand)) {
                if (isValid(newCommand)) //formatting
                {
                    //the new command should not exist in the database as it would be a duplicate
                    if (commandExists(newCommand)==false) {
                        //reverse false to true as there are no results returned even though the row is updated.
                        boolean result = UnixCommandDAL.updateUnixCommand(oldCommand, newCommand);
                        if (result == false) {
                            return true;
                        } else {
                            return result;
                        }

                    }
                    else
                        throw new IllegalArgumentException("The new command already exists.");
                }
            }
            else
                throw new IllegalArgumentException("this command does not exist in the database, hence it cannot be edited.");
        }
        return false;
    }

        public static boolean editUnixCategory(String command, String oldCategory, String newCategory) throws Exception {
        if (isValid(command)) //formatting
        {
            //this should already exist for editing
            if (commandExists(command)) {
                if (isValid(oldCategory)) //formatting
                {
                    //the new command should not exist in the database as it would be a duplicate
                    if (categoryExists(oldCategory)) {
                        if(isValid(newCategory)) //formatting
                        {
                            //reverse false to true as there are no results returned even though the row is updated.
                            boolean result = UnixCommandDAL.updateUnixCategory(command,newCategory);
                            if (result == false) {
                                return true;
                            } else {
                                return result;
                            }
                        }
                    }
                    else
                        throw new IllegalArgumentException("this category does not exist in the database, hence it cannot be edited.");
                }
            }
            
        }
        return false;
    }
        
    public static IUnixCommand getUnixCommand(String command) throws Exception
    {
        if (isValid(command))
        {
            if (commandExists(command))
                return UnixCommandDAL.getUnixCommand(command); 
        }
        
        return null;
    }



    //inner database access class, visible from this class only
    private static class UnixCommandDAL {

        private static ResultSet rs;

        private static List<IUnixCommand> retrieveAllCommands() throws Exception {
            List<IUnixCommand> allCommands = new ArrayList<IUnixCommand>();
            rs = DBUtil.executeQuery("select * from unix_command order by category,unix_command asc");
            while (rs.next()) {
                allCommands.add(new UnixCommand(rs.getString("UNIX_COMMAND"), rs.getString("CATEGORY")));
            }
            return allCommands;
        }

        private static boolean commandExists(String command) throws Exception {
            rs = DBUtil.executeQuery("Select * FROM UNIX_COMMAND WHERE UNIX_COMMAND ='" + command + "'");
            String cmd = null;
            while(rs.next())
            {
                cmd = rs.getString("UNIX_COMMAND");
            }
            if (cmd == null)
                return false;

            return true;
        }

        private static boolean categoryExists(String category) throws Exception {
            rs = DBUtil.executeQuery("Select CATEGORY FROM UNIX_COMMAND WHERE CATEGORY ='" + category + "'", 1);
            String s = null;

            while (rs.next()) {
                s = rs.getString("CATEGORY");
            }

            //close the resultset
            rs.close();

            if (s == null) {
                return false;
            }
            return true;
        }

        private static String getCategoryByCommand(String command) throws Exception {
            rs = DBUtil.executeQuery("SELECT CATEGORY FROM UNIX_COMMAND WHERE UNIX_COMMAND = '" + command + "'", 1);

            while (rs.next()) {
                return rs.getString("CATEGORY");
            }
            return null;
        }

        private static List getCommandsByCategory(String category) throws Exception {
            rs = DBUtil.executeQuery("SELECT UNIX_COMMAND FROM UNIX_COMMAND WHERE CATEGORY = '" + category + "'");
            List commands = new ArrayList();
            while (rs.next()) {
                commands.add(rs.getString("UNIX_COMMAND"));
            }

            return commands;
        }

        private static boolean insertUnixCommand(String command, String category) throws Exception {
            return DBUtil.execute("INSERT INTO UNIX_COMMAND (UNIX_COMMAND,CATEGORY) VALUES ('" + command + "','" + category + "')");
        }

        private static boolean updateUnixCommand(String oldCommand, String newCommand) throws Exception {
            return DBUtil.execute("UPDATE UNIX_COMMAND SET UNIX_COMMAND= '" + newCommand + "' WHERE UNIX_COMMAND = '" + oldCommand + "' ");
        }

        private static boolean updateUnixCategory(String command, String newCategory) throws Exception
        {
            return DBUtil.execute("UPDATE UNIX_COMMAND SET CATEGORY = '" + newCategory + "' WHERE UNIX_COMMAND ='" + command + "'");
        }

        private static IUnixCommand getUnixCommand(String command) throws Exception
        {
            rs = DBUtil.executeQuery("SELECT * FROM UNIX_COMMAND WHERE UNIX_COMMAND = '" + command + "'");

            while(rs.next())
            {
                return new UnixCommand(rs.getString("UNIX_COMMAND"),rs.getString("CATEGORY"));
            }
            
            return null;
        }
    }
}
