/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Modeles.ActionManager;
import Modeles.Player;
import Modeles.Enemy;
import Modeles.Fight;
import Modeles.Statistics;
import Modeles.WorldIHM;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author site7
 */
import javafx.stage.Modality;
import javafx.stage.Stage;
public class FightController implements Initializable {
    
    private HashMap<String, Enemy> enemies;
    private Enemy enemy;
    private Player player;
    private WorldIHM world;
    private Fight fight;
    private ActionManager manager;
    private static final String RED_BAR    = "red-bar";
    private static final String YELLOW_BAR = "yellow-bar";
    private static final String ORANGE_BAR = "orange-bar";
    private static final String GREEN_BAR  = "green-bar";
    private static final String[] barColorStyleClasses = { RED_BAR, ORANGE_BAR, YELLOW_BAR, GREEN_BAR };

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
    private ImageView enemyPicture;
    private Label labelNameEnemy;
    private ProgressBar HPBarEnemy;
    @FXML
    private Label labelAction;
    @FXML
    private Label description;
    @FXML
    private GridPane choices;
    @FXML
    private Button defendButton;
    @FXML
    private Button InventoryButton;
    @FXML
    private Label labelAttackPlayer;
    @FXML
    private Label labelDefensePlayer;
    @FXML
    private GridPane enemyGrid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //manager.startFight();
        
        HPBarPlayer.progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double progress = newValue == null ? 0 : newValue.doubleValue();
                if (progress < 0.25) {
                    HPBarPlayer.setStyle("-fx-accent : red;");
                } else if (progress < 0.5) {
                    HPBarPlayer.setStyle("-fx-accent : orange;");
                } else if (progress < 0.75) {
                    HPBarPlayer.setStyle("-fx-accent : yellow;");
                } else {
                    HPBarPlayer.setStyle("-fx-accent : green;");
                }
            }
        });
        /*
        
        */
    }    

    public void setPlayer(Player player){
        this.player = player;
        playerInitialize();
    }    
    
    public void startFight(){
        this.fight = new Fight(player);        
    }
    
    public void playerInitialize(){
        Statistics statsPlayer = this.player.getStatistics();
        
        this.HPBarPlayer.setProgress((double)statsPlayer.getHealth()/ (double)statsPlayer.getMaxHealth());
        this.labelNamePlayer.setText(player.getName());
        this.labelAttackPlayer.setText(Integer.toString(statsPlayer.getAttack()));
        this.labelDefensePlayer.setText(Integer.toString(statsPlayer.getDefense()));
        this.maxHPPLAYER.setText(Integer.toString(statsPlayer.getMaxHealth()));
        this.playerHP.setText(Integer.toString(statsPlayer.getHealth()));
        
        String imgPlayer = "spaceandpens/images/pnj/" + "samuel" + ".png";
        this.playerPicture.setImage(new Image(imgPlayer));
    }
    
    public void enemiesInitialize(HashMap<String, Enemy> enemies){
        fight.remEnemyDeath();
        this.enemies = enemies;
        int row = 0;
        int column = 0;
        int numEnemy = 0;
        for(Map.Entry<String, Enemy> entry : enemies.entrySet()) {
            String enemyName = entry.getKey();
            Enemy enemyStat = entry.getValue();
            
            //if (enemyStat.getHealth()>0) {
                Label labelNameEnemy1 = new Label(enemyName);
                labelNameEnemy1.setId("label" + enemyName);
                ImageView enemyPicture1 = new ImageView(new Image("/spaceandpens/images/ennemi/"+enemyName+".png"));
                enemyPicture1.setId("picture" + enemyName);
                ProgressBar HPEnemy = new ProgressBar((double)enemyStat.getHealth()/ (double)enemyStat.getStatistics().getMaxHealth());
                if (HPEnemy.getProgress() < 0.25) {
                            HPEnemy.setStyle("-fx-accent : red;");
                        } 
                else if (HPEnemy.getProgress() < 0.5) {
                            HPEnemy.setStyle("-fx-accent : orange;");
                        }
                else if (HPEnemy.getProgress() < 0.75) {
                            HPEnemy.setStyle("-fx-accent : yellow;");
                        } 
                else {
                            HPEnemy.setStyle("-fx-accent : green;");
                        }
                HPEnemy.setId("HPBar" + enemyName);
                VBox vboxEnemy = new VBox(labelNameEnemy1, HPEnemy, enemyPicture1);
                vboxEnemy.setId("vbox" + enemyName);
                enemyPicture1.setFitHeight(150);
                enemyPicture1.setFitWidth(150);
                vboxEnemy.setLayoutX(700);
                vboxEnemy.setLayoutY(0);
                
                vboxEnemy.setAlignment(Pos.CENTER);
                                
                vboxEnemy.setCursor(Cursor.HAND); //Change cursor to hand
                
                vboxEnemy.setOnMouseClicked(event -> {
                    fight.playerAttack(enemyName);
                    System.out.println("Controllers.FightController.enemiesInitialize()");
                    System.out.println(enemyName);
                    reInitialize(player, enemies);
                    fight.enemyAttack();
                    reInitialize(player, enemies);
                });
                if(numEnemy % 2 == 1){
                    enemyGrid.add(vboxEnemy, row, column+1);
                    row++;
                }
                else{
                    enemyGrid.add(vboxEnemy, row, column);
                }
                numEnemy++;
            //}
            fight.checkEnemyDeath(enemyName);
        }
    }
    
    public void updateEnemy(HashMap<String, Enemy> enemies){
        enemyGrid.getChildren().clear();
        enemiesInitialize(enemies);
    }
    
    public void reInitialize(Player player, HashMap<String, Enemy> enemies){
        playerInitialize();
        updateEnemy(enemies);
        checkEndGame();
    }
    
    public void setFight(Player player, HashMap<String, Enemy> enemies){
        setPlayer(player);
        startFight();
        enemiesInitialize(enemies);
    }
    
    public void checkEndGame(){
        System.out.println("Controllers.FightController.checkEndGame()");
        System.out.println(enemies.size());
        if(fight.stillFighting() == 2){
                player = fight.getPlayerPostFight();
                Stage stage = (Stage) World.getScene().getWindow();
                stage.close();
            }   
            else{
                if(fight.stillFighting() == 1){
                //todo joueur mort
                }
            }
        }
 
    @FXML
    public void defend(ActionEvent event){
        fight.defend();
        fight.enemyAttack();
        reInitialize(player, enemies);
    }
    
 
    @FXML
    private void quit(Event event) {
        manager.actionQuit();
    }

    @FXML
    private void openStats(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/Stats.fxml"));
        Parent root = loader.load();

        StatsController stats = loader.getController();
        stats.setPlayer(this.world.getPlayer());

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.getIcons().add(new Image("spaceandpens/images/spaceandpens.png"));
        stage.setTitle("Statistics and Inventory");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }
}