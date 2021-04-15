/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author site7
 */
public class FightController implements Initializable {

    @FXML
    private VBox World;
    @FXML
    private MenuBar menubar;
    @FXML
    private Menu option;
    @FXML
    private MenuItem help;
    @FXML
    private MenuItem quit;
    @FXML
    private AnchorPane fightPanel;
    @FXML
    private VBox playerDisplay;
    @FXML
    private ImageView playerPicture;
    @FXML
    private VBox vboxPlayer;
    @FXML
    private Label labelNamePlayer;
    @FXML
    private Label maxHPPLAYER;
    @FXML
    private Label playerHP;
    @FXML
    private ProgressBar HPBarPlayer;
    @FXML
    private Label attackPlayer;
    @FXML
    private Label PlayerDefense;
    @FXML
    private VBox enemuDisplay;
    @FXML
    private ImageView enemyPicture;
    @FXML
    private VBox vboxEnemy;
    @FXML
    private Label labelNameEnemy;
    @FXML
    private ProgressBar HPBarEnemy;
    @FXML
    private Label labelAction;
    @FXML
    private Label description;
    @FXML
    private GridPane choices;
    @FXML
    private Button attackButton;
    @FXML
    private Button defendButton;
    @FXML
    private Button InventoryButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
