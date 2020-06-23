/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

import java.util.*;
import java.sql.*;
/**
 *
 * @author KTam
 */

//Manager class for all actions related to Race.
public class RaceInfoManager {

    private static IRaceInfo createRaceInfo(int raceCode, String race)
    {
        return new RaceInfo(raceCode, race);
    }

    public static List<IRaceInfo> getAllRaces() throws Exception
    {
        return RaceInfoDAL.RetrieveAllRaces();
    }

    public static IRaceInfo getRaceInfoByCode(int raceCode) throws Exception {
        if (raceCodeIsValid(raceCode))
            return RaceInfoDAL.getRaceInfo(raceCode);
        
        return null;
    }

    //Validates that a race code is valid and does not already exist
    private static boolean raceCodeIsValid(int raceCode) throws Exception {
        if (raceCode <= 0) {
            throw new IllegalArgumentException("Race code must be a positive number");
        }
        return true;
    }

    //Validates that a race is valid and does not already exist
    private static boolean raceIsValid(String race) throws Exception {
        if (race == null) {
            throw new IllegalArgumentException("Race cannot be null");
        }
        if (race.equals("")) {
            throw new IllegalArgumentException("Race cannot be blank");
        }

        if (race.replace(" ", "").length() == 0) {
            throw new IllegalArgumentException("Race length should be greater than 0");
        }

        if (race.length() > 50) {
            throw new IllegalArgumentException("Race length should be less than or equal to 50");
        }

        if (RaceInfoDAL.raceExists(race)) {
            throw new IllegalArgumentException("Race \"" + race + "\" already exists");
        }

        return true;
    }

    public static boolean addRaceInfo(int raceCode, String race) throws Exception
    {

        if (raceCodeIsValid(raceCode) &&
            raceIsValid(race))
        {
            if (RaceInfoDAL.raceCodeExists(raceCode)) {
                throw new IllegalArgumentException("Race code " + raceCode + " already exists");
            }
            RaceInfoDAL.insertRaceInfo(raceCode, race);
            return true;
        }
        return false;
    }

    public static boolean editRaceInfo(int raceCode, String race) throws Exception
    {
        if (raceCodeIsValid(raceCode) &&
            raceIsValid(race))
        {
            if (!RaceInfoDAL.raceCodeExists(raceCode)) {
                throw new IllegalArgumentException("Race code " + raceCode + " does not exist");
            }
            RaceInfoDAL.updateRaceInfo(raceCode, race);
            return true;
        }
        return false;
    }

    private static class RaceInfoDAL {
        private static ResultSet rs;
        private static List<IRaceInfo> RetrieveAllRaces() throws Exception
        {
            List<IRaceInfo> allRaces = new ArrayList<IRaceInfo>();
            rs = DBUtil.executeQuery("SELECT * FROM RACE_INFO");
            while(rs.next())
            {
                int raceCode = rs.getInt("RACE_CODE");
                String race = rs.getString("RACE");
                allRaces.add(RaceInfoManager.createRaceInfo(raceCode, race));
            }
            return allRaces;
        }

        private static boolean raceCodeExists(int raceCode) throws Exception {
            rs = DBUtil.executeQuery("Select RACE_CODE FROM RACE_INFO WHERE RACE_CODE =" + raceCode);
            int d = -1;

            while (rs.next()) {
                d = rs.getInt("RACE_CODE");
            }

            //close the resultset
            rs.close();

            if (d == -1) {
                return false;
            }

            return true;
        }

        private static boolean raceExists(String race) throws Exception {
            rs = DBUtil.executeQuery("Select RACE FROM RACE_INFO WHERE RACE ='" + race + "'");
            String s = null;

            while (rs.next()) {
                s = rs.getString("RACE");
            }

            //close the resultset
            rs.close();

            if (s == null) {
                return false;
            }
            return true;
        }

        private static IRaceInfo getRaceInfo(int raceCode) throws Exception {
            rs = DBUtil.executeQuery("Select RACE_CODE, RACE FROM RACE_INFO WHERE RACE_CODE =" + raceCode);

            while (rs.next()) {
                return new RaceInfo(raceCode, rs.getString("RACE"));
            }
            return null;
        }

        private static boolean insertRaceInfo(int raceCode, String race) throws Exception {
            return DBUtil.execute("INSERT INTO RACE_INFO (RACE_CODE,RACE) VALUES (" + raceCode + ",'" + race + "')");
        }

        private static boolean updateRaceInfo(int raceCode, String race) throws Exception {
            return DBUtil.execute("UPDATE RACE_INFO SET RACE = '" + race + "' WHERE RACE_CODE = " + raceCode);
        }

    }
}
