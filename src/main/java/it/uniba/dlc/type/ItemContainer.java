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

    // Id
    public ItemContainer(int id) {
	super(id);
    }

    // Id + nome
    public ItemContainer(int id, String name) {
	super(id, name);
    }

    // Id + nome + descrizione
    public ItemContainer(int id, String name, String description) {
	super(id, name, description);
    }

    // Id + nome + descrizione + alias
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

    // Aggiunta e rimozione dell'oggetto dal contenitore
    public void add(Item item) {
	list.add(item);
    }

    public void remove(Item item) {
	list.remove(item);
    }

} // fine della classe principale "ItemContainer"
