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
		return i; // Posizione del comando
	    }
	}
	return -1; // Comando non trovato
    }

    // Cerca l'oggetto
    private int searchItem(String token, List<Item> items) {
	for (int i = 0; i < items.size(); i++) {
	    if (items.get(i).getName().equalsIgnoreCase(token) || items.get(i).getAlias().contains(token)) {
		return i; // Posizione dell'oggetto
	    }
	}
	return -1; // Oggetto non trovato
    }

    // Cerca l'articolo
    private int searchArticle(String token) {
	String[] articles = {"il", "lo", "la", "i", "gli", "le", "l"};
	for (String article : articles) {
	    if (article.equals(token)) {
		return 1; // Articolo trovato
	    }
	}
	return -1; // Articolo non trovato
    }

    // Cerca la preposizione
    private int searchPreposition(String token) {
	String[] prepositions = {"con", "nel", "in"};
	for (String preposition : prepositions) {
	    if (preposition.equals(token)) {
		return 1; // Preposizione trovata
	    }
	}
	return -1; // Preposizione non trovata
    }

    /**
     * Il parser è in grado di riconoscere il seguente tipo di frasi.
     * <comando> // Esempio: "inventario"
     * <comando> <articolo> <oggetto> // Esempio: "apri (l') armadio"
     * <comando> <articolo> <oggetto inventario> // Esempio: "usa (la) torcia"
     * <comando> <articolo> <oggetto> <preposizione> <articolo> <oggetto inventario> // Esempio: "apri (la) porta con (la) chiave"
     * L'articolo è opzionale. Nel caso venga inserito o meno, la frase verrà riconosciuta lo stesso.
     *
     * @param console Stringa inserita in input
     * @param commands Lista dei comandi
     * @param items Lista degli oggetti nella stanza
     * @param inventory Lista degli oggetti nell'inventario
     * @return comando + oggetto (nella stanza) + oggetto inventario (posseduto)
     */
    public ParserOutput parse(String console, List<Command> commands, List<Item> items, List<Item> inventory) {

	String consoleLower = console.toLowerCase().trim(); // Trasforma la frase digitata in minuscolo e togli spazi iniziali e finali

	String[] token = consoleLower.split("\\s+|\\'"); // Dividi la frase digitata in più parole (token)

	int nToken = token.length; // Numero di parole presenti
	int i = 0; // Posizione della parola in esaminazione

	int inputCommand = searchCommand(token[i], commands); // Cerca il comando

	if (inputCommand > -1) { // Se ho trovato il comando

	    if (nToken > i + 1) { // Se c'è una parola successiva

		i++; // Vai alla parola successiva
		int inputArticle = searchArticle(token[i]); // Cerca l'articolo
		int inputPreposition = searchPreposition(token[i]); // Cerca la preposizione

		if (inputArticle > -1 || inputPreposition > -1) { // Se ho trovato un articolo
		    if (nToken > i + 1) { // Se c'è una parola successiva
			i++; // Vai alla parola successiva
		    } else { // Se non c'è un'altra parola dopo l'articolo
			noCommand();
			return new ParserOutput(null, null, null); // Non riconosciuto
		    }
		}

		int inputItem = searchItem(token[i], items); // Cerca l'oggetto nella stanza
		int inputInventoryItem = searchItem(token[i], inventory); // Cerca l'oggetto nell'inventario

		if (inputItem > -1) { // Se ho trovato l'oggetto nella stanza

		    while (nToken > i + 1) { // Finché c'è un'altra parola

			i++; // Vai alla parola successiva
			inputPreposition = searchPreposition(token[i]); // Cerca la preposizione

			if (inputPreposition > -1) { // Se ho trovato una preposizione

			    if (nToken > i + 1) { // Se c'è un'altra parola

				i++; // Vai alla parola successiva
				inputArticle = searchArticle(token[i]); // Cerca l'articolo

				if (inputArticle > -1) { // Se ho trovato un articolo
				    if (nToken > i + 1) { // Se c'è una parola successiva
					i++; // Vai alla parola successiva
				    } else { // Se non c'è un'altra parola dopo l'articolo
					noCommand();
					return new ParserOutput(null, null, null); // Non riconosciuto
				    }
				}

				inputInventoryItem = searchItem(token[i], inventory); // Cerca l'oggetto nell'inventario

				if (inputInventoryItem > -1) { // Se ho trovato l'oggetto nell'inventario
				    return new ParserOutput(commands.get(inputCommand), items.get(inputItem), inventory.get(inputInventoryItem)); // Ritorna comando + oggetto + oggetto inventario
				} else { // Se non ho trovato l'oggetto nell'inventario
				    noInventoryItem();
				    return new ParserOutput(null, null, null); // Non riconosciuto
				}
			    } else { // Se non c'è un'altra parola dopo la preposizione
				noCommand();
				return new ParserOutput(null, null, null); // Non riconosciuto
			    }

			} // fine "if" preposizione

		    } // fine "while"

		    return new ParserOutput(commands.get(inputCommand), items.get(inputItem), null); // Ritorna comando + oggetto

		} else if (inputInventoryItem > -1) { // Se ho trovato l'oggetto nell'inventario

		    while (nToken > i + 1) { // Finché c'è un'altra parola

			i++; // Vai alla parola successiva
			inputPreposition = searchPreposition(token[i]); // Cerca la preposizione

			if (inputPreposition > -1) { // Se ho trovato una preposizione

			    noCommand();
			    return new ParserOutput(null, null, null); // Non riconosciuto

			} // fine "if" preposizione

		    } // fine "while"

		    return new ParserOutput(commands.get(inputCommand), null, inventory.get(inputInventoryItem)); // Ritorna comando + oggetto inventario

		} else { // Se non ho trovato nessun oggetto
		    noItem();
		    return new ParserOutput(null, null, null); // Non riconosciuto
		}

	    } else { // Se c'è una sola parola
		return new ParserOutput(commands.get(inputCommand), null, null); // Ritorna comando
	    }

	} else { // Se non ho trovato il comando
	    noCommand();
	    return new ParserOutput(null, null, null); // Non riconosciuto
	}

    } // fine della funzione "parse"

    public void noCommand() {
	System.out.println("================================================");
	System.out.println("Non ho capito.");
	System.out.println("================================================");
    }

    public void noItem() {
	System.out.println("================================================");
	System.out.println("Non vedo questo oggetto.");
	System.out.println("================================================");
    }

    public void noInventoryItem() {
	System.out.println("================================================");
	System.out.println("Non possiedo questo oggetto.");
	System.out.println("================================================");
    }

} // fine della classe principale "Parser"
