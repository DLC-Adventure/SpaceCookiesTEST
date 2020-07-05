/*
 * SPACE COOKIES by DLC © 2020
 */
package it.dlc.adventure.swing;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Immagine swing della scrivania con i plettri colorati.
 */
public class Picks {

    public void picks() {
        JFrame Picks = new JFrame();
        Picks.setBounds(100, 200, 800, 800);
        Picks.setVisible(true);
        Picks.add(new JLabel(new ImageIcon("media/Picks.png")));
        Picks.setTitle("Scrivania");
        Picks.setResizable(false);
        Picks.setAlwaysOnTop(true);
        Picks.pack();
    }
    
}
