/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import java.io.IOException;

/**
 * Invokes Quizapp class to simulate Quiz
 * @author sharanya
 */
public class Quiz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here
        Quizapp obj= new Quizapp();// Create object of Quizapp class
        obj.continuegame(args);// call continuegame method of Quizapp tokepp the test loop active or terminate it when needed
        
        
    }
    
}
