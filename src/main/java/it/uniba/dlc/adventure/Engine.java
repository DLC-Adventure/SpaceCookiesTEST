/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package it.uniba.dlc.adventure;

import it.uniba.dlc.parser.Parser;
import it.uniba.dlc.parser.ParserOutput;
import it.uniba.dlc.type.CommandType;
import java.util.Scanner;

/*
 * @author dlc
 */
public class Engine {
    
    private final GameDescription game;
    
    private final Parser parser;
    
    public Engine(GameDescription game) {
        this.game = game;
        try {
            this.game.init();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        parser = new Parser();
    }
    
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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Inizializzo musica gioco
        String filepath ="song.wav";
        musicStuff musicObject = new musicStuff();
        musicObject.playMusic(filepath);
        
        Engine engine = new Engine(new Game());
        engine.run();
    }
    
}
