/*
 * SPACE COOKIES by DLC © 2020
 * Donatello Scigliuto, Luigi Vulcano, Cristiana Sorrenti
 */
package it.dlc.adventure;

import it.dlc.adventure.parser.Parser;
import it.dlc.adventure.parser.ParserOutput;
import it.dlc.adventure.gui.Music;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Motore di gioco.
 */
public class Engine {

    private GameDescription game;
    private final Parser parser;

    /**
     * Inizializzazione del gioco.
     *
     * @param game
     */
    public Engine(GameDescription game) {

	this.game = game;

	try {

	    this.game.intro(); // Mostra introduzione del gioco

	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    System.out.println("================================================================================================");
	    System.out.println("Premi il tasto INVIO per continuare...");
	    System.out.println("================================================\n");
	    br.readLine();

	    this.game.help(); // Mostra comandi principali

	    System.out.println("\n================================================================================================");
	    System.out.println("Premi il tasto INVIO per continuare...");
	    System.out.println("================================================\n");
	    br.readLine();

	    this.game.init(); // Inizializzazione del gioco

	} catch (Exception ex) {
	    System.out.println("\n################################################");
	    System.err.println("Impossibile avviare il gioco.\nEccezione verificata: " + ex);
	    System.out.println("################################################");
	}

	parser = new Parser();

    }

    /**
     * Avvio del gioco.
     */
    public void run() {

	//System.out.println("================================================");
	//System.out.println(game.getCurrentRoom().getName()); // Nome della stanza attuale
	System.out.println("================================================================================================");
	System.out.println(game.getCurrentRoom().getDescription()); // Descrizione della stanza attuale
	System.out.println("================================================================================================\n");

	Scanner scanner = new Scanner(System.in); // Digitazione in input

	while (scanner.hasNextLine()) {

	    System.out.print("\n");

	    String console = scanner.nextLine(); // Quando premo INVIO, tutto ciò che ho scritto viene passato nella stringa "console"

	    if (!console.isEmpty()) { // Se la stringa digitata non è vuota

		// Se è stato digitato "salva" o "salva partita"
		if (console.equalsIgnoreCase("SALVA") || console.equalsIgnoreCase("SALVA PARTITA")) {

		    try {
			game.save();
			System.out.println("================================================");
			System.out.println("Salvataggio partita completato.");
			System.out.println("================================================");
		    } catch (IOException | ClassNotFoundException ex) {
			System.out.println("######################################################");
			System.err.println("Impossibile salvare la partita.\n" + ex.getMessage());
			System.out.println("######################################################");
		    }

		    // Se è stato digitato "carica" o "carica partita"
		} else if (console.equalsIgnoreCase("CARICA") || console.equalsIgnoreCase("CARICA PARTITA")) {

		    try {
			game = game.load();
			System.out.println("================================================");
			System.out.println("Caricamento partita completato.");
			System.out.println("================================================");
		    } catch (IOException | ClassNotFoundException ex) {
			System.out.println("######################################################");
			System.err.println("Impossibile caricare la partita.\n" + ex.getMessage());
			System.out.println("######################################################");
		    }

		} else {
		    // Stringa digitata + lista comandi + oggetti nella stanza + inventario
		    ParserOutput p = parser.parse(console, game.getCommands(), game.getCurrentRoom().getItems(), game.getInventory());

		    if (p.getCommand() != null) { // Se ho trovato il comando
			System.out.println("================================================================================================");
			game.nextMove(p, System.out);
			System.out.println("================================================================================================");
		    }
		}

	    } else { // Se non ho digitato niente
		System.out.println("================================================");
		System.out.println("Digita qualcosa!");
		System.out.println("================================================");
	    }

	    System.out.print("\n");

	} // fine "while"

    }

    /**
     * Esecuzione del gioco.
     *
     * @param args
     */
    public static void main(String[] args) {

	// Riproduzione della musica
	Music music = new Music();
	music.playMusic();

	// Avvio del gioco
	Engine engine = new Engine(new Game());
	engine.run();

    }

} // fine della classe principale "Engine"
