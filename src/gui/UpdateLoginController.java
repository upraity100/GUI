package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
public class UpdateLoginController implements Initializable {

    
    
    
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button backHandler;
    @FXML
    private Button updateHandler;
    @FXML
    private TextField nameTxt;
    @FXML
    private TextField newNameTxt;
    @FXML
    private TextField studentRollTxt;


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
        stage.setTitle("Update login");
        stage.show();
        
    }

    @FXML
    private void updateHandler(ActionEvent event) throws SQLException {
        String studentRoll=studentRollTxt.getText();
         String name=nameTxt.getText();
          String newName=newNameTxt.getText();
          if(studentRollTxt.equals("")||nameTxt.equals("")||newNameTxt.equals(""))
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
                  int x= s1.executeUpdate("UPDATE student30 set name='"+newName+"'WHERE studentRoll='"+studentRoll+"'AND name='"+name+"'");
                  if(x>0)
                  {
                      studentRollTxt.setText("");
                      nameTxt.setText("");
                      newNameTxt.setText("");
                      System.out.println("name successFully Update");
                      JOptionPane.showMessageDialog(null,"NAME SUCCESSFULLY UPDATE");
                      
                  }
                   conn.close();
                                    
              }
              catch(Exception e)
                      {
                          System.out.println(e);
                          
                      }
              
          }
    }
}