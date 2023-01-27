/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class GUIFXMLController implements Initializable {

    @FXML
    private Button studentLogin;
    @FXML
    private Button updateLogin;
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button deleteLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openStudentLogin(ActionEvent e) throws IOException {
        root=FXMLLoader.load(getClass().getResource("login.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.setTitle("Student login");
        stage.show();
        
        
    }

    @FXML
    private void openUpdateLogin(ActionEvent e) throws IOException {
        root=FXMLLoader.load(getClass().getResource("UpdateLogin.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.setTitle("UPDATE login");
        stage.show();
    }

    @FXML
    private void openDeleteLogin(ActionEvent e) throws IOException {
        root=FXMLLoader.load(getClass().getResource("Delete.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.setTitle("Delete login");
        stage.show();

    }
    
}
