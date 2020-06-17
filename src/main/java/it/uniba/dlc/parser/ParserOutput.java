/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.dlc.parser;

import it.uniba.dlc.type.Item;
import it.uniba.dlc.type.Command;

/**
 *
 * @author pierpaolo
 */
public class ParserOutput {

    private Command command;

    private Item object;
    
    private Item invObject;

    
    
    public ParserOutput(Command command, Item object) {
        this.command = command;
        this.object = object;
    }

    public ParserOutput(Command command, Item object, Item invObejct) {
        this.command = command;
        this.object = object;
        this.invObject = invObejct;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Item getObject() {
        return object;
    }

    public void setObject(Item object) {
        this.object = object;
    }

    public Item getInvObject() {
        return invObject;
    }

    public void setInvObject(Item invObject) {
        this.invObject = invObject;
    }

}
