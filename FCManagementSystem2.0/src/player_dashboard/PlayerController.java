package player_dashboard;
import db_connection.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PlayerController implements Initializable {

    @FXML
    private TableView<PlayerData> playertable;

    @FXML
    private TableColumn<PlayerData, String> idcolumn;

    @FXML
    private TableColumn<PlayerData, String> dobcolumn;

    @FXML
    private TableColumn<PlayerData, String> emailcolumn;

    @FXML
    private TableColumn<PlayerData, String> firstnamecolumn;

    @FXML
    private TableColumn<PlayerData, String> lastnamecolumn;


    private ObservableList<PlayerData> data;
    private String sql = "SELECT * FROM players";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void loadPlayerData(javafx.event.ActionEvent actionEvent)
    {
        try
        {
            Connection conn = DbConnection.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next())
            {
                this.data.add(new PlayerData(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                ));
            }
        }
        catch (SQLException e)
        {
            System.err.println("ERROR: " + e);
        }

        this.idcolumn.setCellValueFactory(new PropertyValueFactory<PlayerData, String>("ID"));

        this.firstnamecolumn.setCellValueFactory(new PropertyValueFactory<PlayerData, String>("firstName"));

        this.lastnamecolumn.setCellValueFactory(new PropertyValueFactory<PlayerData, String>("lastName"));

        this.emailcolumn.setCellValueFactory(new PropertyValueFactory<PlayerData, String>("email"));

        this.dobcolumn.setCellValueFactory(new PropertyValueFactory<PlayerData, String>("DOB"));

        this.playertable.setItems(null);
        this.playertable.setItems(this.data);

    }
}
