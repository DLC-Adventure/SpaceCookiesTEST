/*
 * SPACE COOKIES by DLC © 2020
 */
package it.uniba.dlc.type;

import java.util.ArrayList;
import java.util.List;

/**
 * Metodi dell'inventario.
 */
public class Inventory {

    private List<Item> list = new ArrayList<>(); // Lista degli oggetti nell'inventario

    // Restituisci oggetti nell'inventario
    public List<Item> getList() {
	return list;
    }

    // Imposta oggetti nell'inventario
    public void setList(List<Item> list) {
	this.list = list;
    }

    // Aggiungi oggetto nell'inventario
    public void add(Item item) {
	list.add(item);
    }

    // Rimuovi oggetto dall'inventario
    public void remove(Item item) {
	list.remove(item);
    }

}
