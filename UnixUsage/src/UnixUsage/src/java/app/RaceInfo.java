/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

/**
 *
 * @author KTam
 */

//Implementor class for Interface IRaceInfo

public class RaceInfo implements IRaceInfo {
    
    private int _raceCode;
    private String _race;

    
    RaceInfo(int raceCode, String race)
    {
        _raceCode = raceCode;
        _race = race;
    }

    public int getRaceCode() {
        return _raceCode;
    }

    public void setRaceCode(int raceCode) {
        if (_raceCode <= 0)
            throw new IllegalArgumentException("Invalid Race Code");
        
        //before adding, do we check for duplicates in the database or during insertion?
        _raceCode= raceCode;
        
    }

    public String getRace() {
        return _race;
    }

    public void setRace(String race) {
        if (race.equals(""))
            throw new IllegalArgumentException("Race cannot be blank");
        
        if (race == null)
            throw new IllegalArgumentException("Race cannot be null");
        
        if (race.replace(" ","").length() == 0 )
            throw new IllegalArgumentException("Race length should be greater than 0");
        
        if (race.length() > 50)
            throw new IllegalArgumentException("Race length should be less than or equal to 50");
        
        _race = race;
    }

}
