package F;

import db_connection.DbConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

public class Player implements Initializable {


    @FXML
    private Label dsp;

    @FXML
    private ImageView image;

    @FXML
    private Label keyp;

    @FXML
    private Label assists;

    @FXML
    private Label drb;

    @FXML
    private Label minutes;

    @FXML
    private Label rating;

    @FXML
    private Label unftch;

    @FXML
    private Label spg;

    @FXML
    private Label fouled;

    @FXML
    private Label off;

    @FXML
    private Label goals;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try
        {
            Connection conn = DbConnection.getConnection();
            ResultSet rs2;
            PreparedStatement stmt = conn.prepareStatement(loadF);
            stmt.setInt(1, ManagerController.PLAYER_ID);

            rs2 = stmt.executeQuery();

            if(rs2.next()) {
                DecimalFormat df = new DecimalFormat("#.##");
                df.setRoundingMode(RoundingMode.CEILING);


                minutes.setText(rs2.getString(2));
                goals.setText(rs2.getString(3));
                assists.setText(rs2.getString(4));
                spg.setText(df.format(rs2.getDouble(5)));
                keyp.setText(df.format(rs2.getDouble(6)));
                drb.setText(df.format(rs2.getDouble(7)));
                fouled.setText(df.format(rs2.getDouble(8)));
                off.setText(df.format(rs2.getDouble(9)));
                dsp.setText(df.format(rs2.getDouble(10)));
                unftch.setText(df.format(rs2.getDouble(11)));
                rating.setText(df.format(rs2.getDouble(12)));
            }
        }
        catch (SQLException e)
        {
            System.err.println("ERROR: " + e);
        }

        try
        {
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(loagImage);
            stmt.setInt(1, ManagerController.PLAYER_ID);

            ResultSet rs2 = stmt.executeQuery();

            if(rs2.next()) {
                System.out.println(rs2.getString(1));
                Image imge = new Image((rs2.getString(1)), true);
                image.setImage(imge);
            }
        }
        catch (SQLException e)
        {
            System.err.println("ERROR: " + e);
        }
    }
}