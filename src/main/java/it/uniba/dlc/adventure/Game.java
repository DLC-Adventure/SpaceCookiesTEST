/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.dlc.adventure;

import it.uniba.dlc.parser.ParserOutput;
import it.uniba.dlc.type.Room;
import java.io.PrintStream;

/**
 *
 * @author DLC
 */
public class Game extends GameDescription {

    @Override
    public void init() throws Exception {
	
    //Stanze
	Room module1 = new Room (0, "Modulo 1 ","Ti trovi nel Modulo 1, una stanza pressurizzata di grandi dimensioni, intorno a te vedi alcuni oggetti spaziali dalla dubbia utilità.");
	module1.setLook("Vedi un montacarichi, probabilmente è utilizzato per spostare carichi e rifornimenti da un Modulo all’altro.");
	getRooms().add(module1);
	
	Room module2 = new Room(1, "", "");
	module2.setLook("");
	getRooms().add(module2);
	
	Room module3 = new Room(2, "", "");
	module3.setLook("");
	getRooms().add(module3);
	
	Room kitchen = new Room(3, "Cucina", "Sei in una “spaziosa” cucina. Sembra che qualcuno abbia fatto rifornimento da poco.");
	module2.setLook("Vedi un frigorifero, un tavolo con delle sedie, alcuni scaffali…");
	getRooms().add(kitchen);
	
	Room warehouse = new Room(4, "Stiva", "Sei nella stiva. Che disordine!");
	module3.setLook("Vedi un sacco di robaccia e un armadietto.");
	getRooms().add(warehouse);
	
	Room crewCabin = new Room(5, "Cabina d'equipaggio", "Sei nella cabina dell’equipaggio. Attualmente è qui che dormi. ");
	module3.setLook("Ci sono dei letti a castello, il tuo è quello più vicino alla porta.");
	getRooms().add(crewCabin);
	
	Room cafe  = new Room(6, "Bar", "Sei nel bar della navicella, sembra molto accogliente.");
	module3.setLook("Vedi un lungo bancone sul quale ci sono dei bicchieri da cocktail usati. Il vecchio equipaggio sembra aver fatto baldoria.");
	getRooms().add(cafe);
	
	Room engineRoomN = new Room(7, "Sala motori (nord)", "Sei nella sala motori, ci sono dei macchinari in movimento. Senti dei cigolii strani, spera che non ci siano problemi.");
	module3.setLook("Ci sono tanti macchinari in funzione.");
	getRooms().add(engineRoomN);
	
	Room engineRoomS = new Room(7, "Sala motori (sud)", "È tutto buio, non vedi niente. Senti dei rumori assordanti, sembra di trovarsi in un’officina.");
	module3.setLook("Non vedi niente. || Non hai i raggi infrarossi."); //TODO
	getRooms().add(engineRoomS);
	
	//TODO <dopo aver acceso l'accendino>>
	Room engineRoomS2 = new Room(7, "Sala motori (sud)", "Sei nella sala motori, questa stanza mantiene attiva la navicella.");
	module3.setLook("Ci sono molteplici macchinari,  qui vedi anche una cassetta degli attrezzi."); //TODO
	getRooms().add(engineRoomS);
	
	Room module3 = new Room(8, "", "");
	module3.setLook("");
	getRooms().add(module3);
	
	Room module3 = new Room(9, "", "");
	module3.setLook("");
	getRooms().add(module3);
	
	
	
	
	
	
	
	
    }

    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void nextMove(ParserOutput p, PrintStream out) {
	//TODO
    }

}
