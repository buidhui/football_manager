package D;

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
    private TextField offwon;

    @FXML
    private Button updatebtn;

    @FXML
    private ImageView image;

    @FXML
    private TextField fouls;

    @FXML
    private TextField dribpassed;

    @FXML
    private TextField owng;

    @FXML
    private TextField inters;

    @FXML
    private TextField minutes;

    @FXML
    private TextField blocks;

    @FXML
    private TextField ratings;

    @FXML
    private TextField clear;

    @FXML
    private TextField tackles;

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
                PreparedStatement stmt = conn.prepareStatement(updateD);

                if(minutes.getText() == null) System.out.println("\n \n \n minutes is null \n \n \n");
                System.out.println(minutes.getText() + tackles.getText() + inters.getText());

                stmt.setInt(1, Integer.parseInt(this.minutes.getText()));
                stmt.setDouble(2, Double.parseDouble(this.tackles.getText()));
                stmt.setDouble(3, Double.parseDouble(this.inters.getText()));
                stmt.setDouble(4, Double.parseDouble(this.fouls.getText()));
                stmt.setDouble(5, Double.parseDouble(this.offwon.getText()));
                stmt.setDouble(6, Double.parseDouble(this.clear.getText()));
                stmt.setDouble(7, Double.parseDouble(this.dribpassed.getText()));
                stmt.setDouble(8, Double.parseDouble(this.blocks.getText()));
                stmt.setDouble(9, Double.parseDouble(this.owng.getText()));
                stmt.setDouble(10, Double.parseDouble(this.ratings.getText()));

                stmt.setInt(11, ManagerController.PLAYER_ID);

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
