package G;

import manager_dashboard.ManagerController;
import manager_dashboard.ManagerController.*;
import db_connection.DbConnection;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import manager_dashboard.PlayerData;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static db_connection.SQLCommands.*;

public class Player implements Initializable {
    @FXML
    Label conceded;

    @FXML
    ImageView image;

    @FXML
     Label minutes;

    @FXML
    Label clean;

//    // Một file ảnh nằm trên ổ cứng.
//    File file = new File("C:/MyImages/myphoto.jpg");
// 
//    // --> file:/C:/MyImages/myphoto.jpg
//    String localUrl = file.toURI().toURL().toString();
// 
//    Image image = new Image(localUrl);
    @Override
            public void initialize(URL location, ResourceBundle resources) {
        try
        {
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(loadG);
            stmt.setInt(1, ManagerController.PLAYER_ID);

            ResultSet rs2 = stmt.executeQuery();

            if(rs2.next()) {
                minutes.setText(rs2.getString(2));
                conceded.setText(rs2.getString(3));//(Integer.toString(rs2.getInt(3)));
                clean.setText(rs2.getString(4));//(Integer.toString(rs2.getInt(4)));
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
                boolean backgroundLoading = true;

                // Ảnh sẽ được tải lặng lẽ ở tầng dưới của ứng dụng.
                System.out.println(rs2.getString(1));
                Image imge = new Image((rs2.getString(1)), backgroundLoading);
                image.setImage(imge);
            }
        }
        catch (SQLException e)
        {
            System.err.println("ERROR: " + e);
        }
        String url = "http://img.f8.bdpcdn.net/Assets/Media/2019/05/17/26/buffon.jpg";

    }
}