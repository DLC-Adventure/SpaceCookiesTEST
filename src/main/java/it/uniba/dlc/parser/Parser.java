/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.dlc.parser;

import it.uniba.dlc.type.Item;
import it.uniba.dlc.type.Command;
import java.util.List;

/**
 *
 * @author pierpaolo
 */
public class Parser {

    private int checkForCommand(String token, List<Command> commands) {
	for (int i = 0; i < commands.size(); i++) {
	    if (commands.get(i).getName().equals(token) || commands.get(i).getAlias().contains(token)) {
		return i;
	    }
	}
	return -1;
    }

    private int checkForObject(String token, List<Item> obejcts) {
	for (int i = 0; i < obejcts.size(); i++) {
	    if (obejcts.get(i).getName().equals(token) || obejcts.get(i).getAlias().contains(token)) {
		return i;
	    }
	}
	return -1;
    }

    private int checkForArticle(String token) {
	String[] articles = {"il", "lo", "la", "i", "gli", "le", "l"};
	for (String article : articles) {
	    if (article.equals(token)) {
		return 1;
	    }
	}
	return -1;
    }
    
    private int checkForPreposition(String token) {
	String[] prepositions = {"con","nel","in"};
	for (String preposition : prepositions) {
	    if (preposition.equals(token)) {
		return 1; // Trovato
	    }
	}
	return -1; // Non trovato
    }

    /* ATTENZIONE: il parser è implementato in modo abbastanza independete dalla lingua mi riconosce solo 
    * frasi semplici del tipo <azione> <oggetto> <oggetto> non permette di utilizzare articoli o preposizioni.
    * L'utilizzo di articoli o preporsizioni lo renderebbero dipendente dalla lingua, o meglio bisognerebbe
    * realizzare un parser per ogni lingua, prevedendo un'iterfaccia/classe astratta Perser e diverse
    * implementazioni per ogni lingua.
     */
    public ParserOutput parse(String command, List<Command> commands, List<Item> objects, List<Item> inventory) {
	String phrase = command.toLowerCase().trim(); // Rendi la frase digitata minuscola e togli spazi iniziali e finali

	String[] token = phrase.split("\\s+|\\'"); // Dividi la frase in più parole (token)
	int nToken = token.length; // Numero di parole presenti
	int i = 0;
	int inputPreposition = 0; // Non è ancora passato da una preposizione. [1 = trovato, -1 = inesistente]

	if (nToken > i) { // Se c'è almeno una parola

	    int inputCommand = checkForCommand(token[i], commands); // Restituisce l'elemento (i) oppure -1 (non trovato)

	    if (inputCommand > -1) { // Se il comando è stato trovato
		if (nToken > i + 1) { // Se c'è una parola successiva
		    i++;

		    int inputArticle = checkForArticle(token[i]); // Restituisce 1 (trovato) oppure -1 (non trovato)
		    int inputObject = checkForObject(token[i], objects); // Restituisce l'elemento (i) oppure -1 (non trovato)
		    int inputObjectInventory = checkForObject(token[i], inventory); // Restituisce 1 (trovato) oppure -1 (non trovato)

		    do {
			if (inputObject > -1 || inputArticle > -1 || inputObjectInventory > -1) { // Se ha trovato l'articolo, l'oggetto o l'oggetto nell'inventario
			    if (inputArticle > -1) { // Se si tratta di un articolo
				i++; // Vai alla parola successiva
			    }

			    if (inputPreposition > -1) { // Se non sono passato dalla preposizione, vuol dire che devo trovare l'oggetto
				inputObject = checkForObject(token[i], objects); // Restituisce l'elemento (i) oppure -1 (non trovato)
			    } else { // Altrimenti devo trovare l'oggetto inventario
				inputObjectInventory = checkForObject(token[i], inventory); // Restituisce l'elemento (i) oppure -1 (non trovato)
			    }

			    if (inputObject > -1 && inputPreposition > -1) { // Se si tratta di un oggetto e non sono passato dalla preposizione
				if (nToken > i + 1) { // Se c'è una parola successiva
				    i++;
				    inputPreposition = checkForPreposition(token[i]); // Restituisce 1 (trovato) oppure -1 (non trovato)
				    
				    if (inputPreposition < 0) { // Se la parola non è una preposizione
					return new ParserOutput(null, null); // Parola non riconosciuta
				    }
				} else {
				    return new ParserOutput(commands.get(inputCommand), objects.get(inputObject), null); // Trovato comando + oggetto
				}
			    } else if (inputObjectInventory > -1) {
				return new ParserOutput(commands.get(inputCommand), null, inventory.get(inputObjectInventory)); // Trovato comando + oggetto inventario
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

} // fine della classe principale
