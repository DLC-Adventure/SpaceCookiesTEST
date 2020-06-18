/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.dlc.adventure;

import it.uniba.dlc.parser.ParserOutput;
import it.uniba.dlc.type.Item;
import it.uniba.dlc.type.Command;
import it.uniba.dlc.type.Room;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pierpaolo
 */
public abstract class GameDescription {

    private final List<Room> rooms = new ArrayList<>(); // Lista contenente le stanze

    private final List<Command> commands = new ArrayList<>(); // Lista contenente i comandi

    private final List<Item> inventory = new ArrayList<>(); // Lista degli oggetti nell'inventario

    private Room currentRoom; // Stanza attuale
    
    public List<Room> getRooms() {
        return rooms;
    }

    public List<Command> getCommands() {
        return commands;
    }
    
    public List<Item> getInventory() {
        return inventory;
    }

    // Stanza attuale
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public abstract void init() throws Exception;

    public abstract void nextMove(ParserOutput p, PrintStream out);

}
