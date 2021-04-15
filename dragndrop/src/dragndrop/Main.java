/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragndrop;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Rectangle;
import java.util.Collection;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author charlie
 */
public class Main extends Application { 
  
    @Override 
    public void start(Stage primaryStage) { 
        final Rectangle rectangle = new Rectangle(50, 50, 150, 100); 
        rectangle.setFill(Color.RED); 
        rectangle.setOnDragDetected(mouseEvent -> { 
            System.out.println("DnD detecté."); 
            final Dragboard dragBroard = rectangle.startDragAndDrop(TransferMode.COPY); 
            // Remlissage du contenu. 
            final ClipboardContent content = new ClipboardContent(); 
            // Exporter en tant que texte. 
            content.putString("Un rectangle rouge."); 
            // Exporter en tant que couleur ARGB. 
            DataFormat paintFormat = DataFormat.lookupMimeType(Paint.class.getName()); 
            paintFormat = (paintFormat == null) ? new DataFormat(Paint.class.getName()) : paintFormat; 
            final Color color = (Color) rectangle.getFill(); 
            final int red = (int) (255 * color.getRed()); 
            final int green = (int) (255 * color.getGreen()); 
            final int blue = (int) (255 * color.getBlue()); 
            final int alpha = (int) (255 * color.getOpacity()); 
            final int argb = alpha << 24 | red << 16 | green << 8 | blue; 
            content.put(paintFormat, argb); 
            // Exporter en tant qu'image.        
            final WritableImage capture = rectangle.snapshot(null, null); 
            content.putImage(capture); 
            // 
            dragBroard.setContent(content); 
            mouseEvent.consume();         
        }); 
        final Pane root = new Pane(); 
        root.getChildren().setAll((Collection<? extends Node>) rectangle); 
        final Scene scene = new Scene(root, 600, 600); 
        primaryStage.setTitle("Test de DnD"); 
        primaryStage.setScene(scene); 
        primaryStage.show(); 
    } 
  
    public static void main(String[] args) { 
        launch(args); 
    } 
}
