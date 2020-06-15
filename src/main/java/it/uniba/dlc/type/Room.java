/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.dlc.type;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Donatello
 */
public class Room {

    private final int id;

    private String name;

    private String description;

    private boolean lock = false;

    private Room south = null;

    private Room north = null;

    private Room east = null;

    private Room west = null;

    private final List<Item> items = new ArrayList<>();

    public Room(int id) {
	this.id = id;
    }

    public Room(int id, String name) {
	this.id = id;
	this.name = name;
    }

    public Room(int id, String name, String description) {
	this.id = id;
	this.name = name;
	this.description = description;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Room getSouth() {
	return south;
    }

    public void setSouth(Room south) {
	this.south = south;
    }

    public Room getNorth() {
	return north;
    }

    public void setNorth(Room north) {
	this.north = north;
    }

    public Room getEast() {
	return east;
    }

    public void setEast(Room east) {
	this.east = east;
    }

    public Room getWest() {
	return west;
    }

    public void setWest(Room west) {
	this.west = west;
    }

    public boolean isLock() {
	return lock;
    }

    public void setLock(boolean lock) {
	this.lock = lock;
    }

    @Override
    public int hashCode() {
	int hash = 7;
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
    
    

}
