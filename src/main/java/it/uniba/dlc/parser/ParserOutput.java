/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.dlc.parser;

import it.uniba.dlc.type.Item;
import it.uniba.dlc.type.Command;

/**
 *
 * @author pierpaolo
 */
public class ParserOutput {

    private Command command; // Comando in input
    private Item item; // Oggetto in input
    private Item inventoryItem; // Oggetto inventario in input

    public ParserOutput(Command command, Item item) {
	this.command = command;
	this.item = item;
    }

    public ParserOutput(Command command, Item item, Item inventoryItem) {
	this.command = command;
	this.item = item;
	this.inventoryItem = inventoryItem;
    }

    public Command getCommand() {
	return command;
    }

    public void setCommand(Command command) {
	this.command = command;
    }

    public Item getItem() {
	return item;
    }

    public void setItem(Item item) {
	this.item = item;
    }

    public Item getInventoryItem() {
	return inventoryItem;
    }

    public void setinventoryItem(Item inventoryItem) {
	this.inventoryItem = inventoryItem;
    }

}
