package F;

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
    private ImageView image;

    @FXML
    private Button updatebtn;

    @FXML
    private TextField goal;

    @FXML
    private TextField kp;

    @FXML
    private TextField minutes;

    @FXML
    private TextField opg;

    @FXML
    private TextField spg;

    @FXML
    private TextField ratings;

    @FXML
    private TextField bcpg;

    @FXML
    private TextField assist;

    @FXML
    private TextField dpg;

    @FXML
    private TextField dspg;

    @FXML
    private TextField fpg;

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
        }}

    @FXML
    void update(ActionEvent event) {
        try
        {
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(updateF);

            stmt.setInt(1, Integer.parseInt(this.minutes.getText()));
            stmt.setInt(2, Integer.parseInt(this.goal.getText()));
            stmt.setInt(3, Integer.parseInt(this.assist.getText()));
            stmt.setDouble(4, Double.parseDouble(this.spg.getText()));
            stmt.setDouble(5, Double.parseDouble(this.kp.getText()));
            stmt.setDouble(6, Double.parseDouble(this.dpg.getText()));
            stmt.setDouble(7, Double.parseDouble(this.fpg.getText()));
            stmt.setDouble(8, Double.parseDouble(this.opg.getText()));
            stmt.setDouble(9, Double.parseDouble(this.dspg.getText()));
            stmt.setDouble(10, Double.parseDouble(this.bcpg.getText()));
            stmt.setDouble(11, Double.parseDouble(this.ratings.getText()));

            stmt.setInt(12, ManagerController.PLAYER_ID);

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
