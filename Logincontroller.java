package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class Logincontroller {

    int status;

    @FXML
    private PasswordField passfield;
    @FXML
    private TextField unamefield;
    @FXML
    private Label lblstatus;
    @FXML
    private Label likelbl;

    public void loginbuttonaction(ActionEvent event) throws IOException, Exception {
        status=Phones.accountsearch(unamefield.getText(),passfield.getText());

        if (status==2)
        {
            lblstatus.setText("Login Successful");                                      //Show status as successful
            Stage primaryStage = new Stage();                                       //5 Lines To Open a new Window
            Parent root = FXMLLoader.load(getClass().getResource("mobile.fxml"));
            primaryStage.setTitle("Mobile Database Management");
            primaryStage.setScene(new Scene(root, 996, 595));
            primaryStage.show();

        }
        else if (status==1)
        {
            lblstatus.setText("Login Successful");                                      //Show status as successful
            Stage primaryStage = new Stage();                                       //5 Lines To Open a new Window
            Parent root = FXMLLoader.load(getClass().getResource("standardusermobile.fxml"));
            primaryStage.setTitle("Mobile Database Management");
            primaryStage.setScene(new Scene(root, 833, 549));
            primaryStage.show();

        }else
            lblstatus.setText("Login Failed");                                 //Wrong input
    }
}