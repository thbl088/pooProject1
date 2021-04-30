/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Modeles.Enemy;
import Modeles.Item;
import Modeles.Map;
import Modeles.Npc;
import Modeles.WorldIHM;
import Controllers.TakeListener;
import Modeles.Door;
import Modeles.LockedDoor;
import Modeles.Player;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



/**
 * FXML Controller class
 *
 * @author charlie
 */
public class GameController implements Initializable {
    
    private String name;
    private WorldIHM world;
    //private ActionManager manager;
    
    TakeListener dragNdrop ;
    
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
    private TextArea mapDescription;
    @FXML
    private Pane worldVu;
    @FXML
    private TextArea gameDescription;
    @FXML
    private Pane temp;
    
    

    public void setPlayerName(String name) {
        //Initialise des données pour la partie modele
        this.name = name;
        this.setWorld(this.name);
    }

        
    public void openFight(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/fight.fxml"));
        Parent root = loader.load();

        FightController fightController = loader.getController();
        fightController.setFight(this.world.getPlayer(), this.world.getPlayer().getMapHero().getEnemies());

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.getIcons().add(new Image("spaceandpens/images/spaceandpens.png"));
        stage.setTitle("Fight!");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinHeight(545);
        stage.setMinWidth(800);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.showAndWait();
        actualiseVue();
        if(this.world.player.getHealth()<1){
            endGame();
        }
    }
    
    
    
    
    
     public void endGame() throws IOException {
        Stage stage = (Stage) this.worldVu.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/menu.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image("spaceandpens/images/spaceandpens.png"));
        newStage.setTitle("Space And Pens");
        newStage.sizeToScene();
        newStage.setMinHeight(532);
        newStage.setMinWidth(678);
        newStage.setScene(scene);
        newStage.show();

    }


    public void setWorld(String playerName) {
        
        //Initialise des données pour la partie modele
        this.world = new WorldIHM(playerName);
        
        this.setMapDescription();
        
        //Initialisation parti vu
        TakeListener look = new TakeListener(world, temp, 12, 13);
        this.dragNdrop = look;
        this.initiCursor();
        
        //Debut du jeu
        this.gameDescription.setText("Welcome " + this.name + ".");
        this.setGameDescription("Your ship has crashed, you need a jack and a new motor to leave this planet.");
        this.setGameDescription("You Enter : " + this.world.getPlayer().getMapHero().getName() + ".");
        
        
   
    }

    public void setGameDescription(String text) {
        this.gameDescription.appendText('\n' + text);
    }
    

    public void setMapDescription() {
        this.mapDescription.setText(this.world.getMapDescription());
    }    
    
       public void initiCursor(){
        //On ajoute une image Custom sur le curseur pour la root inventory.
  
        Image imageI = new Image("spaceandpens/images/curseur/bourse.png");
        inventory.setCursor(new ImageCursor(imageI));               
    }
   
    public void actualiseVue() throws IOException{
        
        if (temp.getChildren().size() > 0 ){
            //On supprime les anciens donnée
            temp.getChildren().clear();
        }
        
        //On récupère la nouvel amp
        Map newMap = this.world.player.getMapHero();
        
        //On regarde si la nouvelle map possède le shop
        if (newMap.isShop())
        {
            Pane shop = new Pane();
            
            shop.setLayoutX(801);
            shop.setLayoutY(203);
            shop.setPrefHeight(306);
            shop.setPrefWidth(327);
            
            // Changement du curseur pour que l'utilisateur aperçoit l'interaction avec la boutique
            Image image = new Image("spaceandpens/images/curseur/doorOpen.png");
            shop.setCursor(new ImageCursor(image));
            //On lui ajoute un évènement clique souris
            shop.setOnMouseClicked(event -> {
                try {
                    this.openShop(event);
                } catch (IOException ex) {
                    Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            temp.getChildren().add(shop);     
        }
        
        if(world.player.getMapHero().getName().equals("Ship") && world.player.hasItem("reactor")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setGraphic(null);
            alert.setTitle("Victory");
            alert.setContentText("You beat the game, congratulation!");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("spaceandpens/images/spaceandpens.png"));            
            alert.showAndWait();
            endGame();
        }
        
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
            //On récupére la Hashmap de la Map
            HashMap<String, Item> itemHash = world.getPlayer().getMapHero().getItem();
          
            //On crée la nouvelle entité 
            ImageView nEntity = new ImageView(new Image("/spaceandpens/images/objet/"+items[i]+".png"));
            
            
            //On lui donne un id le nom de l'objet 
            nEntity.setId(items[i].toString());
            
            //On prend nos valeur déjà prédifini pour la taille et largeur
            nEntity.setFitHeight(itemHash.get(items[i].toString()).getPositionHeight());
            nEntity.setFitWidth(itemHash.get(items[i].toString()).getPositionWidth());
            
            //On la place sur la nouvelle map 
            nEntity.setLayoutX(itemHash.get(items[i].toString()).getPositionX());
            nEntity.setLayoutY(itemHash.get(items[i].toString()).getPositionY());
            
            //Changement de l'image du curseur
            Image image = new Image("spaceandpens/images/curseur/main.png");
            nEntity.setCursor(new ImageCursor(image));
            
            nEntity.setOnDragDetected(event -> {
                dragNdrop.handleDragDetected(event);
                
            });
            
            //On l'ajoute comme enfant au pane temp 
            temp.getChildren().add(nEntity);
        }
        
        Object[] npcs = npcList.toArray();
        for (int i = 0 ; i < npcs.length; i++) {
            
            HashMap<String, Npc> npcHash = world.getPlayer().getMapHero().getNpcs();
            
            ImageView nEntity = new ImageView(new Image("/spaceandpens/images/pnj/"+npcs[i]+".png")); 
            String nameNpc = npcs[i].toString();
            
            nEntity.setId(nameNpc);
            nEntity.setFitHeight(npcHash.get(npcs[i].toString()).getPositionHeight());
            nEntity.setFitWidth(npcHash.get(npcs[i].toString()).getPositionWidth());
            nEntity.setLayoutX(npcHash.get(npcs[i].toString()).getPositionX());
            nEntity.setLayoutY(npcHash.get(npcs[i].toString()).getPositionY());
            
            Image image = new Image("spaceandpens/images/curseur/bulle.png");
            nEntity.setCursor(new ImageCursor(image));
            
            nEntity.setOnMouseClicked(event -> {
                try {
                    this.openTalk(event, nameNpc);
                } catch (IOException ex) {
                    Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                }
                });
            
            temp.getChildren().add(nEntity);
            
        }
        
        Object[] ennemis = ennemisList.toArray();
        for (int i = 0 ; i < ennemis.length; i++) {
            HashMap<String, Enemy> ennemiHash = world.getPlayer().getMapHero().getEnemies();
            
            ImageView nEntity = new ImageView(new Image("/spaceandpens/images/ennemi/"+ennemis[i]+".png"));
            
            nEntity.setId(ennemis[i].toString());
            nEntity.setFitHeight(ennemiHash.get(ennemis[i].toString()).getPositionHeight());
            nEntity.setFitWidth(ennemiHash.get(ennemis[i].toString()).getPositionWidth());
            nEntity.setLayoutX(ennemiHash.get(ennemis[i].toString()).getPositionX());
            nEntity.setLayoutY(ennemiHash.get(ennemis[i].toString()).getPositionY());
            
            Image image = new Image("spaceandpens/images/curseur/epe.png");
            nEntity.setCursor(new ImageCursor(image));
                    
            temp.getChildren().add(nEntity);
            
            //On lui ajoute un évènement Mouseclique 
            nEntity.setOnMouseClicked(event -> {
                try {
                    this.openFight(event);
                    
                } catch (IOException ex) {
                    Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
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
    
   public Object[] actionGo(String direction) { //déplace le joueur sur le monde
		Map currentLoc = this.world.player.getMapHero();
		Player currentPlayer = this.world.player;


		switch (direction.toLowerCase()) {
			case "north" :
				if (currentLoc.isNorth() && (!(currentLoc.getNorth() instanceof LockedDoor) || !((LockedDoor) currentLoc.getNorth()).isLocked()))
				 {
					currentPlayer.move(currentLoc.getNorth().getDestination());
					return new Object[]{true, "You Enter : " + currentPlayer.getMapHero().getName()};
				 }
				else if (!currentLoc.isNorth())
				{
					return new Object[]{false, "Impossible to go north"};
				}
				else if (((LockedDoor) currentLoc.getNorth()).isLocked())
				{
                                        
					return new Object[]{false, "North door is locked"};
				}
				break;
			case "south" :
				if (currentLoc.isSouth() && (!(currentLoc.getSouth() instanceof LockedDoor) || !((LockedDoor) currentLoc.getSouth()).isLocked()) ||
				 ( currentLoc.getName().equals("Crash Site") &&  currentPlayer.hasItem("jack") ))
				{
					currentPlayer.move(currentLoc.getSouth().getDestination());
					return new Object[]{true, "You Enter : " + currentPlayer.getMapHero().getName()};
				}
				else if (!currentLoc.isSouth())
				{
					return new Object[]{false, "Impossible to go south"};
				}
				else if (((LockedDoor) currentLoc.getSouth()).isLocked())
				{
					return new Object[]{false, "South door is locked"};
				}
				break;
			case "east" :
				if (currentLoc.isEast() && (!(currentLoc.getEast() instanceof LockedDoor) || !((LockedDoor) currentLoc.getEast()).isLocked()))
				{
					currentPlayer.move(currentLoc.getEast().getDestination());
					return new Object[]{true, "You Enter : " + currentPlayer.getMapHero().getName()};
				}
				else if (!currentLoc.isEast())
				{
					return new Object[]{false, "Impossible to go east"};
				}
				else if (((LockedDoor) currentLoc.getEast()).isLocked())
				{
					return new Object[]{false, "East door is locked"};
				}
				break;
			case "west" :
				if (currentLoc.isWest() && (!(currentLoc.getWest() instanceof LockedDoor) || !((LockedDoor) currentLoc.getWest()).isLocked()))
				{
					currentPlayer.move(currentLoc.getWest().getDestination());
					return new Object[]{true, "You Enter : " + currentPlayer.getMapHero().getName()};
				}
				else if (!currentLoc.isWest())
				{
					return new Object[]{false, "Impossible to go west"};
				}
				else if (((LockedDoor) currentLoc.getWest()).isLocked())
				{
					return new Object[]{false, "West door is locked"};
				}
				break;
			default :
				return new Object[]{false, "You can't go there"};
		}
		return new Object[]{false, "You can't go there"};
	}
   
    @FXML
    private void goNorth(MouseEvent event) throws IOException
    {
        
        Object[] response = this.actionGo("north");
        if(((boolean) response[0] == false ) && ("End Portal" == this.world.getPlayer().getMapHero().getName() ))
        {
            this.openWindowEndPortal(event);
            LockedDoor northDoor = (LockedDoor) this.world.getPlayer().getMapHero().getNorth();
            if( northDoor.isLocked())
            {
                String description = "Now the door is unlock";
                this.setGameDescription(description);
            }
 
        }
        else{
            if((boolean) response[0]){
                
                this.setMapDescription();
            }
            this.setGameDescription((String) response[1]);
            this.actualiseVue();
        }    
        
    }

    @FXML
    private void goWest(MouseEvent event) throws IOException 
    {
        Object[] response = this.actionGo("west");
        if((boolean) response[0])
            this.setMapDescription();
        this.setGameDescription((String) response[1]);
        
        this.actualiseVue();
    }

    @FXML
    private void goEast(MouseEvent event) throws IOException 
    {
        Object[] response = this.actionGo("east");
        if((boolean) response[0])
            this.setMapDescription();
        this.setGameDescription((String) response[1]);
        this.actualiseVue();

    }

    @FXML
    private void goSouth(MouseEvent event) throws IOException 
    {
        Object[] response = this.actionGo("south");
        if((boolean) response[0])
            this.setMapDescription();
        this.setGameDescription((String) response[1]);
        
        this.actualiseVue();
    }

    @FXML
    public void openStats(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/Stats.fxml"));
        Parent root = loader.load();

        StatsController stats = loader.getController();
        stats.setStats(this.world.getPlayer());

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.getIcons().add(new Image("spaceandpens/images/spaceandpens.png"));
        stage.setTitle("Statistics and Inventory");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }   
    
    public void openShop(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/Shop.fxml"));
        Parent root = loader.load();

        ShopController shopController = loader.getController();
        shopController.setPlayerAndShop(this.world.getPlayer(), (Modeles.Shop) this.world.getPlayer().getMapHero().getShop().getDestination());

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.getIcons().add(new Image("spaceandpens/images/spaceandpens.png"));
        stage.setTitle("Shop");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinHeight(545);
        stage.setMinWidth(800);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.showAndWait();
    }
    
    
    
    public void openTalk(MouseEvent event, String nameNpc) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/Talk.fxml"));
        Parent root = loader.load();
        
        TalkController talkController = loader.getController();
        
        talkController.init(this.world.getPlayer(),nameNpc); 
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.getIcons().add(new Image("spaceandpens/images/spaceandpens.png"));
        stage.setTitle("Talk");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinHeight(545);
        stage.setMinWidth(800);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.showAndWait();    
    }
    
    public void openWindowEndPortal(MouseEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vues/endDoor.fxml"));
        Parent root = loader.load();
        
        EndDoorController endDoorController = loader.getController();
        
        endDoorController.initEndDoor(this.world.getPlayer().getInventory(), this.world.getPlayer()); 
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.getIcons().add(new Image("spaceandpens/images/spaceandpens.png"));
        stage.setTitle("End Door");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinHeight(532);
        stage.setMinWidth(802);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.showAndWait();    
    }  
    
    
    
    @FXML
    private void handleDragOver(DragEvent event) {
        dragNdrop.handleDragOver(event);
    }

    @FXML
    private void handleDrop(DragEvent event) throws FileNotFoundException {
        dragNdrop.handleDrop(event);
    }   

    @FXML
    private void lookDoorNorth(MouseEvent event) {
        Door door =  world.getPlayer().getMapHero().getNorth();        // On récupére la porte 
       
      if (door == null){                //Si elle est nul on change le curseur pour dire qu'il n'y a d'autre map
           Image image = new Image("spaceandpens/images/curseur/nop.png");
           north.setCursor(new ImageCursor(image));
      }
      else if(( door  instanceof LockedDoor )){      //On vérifie si cette porte est une porte fermée, verrouillé sur la map End Portal ( élément de l'histoire ), deverrouillé. Change le cureur suivant le choix
            if("End Portal" == this.world.getPlayer().getMapHero().getName() && ((LockedDoor) door).isLocked() )
            { 
                Image image = new Image("spaceandpens/images/curseur/oeil.png");
                north.setCursor(new ImageCursor(image));
            }
            else if (((LockedDoor) door).isLocked()){
                Image image = new Image("spaceandpens/images/curseur/cadenat.png");
                north.setCursor(new ImageCursor(image));
                }
            else{
                Image image = new Image("spaceandpens/images/curseur/haut.png");
                north.setCursor(new ImageCursor(image));
                }
      }
      else if ( door != null ){          // Si la porte existe on indique changement du curseur                                                                                                                                     
            Image image = new Image("spaceandpens/images/curseur/haut.png");
            north.setCursor(new ImageCursor(image));
        }
   }
        
        

    @FXML
    private void lookDoorWest(MouseEvent event) {
        
      Door door =  world.getPlayer().getMapHero().getWest();
       
      if (door == null){
           Image image = new Image("spaceandpens/images/curseur/nop.png");
           west.setCursor(new ImageCursor(image));
      }
      else if(( door  instanceof LockedDoor )){
            if (((LockedDoor) door).isLocked()){
                if( ((LockedDoor) door).isLocked()){
                    Image image = new Image("spaceandpens/images/curseur/cadenat.png");
                    west.setCursor(new ImageCursor(image));
                }
                else{
                    Image image = new Image("spaceandpens/images/curseur/gauche.png");
                    north.setCursor(new ImageCursor(image));
                    }
                }
      }
      else if ( door != null){
            Image image = new Image("spaceandpens/images/curseur/gauche.png");
            west.setCursor(new ImageCursor(image));
        }
    }

    @FXML
    private void lookDoorEast(MouseEvent event) {
        
      Door door =  world.getPlayer().getMapHero().getEast();
       
      if (door == null){
           Image image = new Image("spaceandpens/images/curseur/nop.png");
           east.setCursor(new ImageCursor(image));
      }
      else if(( door  instanceof LockedDoor )){
            if (((LockedDoor) door).isLocked()){
                if( ((LockedDoor) door).isLocked()){
                    Image image = new Image("spaceandpens/images/curseur/cadenat.png");
                    east.setCursor(new ImageCursor(image));
                }
                else{
                    Image image = new Image("spaceandpens/images/curseur/droite.png");
                    east.setCursor(new ImageCursor(image));
                    }
                }
      }
      else if ( door != null){
            Image image = new Image("spaceandpens/images/curseur/droite.png");
            east.setCursor(new ImageCursor(image));
        }
    }

    @FXML
    private void lookDoorSouth(MouseEvent event) {
        
      Door door =  world.getPlayer().getMapHero().getSouth();
       
      if (door == null){
           Image image = new Image("spaceandpens/images/curseur/nop.png");
           south.setCursor(new ImageCursor(image));
      }
      else if(( door  instanceof LockedDoor )){
            if (((LockedDoor) door).isLocked()){
                if( ((LockedDoor) door).isLocked()){
                    Image image = new Image("spaceandpens/images/curseur/cadenat.png");
                    south.setCursor(new ImageCursor(image));
                }
                else{
                    Image image = new Image("spaceandpens/images/curseur/gauche.png");
                    south.setCursor(new ImageCursor(image));
                    }
                }
      }      
      else if ( door != null){
            Image image = new Image("spaceandpens/images/curseur/bas.png");
            south.setCursor(new ImageCursor(image));
        }
    }

    @FXML
    private void openHelp(ActionEvent event) {
    }

    @FXML
    private void quit(ActionEvent event) throws IOException {
        endGame();
    }
}
