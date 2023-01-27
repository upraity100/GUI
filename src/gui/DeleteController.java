/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class DeleteController implements Initializable {

    @FXML
    private Button backHandler;
    @FXML
    private Button deleteHandler;
    @FXML
    private TextField studentRollTxt;
    @FXML
    private TextField nameTxt;
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
        stage.setTitle("Delete login");
        stage.show();
    }

    @FXML
    private void deleteHandler(ActionEvent e) {
         String studentRoll=studentRollTxt.getText();
         String name=nameTxt.getText();
          if(studentRollTxt.equals("")||nameTxt.equals(""))
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
                  Connection conn =DriverManager.getConnection("jdbc:oracle:thin:system/1234@localhost:1521:Xe");
                  Statement s1=conn.createStatement();
                  int x= s1.executeUpdate("DELETE from student30 WHERE studentRoll='"+studentRoll+"'AND name='"+name+"'");
                  if(x>0)
                  {
                      studentRollTxt.setText("");
                      nameTxt.setText("");
                     
                      System.out.println("successFully DELETE");
                      JOptionPane.showMessageDialog(null,   "SUCCESSFULLY DELETE"  );
                      
                  }
                  conn.close();
                                    
              }
              
              catch(Exception e1)
                      {
                          System.out.println(e1);
                          
                      }
              
          }
    }
    
}
