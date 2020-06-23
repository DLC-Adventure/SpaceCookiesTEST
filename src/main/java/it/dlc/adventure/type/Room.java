/*
 * SPACE COOKIES by DLC © 2020
 */
package it.dlc.adventure.type;

import java.util.ArrayList;
import java.util.List;

/**
 * Metodi delle stanze.
 */
public class Room {

    private final int id; // Id della stanza
    private String name; // Nome della stanza
    private String description; // Descrizione della stanza
    private String look; // Contenuto del comando "OSSERVA"

    private boolean accessible = true; // La stanza è accessibile
    private boolean visible = true; // La stanza è visibile (ha le luci accese)

    private Room north = null;
    private Room south = null;
    private Room west = null;
    private Room east = null;

    private final List<Item> list = new ArrayList<>(); // Oggetti presenti nella stanza

    // Id
    public Room(int id) {
	this.id = id;
    }

    // Id + nome + descrizione
    public Room(int id, String name, String description) {
	this.id = id;
	this.name = name;
	this.description = description;
    }

    // Nome della stanza
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    // Descrizione della stanza
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    // Comando "OSSERVA"
    public String getLook() {
	return look;
    }

    public void setLook(String look) {
	this.look = look;
    }

    // Se accessibile
    public boolean isAccessible() {
	return accessible;
    }

    public void setAccessible(boolean accessible) {
	this.accessible = accessible;
    }
    
    // Se visibile (luci accese)
    public boolean isVisible() {
	return visible;
    }

    public void setVisible(boolean visible) {
	this.visible = visible;
    }

    // Nord
    public Room getNorth() {
	return north;
    }

    public void setNorth(Room north) {
	this.north = north;
    }

    // Sud
    public Room getSouth() {
	return south;
    }

    public void setSouth(Room south) {
	this.south = south;
    }

    // Ovest
    public Room getWest() {
	return west;
    }

    public void setWest(Room west) {
	this.west = west;
    }

    // Est
    public Room getEast() {
	return east;
    }

    public void setEast(Room east) {
	this.east = east;
    }

    // Oggetti presenti nella stanza
    public List<Item> getItems() {
	return list;
    }

    // EQUALS + HASH CODE
    @Override
    public int hashCode() {
	int hash = 3;
	hash = 83 * hash + this.id;
	return hash;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final Room other = (Room) obj;
	if (this.id != other.id) {
	    return false;
	}
	return true;
    }

} // fine della classe principale "Room"
