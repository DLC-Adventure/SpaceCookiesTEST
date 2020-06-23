/*
 * SPACE COOKIES by DLC © 2020
 */
package it.dlc.adventure.parser;

import it.dlc.adventure.type.Item;
import it.dlc.adventure.type.Command;
import java.util.List;

/**
 * Gestione del parser.
 */
public class Parser {

    // Cerca il comando
    private int searchCommand(String token, List<Command> commands) {
	for (int i = 0; i < commands.size(); i++) {
	    if (commands.get(i).getAlias().contains(token)) {
		return i;
	    }
	}
	return -1; // Comando non trovato
    }

    // Cerca l'oggetto
    private int searchItem(String token, List<Item> items) {
	for (int i = 0; i < items.size(); i++) {
	    if (items.get(i).getName().equalsIgnoreCase(token) || items.get(i).getAlias().contains(token)) {
		return i;
	    }
	}
	return -1; // Oggetto non trovato
    }

    // Cerca l'articolo
    private int searchArticle(String token) {
	String[] articles = {"il", "lo", "la", "i", "gli", "le", "l"};
	for (String article : articles) {
	    if (article.equals(token)) {
		return 1;
	    }
	}
	return -1; // Articolo non trovato
    }

    /**
     * Il parser è in grado di riconoscere le seguenti frasi.
     * <comando> // Esempio: "inventario"
     * <comando> <articolo> <oggetto> // Esempio: "apri (l') armadio"
     * <comando> <articolo> <oggetto inventario> // Esempio: "usa (la) torcia"
     * L'articolo è opzionale. Nel caso venga inserito o meno, la frase verrà riconosciuta lo stesso.
     *
     * @param console Stringa inserita in input
     * @param commands Lista dei comandi
     * @param items Lista degli oggetti
     * @param inventory Oggetti nell'inventario
     * @return comando + oggetto + oggetto inventario
     */
    public ParserOutput parse(String console, List<Command> commands, List<Item> items, List<Item> inventory) {

	String consoleLower = console.toLowerCase().trim(); // Trasforma la frase digitata in minuscolo e togli spazi iniziali e finali

	String[] token = consoleLower.split("\\s+|\\'"); // Dividi la frase digitata in più parole (token)

	int nToken = token.length; // Numero di parole presenti
	int i = 0; // Posizione della parola in esaminazione

	int inputCommand = searchCommand(token[i], commands); // Cerca il comando

	if (inputCommand > -1) { // Se ho trovato il comando

	    i++; // Vai alla parola successiva
	    
	    if (nToken > 1) { // Se c'è più di una parola

		int inputArticle = searchArticle(token[i]); // Cerca l'articolo

		if (inputArticle > -1) { // Se ho trovato un articolo
		    i++; // Vai alla parola successiva
		}

		int inputItem = searchItem(token[i], items); // Cerca l'oggetto nella stanza
		int inputInventoryItem = searchItem(token[i], inventory); // Cerca l'oggetto nell'inventario

		if (inputItem > -1) { // Se ho trovato l'oggetto nella stanza
		    return new ParserOutput(commands.get(inputCommand), items.get(inputItem), null); // Ritorna comando + oggetto
		} else if (inputInventoryItem > -1) { // Se ho trovato l'oggetto nell'inventario
		    return new ParserOutput(commands.get(inputCommand), null, inventory.get(inputInventoryItem)); // Ritorna comando + oggetto inventario
		} else { // Se non ho trovato nessun oggetto
		    return new ParserOutput(commands.get(inputCommand), null, null); // Oggetto non trovato
		}

	    } else { // Se c'è una sola parola
		return new ParserOutput(commands.get(inputCommand), null, null); // Ritorna comando
	    }

	} else { // Se non ho trovato il comando
	    return new ParserOutput(null, null, null); // Comando non trovato
	}

    } // fine della funzione "parse"

} // fine della classe principale "Parser"
