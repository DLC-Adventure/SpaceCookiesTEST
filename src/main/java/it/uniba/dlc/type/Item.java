/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.dlc.type;

import java.util.Set;

/**
 *
 * @author DLC
 */
public class Item {

    private final int id;

    private String name;

    private String description;

    private Set<String> alias;

    private boolean openable = false;

    private boolean pickupable = true;

    private boolean open = false;

    public Item(int id) {
	this.id = id;
    }

    public Item(int id, String name) {
	this.id = id;
	this.name = name;
    }

    public Item(int id, String name, String description) {
	this.id = id;
	this.name = name;
	this.description = description;
    }

    public Item(int id, String name, String description, Set<String> alias) {
	this.id = id;
	this.name = name;
	this.description = description;
	this.alias = alias;
    }

    public int getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public Set<String> getAlias() {
	return alias;
    }

    public void setAlias(Set<String> alias) {
	this.alias = alias;
    }

    public boolean isOpenable() {
	return openable;
    }

    public void setOpenable(boolean openable) {
	this.openable = openable;
    }

    public boolean isPickupable() {

	return pickupable;
    }

    public void setPickupable(boolean pickupable) {
	this.pickupable = pickupable;
    }

    public boolean isOpen() {
	return open;
    }

    public void setOpen(boolean open) {
	this.open = open;
    }

    @Override
    public int hashCode() {
	int hash = 3;
	hash = 53 * hash + this.id;
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
	final Item other = (Item) obj;
	if (this.id != other.id) {
	    return false;
	}
	return true;
    }

}
