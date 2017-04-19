/**
 * Created by myron on 3/22/2017.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import org.python.core.PyInstance;
import org.python.core.PyObject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class Query extends Application implements Initializable{
    public static void main(String[] args) {
        launch(args);
    }

    private final TextField riotText = new TextField(""
            + "http://www.riotgames.com/");
    private final TextField leagueText = new TextField(""
            + "http://na.leagueoflegends.com/");

    private ObservableList<Table> removedChampion = FXCollections
            .observableArrayList();
    private ObservableList<Table> theChampionsList = FXCollections
            .observableArrayList();

    private int countOfTeamOne = 0;
    private int countOfTeamTwo = 0;
    private ArrayList <Table>teamOneArray = new ArrayList();
    private ArrayList <Table>teamTwoArray = new ArrayList();
    private double temp = 0;

    @FXML
    ListView<String> teamOneList = new ListView<>();
    @FXML
    ListView<String> teamTwoList = new ListView<>();

    @FXML
    public Button closeMain = new Button();
    @FXML
    public Button closeAbout = new Button();

    // Define Table
    @FXML
    TableView<Table> tableID;
    @FXML
    TableColumn<Table, Integer> ID;
    @FXML
    TableColumn<Table, String> NAME;
    @FXML
    TableColumn<Table, String> TITLE;
    @FXML
    TableColumn<Table, String> ROLE_1;
    @FXML
    TableColumn<Table, String> ROLE_2;
    @FXML
    TableColumn<Table, Float> HEALTH;
    @FXML
    TableColumn<Table, Float> HEALTH_REGEN;
    @FXML
    TableColumn<Table, Float> MANA;
    @FXML
    TableColumn<Table, Float> MANA_REGEN;
    @FXML
    TableColumn<Table, Float> MOVEMENT_SPEED;
    @FXML
    TableColumn<Table, Float> ATTACK_DAMAGE;
    @FXML
    TableColumn<Table, Float> ATTACK_SPEED;
    @FXML
    TableColumn<Table, Float> ATTACK_RANGE;
    @FXML
    TableColumn<Table, Float> ARMOR;
    @FXML
    TableColumn<Table, Float> MAGIC_RESIST;




    public void initialize(URL location, ResourceBundle resources) {

        ID.setCellValueFactory(new PropertyValueFactory<>("rID"));
        NAME.setCellValueFactory(new PropertyValueFactory<>("rNAME"));
        TITLE.setCellValueFactory(new PropertyValueFactory<>("rTITLE"));
        ROLE_1.setCellValueFactory(new PropertyValueFactory<>("rROLE_1"));
        ROLE_2.setCellValueFactory(new PropertyValueFactory<>("rROLE_2"));
        HEALTH.setCellValueFactory(new PropertyValueFactory<>("rHEALTH"));
        HEALTH_REGEN.setCellValueFactory(new PropertyValueFactory<>("rHEALTH_REGEN"));
        MANA.setCellValueFactory(new PropertyValueFactory<>("rMANA"));
        MANA_REGEN.setCellValueFactory(new PropertyValueFactory<>("rMANA_REGEN"));
        MOVEMENT_SPEED.setCellValueFactory(new PropertyValueFactory<>("rMOVEMENT_SPEED"));
        ATTACK_DAMAGE.setCellValueFactory(new PropertyValueFactory<>("rATTACK_DAMAGE"));
        ATTACK_SPEED.setCellValueFactory(new PropertyValueFactory<>("rATTACK_SPEED"));
        ATTACK_RANGE.setCellValueFactory(new PropertyValueFactory<>("rATTACK_RANGE"));
        ARMOR.setCellValueFactory(new PropertyValueFactory<>("rARMOR"));
        MAGIC_RESIST.setCellValueFactory(new PropertyValueFactory<>("rMAGIC_RESIST"));
        tableID.setItems(queryChampions());

    }


    public void execute(MouseEvent mouseEvent) {

/*
        // TODO: use for faster testing only comment this out when running
        final List<Table> items = tableID.getItems();
        teamOneArray.add(items.remove(0));
        teamOneArray.add(items.remove(1));
        teamOneArray.add(items.remove(2));
        teamOneArray.add(items.remove(3));
        teamOneArray.add(items.remove(4));
        teamTwoArray.add(items.remove(5));
        teamTwoArray.add(items.remove(6));
        teamTwoArray.add(items.remove(7));
        teamTwoArray.add(items.remove(8));
        teamTwoArray.add(items.remove(9));
        countOfTeamOne = 5;
        countOfTeamTwo = 5;
*/

        // keep this uncommented from here down
        if (countOfTeamOne == 5 && countOfTeamTwo == 5) {
            // first five are from team one, second five are from team two
            int championOneID = teamOneArray.get(0).getRID();
            int championTwoID = teamOneArray.get(1).getRID();
            int championThreeID = teamOneArray.get(2).getRID();
            int championFourID = teamOneArray.get(3).getRID();
            int championFiveID = teamOneArray.get(4).getRID();
            int championSixID = teamTwoArray.get(0).getRID();
            int championSevenID = teamTwoArray.get(1).getRID();
            int championEightID = teamTwoArray.get(2).getRID();
            int championNineID = teamTwoArray.get(3).getRID();
            int championTenID = teamTwoArray.get(4).getRID();
//            String championOneName = teamOneArray.get(0).getRNAME();
            Interpreter ie = new Interpreter();
            ie.execfile("runExecute.py");
            PyInstance hello = ie.createClass("RunExecute",
                    championOneID,
                    championTwoID,
                    championThreeID,
                    championFourID,
                    championFiveID,
                    championSixID,
                    championSevenID,
                    championEightID,
                    championNineID,
                    championTenID);
            hello.invoke("calc");
            hello.invoke("execute");

            temp = hello.__getattr__("probability").asDouble();
            temp = Math.floor(temp * 10000) / 100;

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Probability");
            alert.setHeaderText(null);
            alert.setContentText("The probability that team one will win is "
                    + temp + "%");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.resizableProperty().setValue(Boolean.FALSE);
            alert.initStyle(StageStyle.UNDECORATED);
            alert.setHeaderText("What are you doing?!?!");
            alert.setContentText("You must have two teams of five to start!");
            alert.showAndWait();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Scene"
                + ".fxml"));
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.initStyle(StageStyle.UNDECORATED);
        Scene mainScene = new Scene(root);
        stage.setScene(mainScene);
        stage.show();
    }

    @FXML
    private void openRiot() {
        getHostServices().showDocument(riotText.getText());
    }

    @FXML
    private void openLeague() {
        getHostServices().showDocument(leagueText.getText());
    }

    @FXML
    private void showAbout() throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.resizableProperty().setValue(Boolean.FALSE);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setHeaderText("About this Application");
        alert.setContentText("This application uses a machine learning "
                + "algorithm to determine the likelihood of match results "
                + "between two five-man teams playing a League of Legends "
                + "match. The champions and their data are stored in a SQLite"
                + " database."
                + "\n\nApplication Creators: Myron King & Jian Hua"
                + "\n\nCreated Spring 2017");
        alert.showAndWait();
    }

    @FXML
    private void closeMain(){
        Stage stage = (Stage) closeMain.getScene().getWindow();
        stage.close();
    }

    private ObservableList<Table> queryChampions() {
        Connection c;
        Statement stmt;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:heroes.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM NEWHEROES;" );
            while ( rs.next() ) {
                theChampionsList.add(new Table(rs.getInt("ID"), rs.getString
                        ("NAME"), rs.getString("TITLE"), rs.getString
                        ("ROLE_1"), rs.getString("ROLE_2"), rs.getFloat
                        ("HEALTH"), rs.getFloat("HEALTH_REGEN"), rs
                        .getFloat("MANA"), rs.getFloat("MANA_REGEN"), rs
                        .getFloat("MOVEMENT_SPEED"), rs.getFloat
                        ("ATTACK_DAMAGE"), rs.getFloat("ATTACK_SPEED"), rs
                        .getFloat("ATTACK_RANGE"), rs.getFloat("ARMOR"), rs
                        .getFloat("MAGIC_RESIST")));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return theChampionsList;
    }

    private void addToTeamOne(int index) {
        if(countOfTeamOne < 5) {
            final List<Table> items = tableID.getItems();
            if (items == null || items.size() == 0) return;
            Table temp = items.remove(index);
            teamOneArray.add(temp);
            String nameAdded = temp.getRNAME();
            teamOneList.getItems().add(nameAdded);
            countOfTeamOne++;
            Platform.runLater(() -> {
            });
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.resizableProperty().setValue(Boolean.FALSE);
            alert.initStyle(StageStyle.UNDECORATED);
            alert.setHeaderText("What are you doing?!?!");
            alert.setContentText("You cannot have more than five players per "
                    + "team!");
            alert.showAndWait();
        }
    }

    private void addToTeamTwo(int index) {
        if(countOfTeamTwo < 5) {
            final List<Table> items = tableID.getItems();
            if (items == null || items.size() == 0) return;
            Table temp = items.remove(index);
            teamTwoArray.add(temp);
            String nameAdded = temp.getRNAME();
            teamTwoList.getItems().add(nameAdded);
            countOfTeamTwo++;
            Platform.runLater(() -> {
            });
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.resizableProperty().setValue(Boolean.FALSE);
            alert.initStyle(StageStyle.UNDECORATED);
            alert.setHeaderText("What are you doing?!?!");
            alert.setContentText("You cannot have more than five players per "
                    + "team!");
            alert.showAndWait();
        }
    }

    @FXML
    private void addTeamOne() {
        if(countOfTeamOne < 5) {
            int i = tableID.getSelectionModel().getSelectedCells().get(0)
                    .getRow();
            updateRemoved(tableID.getItems().get(i));
            addToTeamOne(i);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.resizableProperty().setValue(Boolean.FALSE);
            alert.initStyle(StageStyle.UNDECORATED);
            alert.setHeaderText("What are you doing?!?!");
            alert.setContentText("You cannot have more than five players per "
                    + "team!");
            alert.showAndWait();
        }
    }

    @FXML
    private void addTeamTwo() {
        if(countOfTeamTwo < 5) {
            int i = tableID.getSelectionModel().getSelectedCells().get(0)
                    .getRow();
            updateRemoved(tableID.getItems().get(i));
            addToTeamTwo(i);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.resizableProperty().setValue(Boolean.FALSE);
            alert.initStyle(StageStyle.UNDECORATED);
            alert.setHeaderText("What are you doing?!?!");
            alert.setContentText("You cannot have more than five players per "
                    + "team!");
            alert.showAndWait();
        }
    }

    private void updateRemoved(Table t) {
        removedChampion.add(t);
//        System.out.println(removedChampion.size());
        System.out.println("The following players have now been removed from "
                + "the pool of selectable players:");
        for (Table aRemovedChampion : removedChampion) {
            System.out.println(aRemovedChampion.getRNAME());
        }
    }

    @FXML
    private void removeFromTeamOne() {
        String toClearFromTeam = teamOneList.getSelectionModel()
                .getSelectedItems().get(0);
        for (int i = 0; i < removedChampion.size(); i++) {
            if(toClearFromTeam.compareTo(removedChampion.get(i).getRNAME())
                    == 0) {
                theChampionsList.add(removedChampion.get(i));
                removedChampion.remove(i);
//                System.out.println("matches");
            } else {
//                System.out.println("doesn't match");
            }
        }
        for(int i = 0; i < countOfTeamOne; i++) {
            if (teamOneList.getItems().get(i).compareTo(toClearFromTeam) == 0) {
                System.out.println("team one has " + teamOneArray.size() +
                        " members before being removed.");
                teamOneList.getItems().remove(i);
                teamOneArray.remove(i);
                System.out.println("team one has " + teamOneArray.size() +
                        " members after removal.");
                countOfTeamOne--;
            }
        }
    }

    @FXML
    private void removeFromTeamTwo() {
        String toClearFromTeam = teamTwoList.getSelectionModel()
                .getSelectedItems().get(0);
        for (int i = 0; i < removedChampion.size(); i++) {
            if(toClearFromTeam.compareTo(removedChampion.get(i).getRNAME())
                    == 0) {
                theChampionsList.add(removedChampion.get(i));
                removedChampion.remove(i);
//                System.out.println("matches");
            } else {
//                System.out.println("doesn't match");
            }
        }
        for(int i = 0; i < countOfTeamTwo; i++) {
            if (teamTwoList.getItems().get(i).compareTo(toClearFromTeam) == 0) {
                System.out.println("team two has " + teamTwoArray.size() +
                        " members before being removed.");
                teamTwoList.getItems().remove(i);
                teamTwoArray.remove(i);
                System.out.println("team two has " + teamTwoArray.size() +
                        " members after removal.");
                countOfTeamTwo--;
            }
        }
    }

    public void accuracy(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Accuracy");
        alert.setHeaderText(null);
        alert.setContentText("Using the Logistic Regression model, the "
                + "precision of this model is 85.66% and the accuracy of this "
                + "model is 84.12%.");
        alert.showAndWait();
    }
}
