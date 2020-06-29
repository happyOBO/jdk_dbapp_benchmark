package clientv4;
/**
 * @author James
 * 08/04/2019
 * A Client-Server application that allows the storage, retrieval, display and manipulation of data
 * using a SQL database. Zoo Register.
 */

/*
*This classes purpose is to create an animal object that will corspond with what
*is sent to the server, what is received from the server and what is added into
*the JTable. getters and setters created.
*/
public class animal {
    
    //All variables below match with the columbs in the animals table.
    public int iD;
    public String name;
    public String description;
    public int speciesID;
    
    //public constructor for the animal class
    public animal(int iD, String name, String description, int speciesID) {
        
        this.iD = iD;
        this.name = name;
        this.description = description;
        this.speciesID = speciesID;
        
    }
    
    //public getter to retrieve ID value
    public int getID() {
        return iD;
    }
    
    //public getter to retrieve Name value
    public String getName() {
        return name;
    }
    
    //public getter to retrieve description value
    public String getDescription() {
        return description;
    }
    
    //public getter to retrieve speciesID value
    public int getSpeciesID() {
        return speciesID;
    }
}
