/*
 * SPACE COOKIES by DLC © 2020
 */
package it.dlc.adventure.parser;

import it.dlc.adventure.type.Item;
import it.dlc.adventure.type.Command;

/**
 * Metodi che elaborano l'output del parser.
 */
public class ParserOutput {

    private Command command; // Comando in input
    private Item item; // Oggetto in input
    private Item inventoryItem; // Oggetto inventario in input

    // Comando
    public ParserOutput(Command command) {
	this.command = command;
    }
    
    // Comando + oggetto
    public ParserOutput(Command command, Item item) {
	this.command = command;
	this.item = item;
    }

    // Comando + oggetto + oggetto inventario
    public ParserOutput(Command command, Item item, Item inventoryItem) {
	this.command = command;
	this.item = item;
	this.inventoryItem = inventoryItem;
    }

    // Comando
    public Command getCommand() {
	return command;
    }

    public void setCommand(Command command) {
	this.command = command;
    }

    // Oggetto
    public Item getItem() {
	return item;
    }

    public void setItem(Item item) {
	this.item = item;
    }

    // Oggetto inventario
    public Item getInventoryItem() {
	return inventoryItem;
    }

    public void setInventoryItem(Item inventoryItem) {
	this.inventoryItem = inventoryItem;
    }

} // fine della classe principale "ParserOutput"
