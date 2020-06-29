/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

/**
 * Controls the quiz application
 * @author sharanya
 */
public class Quizapp {

    int score = 0;
    ArrayList<String> question = new ArrayList<>(20);
    private String framework = "embedded";
    private String protocol = "jdbc:derby:";
    
    /**
     * Reads data from Question file and adds them to array list
     * @throws IOException 
     */

    public void readData() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("Questions.txt"));
        String s;
        s = in.readLine(); //read data from txt file
        while (s != null) {
          
            question.add(s); //add data to text file
            s = in.readLine();
        }

    }
    
    /**
     * Keeps the game loop active and terminates it when needed
     * @param args Determines the framework in which the application is starting
     * @throws ClassNotFoundException
     * @throws IOException 
     */

   public void continuegame(String[] args) throws ClassNotFoundException, IOException {
        String choice = "Y";
        int trial = 1;
        Scanner sc = new Scanner(System.in);
        //Prompts user to enter an option to keep the game loop active
        while (choice.equalsIgnoreCase("Y")) {
            if (trial == 1) {
                readData();
                go(args);
                getData();
                displayScore();
                trial++;
            } else {
                score = 0;
                getData();
                displayScore();
                trial++;
            }
            System.out.println("\nWould you like to play another game? Enter Y to continue\n");
            choice = sc.nextLine();
        }
    }
/**
 * Establishes Database connection and inputs data into Quiz table
 * @param args Determines the framework in which the application is starting
 * @throws ClassNotFoundException 
 */
   public  void go(String[] args) throws ClassNotFoundException {
        String url = "jdbc:derby:C:\\Users\\Sharanya\\Documents\\ExamDB;create=true";
        String username = "app";
        String password = "app";

        PreparedStatement psInsert;
        Statement s;
        ResultSet rs = null;

        boolean createdFlg = false;

        // Connecting to database
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            //conn.setAutoCommit(false);
            s = conn.createStatement();

            // Creating a table
            try {
                s.execute("create table QUIZ(QNO int, Question varchar(100), Choice1 varchar(50), Choice2 varchar(50), Choice3 varchar(50), Choice4 varchar(50), Ans varchar(2))");
                createdFlg = true;
            } catch (SQLException sqle) {
                s.execute("drop table quiz");
            }

            if (!createdFlg) {
                s.execute("create table quiz(QNO int, Question varchar(100), Choice1 varchar(50), Choice2 varchar(50), Choice3 varchar(50), Choice4 varchar(50), Ans varchar(2))");
            }

            psInsert = conn.prepareStatement("insert into quiz values (?, ?, ?, ?, ?, ?, ?)");

            String[] questionParts;

            // Insert questions data into database table
            for (String questions : question) {
                
                questionParts = questions.split(",");
                psInsert.setInt(1, Integer.parseInt(questionParts[0]));
                psInsert.setString(2, questionParts[1]);
                psInsert.setString(3, questionParts[2]);
                psInsert.setString(4, questionParts[3]);
                psInsert.setString(5, questionParts[4]);
                psInsert.setString(6, questionParts[5]);
                
                psInsert.setString(7, questionParts[6]);
                psInsert.executeUpdate();
            }

            // Committing changes
            conn.commit();

              } catch (SQLException e) {
            System.out.println("Exception creating connection: " + e);
        }
    }
   /**
    * Prints score of the current game on the screen
    */

    public void displayScore() {
        System.out.println("Your score for this game is : " + score + " on 3");
    }
    
    /**
     * retrieves data from the database and prints three radom question for the test, and updates score.
     */

    void getData() {
        String url = "jdbc:derby:C:\\Users\\Sharanya\\Documents\\ExamDB;";
        String username = "app";
        String password = "app";

        PreparedStatement psInsert;
        Statement s;
        ResultSet rs = null;

        boolean createdFlg = false;

        // Connecting to database
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            //conn.setAutoCommit(false);
            s = conn.createStatement();

            // Creating a table
            try {
                rs = s.executeQuery("SELECT * FROM QUIZ ORDER BY RANDOM() OFFSET 0 ROWS FETCH NEXT 3 ROW ONLY ");
                Scanner sc = new Scanner(System.in);

                while (rs.next()) {

                    System.out.println("Choose the best option");
                     // Printing quiz questions to the screen
                    System.out.println("" + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
                    String x = sc.nextLine();

                    while (x.equals("0") || x.equals("1") || x.equals("2") || x.equals("3") || x.equals("4") || x.equals("5") || x.equals("6") || x.equals("7") || x.equals("8") || x.equals("9")) {
                        System.out.println("\nPlease enter a valid option- a,b,c or d\n");
                        x = sc.nextLine();
                    }
                    //update score and continue to next question

                    if (x.equals(rs.getString(7))) {
                        score++;
                        System.out.println("Right answer\n");
                    } else {
                        System.out.println("Wrong answer! Proceed to the next question\n");
                    }

                }
            } catch (SQLException sqle) {

                System.out.println(sqle);// catching any exception occured while connecting to the database
            }

        } catch (SQLException e) {
            System.out.println("Exception creating connection: " + e);
        }
    }
}

