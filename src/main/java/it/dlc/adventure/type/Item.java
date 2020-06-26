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
    private boolean pickupable = false; // Se si può prendere
    private boolean usable = false; // Se si può utilizzare
    private boolean pushable = false; // Se si può premere
    private boolean pullable = false; // Se si può tirare
    private boolean turnable = false; // Se si può accendere
    
    private boolean walkable = false; // Se è attraversabile
    private boolean drinkable = false; // Se è bevibile
    private boolean cleanable = false; // Se è pulibile
    private boolean playable = false; // Se è giocabile
    private boolean readable = false; // Se è leggibile
    private boolean kickable = false; // Se è cacciabile

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
    public boolean isPickupable() {
	return pickupable;
    }

    public void setPickupable(boolean pickupable) {
	this.pickupable = pickupable;
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
    
    // Se si può accendere
    public boolean isTurnable() {
	return turnable;
    }

    public void setTurnable(boolean turnable) {
	this.turnable = turnable;
    }
    
    // Se è attraversabile
    public boolean isWalkable() {
	return walkable;
    }

    public void setWalkable(boolean walkable) {
	this.walkable = walkable;
    }
    
    // Se è bevibile
    public boolean isDrinkable() {
	return drinkable;
    }

    public void setDrinkable(boolean drinkable) {
	this.drinkable = drinkable;
    }
    
    // Se è pulibile
    public boolean isCleanable() {
	return cleanable;
    }

    public void setCleanable(boolean cleanable) {
	this.cleanable = cleanable;
    }
    
    // Se è giocabile
    public boolean isPlayable() {
	return playable;
    }

    public void setPlayable(boolean playable) {
	this.playable = playable;
    }
    
    // Se è leggibile
    public boolean isReadable() {
	return readable;
    }

    public void setReadable(boolean readable) {
	this.readable = readable;
    }
    
    // Se è cacciabile
    public boolean isKickable() {
	return kickable;
    }
    
    public void setKickable(boolean kickable) {
	this.kickable = kickable;
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
