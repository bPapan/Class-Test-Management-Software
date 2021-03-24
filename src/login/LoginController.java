/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * Login Controller.
 * 
 * @author Abhik_Blaze
 */
public class LoginController extends AnchorPane {

    @FXML
    TextField userId;
    @FXML
    PasswordField password;
    @FXML
    Button login;
    @FXML
    Label errorMessage;

    private Main application;
    
    
    public void setApp(Main application){
        this.application = application;
    }
    
    void initialize() {
        errorMessage.setText("");
    }

    @FXML
    public void processLogin(ActionEvent event) {
        if (application == null){
            
            errorMessage.setText("Hello " + userId.getText());
        } else {
            if (!application.userLogging(userId.getText(), password.getText())){
                errorMessage.setText("Unknown user " + userId.getText());
            }
        }
    }
}
