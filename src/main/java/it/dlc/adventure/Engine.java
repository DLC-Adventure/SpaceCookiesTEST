/*
 * SPACE COOKIES by DLC © 2020
 */
package it.dlc.adventure;

import it.dlc.adventure.parser.Parser;
import it.dlc.adventure.parser.ParserOutput;
import it.dlc.adventure.type.CommandType;
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
	    System.out.println("================================================");
	    System.out.println("Premi il tasto INVIO per continuare...");
	    System.out.println("================================================");
	    br.readLine();

	    this.game.help(); // Mostra introduzione del gioco

	    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("================================================");
	    System.out.println("Premi il tasto INVIO per continuare...");
	    System.out.println("================================================");
	    br.readLine();

	    this.game.init(); // Inizializzazione del gioco

	} catch (Exception ex) {
	    System.out.println("================================================");
	    System.err.println("Impossibile avviare il gioco.\nEccezione verificata: " + ex);
	    System.out.println("================================================");
	}

	parser = new Parser();

    }

    /**
     * Avvio del gioco.
     */
    public void run() {

	//System.out.println(game.getCurrentRoom().getName()); // Nome della stanza attuale
	System.out.println("================================================");
	System.out.println(game.getCurrentRoom().getDescription()); // Descrizione della stanza attuale
	System.out.println("================================================");

	Scanner scanner = new Scanner(System.in); // Digitazione in input

	while (scanner.hasNextLine()) {

	    String console = scanner.nextLine(); // Quando premo INVIO, tutto ciò che ho scritto viene passato nella stringa "console"

	    if (!console.isEmpty()) { // Se la stringa digitata non è vuota
		// Stringa digitata + lista comandi + oggetti nella stanza + inventario
		ParserOutput p = parser.parse(console, game.getCommands(), game.getCurrentRoom().getItems(), game.getInventory());

		if (p.getCommand() == null) { // Se non ho trovato il comando
		    System.out.println("================================================");
		    System.out.println("Non ho capito.");
		    System.out.println("================================================");
		} else { // Comando trovato
		    System.out.println("================================================");
		    game.nextMove(p, System.out);
		    System.out.println("================================================");
		}
	    } else { // Se non ho digitato niente
		System.out.println("================================================");
		System.out.println("Digita qualcosa!");
		System.out.println("================================================");
	    }

	} // fine "while"

    }

    /**
     * Esecuzione del gioco.
     *
     * @param args
     */
    public static void main(String[] args) {

	Music music = new Music();
	music.playMusic(); // Riproduzione della musica

	Engine engine = new Engine(new Game());
	engine.run(); // Avvio del gioco

    }

} // fine della classe principale "Engine"
