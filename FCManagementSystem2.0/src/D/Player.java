package D;

import db_connection.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import manager_dashboard.ManagerController;

import java.io.IOException;
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
    private ImageView image;

    @FXML
    private Label fouls;

    @FXML
    private Label drb;

    @FXML
    private Label owng;

    @FXML
    private Label minutes;

    @FXML
    private Label blocks;

    @FXML
    private Label inter;

    @FXML
    private Label clear;

    @FXML
    private Label rating;

    @FXML
    private Label tackles;

    @FXML
    private Label offsides;

    @Override
            public void initialize(URL location, ResourceBundle resources) {
        try
        {
            Connection conn = DbConnection.getConnection();
            ResultSet rs2;
             PreparedStatement stmt = conn.prepareStatement(loadD);
                stmt.setInt(1, ManagerController.PLAYER_ID);

                rs2 = stmt.executeQuery();

            if(rs2.next()) {
                DecimalFormat df = new DecimalFormat("#.##");
                df.setRoundingMode(RoundingMode.CEILING);

                minutes.setText(rs2.getString(2));
                tackles.setText(df.format(rs2.getDouble(3)));
                inter.setText(df.format(rs2.getDouble(4)));
                fouls.setText(df.format(rs2.getDouble(5)));
                offsides.setText(df.format(rs2.getDouble(6)));
                clear.setText(df.format(rs2.getDouble(7)));
                drb.setText(df.format(rs2.getDouble(8)));
                blocks.setText(df.format(rs2.getDouble(9)));
                owng.setText(rs2.getString(10));
                rating.setText(df.format(rs2.getDouble(11)));
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


    @FXML
    void update(ActionEvent event) {
        Stage oldstage = (Stage) this.drb.getScene().getWindow();
        oldstage.close();

        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource(
                    "D/update.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Statistics for new Match");
        stage.show();
    }


    @FXML
    void delete()
    {
        try
        {
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(deletePlayer);

            stmt.setInt(1, ManagerController.PLAYER_ID);

            stmt.executeUpdate();
            conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        Stage oldstage = (Stage) this.minutes.getScene().getWindow();
        oldstage.close();
    }
}