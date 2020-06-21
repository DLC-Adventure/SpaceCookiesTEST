/*
 * SPACE COOKIES by DLC © 2020
 */
package it.uniba.dlc.type;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Metodi degli oggetti di tipo contenitore.
 */
public class ItemContainer extends Item {

    private List<Item> list = new ArrayList<>(); // Lista degli oggetti contenitore

    // Oggetto contenitore
    public ItemContainer(int id) {
	super(id);
    }

    public ItemContainer(int id, String name) {
	super(id, name);
    }

    public ItemContainer(int id, String name, String description) {
	super(id, name, description);
    }

    public ItemContainer(int id, String name, String description, Set<String> alias) {
	super(id, name, description, alias);
    }

    // Lista degli oggetti contenitore
    public List<Item> getList() {
	return list;
    }

    public void setList(List<Item> list) {
	this.list = list;
    }

    // Aggiunta e rimozione dalla lista
    public void add(Item o) {
	list.add(o);
    }

    public void remove(Item o) {
	list.remove(o);
    }

} // fine della classe principale "ItemContainer"
