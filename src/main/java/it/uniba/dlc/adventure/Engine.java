/*
 * SPACE COOKIES by DLC © 2020
 */
package it.uniba.dlc.adventure;

import it.uniba.dlc.parser.Parser;
import it.uniba.dlc.parser.ParserOutput;
import it.uniba.dlc.type.CommandType;
import java.util.Scanner;

/**
 * Motore di gioco.
 */
public class Engine {
    
    private final GameDescription game;
    
    private final Parser parser;
    
    /**
     * 
     * @param game 
     */
    public Engine(GameDescription game) {
        this.game = game;
        try {
            this.game.init();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        parser = new Parser();
    }
    
    /**
     * 
     */
    public void run() {
        System.out.println(game.getCurrentRoom().getName());
        System.out.println("================================================");
        System.out.println(game.getCurrentRoom().getDescription());
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine(); // Quando premo INVIO, tutto ciò che ho scritto viene passato alla stringa "command"
            ParserOutput p = parser.parse(command, game.getCommands(), game.getCurrentRoom().getItems(), game.getInventory());
            if (p.getCommand() != null && p.getCommand().getType() == CommandType.END) {
                System.out.println("Addio!");
                break;
            } else {
                game.nextMove(p, System.out);
                System.out.println("================================================");
            }
        }
    }
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        // Inizializzo musica gioco
        String filepath ="song.wav";
        Music musicObject = new Music();
        musicObject.playMusic(filepath);
        
        Engine engine = new Engine(new Game());
        engine.run();
    }
    
}
