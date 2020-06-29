package clientv4;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 * @author James
 * 08/04/2019
 * A Client-Server application that allows the storage, retrieval, display and manipulation of data
 * using a SQL database. Zoo Register.
 */

/*
*This classis one of the most important classes regarding the client server application, 
*it houses all socket objects, readers and writers, 
*it houses all methods relating to the client app connecting to the server app
*IT feeds functionality to the Homescreen class, adminScreen class and adminLogin class.
*/
public class cliConn {
    
    Socket cliSoc;
    BufferedReader input;
    PrintWriter output;
    ObjectInputStream objin;
    
    //Constructor for the CliConn class
    public cliConn() {
        
    }
    
    //This method is called to initialize socket connection as well as readers and writers with the server.
    public void connectTheServer() {
        try {
            cliSoc = new Socket("localhost", 7777);
            input = new BufferedReader(new InputStreamReader(cliSoc.getInputStream()));
            output = new PrintWriter(new BufferedOutputStream(cliSoc.getOutputStream()), true);
            objin = new ObjectInputStream(cliSoc.getInputStream());
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error occured establishing connection to the server");
        }
    }
    
    /*this method is called by adminLogin class screen to validate input. 
     *It communicates with the server using a socket, a reader and a writer.
     */
    public String validateCred(String username, String password) {
        String validation = "";
        
        output.println("1");
        output.println(username);
        output.println(password);
        
        try {
            validation = input.readLine();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error occured receiving validation on admin credentials.");
        }
        return validation;
    }
    
    /*this method is called by HomeScreen class to communicate with the 
     *server and provide it with key info to search for users choice of animal.
     */
    public animal[] searchAnimals(String animalKeyword) {
        ArrayList<animal> animalList = new ArrayList();
        
        output.println("2");
        output.println(animalKeyword);
        try {
            do{
            animal animal = (animal)objin.readObject();    
            animalList.add(animal);
            if (animal==null) {
                break;
            }
            } while (true);
        } catch (ClassNotFoundException | IOException me) {
            JOptionPane.showMessageDialog(null, "Error receiving animal objects");
        }
        animal[] animalsArray = (animal[])animalList.toArray();
        return animalsArray;
    }
    
    /*this method is called by HomeScreen class to communicate with the 
     *server and provide it with key info to search for users choice of species.
     */
    public String[][] searchSpecies(String speciesKeyword) {
        String speciesToArray = "";
        
        output.println("3");
        output.println(speciesKeyword);
        
        try {
            speciesToArray = input.readLine();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error occured in the seaarchSpecies Method");
        }
        String[] split = speciesToArray.split("-");
        int rows = split.length/2;
        String[][] tableData = new String[rows][2];
        int count = 0;
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < 2; i++) {
                tableData[j][i] = split[count];
                count++;
            }
        }
        return tableData;
    }
    
    /*this method is called by adminScreen class to communicate with the 
     *server and provide it with key info to add the animal data specified by 
     *the admin user.
     */
    public String addAnimal(String animalName, String description, String speciesID) {
        String success = "false";
        
        try {
            output.println("4");
            output.println(animalName);
            output.println(description);
            output.println(speciesID);
            success = input.readLine();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error occured executing add animal method in CliConn");
        }
        return success;
    }
    
    /*this method is called by adminScreen class to communicate with the 
     *server and provide it with key info to add the species data specified by 
     *the admin user.
     */
    public String addSpecies(String speciesName) {
        String success = "false";
        
        try {
            output.println("5");
            output.println(speciesName);
            success = input.readLine();
        } catch (IOException ioe)  {
            JOptionPane.showMessageDialog(null, "Error occured executing add species method in CliConn");
        }
        return success;
    }
    
    /*this method is called by adminScreen class to communicate with the 
     *server and provide it with key info to delete the record of animal 
     *specified by the admin user.
     */
    public String deleteAnimal(String animalName) {
        String success = "";
        
        output.println("6");
        output.println(animalName);
        
        try {
            success = input.readLine();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error occured reading result from server when deleting animal");
        }
        
        return success;
    }
    
    /*this method is called by adminScreen class to communicate with the 
     *server and provide it with key info to delete the record of species 
     *specified by the admin user.
     */
    public String deleteSpecies(String speciesName) {
        String success = "";
        
        output.println("7");
        output.println(speciesName);
        
        try {
            success = input.readLine();
        } catch (IOException ioe){
            JOptionPane.showMessageDialog(null, "Error occured reading result from server when deleting deleting species");
        }
        return success;
    }
}
