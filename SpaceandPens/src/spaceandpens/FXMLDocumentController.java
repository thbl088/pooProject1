/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceandpens;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author site7
 */
public class FXMLDocumentController implements Initializable {

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
    private void openShop(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Vues/Shop.fxml"));
        Stage stage = new Stage();
        stage.sizeToScene();
        stage.setMinWidth(900);
        stage.setMinHeight(530);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
