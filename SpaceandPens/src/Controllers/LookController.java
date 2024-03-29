/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author charlie
 */
public class LookController implements Initializable {

    @FXML
    private Pane world;
 
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleDragOver(DragEvent event) { 
        if(event.getDragboard().hasImage()){   // autorise le déplacement d'une image
        event.acceptTransferModes(TransferMode.ANY);
    }
    }

    @FXML
    private void handleDrop(DragEvent event) throws FileNotFoundException {
       Node node = (Node) event.getGestureSource();                           // on récupére la source 
                
        world.getChildren().remove(node);                                    //on la supprime 
        
    }

    @FXML
    private void handleDragDetected(MouseEvent event) {          //Prendre l'image
        ImageView img  = (ImageView) event.getSource();
       
        Dragboard db = img.startDragAndDrop(TransferMode.ANY);
        
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(img.getImage());
        
        db.setContent(cb);
        
        event.consume();
        
        
        
    }
}
