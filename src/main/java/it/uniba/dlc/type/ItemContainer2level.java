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

// Oggetti contenitore contenuto a sua volta in un altro contenitore 
public class ItemContainer2level extends ItemContainer{
    
    private List<ItemContainer> list2 = new ArrayList<>();
    
    public ItemContainer2level(int id) {
        super(id);
    }
    
    public ItemContainer2level(int id, String name) {
        super(id, name);
    }
    
    public ItemContainer2level(int id, String name, String description) {
        super(id, name, description);
    }
    
    public ItemContainer2level(int id, String name, String description, Set<String> alias) {
        super(id, name, description, alias);
    }
    
    public List<ItemContainer> getList2() {
        return list2;
    }
    
    public void setList2(List<ItemContainer> list) {
        this.list2 = list;
    }
    
    
}
