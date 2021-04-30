/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import javafx.scene.input.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author charlie
 */
public class EcouteurShop extends JPanel {
    public EcouteurShop() {
        setPreferredSize(new Dimension(306, 327));
        addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e){
                    
                }         
            }
            );
    }
    
}
