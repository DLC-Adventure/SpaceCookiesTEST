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
public class ElementTable {

    public void ElementTable() {
        JFrame ElementTable = new JFrame();
        ElementTable.setBounds(100, 200, 800, 800);
        ElementTable.setVisible(true);
        ElementTable.add(new JLabel(new ImageIcon("img/ElementTable.png")));
        ElementTable.setTitle("Muro");
        ElementTable.setResizable(false);
        ElementTable.setAlwaysOnTop(true);
        ElementTable.pack();

    }
}
