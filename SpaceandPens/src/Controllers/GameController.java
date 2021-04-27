/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Modeles.ActionManager;
import Modeles.Map;
import Modeles.WorldIHM;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


/**
 * FXML Controller class
 *
 * @author charlie
 */
public class GameController implements Initializable {
    
    private String name;
    private WorldIHM world;
    private ActionManager manager;

    
    @FXML
    private ImageView map;
    @FXML
    private Pane north;
    @FXML
    private Pane west;
    @FXML
    private Pane east;
    @FXML
    private Pane south;
    @FXML
    private Pane inventory;
    @FXML
    private MenuBar menu;
    
    @FXML
    private TextArea mapDescription;
    @FXML
    private Pane worldVu;
    @FXML
    private TextArea gameDescription;
    @FXML
    private Pane temp;
    
        public void setMapDescription() {
        this.mapDescription.setText(this.world.getMapDescription());
    }

    public void setPlayerName(String name) {
        this.name = name;
        this.setWorld(this.name);
    }

    public void setWorld(String playerName) {
        this.world = new WorldIHM(playerName);
        this.manager = new ActionManager(this.world);
        this.setMapDescription();
        this.gameDescription.setText("Welcome " + this.name + ".");
        this.setGameDescription("Your ship has crashed, you need a jack and a new motor to leave this planet.");
        this.setGameDescription("You Enter : " + this.world.getPlayer().getMapHero().getName() + ".");
    }

    public void setGameDescription(String text) {
        this.gameDescription.appendText('\n' + text);
    }
    
    public void actualiseVue(){
        
        if (temp.getChildren().size() > 0 ){
            //On supprime les anciens donnée
            temp.getChildren().clear();
        }
        
        //On récupère la nouvel amp
        Map newMap = this.world.player.getMapHero();
        
        //On récupére son contenu
        String nameMap = newMap.getName();
        Set<String> itemList = newMap.getGroundItemsList();
        Set<String> npcList = newMap.getNpcsList();
        Set<String> ennemisList = newMap.getEnemiesList();
        
        //On actualise la map
        map.setImage(new Image("/spaceandpens/images/map/"+nameMap+".png"));
        
        //On place les objet pnj et ennemis si y'en a 
        Object[] items = itemList.toArray();
        for (int i = 0 ; i < items.length; i++) {
            
            //On crée la nouvelle entité 
            ImageView nEntity = new ImageView(new Image("/spaceandpens/images/objet/"+items[i]+".png"));
            
            //On prend nos valeur déjà prédifini pour la taille et largeur
            nEntity.setFitHeight(170);
            nEntity.setFitWidth(182);
            
            //On la place sur la nouvelle map 
            nEntity.setLayoutX(i*100);
            nEntity.setLayoutY(i*100);
            
            //On l'ajoute comme enfant au pane temp 
            temp.getChildren().add(nEntity);
            
        }
        
        Object[] npcs = npcList.toArray();
        for (int i = 0 ; i < npcs.length; i++) {
            
            ImageView nEntity = new ImageView(new Image("/spaceandpens/images/pnj/"+npcs[i]+".png")); 
            nEntity.setFitHeight(170);
            nEntity.setFitWidth(182);
            nEntity.setLayoutX(i*100);
            nEntity.setLayoutY(i*100);
                    
            temp.getChildren().add(nEntity);
            
        }
        
        Object[] ennemis = ennemisList.toArray();
        for (int i = 0 ; i < ennemis.length; i++) {
              
            ImageView nEntity = new ImageView(new Image("/spaceandpens/images/ennemi/"+ennemis[i]+".png"));
            nEntity.setFitHeight(170);
            nEntity.setFitWidth(182);
            nEntity.setLayoutX(i*100);
            nEntity.setLayoutY(i*100);
                    
            temp.getChildren().add(nEntity);
            
        }        
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goNorth(MouseEvent event)
    {
        Object[] response = this.manager.actionGo("north");
        if((boolean) response[0])
            this.setMapDescription();
        this.setGameDescription((String) response[1]);
        this.actualiseVue();
    }

    @FXML
    private void goWest(MouseEvent event) 
    {
        Object[] response = this.manager.actionGo("west");
        if((boolean) response[0])
            this.setMapDescription();
        this.setGameDescription((String) response[1]);
        
        this.actualiseVue();
    }

    @FXML
    private void goEast(MouseEvent event) 
    {
        Object[] response = this.manager.actionGo("east");
        if((boolean) response[0])
            this.setMapDescription();
        this.setGameDescription((String) response[1]);
        this.actualiseVue();

    }

    @FXML
    private void goSouth(MouseEvent event) {
                Object[] response = this.manager.actionGo("south");
        if((boolean) response[0])
            this.setMapDescription();
        this.setGameDescription((String) response[1]);
        
        this.actualiseVue();
    }

    @FXML
    private void goInventory(MouseEvent event) {
    }
    
}
