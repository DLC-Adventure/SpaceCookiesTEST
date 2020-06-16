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
 * @author Donatello
 */
public class Inventory {
    
    List<Item> list = new ArrayList<>();
    
    public List<Item> getList(){
	return list;
    }
    
    public void setList(List<Item> list){
	this.list = list;
    }
	
    public void add(Item item){
	list.add(item);
    }
    
    public void remove(Item item){
	list.remove(item);
    }
    
    
    
}
