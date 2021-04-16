/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author charlie
 */
public class CleftestController implements Initializable {

    @FXML
    private ImageView ombre;
    @FXML
    private ImageView magicarp;
    @FXML
    private ImageView cupcake;
    @FXML
    private Circle four;
    @FXML
    private Circle clan;
    @FXML
    private Circle pokemon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void glisse(MouseEvent event) {
       ImageView img  = (ImageView) event.getSource();
       
        Dragboard db = img.startDragAndDrop(TransferMode.ANY);
        
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(img.getImage());
        
        db.setContent(cb);
        
        event.consume();
    }

    @FXML
    private void depose(DragEvent event) {
   

          
    }
    
        
    

    @FXML
    private void detecte(DragEvent event) {
       
       //String lieu = event.get
        if(event.getDragboard().hasImage() && event.getGestureSource().equals(magicarp)){// && lieu == "magicarp" ){   // autorise le déplacement d'une image
        event.acceptTransferModes(TransferMode.ANY);
        }
        
}
}
