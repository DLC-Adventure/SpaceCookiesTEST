/*
 * SPACE COOKIES by DLC © 2020
 */
package it.dlc.adventure.type;

import java.util.ArrayList;
import java.util.List;

/**
 * Metodi dell'inventario.
 */
public class Inventory {

    private List<Item> list = new ArrayList<>(); // Lista degli oggetti nell'inventario

    // Lista degli oggetti nell'inventario
    public List<Item> getList() {
	return list;
    }

    public void setList(List<Item> list) {
	this.list = list;
    }

    // Aggiunta e rimozione dell'oggetto dall'inventario
    public void add(Item item) {
	list.add(item);
    }

    public void remove(Item item) {
	list.remove(item);
    }

} // fine della classe principale "Inventory"
