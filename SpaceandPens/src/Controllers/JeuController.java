/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import Modeles.ActionManager;
import Modeles.Shop;
import Modeles.WorldIHM;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author site7
 */
public class JeuController implements Initializable {

    private String name;
    private WorldIHM world;
    private ActionManager manager;


    @FXML
    private ImageView north;
    @FXML
    private ImageView east;
    @FXML
    private ImageView south;
    @FXML
    private ImageView west;
    @FXML
    private Button Shop;

    @FXML
    private TextArea mapDescription;

    @FXML
    private TextArea gameDescription;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setMapDescription() {
        this.mapDescription.setText(this.world.getMapDescription());
    }

    public void setPlayerName(String name) {
        this.name = name;
        this.setWorld(this.name);
    }

    public void setWorld(String playerName) {
        this.world = new WorldIHM(playerName);
        this.manager = new ActionManager(this.world);
        this.setMapDescription();
        this.gameDescription.setText("Welcome " + this.name + ".");
        this.setGameDescription("Your ship has crashed, you need a jack and a new motor to leave this planet.");
        this.setGameDescription("You Enter : " + this.world.getPlayer().getMapHero().getName() + ".");
    }

    public void setGameDescription(String text) {
        this.gameDescription.appendText('\n' + text);
    }

    @FXML
    public void actionQuit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void moveNorth(MouseEvent event) {

        Object[] response = this.manager.actionGo("north");
        if((boolean) response[0])
            this.setMapDescription();
        this.setGameDescription((String) response[1]);
        this.checkIfShop();
    }

    @FXML
    public void moveEast(MouseEvent event) {
        Object[] response = this.manager.actionGo("east");
        if((boolean) response[0])
            this.setMapDescription();
        this.setGameDescription((String) response[1]);
        this.checkIfShop();
    }

    @FXML
    public void moveSouth(MouseEvent event) {
        Object[] response = this.manager.actionGo("south");
        if((boolean) response[0])
            this.setMapDescription();
        this.setGameDescription((String) response[1]);
        this.checkIfShop();
    }

    @FXML
    public void moveWest(MouseEvent event) {
        Object[] response = this.manager.actionGo("west");
        if((boolean) response[0])
            this.setMapDescription();
        this.setGameDescription((String) response[1]);
        this.checkIfShop();
    }

    @FXML
    public void openShop(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/Shop.fxml"));
        Parent root = loader.load();

        ShopController shopController = loader.getController();
        shopController.setPlayerAndShop(this.world.getPlayer(), (Modeles.Shop) this.world.getPlayer().getMapHero().getShop().getDestination());

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinHeight(545);
        stage.setMinWidth(900);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public void checkIfShop() {
        if (this.world.getPlayer().getMapHero().isShop())
            this.Shop.setDisable(false);
        else
            this.Shop.setDisable(true);
    }
    
}
