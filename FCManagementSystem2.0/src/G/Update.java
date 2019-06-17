package G;

import db_connection.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import manager_dashboard.ManagerController;

import java.math.RoundingMode;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import static db_connection.SQLCommands.*;

public class Update implements Initializable {

    @FXML
    private TextField conceded;

    @FXML
    private ImageView image;

    @FXML
    private Button updatebtn;

    @FXML
    private TextField minutes;

    @FXML
    private TextField clean;


    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        try
        {
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(loagImage);
            stmt.setInt(1, ManagerController.PLAYER_ID);

            ResultSet rs2 = stmt.executeQuery();

            if(rs2.next()) {
                System.out.println(rs2.getString(1));
                javafx.scene.image.Image imge = new Image((rs2.getString(1)), true);
                image.setImage(imge);
            }
        }
        catch (SQLException e)
        {
            System.err.println("ERROR: " + e);
        }
    }

    @FXML
    void update(ActionEvent event) {
        try
        {
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(updateG);


            stmt.setInt(1, Integer.parseInt(this.minutes.getText()));
            stmt.setInt(2, Integer.parseInt(this.conceded.getText()));
            stmt.setInt(3, Integer.parseInt(this.clean.getText()));

            stmt.setInt(4, ManagerController.PLAYER_ID);

            stmt.executeUpdate();
            conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        Stage oldstage = (Stage) this.updatebtn.getScene().getWindow();
        oldstage.close();
        oldstage.setResizable(false);
    }


}
