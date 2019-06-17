package login;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable
{
    UserAuthentication userAuthentication = new UserAuthentication();

    @FXML
    private Label dbstatus;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<option> combobox;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginStatus;


    @Override
    public void initialize(URL url, ResourceBundle rb)
    {    
        if (this.userAuthentication.isConnected())
        {
            this.dbstatus.setText("");
        }
        else
        {
            this.dbstatus.setText("");
        }

        this.combobox.setItems(FXCollections.observableArrayList(option.values()));
    }

    @FXML
    public void Login(ActionEvent event)
    {
        System.out.println("1");
        try
        {
            System.out.println("2");

            if (this.userAuthentication.
                    isValid(this.username.getText(), this.password.getText(),
                            (this.combobox.getValue()).toString()))
            {
//                System.out.println("3");
                Stage stage = (Stage) this.loginButton.getScene().getWindow();
                stage.close();


                switch (( this.combobox.getValue()).toString()) {
                    case "Manager":
                        managerLogin();
                        break;
                    case "Player":
                        playerLogin();
                        break;
                }
            } else
            {
                System.out.println("3");

                this.loginStatus.setText("Wrong Username \n   or Password");
            }

        }
        catch (Exception localException)
        {
            System.out.println("4");
            localException.printStackTrace();
        }
    }

    public void managerLogin()
    {
        try
        {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(
                    "manager_dashboard/manager.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Manager Dashboard");
            stage.show();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void playerLogin()
    {
        try
        {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(
                    "player_dashboard/player.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Player Dashboard");
            stage.show();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
