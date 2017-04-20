/*
 * Created by myron on 3/22/2017.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.python.core.PyInstance;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

    @SuppressWarnings("unchecked")
    private ArrayList <Table>teamOneArray = new ArrayList();
    @SuppressWarnings("unchecked")
    private ArrayList <Table>teamTwoArray = new ArrayList();

    @FXML
    ListView<String> teamOneList = new ListView<>();
    @FXML
    ListView<String> teamTwoList = new ListView<>();

    @FXML
    public Button closeMain = new Button();

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

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location The location used to resolve relative paths for the
     *                 root object
     * @param resources The resources used to localize the root object
     */
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

    /**
     * Execute when the execute button is pressed on the main user interface.
     * It pulls the IDs from team arrays and loads them into the Python
     * function. The Python function returns the the results from the machine
     * learning algorithm and uses that value to display to the user.
     */
    public void execute() {

/*        // TODO: use for faster testing only comment this out when running
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
        countOfTeamTwo = 5;*/

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

            double temp = hello.__getattr__("probability").asDouble();
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

    /**
     * Creates the initial stage for the primary user interface screen. It
     * loads the screen without any controls directly available to the user
     *
     * @param primaryStage the primary stage
     * @throws Exception IO exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Scene"
                + ".fxml"));
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    /**
     * calls the fxml code that opens the riot.com web page
     */
    @FXML
    private void openRiot() {
        getHostServices().showDocument(riotText.getText());
    }

    /**
     * calls the fxml code that opens the leagueoflegends.com web page
     */
    @FXML
    private void openLeague() {
        getHostServices().showDocument(leagueText.getText());
    }

    /**
     * opens the about information window
     *
     * @throws Exception IO exception
     */
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
                + "\n\nApplication Creators: Myron King, Tri Nguyen & Jian Hua"
                + "\n\nCreated Spring 2017");
        alert.showAndWait();
    }

    /**
     * closes the primary user interface when the user clicks the exit button
     */
    @FXML
    private void closeMain(){
        Stage stage = (Stage) closeMain.getScene().getWindow();
        stage.close();
    }

    /**
     * Establishes a connection to the database via a JDBC connection. The
     * database is stored locally on the users hard drive as an SQLite
     * database. There is a simple select query that runs to pull all
     * champions from the database and puts them in a list.
     *
     * @return the Observable list of champions from the database
     */
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

    /**
     * The index value is coming from addTeamOne() (which ultimately get
     * the index value from the mouse click). If the number of
     * players on the team is already 5, the warning box is displayed and the
     * user can not add any more players to this team.
     *
     * Each champion is viewed as a table entry; there is a list of table
     * entries that is generated.
     *
     * The indexed champion is removed from the list (the selectable
     * champions) and added to an array list for the team (used to send data
     * to the Python machine learning algorithm) and a list to display the
     * selected champion in the teams selection area.
     *
     * Finally, the count of the team is incremented.
     *
     * @param index the index value assigned by the mouse click
     */
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

    /**
     * The index value is coming from the addTeamTwo() (which ultimately get
     * the index value from the mouse click). If the number of
     * players on the team is already 5, the warning box is displayed and the
     * user can not add any more players to this team.
     *
     * Each champion is viewed as a table entry; there is a list of table
     * entries that is generated.
     *
     * The indexed champion is removed from the list (the selectable
     * champions) and added to an array list for the team (used to send data
     * to the Python machine learning algorithm) and a list to display the
     * selected champion in the teams selection area.
     *
     * Finally, the count of the team is incremented.
     *
     * @param index the index value assigned by the mouse click
     */
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

    /**
     * Gets the row from the mouse click, then uses that index to add the
     * removed champion to a removed list (the removed list is ultimately
     * used to return champions back to the selectable pool of champions on
     * the right side of the user interface), and also to add the selected
     * champion to the selected team.
     */
    @FXML
    private void addTeamOne() {
        if(countOfTeamOne < 5) {
            int i = tableID.getSelectionModel().getSelectedCells().get(0)
                    .getRow();
            removedChampion.add(tableID.getItems().get(i));
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

    /**
     * Gets the row from the mouse click, then uses that index to add the
     * removed champion to a removed list (the removed list is ultimately
     * used to return champions back to the selectable pool of champions on
     * the right side of the user interface), and also to add the selected
     * champion to the selected team.
     */
    @FXML
    private void addTeamTwo() {
        if(countOfTeamTwo < 5) {
            int i = tableID.getSelectionModel().getSelectedCells().get(0)
                    .getRow();
            removedChampion.add(tableID.getItems().get(i));
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

    /**
     * removes the selected champion from the team and puts the selected player
     * back in the selectable pool of champion. Removes selected champion
     * from three areas, the removed list, the list of names used to shaow
     * selected players for that team, and the array list of tables being
     * sent to Python.
     */
    @FXML
    private void removeFromTeamOne() {
        String toClearFromTeam = teamOneList.getSelectionModel()
                .getSelectedItems().get(0); // gets the selected champion's name
        for (int i = 0; i < removedChampion.size(); i++) {
            if(toClearFromTeam.compareTo(removedChampion.get(i).getRNAME())
                    == 0) { // iterates through the team and removes matching
                // name
                theChampionsList.add(removedChampion.get(i)); // adds back to
                // the primary selectable list
                removedChampion.remove(i); // removes the champion from
                // removed list
            }
        }
        for(int i = 0; i < countOfTeamOne; i++) {
            if (teamOneList.getItems().get(i).compareTo(toClearFromTeam) == 0) {
                teamOneList.getItems().remove(i); // removes from team list
                teamOneArray.remove(i); // removes from array list that will
                // eventually be sent to Python
                countOfTeamOne--;
            }
        }
    }

    /**
     * removes the selected champion from the team and puts the selected player
     * back in the selectable pool of champion. Removes selected champion
     * from three areas, the removed list, the list of names used to shaow
     * selected players for that team, and the array list of tables being
     * sent to Python.
     */
    @FXML
    private void removeFromTeamTwo() {
        String toClearFromTeam = teamTwoList.getSelectionModel()
                .getSelectedItems().get(0); // gets the selected champion's name
        for (int i = 0; i < removedChampion.size(); i++) {
            if(toClearFromTeam.compareTo(removedChampion.get(i).getRNAME())
                    == 0) { // iterates through the team and removes matching
                // name
                theChampionsList.add(removedChampion.get(i)); // adds back to
                // the primary selectable list
                removedChampion.remove(i); // removes the champion from
                // removed list
            }
        }
        for(int i = 0; i < countOfTeamTwo; i++) {
            if (teamTwoList.getItems().get(i).compareTo(toClearFromTeam) == 0) {
                teamTwoList.getItems().remove(i); // removes from team list
                teamTwoArray.remove(i);// removes from array list that will
                // eventually be sent to Python
                countOfTeamTwo--;
            }
        }
    }

    /**
     * Displays the accuracy of our machine learning algorithm
     */
    public void accuracy() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Accuracy");
        alert.setHeaderText(null);
        alert.setContentText("Using the Logistic Regression model, the "
                + "precision of this model is 85.66% and the accuracy of this "
                + "model is 84.12%.");
        alert.showAndWait();
    }
}
