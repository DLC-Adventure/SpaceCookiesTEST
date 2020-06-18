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
 * @author pierpaolo
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
