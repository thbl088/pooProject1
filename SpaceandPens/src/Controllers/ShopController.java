package Controllers;

import Modeles.Armor;
import Modeles.Item;
import Modeles.Player;
import Modeles.Shop;
import Modeles.Weapon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.ImageCursor;

public class ShopController implements Initializable {

    private Player player;
    private Shop shop;
    @FXML
    private ListView<String> shopInventory;
    @FXML
    private ListView<String> playerInventory;
    @FXML
    private TextField playerCash;
    @FXML
    private TextArea itemDescription;
    @FXML
    private Button sell;
    @FXML
    private Button buy;
    @FXML
    private TextField priceBuy;
    @FXML
    private TextField priceSell;
    @FXML
    private Button exit;
    @FXML
    private Label dialog;
    @FXML
    private ImageView itemView;
    @FXML
    private Button healthPotion;
    @FXML
    private Button attackPotion;
    @FXML
    private Button defPotion;
    @FXML
    private Button critPotion;
    @FXML
    private Label stats;
    @FXML
    private TextField statItem;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
    public void initCursorShop(){
        Image image = new Image("spaceandpens/images/curseur/bourse.png");
        Image imageSell = new Image("spaceandpens/images/curseur/billet.png");
        Image imageSortie = new Image("spaceandpens/images/curseur/doorOpen.png");
        Image imageMain = new Image("spaceandpens/images/curseur/main.png");
        
        shopInventory.setCursor(new ImageCursor(imageMain));
        playerInventory.setCursor(new ImageCursor(imageMain));
        buy.setCursor(new ImageCursor(image));
        defPotion.setCursor(new ImageCursor(image));
        critPotion.setCursor(new ImageCursor(image));
        attackPotion.setCursor(new ImageCursor(image));
        healthPotion.setCursor(new ImageCursor(image));
        sell.setCursor(new ImageCursor(imageSell));
        exit.setCursor(new ImageCursor(imageSortie));
    }

    //méthode appelée uniquement par le contrôleur du jeu
    //elle permet de fournir à ce contrôleur les références du joueur et du shop
    //elle initialise aussi les listes des inventaires du shop et du joueur
    public void setPlayerAndShop(Player player, Shop shop) {
        this.player = player;
        this.shop = shop;
        for (Map.Entry<String, Item> pair : this.shop.getItems().entrySet()) {
            this.shopInventory.getItems().add(pair.getKey());
        }
        for (Map.Entry<String, Item> pair : this.player.getInventory().entrySet()) {
            this.playerInventory.getItems().add(pair.getKey());
        }
        this.playerCash.setText(Integer.toString(this.player.getStatistics().getMoney()));
        this.itemDescription.setText(this.shopInventory.getSelectionModel().getSelectedItem());

        String[] dial = this.shop.getDescription().split(":");
        this.dialog.setText(dial[2]);
        
        this.initCursorShop();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    //ces deux méthodes actualisent les informations affichées pour l'objet sélectionné
    @FXML
    public void selectBuy(MouseEvent event) {
        if (this.shopInventory.getSelectionModel().getSelectedItem() != null) {
            String name = this.shopInventory.getSelectionModel().getSelectedItem();
            Item item = this.shop.getItems().get(name);
            this.itemDescription.setText(item.getDescription());
            this.priceBuy.setText(Integer.toString(item.getPrice()));
            this.priceSell.setText(Integer.toString(item.getPrice()));
            Image itemURL = new Image("/spaceandpens/images/objet/"+name+".png");
            this.itemView.setImage(itemURL);
            
            if(item instanceof Weapon){
                this.statItem.setText(((Weapon) item).getAttackBonus()+"");
                this.stats.setText("Damages");
            }
            else if(item instanceof Armor){
                this.statItem.setText(((Armor) item).getDefenseBonus()+"");
                this.stats.setText("Resistances");            
            }
            else{
                this.statItem.setText(item.getName());
                this.stats.setText("Item");
            }
        }
    }

    @FXML
    public void selectSell(MouseEvent event) {
        if (this.playerInventory.getSelectionModel().getSelectedItem() != null) {
            String name = this.playerInventory.getSelectionModel().getSelectedItem();
            Item item = this.player.getInventory().get(name);
            this.itemDescription.setText(item.getDescription());
            this.priceBuy.setText(Integer.toString(item.getPrice()));
            this.priceSell.setText(Integer.toString(item.getPrice()));
            Image itemURL = new Image("/spaceandpens/images/objet/"+name+".png");
            this.itemView.setImage(itemURL);
            
            if(item instanceof Weapon){
                this.statItem.setText(((Weapon) item).getAttackBonus()+"");
                this.stats.setText("Damages");
            }
            else if(item instanceof Armor){
                this.statItem.setText(((Armor) item).getDefenseBonus()+"");
                this.stats.setText("Resistances");            
            }
            else{
                this.statItem.setText(item.getName());
                this.stats.setText("Item");
            }
        }
    }

    // ces deux méthodes gèrent la transaction shop-player
    // elles vérifient si le joueur a suffisamment d'argent ou si l'objet à vendre n'est pas critique
    @FXML
    public void buyItem(ActionEvent event) {
        if (this.shopInventory.getSelectionModel().getSelectedItem() != null){
            String name = this.shopInventory.getSelectionModel().getSelectedItem();
            int itemRank = this.shopInventory.getSelectionModel().getSelectedIndex();
            Item item = this.shop.getItems().get(name);
            if (this.player.getStatistics().getMoney() - item.getPrice() >= 0) {

                this.player.addInventory(item);
                this.player.getStatistics().removeMoney(item.getPrice());

                this.shop.removeItem(item.getName());
                this.shopInventory.getItems().remove(itemRank);

                this.setPlayerCash();
                this.playerInventory.getItems().add(name);
            }
            else {
                this.noMoney();
            }
        }
    }

    @FXML
    public void sellItem(ActionEvent event) {
        if (this.playerInventory.getSelectionModel().getSelectedItem() != null){
            String name = this.playerInventory.getSelectionModel().getSelectedItem();
            int itemRank = this.playerInventory.getSelectionModel().getSelectedIndex();
            Item item = this.player.getInventory().get(name);
            
            if (item.getPrice() < 0){

                Image img = new Image("spaceandpens/images/spaceandpens.png");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(img);
                alert.setHeaderText(null);
                alert.setGraphic(null);
                alert.setTitle("Information");
                alert.setContentText("This item is too important to be sold");
                alert.showAndWait();
            }
            
           else if (item != this.player.getArmor() && item != this.player.getWeapon()) {
                this.player.removeInventory(item);
                this.player.getStatistics().addMoney(item.getPrice());

                this.shop.addItem(item);
                this.playerInventory.getItems().remove(itemRank);

                this.setPlayerCash();
                this.shopInventory.getItems().add(name);
            }
            else
            {
                Image img = new Image("spaceandpens/images/spaceandpens.png");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(img);
                alert.setHeaderText(null);
                alert.setGraphic(null);
                alert.setTitle("Information");
                alert.setContentText("You can't sell an equiped item");

                alert.showAndWait();
            }
        }
    }

    //actualise
    public void setPlayerCash() {
        this.playerCash.setText(Integer.toString(this.player.getStatistics().getMoney()));
    }

    @FXML
    public void exitShop(ActionEvent event) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void buyHealth(ActionEvent e) {
        if(this.player.getStatistics().getMoney() >= this.shop.getPotionCost())
        {
            this.player.addHealthPotion();
            this.player.getStatistics().removeMoney(this.shop.getPotionCost());
            this.setPlayerCash();
        }
        else {
            this.noMoney();
        }
    }

    @FXML
    public void buyAttack(ActionEvent e) {
        if(this.player.getStatistics().getMoney() >= this.shop.getPotionCost())
        {
            this.player.addAttackPotion();
            this.player.getStatistics().removeMoney(this.shop.getPotionCost());
            this.setPlayerCash();
        }
        else {
            this.noMoney();
        }
    }
    @FXML
    public void buyDefense(ActionEvent e) {
        if(this.player.getStatistics().getMoney() >= this.shop.getPotionCost())
        {
            this.player.addDefensePotion();
            this.player.getStatistics().removeMoney(this.shop.getPotionCost());
            this.setPlayerCash();
        }
        else {
            this.noMoney();
        }
    }
    @FXML
    public void buyCritical(ActionEvent e) {
        if(this.player.getStatistics().getMoney() >= this.shop.getPotionCost())
        {
            this.player.addCritPotion();
            this.player.getStatistics().removeMoney(this.shop.getPotionCost());
            this.setPlayerCash();
        }
        else {
            this.noMoney();
        }
    }

    public void noMoney() {
        Image img = new Image("spaceandpens/images/spaceandpens.png");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(img);
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.setTitle("MESSAGE FROM THE BANK");
        alert.setContentText("You don't have enough money to buy this item !");

        alert.showAndWait();
    }

}
