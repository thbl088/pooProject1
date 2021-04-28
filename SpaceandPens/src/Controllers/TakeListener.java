/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Modeles.Item;
import Modeles.WorldIHM;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
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
import javax.swing.JPanel;

/**
 * FXML Controller class
 *
 * @author charlie
 */
public class TakeListener extends JPanel {
    
    private Pane world;
    private WorldIHM game;

    public TakeListener(WorldIHM jeu, Pane paneItem, int x, int y) {
        
        this.world = paneItem;
        this.game = jeu;
        setPreferredSize(new Dimension(x, y));
        addMouseListener(new MouseAdapter() {
        }
        );
    }
    
    public void handleDragDetected(MouseEvent event) 
    {                                                           //Prendre l'image
        ImageView img  = (ImageView) event.getSource();
        Dragboard db = img.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(img.getImage());
        db.setContent(cb);
        event.consume();
    }
    
    
    public void handleDragOver(DragEvent event)
    { 
        if(event.getDragboard().hasImage()){   // autorise le déplacement d'une image
            event.acceptTransferModes(TransferMode.ANY);}
    }
    
     public void handleDrop(DragEvent event) throws FileNotFoundException 
     {
         Node node = (Node) event.getGestureSource();                           // on récupére la source 
         String nameId = node.getId().toString();
         
         Item item = game.getPlayer().getMapHero().takeItem(nameId);          // Remove l'item de la hasmap 
         game.getPlayer().addInventory(item);                                 // Ajoute l'item dans l'inventaire
         world.getChildren().remove(node);                                    //on la supprime du pane pour faire comme si on la rammassé 
     }
}


