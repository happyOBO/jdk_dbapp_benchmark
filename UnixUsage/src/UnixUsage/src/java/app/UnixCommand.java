/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author farooqb
 */
//Implementor class for the Interface IUnixCommand
public class UnixCommand implements IUnixCommand {

    private String _command,_category;


    UnixCommand(String command, String category) {
        _command = command;
        _category = category;
    }

    public String getUnixCommand() {
        return _command;
    }

    public void setUnixCommand(String command) {
        _command = command;
    }

    public String getCategory() {
        return _category;
    }

    public void setCategory(String category) {
        _category = category;
    }
}
