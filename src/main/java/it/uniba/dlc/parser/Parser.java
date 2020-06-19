/*
 * SPACE COOKIES by DLC © 2020
 */
package it.uniba.dlc.parser;

import it.uniba.dlc.type.Item;
import it.uniba.dlc.type.Command;
import java.util.List;


/**
 * Classe Parser.
 */
public class Parser {

    private int checkForCommand(String token, List<Command> commands) {
	for (int i = 0; i < commands.size(); i++) {
	    if (commands.get(i).getAlias().contains(token)) {
		return i;
	    }
	}
	return -1; // Comando non trovato
    }

    private int checkForArticle(String token) {
	String[] articles = {"il", "lo", "la", "i", "gli", "le", "l"};
	for (String article : articles) {
	    if (article.equals(token)) {
		return 1;
	    }
	}
	return -1; // Articolo non trovato
    }

    private int checkForItem(String token, List<Item> items) {
	for (int i = 0; i < items.size(); i++) {
	    if (items.get(i).getName().equals(token) || items.get(i).getAlias().contains(token)) {
		return i;
	    }
	}
	return -1; // Oggetto non trovato
    }

    private int checkForPreposition(String token) {
	String[] prepositions = {"con", "nel", "in"};
	for (String preposition : prepositions) {
	    if (preposition.equals(token)) {
		return 1; // Preposizione trovata
	    }
	}
	return -1; // Preposizione non trovata
    }

    /**
     * Il parser è in grado di riconoscere anche frasi più o meno complesse.
     * Le frasi riconosciute sono:
     * <comando> // Esempio: "inventario"
     * <comando> <articolo> <oggetto> // Esempio: "apri (l') armadio"
     * <comando> <articolo> <oggetto inventario> // Esempio: "usa (la) torcia"
     * <comando> <articolo> <oggetto> <preposizione> <articolo> <oggetto inventario> // Esempio: "apri (la) porta con (la) chiave"
     * L'articolo è opzionale. Nel caso venissero inserite parole strane o non riconosciute, verrà restituito "Non ho capito"
     *
     * @param command
     * @param commands
     * @param items
     * @param inventory
     * @return
     */
    public ParserOutput parse(String command, List<Command> commands, List<Item> items, List<Item> inventory) {
	String phrase = command.toLowerCase().trim(); // Rendi la frase digitata minuscola e togli spazi iniziali e finali

	String[] token = phrase.split("\\s+|\\'"); // Dividi la frase in più parole (token)
	int nToken = token.length; // Numero di parole presenti
	int i = 0; // Posizione della parola in esaminazione
	int inputPreposition = 0; // Non è ancora passato da una preposizione. [1 = trovato, -1 = inesistente]

	if (nToken > i) { // Se c'è almeno una parola

	    int inputCommand = checkForCommand(token[i], commands); // Restituisce l'elemento (i) oppure -1 (non trovato)

	    if (inputCommand > -1) { // Se il comando è stato trovato
		if (nToken > i + 1) { // Se c'è una parola successiva
		    i++; // Passa alla parola successiva

		    int inputArticle = checkForArticle(token[i]); // Restituisce 1 (trovato) oppure -1 (non trovato)
		    int inputItem = checkForItem(token[i], items); // Restituisce l'elemento (i) oppure -1 (non trovato)
		    int inputItemInventory = checkForItem(token[i], inventory); // Restituisce 1 (trovato) oppure -1 (non trovato)

		    do {
			if (inputItem > -1 || inputArticle > -1 || inputItemInventory > -1) { // Se ha trovato l'articolo, l'oggetto o l'oggetto nell'inventario
			    if (inputArticle > -1) { // Se si tratta di un articolo
				i++; // Vai alla parola successiva
			    }

			    if (inputPreposition > -1) { // Se non sono passato dalla preposizione, vuol dire che devo trovare l'oggetto
				inputItem = checkForItem(token[i], items); // Restituisce l'elemento (i) oppure -1 (non trovato)
			    } else { // Altrimenti devo trovare l'oggetto inventario
				inputItemInventory = checkForItem(token[i], inventory); // Restituisce l'elemento (i) oppure -1 (non trovato)
			    }

			    if (inputItem > -1 && inputPreposition > -1) { // Se si tratta di un oggetto e non sono passato dalla preposizione
				if (nToken > i + 1) { // Se c'è una parola successiva
				    i++; // Passa alla parola successiva
				    inputPreposition = checkForPreposition(token[i]); // Restituisce 1 (trovato) oppure -1 (non trovato)

				    if (inputPreposition < 0) { // Se la parola non è una preposizione
					return new ParserOutput(null, null); // Parola non riconosciuta
				    }
				} else {
				    return new ParserOutput(commands.get(inputCommand), items.get(inputItem), null); // Trovato comando + oggetto
				}
			    } else if (inputItemInventory > -1) {
				return new ParserOutput(commands.get(inputCommand), null, inventory.get(inputItemInventory)); // Trovato comando + oggetto inventario
			    } else {
				return new ParserOutput(null, null); // Oggetto non trovato
			    }
			} else {
			    return new ParserOutput(null, null); // Articolo, oggetto o oggetto inventario non trovati
			}

		    } while (inputPreposition < 1); // Cicla fintantoché non ho trovato una preposizione (inputPreposition = -1)

		} else {
		    return new ParserOutput(commands.get(inputCommand), null); // Trovato solo il comando
		}

	    } else {
		return new ParserOutput(null, null); // Comando non trovato
	    }
	} else {
	    return null; // Non ho inserito niente
	}

	return null; // Non ho inserito niente

    } // fine della classe "ParserOutput"

} // fine della classe principale "Parser"
