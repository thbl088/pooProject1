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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.WindowEvent;

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/game.fxml"));

        Parent root = loader.load();
        GameController jeuController = loader.getController();
        jeuController.setPlayerName(this.playerName.getText());

        Scene scene = new Scene(root);
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image("spaceandpens/images/spaceandpens.png"));
        newStage.setTitle("Space And Pens");
        newStage.setOnCloseRequest(windowEvent ->  Platform.exit() ); //ferme toutes les fenêtres fils du programme lorsque l'utilisateur ferme la fenêtre principale
        newStage.sizeToScene();
        newStage.setMinHeight(635);
        newStage.setMinWidth(1035);
        newStage.setScene(scene);
        newStage.show();

    }
}
