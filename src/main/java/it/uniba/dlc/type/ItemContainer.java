/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.dlc.type;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author DLC
 */
public class ItemContainer extends Item {

    private List<Item> list = new ArrayList<>();

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

    public List<Item> getList() {
	return list;
    }

    public void setList(List<Item> list) {
	this.list = list;
    }

    public void add(Item item) {
	list.add(item);
    }

    public void remove(Item item) {
	list.remove(item);
    }

}
