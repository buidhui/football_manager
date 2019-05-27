package manager_dashboard;
import db_connection.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static db_connection.SQLCommands.addPlayer;
import static db_connection.SQLCommands.loadPlayer;

public class ManagerController implements Initializable {
        @FXML
        private TableView<PlayerData> playertable;

        @FXML
        private TableColumn<PlayerData, String> idcolumn;

        @FXML
        private TableColumn<PlayerData, String> namecolumn;

        @FXML
        private TableColumn<PlayerData, String> positioncolumn;

        @FXML
        private TableColumn<PlayerData, String> agecolumn;

        @FXML
        private TableColumn<PlayerData, String> heightcolumn;

        @FXML
        private TableColumn<PlayerData, String> weightcolumn;

        @FXML
        private TableColumn<PlayerData, String> nationalitycolumn;

        @FXML
        private TableColumn<PlayerData, String> appearancecolumn;

        @FXML
        private TextField id;

        @FXML
        private TextField name;

        @FXML
        private TextField position;

        @FXML
        private TextField age;

        @FXML
        private TextField height;

        @FXML
        private TextField weight;

        @FXML
        private TextField nationality;

        @FXML
        private TextField appearance;

        private DbConnection dc;

        private ObservableList<PlayerData> data;

        public static int PLAYER_ID = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.dc = new DbConnection();

        playertable.setOnMouseClicked( event -> {
            if( event.getClickCount() == 2 ) {
                System.out.println( playertable.getSelectionModel().getSelectedItem());

                String position = playertable.getSelectionModel().getSelectedItem().getPosition();
                int dummy = Integer.parseInt(playertable.getSelectionModel().getSelectedItem().getId());
                PLAYER_ID = dummy;

                Stage stage = new Stage();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource(
                            position + "/player.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle(playertable.getSelectionModel().getSelectedItem().getName());
                stage.show();
            }});
    }

    public void addPlayer(javafx.event.ActionEvent actionEvent)
    {
        try
        {
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(addPlayer);

            stmt.setInt(1, Integer.parseInt(this.id.getText()) );
//            stmt.setString(1, this.id.getText());
            stmt.setString(2, this.name.getText());
            stmt.setString(3, this.position.getText());
            stmt.setInt(4, Integer.parseInt(this.age.getText()) );
//            stmt.setString(4, this.age.getText());
            stmt.setString(5, this.height.getText());
            stmt.setString(6, this.weight.getText());
            stmt.setString(7, this.nationality.getText());
            stmt.setInt(8, Integer.parseInt(this.appearance.getText()) );

//            stmt.setString(8, this.appearance.getText());

            stmt.execute();
            conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void clearFields(javafx.event.ActionEvent actionEvent)
    {
        this.id.setText("");
        this.name.setText("");
        this.position.setText("");
        this.age.setText("");
        this.height.setText("");
        this.weight.setText("");
        this.nationality.setText("");
        this.appearance.setText("");
    }

    public void loadPlayerData(javafx.event.ActionEvent actionEvent)
    {
        try
        {
            Connection conn = DbConnection.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(loadPlayer);

            while (rs.next())
            {
                this.data.add(new PlayerData(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
        }
        catch (SQLException e)
        {
            System.err.println("ERROR: " + e);
        }
        this.idcolumn.setCellValueFactory(new PropertyValueFactory<PlayerData, String>("id"));

        this.namecolumn.setCellValueFactory(new PropertyValueFactory<PlayerData, String>("name"));

        this.positioncolumn.setCellValueFactory(new PropertyValueFactory<PlayerData, String>("position"));

        this.agecolumn.setCellValueFactory(new PropertyValueFactory<PlayerData, String>("age"));

        this.heightcolumn.setCellValueFactory(new PropertyValueFactory<PlayerData, String>("height"));

        this.weightcolumn.setCellValueFactory(new PropertyValueFactory<PlayerData, String>("weight"));
        this.nationalitycolumn.setCellValueFactory(new PropertyValueFactory<PlayerData, String>("nationality"));
        this.appearancecolumn.setCellValueFactory(new PropertyValueFactory<PlayerData, String>("appearance"));

        this.playertable.setItems(null);
        this.playertable.setItems(this.data);

    }
}
