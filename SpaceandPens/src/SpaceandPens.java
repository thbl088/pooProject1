/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Modeles.WorldIHM;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

/**
 *
 * @author charlie
 */
public class SpaceandPens extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Vues/menu.fxml"));
        
        Scene scene = new Scene(root);
        installIcons(new Image("spaceandpens/images/spaceandpens.png"));
        stage.setScene(scene);
        stage.show();
    }

    public static void installIcons(Image img) {
        Window.getWindows().addListener((ListChangeListener<Window>) collection -> {
            while (collection.next()) {
                for (Window window : collection.getAddedSubList()) {
                    if (window instanceof Stage) {
                        ((Stage) window).getIcons().setAll(img);
                    }
                }
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
