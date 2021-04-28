/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import javafx.scene.control.*;
import Modeles.Item;
import Modeles.Player;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author charlie
 */
public class TalkController implements Initializable {
    
    private Player player;
    private String nameNpc;
    @FXML
    private Pane root;
    @FXML
    private TextArea gameDescription;
    @FXML
    private ImageView pnj;
    @FXML
    private ImageView hero;
    
    
 
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        
    }
    public void init(Player player, String nameNpc){
        this.player = player;    
        this.nameNpc = nameNpc;
        this.Talk(this.nameNpc);
    }
    
    public void setDescription(String text){
        this.gameDescription.appendText('\n' + text);
    }
    
    public void changeView(String name){
        this.pnj.setImage(new Image("/spaceandpens/images/pnj/"+name+".png"));
    }
    
    public void animationItem(String nameItem){
        
        ImageView item = new ImageView(new Image("/spaceandpens/images/objet/"+nameItem+".png"));
        
        //On prend nos valeur déjà prédifini pour la taille et largeur
        item.setFitHeight(182);
        item.setFitWidth(170);
            
        //On le place
        //item.setLayoutX(hero.getLayoutX());
        item.setLayoutY(10);        
        
        root.getChildren().add(item);
        
        
        //Animation droit
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(5));            // On choisit la durrée
        transition.setNode(item);                               // On choisi ou la mettre 
        transition.setFromX(pnj.getLayoutX());                  // Point de départ        
        transition.setToX(hero.getLayoutX());                   // Point d'arriver  

        //Animation rotate
        RotateTransition transitionRotation = new RotateTransition(Duration.seconds(5), item);
        transitionRotation.setFromAngle(0);      //Angle partant  
        transitionRotation.setToAngle(720);      // Angle final
        
        // On lance
        transition.play();
        transitionRotation.play();
        
    }
    
    public void Talk(String name){
        
        this.changeView(name);
        
        Player p = this.player;
        if ( p.getMapHero().getNpc(name) != null ){      // vérifie si l'entité est bien un pnj
            this.setDescription(p.getMapHero().getNpc(name).getDialog()); // récupére et affiche son dialogue
            if ( (name.equals("crazy man") && !(p.hasItem("tank track")) )    //vérifie le pnj si c'est  le crazy_man ou samuel deux pnj qui donne des items et on vérifie si ils ont déjà pas donnée les items
                    || name.equals("samuel") && !(p.hasItem("garbage collector")))
            {  
                Item objet_pnj = p.getMapHero().getNpc(name).getItem();
                this.animationItem(objet_pnj.getName());
                this.setDescription("You obtain " + objet_pnj.getName() + ".");
                p.addInventory(objet_pnj);
            }
        }  
    }
}
