/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceandpens;

import java.io.IOException;
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
