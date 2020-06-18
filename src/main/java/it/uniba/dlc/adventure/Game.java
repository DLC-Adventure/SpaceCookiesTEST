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
        Room airlock = new Room(0, "Camera di equilibrio", "Ti trovi nella Camera di equilibrio, permette il passaggio di persone e materiali tra due ambienti con atmosfere diverse.");
        airlock.setLook("Vedi, tra varie attrezzature, una di quelle tute da astronauta, utilizzate per resistere all’atmosfera esterna. Inoltre vedi un’enorme porta che si affaccia all’esterno. Non ti consiglio di uscire!");
        getRooms().add(airlock);
        
        Room module1 = new Room(1, "Modulo 1 ", "Ti trovi nel Modulo 1, una stanza pressurizzata di grandi dimensioni, intorno a te vedi alcuni oggetti spaziali dalla dubbia utilità.");
        module1.setLook("Vedi un montacarichi, probabilmente è utilizzato per spostare carichi e rifornimenti da un Modulo all’altro.");
        getRooms().add(module1);
        
        Room module2 = new Room(2, "", "");
        module2.setLook("");
        getRooms().add(module2);
        
        Room module3 = new Room(3, "", "");
        module3.setLook("");
        getRooms().add(module3);
        
        Room kitchen = new Room(4, "Cucina", "Sei in una “spaziosa” cucina. Sembra che qualcuno abbia fatto rifornimento da poco.");
        kitchen.setLook("Vedi un frigorifero, un tavolo con delle sedie, alcuni scaffali…");
        getRooms().add(kitchen);
        
        Room warehouse = new Room(5, "Stiva", "Sei nella stiva. Che disordine!");
        warehouse.setLook("Vedi un sacco di robaccia e un armadietto.");
        getRooms().add(warehouse);
        
        Room crewCabin = new Room(6, "Cabina d'equipaggio", "Sei nella cabina dell’equipaggio. Attualmente è qui che dormi. ");
        crewCabin.setLook("Ci sono dei letti a castello, il tuo è quello più vicino alla porta.");
        getRooms().add(crewCabin);
        
        Room cafe = new Room(7, "Bar", "Sei nel bar della navicella, sembra molto accogliente.");
        cafe.setLook("Vedi un lungo bancone sul quale ci sono dei bicchieri da cocktail usati. Il vecchio equipaggio sembra aver fatto baldoria.");
        getRooms().add(cafe);
        
        Room engineRoomN = new Room(8, "Sala motori (nord)", "Sei nella sala motori, ci sono dei macchinari in movimento. Senti dei cigolii strani, spera che non ci siano problemi.");
        engineRoomN.setLook("Ci sono tanti macchinari in funzione.");
        getRooms().add(engineRoomN);
        
        Room engineRoomS = new Room(9, "Sala motori (sud)", "È tutto buio, non vedi niente. Senti dei rumori assordanti, sembra di trovarsi in un’officina.");
        engineRoomS.setLook("Non vedi niente. || Non hai i raggi infrarossi."); //TODO
        getRooms().add(engineRoomS);
        engineRoomS.setVisible(false); //
        
        //TODO <dopo aver acceso l'accendino>>
        Room engineRoomS1 = new Room(10, "Sala motori (sud)", "Sei nella sala motori, questa stanza mantiene attiva la navicella.");
        engineRoomS1.setLook("Ci sono molteplici macchinari,  qui vedi anche una cassetta degli attrezzi.");
        getRooms().add(engineRoomS1);
        
        Room observationDome = new Room(11, "Cupola di osservazione", "");
        observationDome.setLook("");
        getRooms().add(observationDome);
        
        Room toilette = new Room(13, "Toilet", "Ti trovi nella toilette. La stessa aria viene sottoposta ad un processo di igienizzazione per rimuovere odori e batteri, per essere infine reimmessa in cabina.");
        toilette.setLook("");
        getRooms().add(toilette);
        
        Room escapePods  = new Room(14, "Capsula di salvataggio", "");
        escapePods.setLook("");
        getRooms().add(escapePods);
        
        Room medicalRoom = new Room(15, "Stanza medica", "");
        medicalRoom.setLook("");
        getRooms().add(medicalRoom);
        
        Room meetingRoom = new Room(16, "Sala riunioni", "Sei nella sala riunioni, qui il comandante e l’equipaggio discutono le decisioni da prendere, ma visto che sei da solo non credo ci sia molto di cui discutere.");
        meetingRoom.setLook("Vedi un sacco di poltrone, dei quadri e un grande tavolo rotondo al centro della stanza.");
        getRooms().add(meetingRoom);
        
        Room controlRoom = new Room(17, "Stanza di comando", "Sei nella stanza di comando, un’enorme finestra ti permette di vedere l’intero pianeta Terra.");
        controlRoom.setLook("");
        getRooms().add(controlRoom);
        
        Room livingRoom = new Room(18, "Salotto", "Sei in quello che sembra essere un salotto. C’è un divano con un’enorme TV a schermo piatto.");
        livingRoom.setLook("");
        getRooms().add(livingRoom);
        
        Room captainsCabin = new Room(19, "Cabina del comandante", "");
        captainsCabin.setLook("");
        getRooms().add(captainsCabin);
        
        Room researchLab = new Room(20, "Laboratorio di ricerca", "Sei nel laboratorio di ricerca, qui venivano condotti esperimenti e altre ricerche in un ambiente a gravità zero impossibile da riprodurre sulla Terra. Dispone di prese elettriche e interfacce di trasmissione dati.");
        researchLab.setLook("");
        getRooms().add(researchLab);
        
        Room secretLab = new Room(21, "Laboratorio segreto COVID-19", "Sei entrato in una stanza dall’aspetto molto bizzarro, sulla targhetta della porta da cui sei entrato leggi “Laboratorio segreto Codiv-19");
        secretLab.setLook("È piena di provette, sulla parete noti una foto di Bill Gates.");
        getRooms().add(secretLab);
        
        //MAPPA
        airlock.setWest(module1);
        
        module1.setNorth(kitchen);
        module1.setSouth(crewCabin);
        module1.setWest(module2);
        module1.setEast(airlock);
        
        module2.setNorth(observationDome);
        module2.setSouth(toilette);
        module2.setWest(module3);
        module2.setEast(module1);
        
        module3.setNorth(escapePods);
        module3.setSouth(medicalRoom);
        module3.setWest(meetingRoom);
        module3.setEast(module2);
        
        kitchen.setNorth(warehouse);
        kitchen.setSouth(module1);
        
        warehouse.setEast(engineRoomN);
        warehouse.setSouth(kitchen);
        
        engineRoomN.setWest(warehouse);
        engineRoomS.setWest(cafe);
        engineRoomS1.setWest(cafe); //TODO  da rivedere
        
        crewCabin.setNorth(module1);
        crewCabin.setSouth(cafe);
        
        observationDome.setSouth(module2);
        
        toilette.setNorth(module2);
        toilette.setWest(medicalRoom);
        
        escapePods.setSouth(module3);
        
        medicalRoom.setNorth(module3);
        medicalRoom.setWest(livingRoom);
        medicalRoom.setEast(toilette); //TODO
        
        meetingRoom.setNorth(researchLab);
        meetingRoom.setWest(controlRoom);
        meetingRoom.setEast(module3);
        
        controlRoom.setEast(meetingRoom);
        
        livingRoom.setSouth(captainsCabin);
        livingRoom.setEast(medicalRoom);
        
        captainsCabin.setNorth(livingRoom);
        
        researchLab.setNorth(secretLab);
        researchLab.setSouth(meetingRoom);
        
        secretLab.setSouth(researchLab);
        
        //Oggetti
        
        
        
        
        ///// CONTINUA
    }
    
    @Override
    public void nextMove(ParserOutput p, PrintStream out) {
        //TODO
    }
    
}
