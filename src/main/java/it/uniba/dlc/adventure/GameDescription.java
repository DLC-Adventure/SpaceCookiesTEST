/*
 * SPACE COOKIES by DLC © 2020
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
 * Metodi che gestiscono il gioco.
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
