/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class LoginController implements Initializable {

    @FXML
    private TextField studentRollTxt;
    @FXML
    private TextField studentYearTxt;
    @FXML
    private TextField studentCourseTxt;
    @FXML
    private TextField studentNameTxt;
    @FXML
    private Button backButton;
    @FXML
    private Button loginBtn;
    private Parent root;
    private Stage stage;
    private Scene scene;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backHandler(ActionEvent e) throws IOException {
        root=FXMLLoader.load(getClass().getResource("GUIFXML.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.setTitle("Student login");
        stage.show();
        
    }

   @FXML
   private void loginHandler(ActionEvent e1) {
       
         String studentRoll=studentRollTxt.getText();
         String name=studentNameTxt.getText();
         String course=studentCourseTxt.getText();
         String year=studentYearTxt.getText();
          
          if(studentRollTxt.equals("")||studentNameTxt.equals("")||studentCourseTxt.equals("")||studentYearTxt.equals(""))
          {
              Alert alert= new Alert(Alert.AlertType.WARNING);
              alert.setTitle("Warning");
              alert.setHeaderText("WARNING");
              alert.setContentText("All field are required");
              alert.showAndWait();
              
          }
          else{
              try{
                   Class.forName("oracle.jdbc.driver.OracleDriver");
                
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:system/1234@localhost:1521:Xe");
                
                PreparedStatement statement = conn.prepareStatement("INSERT INTO student30(studentRoll,name,course,year)VALUES(?, ?, ?, ?)");
                
                statement.setLong(1,Long.parseLong(studentRoll));
                statement.setString(2, name);
                statement.setString(3, course);
                statement.setInt(4, Integer.parseInt(year));
                
                statement.executeUpdate();
               
               
                statement = conn.prepareStatement("SELECT * FROM student30");
                
          
                //statement.setLong(1, Long.parseLong(studentId));
                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()){
                   JOptionPane.showMessageDialog(null,"SUCCESSFULLY LOGIN");
                   studentRollTxt.setText("");
                   studentNameTxt.setText("");
                   studentYearTxt.setText("");
                   studentCourseTxt.setText("");
                   conn.close();
             

                   
                } else {
                    Alert failure = new Alert(Alert.AlertType.ERROR);
                    failure.setTitle("Register status");
                    failure.setHeaderText("Registration failed.");
                    failure.showAndWait();
                
              }
             
              
          }
               catch(Exception e)
                      {
                          System.out.println(e);
                          
                      }
      
    }
    
}
}
