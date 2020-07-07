/*
 * SPACE COOKIES by DLC © 2020
 */
package it.dlc.adventure;

import it.dlc.adventure.parser.ParserOutput;
import it.dlc.adventure.type.Item;
import it.dlc.adventure.type.Command;
import it.dlc.adventure.type.Room;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;

/**
 * Metodi che gestiscono il gioco.
 */
public abstract class GameDescription implements Serializable {

    private final List<Room> rooms = new ArrayList<>(); // Lista contenente le stanze
    private final List<Command> commands = new ArrayList<>(); // Lista contenente i comandi
    private final List<Item> inventory = new ArrayList<>(); // Lista degli oggetti nell'inventario

    private Room room; // Stanza richiesta
    private Room currentRoom; // Stanza attuale

    // Restituisci l'elenco delle stanze
    public List<Room> getRooms() {
	return rooms;
    }

    // Restituisci l'elenco dei comandi
    public List<Command> getCommands() {
	return commands;
    }

    // Restituisci l'elenco degli oggetti nell'inventario
    public List<Item> getInventory() {
	return inventory;
    }

    // Restituisci la stanza richiesta
    public Room getRoom() {
	return room;
    }

    // Restituisci la stanza attuale
    public Room getCurrentRoom() {
	return currentRoom;
    }

    // Imposta la stanza attuale
    public void setCurrentRoom(Room currentRoom) {
	this.currentRoom = currentRoom;
    }

    public abstract void intro(); // Introduzione del gioco
    public abstract void help(); // Elenco dei comandi principali

    public abstract void init() throws Exception; // Inizializzazione del gioco
    public abstract void nextMove(ParserOutput p, PrintStream out); // Prossima mossa
    
    public abstract void save() throws FileNotFoundException, IOException, ClassNotFoundException; // Salvataggio della partita
    public abstract GameDescription load() throws FileNotFoundException, IOException, ClassNotFoundException; // Caricamento della partita

} // fine della classe principale "GameDescription"
