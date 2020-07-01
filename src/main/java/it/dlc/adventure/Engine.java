/*
 * SPACE COOKIES by DLC © 2020
 * Donatello Scigliuto, Luigi Vulcano, Cristiana Sorrenti
 */
package it.dlc.adventure;

import it.dlc.adventure.parser.Parser;
import it.dlc.adventure.parser.ParserOutput;
import it.dlc.adventure.swing.Music;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Motore di gioco.
 */
public class Engine {

    private final GameDescription game;
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

	    System.out.println("================================================================================================");
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

	    if (!console.isEmpty() && !console.equals("'")) { // Se la stringa digitata non è vuota e non è uguale a un apostrofo
		// Stringa digitata + lista comandi + oggetti nella stanza + inventario
		ParserOutput p = parser.parse(console, game.getCommands(), game.getCurrentRoom().getItems(), game.getInventory());

		if (p.getCommand() != null) { // Se ho trovato il comando
		    System.out.println("================================================================================================");
		    game.nextMove(p, System.out);
		    System.out.println("================================================================================================");
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
