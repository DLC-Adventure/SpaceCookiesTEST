/*
 * SPACE COOKIES by DLC © 2020
 */
package it.uniba.dlc.type;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Metodi dei comandi.
 */
public class Command {

    private final CommandType type; // Tipo di comando
    private Set<String> alias; // Nome e alias del comando

    // Tipo di comando
    public Command(CommandType type) {
	this.type = type;
    }

    public CommandType getType() {
	return type;
    }

    // Tipo di comando + alias
    public Command(CommandType type, Set<String> alias) {
	this.type = type;
	this.alias = alias;
    }

    // Alias
    public Set<String> getAlias() {
	return alias;
    }

    public void setAlias(Set<String> alias) {
	this.alias = alias;
    }

    public void setAlias(String[] alias) {
	this.alias = new HashSet<>(Arrays.asList(alias));
    }

    // EQUALS + HASH CODE
    @Override
    public int hashCode() {
	int hash = 3;
	hash = 97 * hash + Objects.hashCode(this.type);
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
	final Command other = (Command) obj;
	if (this.type != other.type) {
	    return false;
	}
	return true;
    }

} // fine della classe principale "Command"
