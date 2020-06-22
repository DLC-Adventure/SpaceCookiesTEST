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
public class ParserOLD {

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
	    if (items.get(i).getName().equals(token) || items.get(i).getAlias().contains(token)) {
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
     * Il parser è in grado di riconoscere anche frasi più o meno complesse.
     * Le frasi riconosciute sono:
     * <comando> // Esempio: "inventario"
     * <comando> <articolo> <oggetto> // Esempio: "apri (l') armadio"
     * <comando> <articolo> <oggetto inventario> // Esempio: "usa (la) torcia"
     * <comando> <articolo> <oggetto> <preposizione> <articolo> <oggetto inventario> // Esempio: "apri (la) porta con (la) chiave"
     * L'articolo è opzionale. Nel caso venissero inserite parole strane o non riconosciute, verrà restituito "Non ho capito"
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
	int inputPreposition = 0; // Non è ancora passato da una preposizione. [1 = trovato, -1 = inesistente]

	if (nToken > 0) { // Se c'è almeno una parola

	    int inputCommand = searchCommand(token[i], commands); // Restituisce l'elemento (i) oppure -1 (non trovato)

	    if (inputCommand > -1) { // Se il comando è stato trovato
		if (nToken > i + 1) { // Se c'è una parola successiva
		    i++; // Passa alla parola successiva

		    int inputArticle = searchArticle(token[i]); // Restituisce 1 (trovato) oppure -1 (non trovato)
		    int inputItem = searchItem(token[i], items); // Restituisce l'elemento (i) oppure -1 (non trovato)
		    int inputItemInventory = searchItem(token[i], inventory); // Restituisce l'elemento (i) oppure -1 (non trovato)

		    do {
			if (inputItem > -1 || inputArticle > -1 || inputItemInventory > -1) { // Se ha trovato l'articolo, l'oggetto o l'oggetto nell'inventario
			    if (inputArticle > -1) { // Se si tratta di un articolo
				i++; // Vai alla parola successiva
			    }

			    if (inputPreposition > -1) { // Se non sono passato dalla preposizione, vuol dire che devo trovare l'oggetto
				inputItem = searchItem(token[i], items); // Restituisce l'elemento (i) oppure -1 (non trovato)
			    } else { // Altrimenti devo trovare l'oggetto inventario
				inputItemInventory = searchItem(token[i], inventory); // Restituisce l'elemento (i) oppure -1 (non trovato)
			    }

			    if (inputItem > -1 && inputPreposition > -1) { // Se si tratta di un oggetto e non sono passato dalla preposizione
				if (nToken > i + 1) { // Se c'è una parola successiva
				    i++; // Passa alla parola successiva
				    inputPreposition = searchPreposition(token[i]); // Restituisce 1 (trovato) oppure -1 (non trovato)

				    if (inputPreposition < 0) { // Se la parola non è una preposizione
					//return new ParserOutput(null, null); // Parola non riconosciuta
					return new ParserOutput(commands.get(inputCommand), items.get(inputItem), null); // Ritorna comando + oggetto
				    }
				} else {
				    return new ParserOutput(commands.get(inputCommand), items.get(inputItem), null); // Ritorna comando + oggetto
				}
			    } else if (inputItemInventory > -1) { // Se ho trovato l'oggetto inventario
				return new ParserOutput(commands.get(inputCommand), null, inventory.get(inputItemInventory)); // Ritorna comando + oggetto inventario
			    } else {
				return new ParserOutput(null, null, null); // Oggetto non trovato
			    }
			} else {
			    return new ParserOutput(null, null, null); // Articolo, oggetto o oggetto inventario non trovati
			}

		    } while (inputPreposition < 1); // Cicla fintantoché non ho trovato una preposizione (inputPreposition = -1)

		} else {
		    return new ParserOutput(commands.get(inputCommand), null, null); // Trovato solo il comando
		}

	    } else {
		return new ParserOutput(null, null, null); // Comando non trovato
	    }
	} else {
	    return new ParserOutput(null, null, null); // Non ho inserito niente
	}

	return new ParserOutput(null, null, null); // Non ho inserito niente

    } // fine della funzione "parse"

} // fine della classe principale "Parser"
