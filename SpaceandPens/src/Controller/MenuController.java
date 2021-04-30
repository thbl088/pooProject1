/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author site7
 */
public class MenuController implements Initializable {

    @FXML
    private TextField playerName;
    @FXML
    private Button Jeu;

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/game.fxml"));

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
        newStage.setResizable(false);
        newStage.show();
    }
    @FXML
    public void openHelp(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/help.fxml"));
        Parent root = loader.load();


        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.getIcons().add(new Image("spaceandpens/images/spaceandpens.png"));
        stage.setTitle("Help");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }  

    @FXML
    private void openCredit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.setTitle("Credit");
        alert.setContentText("\nProgrammer : BOUE ALEXIS, LUNETEAU  THOMAS, VIALLE CHARLIE\nDesigner : VIALLE CHARLIE\nBosses's Designer: ZIELINSKI DRAGAN");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("spaceandpens/images/spaceandpens.png"));
        alert.showAndWait();        
    }

    @FXML
    private void quit(ActionEvent event) {
    }
}
