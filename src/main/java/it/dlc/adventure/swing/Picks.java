/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.dlc.adventure.swing;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Ego
 */
public class Picks {

    public void picks() {
        JFrame Picks = new JFrame();
        Picks.setBounds(100, 200, 800, 800);
        Picks.setVisible(true);
        Picks.add(new JLabel(new ImageIcon("img/Picks.png")));
        Picks.pack();
    }
}
