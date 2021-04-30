/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.TakeListener;
import Modeles.Item;
import Modeles.LockedDoor;
import Modeles.Player;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author charlie
 */
public class EndDoorController implements Initializable {
    
    private final String car = "car wheel";
    private final String skate = "little wheel";
    private final String tank = "tank tracks";
    private Player player;
    @FXML
    private Pane spawn;
    @FXML
    private Pane carfinish;
    @FXML
    private Pane skatefinish;
    @FXML
    private Pane tankfinish;
    @FXML
    private Button qui;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void initEndDoor(HashMap<String, Item> inventaire, Player player){
        
       this.player = player;
       
       Image imageQui = new Image("spaceandpens/images/curseur/doorOpen.png");
       qui.setCursor(new ImageCursor(imageQui));
       
       if(player.hasItem(car)){
           
           ImageView nEntity = new ImageView(new Image("/spaceandpens/images/objet/"+car+".png"));
           
           //On prend nos valeur déjà prédifini pour la taille et largeur
            nEntity.setFitHeight(100);
            nEntity.setFitWidth(100);
            
            //On la place sur la nouvelle map 
            nEntity.setLayoutX(150);
            nEntity.setLayoutY(20);
            
            //On lui met un id pour le reconnaître
            nEntity.setId(car);
            
            //On lui personnalise un curseur pour dire à l'utilisateur qu'il peut faire une action
            Image image = new Image("spaceandpens/images/curseur/main.png");
            nEntity.setCursor(new ImageCursor(image));
            
            spawn.getChildren().add(nEntity);
            
            TakeListener dragNdrop = new TakeListener(14 , -8);
            
            nEntity.setOnDragDetected(event -> {
                dragNdrop.glisseEndDoor(event);
            });
            
       }
       if(player.hasItem(skate)){
           
            ImageView nEntity = new ImageView(new Image("/spaceandpens/images/objet/"+skate+".png"));
           
          
            nEntity.setFitHeight(182);
            nEntity.setFitWidth(170);
            
            
            nEntity.setLayoutX(322);
            nEntity.setLayoutY(-8);
            
            
            nEntity.setId(skate);
            
            spawn.getChildren().add(nEntity);
            
            Image image = new Image("spaceandpens/images/curseur/main.png");
            nEntity.setCursor(new ImageCursor(image));
            
            TakeListener dragNdrop = new TakeListener(322 , -8);
            
            nEntity.setOnDragDetected(event -> {
                dragNdrop.glisseEndDoor(event);
            });
           
       }
       if(player.hasItem(tank)){
           
           ImageView nEntity = new ImageView(new Image("/spaceandpens/images/objet/"+tank+".png"));
           
           
            nEntity.setFitHeight(182);
            nEntity.setFitWidth(170);
            
            
            nEntity.setLayoutX(632);
            nEntity.setLayoutY(-8);
            
            nEntity.setId(tank);
            spawn.getChildren().add(nEntity); 
            
            Image image = new Image("spaceandpens/images/curseur/main.png");
            nEntity.setCursor(new ImageCursor(image));
            
            TakeListener dragNdrop = new TakeListener(632 , -8);
            
            nEntity.setOnDragDetected(event -> {
                dragNdrop.glisseEndDoor(event);
            });
       }  
    }
    private void annimationOpenEndDoor(){
        TranslateTransition transitionTank = new TranslateTransition();
        transitionTank.setDuration(Duration.seconds(5));            // On choisit la durrée
        transitionTank.setNode(tankfinish.getChildren().get(0));    // On choisi sur qui mettre l'animation
        transitionTank.setFromY(0);                  // Point de départ        
        transitionTank.setToY(300);                   // Point d'arrivé
        
        TranslateTransition transitionSkate = new TranslateTransition();
        transitionSkate.setDuration(Duration.seconds(5));            
        transitionSkate.setNode(skatefinish.getChildren().get(0));       
        transitionSkate.setFromY(0);                          
        transitionSkate.setToY(75);
        transitionSkate.setToX(-250);

        TranslateTransition transitionCar = new TranslateTransition();
        transitionCar.setDuration(Duration.seconds(5));            
        transitionCar.setNode(carfinish.getChildren().get(0));       
        transitionCar.setFromY(0);                          
        transitionCar.setToY(100);
        transitionCar.setToX(250);
        
        transitionTank.play();
        transitionSkate.play();
        transitionCar.play();
        
        
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.setTitle("The Soul of the End Door");
        alert.setContentText("Captain Keyes [The Soul of the End Door] : Thanks bro you can enter and defeat Leclerc");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("spaceandpens/images/spaceandpens.png"));
        alert.show();

    }
    @FXML
    private void depose(DragEvent event)
    {           
               Node node = (Node) event.getGestureSource();  // on récupére la source 
               String nameId = node.getId();
               if( nameId.equals(car))
               {
                   carfinish.getChildren().add(node);
                   node.setLayoutX(0);
                   node.setLayoutY(0);
               }
               if( nameId.equals(skate))
               {
                   skatefinish.getChildren().add(node);
                   node.setLayoutX(0);
                   node.setLayoutY(0);
               }
               if( nameId.equals(tank))
               {
                   tankfinish.getChildren().add(node);
                   node.setLayoutX(91);
                   node.setLayoutY(-23);
               }
               if( tankfinish.getChildren().size() == 1 && carfinish.getChildren().size() == 1 && skatefinish.getChildren().size() == 1 ){  // Vérifions si les 3 clefs sont positioné à la fin de l'action
                   LockedDoor endDoor = (LockedDoor) this.player.getMapHero().getNorth();           //On ouvre la porte
                   endDoor.unlock();                                                                
                   this.player.removeInventory(this.player.getItem(car));                          //On enlève les items du héro
                   this.player.removeInventory(this.player.getItem(tank));
                   this.player.removeInventory(this.player.getItem(skate));
                   this.annimationOpenEndDoor();
               }
          
    }

    @FXML
    private void detecte(DragEvent event) {
        ImageView image = (ImageView) event.getGestureSource();
        if(event.getDragboard().hasImage() && (image.getId().equals(car) && event.getTarget().equals(carfinish))
                || (image.getId().equals(skate) && event.getTarget().equals(skatefinish))
                || (image.getId().equals(tank) && event.getTarget().equals(tankfinish)))  // autorise le déplacement d'une image
         event.acceptTransferModes(TransferMode.ANY);
        }

    private void removeall() {
        
        skatefinish.getChildren().clear();
        carfinish.getChildren().clear();
        tankfinish.getChildren().clear();
    }

    @FXML
    private void closeWindow(ActionEvent event) {
        Stage stage = (Stage) spawn.getScene().getWindow();
                stage.close();
    }
}    

