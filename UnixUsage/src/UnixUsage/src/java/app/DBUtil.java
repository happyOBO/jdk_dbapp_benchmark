/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.sql.*;
import java.util.*;

/**
 *
 * @author KTam
 */

//This is the Database Connection Class.  Here we pass the sql statements for making changes to the required tables.
public class DBUtil {

    private static final String _userName = "se549";
    private static final String _password = "se549";
    private static final String _driver = "org.apache.derby.jdbc.ClientDriver";
    private static final String _database ="UnixUsage";

    //return a resultset for data manipulation
    public static ResultSet executeQuery(String sql) throws Exception {
        Class.forName(_driver).newInstance();
        Properties props = new Properties(); // connection properties
        props.put("user", _userName);
        props.put("password", _password);
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/"+_database + "", props);
        PreparedStatement ps = conn.prepareStatement(sql);
        return ps.executeQuery();
    }

    //returns a resultset for a fixed number of rows.
    public static ResultSet executeQuery(String sql, int maxRows) throws Exception {
        Class.forName(_driver).newInstance();
        Properties props = new Properties(); // connection properties
        props.put("user", _userName);
        props.put("password", _password);
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/"+_database+"", props);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setMaxRows(maxRows);
        return ps.executeQuery();
    }

    //adding rows/updating to the database.
    public static boolean execute(String sql) throws Exception {
        Class.forName(_driver).newInstance();
        Properties props = new Properties(); // connection properties
        props.put("user", _userName);
        props.put("password", _password);
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/"+_database+"", props);
        PreparedStatement ps = conn.prepareStatement(sql);
        return ps.execute();
    }
}
