package Controllers;

import Modeles.Item;
import Modeles.Player;
import Modeles.Shop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

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
    private Tab buyTab;
    @FXML
    private Tab sellTab;
    @FXML
    private TextField priceBuy;
    @FXML
    private TextField priceSell;
    @FXML
    private Button exit;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setPlayerAndShop(Player player, Shop shop) {
        this.player = player;
        this.shop = shop;
        for (Map.Entry<String, Item> pair : this.shop.getItems().entrySet()) {
            this.shopInventory.getItems().add(pair.getKey().replace('_', ' '));
        }
        for (Map.Entry<String, Item> pair : this.player.getInventory().entrySet()) {
            this.playerInventory.getItems().add(pair.getKey());
        }
        this.playerCash.setText(Integer.toString(this.player.getStatistics().getMoney()));
        this.itemDescription.setText(this.shopInventory.getSelectionModel().getSelectedItem());
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @FXML
    public void selectBuy(MouseEvent event) {
        if (this.shopInventory.getSelectionModel().getSelectedItem() != null) {
            String name = this.shopInventory.getSelectionModel().getSelectedItem().replace(' ', '_');
            Item item = this.shop.getItems().get(name);
            this.itemDescription.setText(item.getDescription());
            this.priceBuy.setText(Integer.toString(item.getPrice()));
            this.priceSell.setText(Integer.toString(item.getPrice()));
        }
    }

    @FXML
    public void selectSell(MouseEvent event) {
        if (this.playerInventory.getSelectionModel().getSelectedItem() != null) {
            String name = this.playerInventory.getSelectionModel().getSelectedItem().replace(' ', '_');
            Item item = this.player.getInventory().get(name);
            this.itemDescription.setText(item.getDescription());
            this.priceBuy.setText(Integer.toString(item.getPrice()));
            this.priceSell.setText(Integer.toString(item.getPrice()));
        }
    }

    @FXML
    public void buyItem(ActionEvent event) {
        if (this.shopInventory.getSelectionModel().getSelectedItem() != null){
            String name = this.shopInventory.getSelectionModel().getSelectedItem().replace(' ', '_');
            int itemRank = this.shopInventory.getSelectionModel().getSelectedIndex();
            Item item = this.shop.getItems().get(name);
            if (this.player.getStatistics().getMoney() - item.getPrice() >= 0) {

                this.player.addInventory(item);
                this.player.getStatistics().removeMoney(item.getPrice());

                this.shop.removeItem(item.getName());
                this.shopInventory.getItems().remove(itemRank);

                this.setPlayerCash();
                this.playerInventory.getItems().add(name.replace('_', ' '));
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setGraphic(null);
                alert.setTitle("MESSAGE DU BANQUIER");
                alert.setContentText("You don't have enough money to buy this item !");

                alert.showAndWait();
            }
        }
    }

    @FXML
    public void sellItem(ActionEvent event) {
        if (this.playerInventory.getSelectionModel().getSelectedItem() != null){
            String name = this.playerInventory.getSelectionModel().getSelectedItem().replace(' ', '_');
            int itemRank = this.playerInventory.getSelectionModel().getSelectedIndex();
            Item item = this.player.getInventory().get(name);
            this.player.removeInventory(item);
            this.player.getStatistics().addMoney(item.getPrice());

            this.shop.addItem(item);
            this.playerInventory.getItems().remove(itemRank);

            this.setPlayerCash();
            this.shopInventory.getItems().add(name.replace('_', ' '));
        }
    }

    public void setPlayerCash() {
        this.playerCash.setText(Integer.toString(this.player.getStatistics().getMoney()));
    }

    @FXML
    public void exitShop(ActionEvent event) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }
}