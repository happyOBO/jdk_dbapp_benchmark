 package serverv4;
/**
 * @author James -> 
 * 08/04/2019
 * A Client-Server application that allows the storage, retrieval, display and manipulation of data
 * using a SQL database. Zoo Register.
 */
import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

 /*
 *This class enables multiple clients to connect to the server, it also houses
 *the key switch statement that handles all incoming requests from the client, 
 *and then calls all corresponding methods to handle those requests.
 */
public class clientHandler extends Thread{
    
    //instance of socket class to be references later
    Socket socket;
    
    //clientHandler constructor
    public clientHandler(Socket s) {
            this.socket = s;
    }
    
    /*This run method consists of the switch case statement that will be provided 
    *to every client connecting. It pulls in the info provided by the client, 
    *proceses the info using the methods in ServerConn, and then send the results back
    *to the client
    */
    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            ObjectOutputStream objout = new ObjectOutputStream(socket.getOutputStream());
            
            while(true) {
                /*vairable that is assigned the numerical call value from the 
                 *client application, it is used in the switch case as it 
                 *indicates which method the client needs the server to execute.
                 */
                String caseNum;
                serverConn sC = new serverConn();
                try {
                    caseNum = input.readLine();
                    String com = "";
                    switch (caseNum) {
                        case "1":
                            String username = input.readLine();
                            String password = input.readLine();
                            String returned1 = sC.checkAgainstAdmins(username, password);
                            output.println(returned1);
                            break;
                        case "2": 
                            String animalWord = input.readLine();
                            animal[] returned2 = sC.searchAnimal(animalWord);
                            objout.writeObject(returned2);
                            break;
                        case "3":
                            String speciesWord = input.readLine();
                            String returned3 = sC.searchSpecies(speciesWord);
                            output.println(returned3);
                            break;
                        case "4":
                            String animalName = input.readLine();
                            String animalDesc = input.readLine();
                            String specID = input.readLine();
                            int specIDNum;
                            try {
                                specIDNum = Integer.parseInt(specID);
                                String returned4 = sC.addAnimal(animalName, animalDesc, specIDNum);
                                output.println(returned4);
                            } catch (NumberFormatException nfe) {
                                
                            }
                            break;
                        case "5":
                            String speciesName = input.readLine();
                            String returned5 = sC.addSpecies(speciesName);
                            output.println(returned5);
                            break;
                        case "6":
                            String animalName6 = input.readLine();
                            String returning6 = sC.delAnimal(animalName6);
                            output.println(returning6);
                            break;
                        case "7":
                            String speciesName7 = input.readLine();
                            String returning7 = sC.delSpecies(speciesName7);
                            output.println(returning7);
                            break;
                        default : 
                            try {
                                input.close();
                                output.close();
                                objout.close();
                            } catch (IOException ioe) {
                                
                            }
                            break;
                        }
                } catch (IOException ioe) {
                    
                }
            }
        } catch (IOException ioe ) {
            
        } finally {
            try {
                socket.close();
            } catch (IOException ioe) {
                
            }
        }
    }
}
