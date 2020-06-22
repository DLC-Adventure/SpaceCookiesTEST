/*
 * SPACE COOKIES by DLC © 2020
 */
package it.uniba.dlc.type;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Metodi degli oggetti.
 */
public class Item {

    private final int id; // Id dell'oggetto
    private String name; // Nome dell'oggetto
    private String description; // Descrizione dell'oggetto
    private Set<String> alias; // Alias dell'oggetto

    private boolean openable = false; // Se si può aprire
    private boolean pickupable = true; // Se si può prendere
    private boolean pushable = false; // Se si può premere
    private boolean usable = false; // Se si può utilizzare
    
    private boolean open = false; // Se è aperto
    private boolean push = false; // Se è premuto

    // Id
    public Item(int id) {
	this.id = id;
    }

    // Id + nome
    public Item(int id, String name) {
	this.id = id;
	this.name = name;
    }

    // Id + nome + descrizione
    public Item(int id, String name, String description) {
	this.id = id;
	this.name = name;
	this.description = description;
    }

    // Id + nome + descrizione + alias
    public Item(int id, String name, String description, Set<String> alias) {
	this.id = id;
	this.name = name;
	this.description = description;
	this.alias = alias;
    }

    // Id dell'oggetto
    public int getId() {
	return id;
    }

    // Nome dell'oggetto
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    // Descrizione dell'oggetto
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    // Alias dell'oggetto
    public Set<String> getAlias() {
	return alias;
    }

    public void setAlias(Set<String> alias) {
	this.alias = alias;
    }

    public void setAlias(String[] alias) {
	this.alias = new HashSet<>(Arrays.asList(alias));
    }

    // Se si può aprire (oggetto contenitore)
    public boolean isOpenable() {
	return openable;
    }

    public void setOpenable(boolean openable) {
	this.openable = openable;
    }

    // Se si può prendere (oggetto inventario)
    public boolean isPickupable() {
	return pickupable;
    }

    public void setPickupable(boolean pickupable) {
	this.pickupable = pickupable;
    }

    // Se si può premere
    public boolean isPushable() {
	return pushable;
    }

    public void setPushable(boolean pushable) {
	this.pushable = pushable;
    }
    
    // Se è aperto
    public boolean isOpen() {
	return open;
    }

    public void setOpen(boolean open) {
	this.open = open;
    }

    // Se è premuto
    public boolean isPush() {
	return push;
    }

    public void setPush(boolean push) {
	this.push = push;
    }
    
    // Se si può utilizzare
    public boolean isUsable() {
	return usable;
    }

    public void setUsable(boolean usable) {
	this.usable = usable;
    }

    // EQUALS + HASH CODE
    @Override
    public int hashCode() {
	int hash = 7;
	hash = 37 * hash + this.id;
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

} // fine della classe principale "Item"
