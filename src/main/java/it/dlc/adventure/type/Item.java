/*
 * SPACE COOKIES by DLC © 2020
 */
package it.dlc.adventure.type;

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
    private boolean open = false; // Se è aperto
    private boolean takeable = true; // Se si può prendere
    private boolean usable = false; // Se si può utilizzare
    private boolean pushable = false; // Se si può premere
    private boolean pullable = false; //Se si può tirare
    private boolean turnable = false; //Se si può accendere-spegnere
    private boolean turned = false; //Se è acceso

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
    
    // Se è aperto (oggetto contenitore)
    public boolean isOpen() {
	return open;
    }

    public void setOpen(boolean open) {
	this.open = open;
    }

    // Se si può prendere (oggetto inventario)
    public boolean isTakeable() {
	return takeable;
    }

    public void setTakeable(boolean takeable) {
	this.takeable = takeable;
    }
    
    // Se si può utilizzare (oggetto/oggetto inventario)
    public boolean isUsable() {
	return usable;
    }

    public void setUsable(boolean usable) {
	this.usable = usable;
    }

    // Se si può premere
    public boolean isPushable() {
	return pushable;
    }

    public void setPushable(boolean pushable) {
	this.pushable = pushable;
    }
    
    // Se si può tirare
    public boolean isPullable() {
	return pullable;
    }

    public void setPullable(boolean pullable) {
	this.pullable = pullable;
    }
    
    // Se si può accendere-spegnere
    public boolean isTurnable() {
	return turnable;
    }

    public void setTurnable(boolean turnable) {
	this.turnable = turnable;
    }
    
    // Se è acceso
    public boolean isTurned() {
	return turned;
    }

    public void setTurned(boolean turned) {
	this.turned = turned;
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
