/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import static jdk.nashorn.internal.objects.NativeRegExp.source;

/**
 * FXML Controller class
 *
 * @author charlie
 */
public class LookController implements Initializable {

    @FXML
    private Pane Sac;
    @FXML
    private ImageView bidoof;
    @FXML
    private ImageView connard;
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
        if(event.getDragboard().hasImage()){   // autorise le déplacement avec un fichier dans le lieu dit
        event.acceptTransferModes(TransferMode.ANY);
    }
    }

    @FXML
    private void handleDrop(DragEvent event) throws FileNotFoundException {
        event.getDragboard().getFiles().clear();
        world.getChildren().remove(bidoof);
        
    }

    @FXML
    private void handleDragDetected(MouseEvent event) {          //Prendre l'image
        Dragboard db = bidoof.startDragAndDrop(TransferMode.ANY);
        
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(bidoof.getImage());
        
        db.setContent(cb);
        
        event.consume();
        
        
        
    }
}
