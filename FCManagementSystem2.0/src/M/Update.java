package M;

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

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static db_connection.SQLCommands.*;

public class Update implements Initializable {



    @FXML
    private ImageView image;

    @FXML
    private Button updatebtn;

    @FXML
    private TextField kp;

    @FXML
    private TextField ppg;

    @FXML
    private TextField minutes;

    @FXML
    private TextField ratings;

    @FXML
    private TextField lb;

    @FXML
    private TextField cross;

    @FXML
    private TextField assist;

    @FXML
    private TextField psp;

    @FXML
    private TextField tb;

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
            PreparedStatement stmt = conn.prepareStatement(updateM);

            System.out.println(minutes.getText());
            System.out.println(assist.getText());
            System.out.println(kp.getText());
            System.out.println(ppg.getText());
            System.out.println(psp.getText());
            System.out.println(cross.getText());
            System.out.println(ratings.getText());

            stmt.setInt(1, Integer.parseInt(this.minutes.getText()));
            stmt.setInt(2, Integer.parseInt(this.assist.getText()));
            stmt.setDouble(3, Double.parseDouble(this.kp.getText()));
            stmt.setDouble(4, Double.parseDouble(this.ppg.getText()));
            stmt.setDouble(5, Double.parseDouble(this.psp.getText()));
            stmt.setDouble(6, Double.parseDouble(this.cross.getText()));
            stmt.setDouble(7, Double.parseDouble(this.lb.getText()));
            stmt.setDouble(8, Double.parseDouble(this.tb.getText()));
            stmt.setDouble(9, Double.parseDouble(this.ratings.getText()));

            stmt.setInt(10, ManagerController.PLAYER_ID);

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
