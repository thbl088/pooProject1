/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Modeles.WorldIHM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author site7
 */
public class MenuPrincipal implements Initializable {

    @FXML
    private TextField playerName;
    @FXML
    private Button Jeu;
    @FXML
    private Button Commandes;
    @FXML
    private Button Crédit;
    @FXML
    private Button Quitter;
    @FXML
    private Button Shop;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void launchGame(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.Jeu.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/jeu.fxml"));

        Parent root = loader.load();
        JeuController jeuController = loader.getController();
        jeuController.setPlayerName(this.playerName.getText());

        Scene scene = new Scene(root);
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image("spaceandpens/images/spaceandpens.png"));
        newStage.sizeToScene();
        newStage.setMinHeight(635);
        newStage.setMinWidth(1035);
        newStage.setScene(scene);
        newStage.show();

    }

    @FXML
    public void openShop(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vues/Shop.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setMinHeight(545);
        stage.setMinWidth(900);
        stage.setScene(scene);
        stage.show();
    }


}
