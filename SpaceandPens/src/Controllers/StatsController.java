package Controllers;

import Modeles.*;
import com.sun.deploy.panel.TextFieldProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class StatsController implements Initializable {

    private Player player;
    private static final String RED_BAR    = "red-bar";
    private static final String YELLOW_BAR = "yellow-bar";
    private static final String ORANGE_BAR = "orange-bar";
    private static final String GREEN_BAR  = "green-bar";
    private static final String[] barColorStyleClasses = { RED_BAR, ORANGE_BAR, YELLOW_BAR, GREEN_BAR };


    @FXML
    private ProgressBar healthBar;
    @FXML
    private Label attack;
    @FXML
    private Label defense;
    @FXML
    private Label critical;
    @FXML
    private Label money;
    @FXML
    private ListView<String> inventoryList;
    @FXML
    private TextArea description;
    @FXML
    private TextField armorName;
    @FXML
    private TextField weaponName;
    @FXML
    private ImageView weaponIcon;
    @FXML
    private ImageView armorIcon;

    @FXML
    private TextField hpPotion;
    @FXML
    private TextField attPotion;
    @FXML
    private TextField defPotion;
    @FXML
    private TextField critPotion;
    @FXML
    private TextField itemType;
    @FXML
    private Button weaponUnequip;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        healthBar.progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double progress = newValue == null ? 0 : newValue.doubleValue();
                if (progress < 0.25) {
                    healthBar.setStyle("-fx-accent : red;");
                } else if (progress < 0.5) {
                    healthBar.setStyle("-fx-accent : orange;");
                } else if (progress < 0.75) {
                    healthBar.setStyle("-fx-accent : yellow;");
                } else {
                    healthBar.setStyle("-fx-accent : green;");
                }
            }
        });

    }


    public void setPlayer(Player player) {
        this.player = player;
        reInitialize();
        initList();
    }

    public void initList() {
        for (Map.Entry<String, Item> pair : this.player.getInventory().entrySet()) {
            String item = pair.getKey();
            this.inventoryList.getItems().add(item);
        }
    }
    public void reInitialize() {
        Statistics stats = this.player.getStatistics();

        this.healthBar.setProgress( (double)stats.getHealth() / (double)stats.getMaxHealth());
        this.attack.setText("Attack : " + stats.getAttack());
        this.defense.setText("Defense : " + stats.getDefense());
        this.critical.setText("Critical : " + stats.getCritical());
        this.money.setText("Money : " + stats.getMoney());

        if (this.player.getWeapon() != null) {
            String imgWeapon = "spaceandpens/images/objet/" + this.player.getWeapon().getName() + ".png";
            this.weaponIcon.setImage(new Image(imgWeapon));
            this.weaponName.setText(this.player.getWeapon().getName());
        }
        else {
            this.weaponIcon.setImage(null);
            this.weaponName.setText(null);
        }

        if (this.player.getArmor() != null) {
            String imgArmor = "spaceandpens/images/objet/" + this.player.getArmor().getName() + ".png";
            this.armorIcon.setImage(new Image(imgArmor));
            this.armorName.setText(this.player.getArmor().getName());
        }
        else {
            this.armorIcon.setImage(null);
            this.armorName.setText(null);
        }

        this.hpPotion.setText(Integer.toString(this.player.getHealthPotion()));
        this.attPotion.setText(Integer.toString(this.player.getAttackPotion()));
        this.defPotion.setText(Integer.toString(this.player.getDefensePotion()));
        this.critPotion.setText(Integer.toString(this.player.getCritPotion()));
    }

    @FXML
    public void weaponUnequip(ActionEvent e) {
        this.player.removeWeapon(this.player.getWeapon());
        reInitialize();
    }

    @FXML
    public void armorUnequip(ActionEvent e) {
        this.player.removeArmor(this.player.getArmor());
        reInitialize();
    }

    @FXML
    public void equipItem(ActionEvent e) {
        if (this.inventoryList.getSelectionModel().getSelectedItem() != null) {
            String selection = this.inventoryList.getSelectionModel().getSelectedItem();
            Item item = this.player.getItem(selection);

            if (item instanceof Weapon && this.player.getWeapon() != item) {
                this.player.equiWeapon((Weapon) item);
            }
            else if (item instanceof Armor && this.player.getArmor() != item) {
                this.player.equiArmor((Armor) item);
            }
        }
        this.reInitialize();
    }

    @FXML
    public void updateDesc(MouseEvent e){
        if (this.inventoryList.getSelectionModel().getSelectedItem() != null) {
            String selection = this.inventoryList.getSelectionModel().getSelectedItem();
            Item item = this.player.getItem(selection);
            this.description.setText(item.getDescription());

            if (item instanceof Weapon)
                this.itemType.setText("Weapon");
            else if (item instanceof Armor)
                this.itemType.setText("Armor");
        }
    }

    @FXML
    public void useHealth(ActionEvent e) {
        if (this.player.getHealthPotion() > 0 && this.player.getHealth() != this.player.getStatistics().getMaxHealth())
            this.player.useHealthPotion();
        this.reInitialize();
    }

    @FXML
    public void useDefense(ActionEvent e) {
        if (this.player.getDefensePotion() > 0)
            this.player.useDefensePotion();
        this.reInitialize();
    }

    @FXML
    public void useAttack(ActionEvent e) {
        if (this.player.getAttackPotion() > 0)
            this.player.useAttackPotion();
        this.reInitialize();
    }

    @FXML
    public void useCritical(ActionEvent e) {
        if (this.player.getCritPotion() > 0)
            this.player.useCritPotion();
        this.reInitialize();
    }
}
