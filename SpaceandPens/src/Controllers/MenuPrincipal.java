/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author site7
 */
public class MenuPrincipal implements Initializable {

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
    private void start(ActionEvent event) {
    }

    @FXML
    private void commandes(ActionEvent event) {
    }

    @FXML
    private void credit(ActionEvent event) {
    }

    @FXML
    private void quitter(ActionEvent event) {
    }
    
}
