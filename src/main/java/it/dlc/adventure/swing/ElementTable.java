/*
 * SPACE COOKIES by DLC © 2020
 */
package it.dlc.adventure.swing;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Immagine swing con la Tavola periodica degli elementi.
 */
public class ElementTable {

    public void ElementTable() {
	JFrame ElementTable = new JFrame();
	ElementTable.setBounds(100, 200, 800, 800);
	ElementTable.setVisible(true);
	ElementTable.add(new JLabel(new ImageIcon("src/main/resources/ElementTable.png")));
	ElementTable.setTitle("Muro");
	ElementTable.setResizable(false);
	ElementTable.setAlwaysOnTop(true);
	ElementTable.pack();

    }
}
