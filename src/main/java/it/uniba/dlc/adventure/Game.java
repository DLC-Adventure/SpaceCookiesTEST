/*
 * SPACE COOKIES by DLC © 2020
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
        
        Room module1 = new Room(1, "Modulo 1", "Ti trovi nel Modulo 1, una stanza pressurizzata di grandi dimensioni, intorno a te vedi alcuni oggetti spaziali dalla dubbia utilità.");
        module1.setLook("Vedi un montacarichi, probabilmente è utilizzato per spostare carichi e rifornimenti da un Modulo all’altro.");
        getRooms().add(module1);
        
        Room module2 = new Room(2, "Modulo 2", "Sei nel modulo 2, una semplice stanza di passaggio.");
        module2.setLook("Non c’è niente qui.");
        getRooms().add(module2);
        
        Room module3 = new Room(3, "Modulo 3", "Sei nel modulo 3, è simile al modulo 1.");
        module3.setLook("Vedi un tastierino numerico fissato al muro.");
        getRooms().add(module3);
        
        Room kitchen = new Room(4, "Cucina", "Sei in una “spaziosa” cucina. Sembra che qualcuno abbia fatto rifornimento da poco.");
        kitchen.setLook("Vedi un frigorifero, un tavolo con delle sedie, alcuni scaffali...");
        getRooms().add(kitchen);
        
        Room warehouse = new Room(5, "Stiva", "Sei nella stiva. Che disordine!");
        warehouse.setLook("Vedi un sacco di robaccia e un armadietto.");
        getRooms().add(warehouse);
        
        Room crewCabin = new Room(6, "Cabina dell'equipaggio", "Sei nella cabina dell’equipaggio. Attualmente è qui che dormi. ");
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
        
        Room observationDome = new Room(11, "Cupola di osservazione", "Sei nella cupola di osservazione, piccolo modulo progettato per l’osservazione delle operazioni di riparazione effettuate al di fuori della navicella.");
        observationDome.setLook("Vedi 6 finestre laterali, ognuna delle quali è dotata di serrande per la protezione dalla contaminazione e dalle collisioni con detriti orbitanti.");
        getRooms().add(observationDome);
        
        Room toilette = new Room(13, "Toilet", "Ti trovi nella toilette. L’aria di questa stanza viene sottoposta ad processo di igienizzazione per rimuovere odori e batteri.");
        toilette.setLook("Vedi un wc e un lavandino. Affianco al lavandino vedi un condotto di aerazione.");
        getRooms().add(toilette);
        
        Room escapePods  = new Room(14, "Capsula di salvataggio", "Sei nella capsula di salvataggio, un dispositivo di fuga installato per l’abbandono della navicella in caso di pericolo.");
        escapePods.setLook("Vedi un pulsante e una leva.");
        getRooms().add(escapePods);
        
        Room medicalRoom = new Room(15, "Stanza medica", "Sei nella stanza medica, fondamentale per la cura dell’equipaggio.");
        medicalRoom.setLook("Vedi un lettino utile per visitare i pazienti e una siringa.");
        getRooms().add(medicalRoom);
        
        Room meetingRoom = new Room(16, "Sala riunioni", "Sei nella sala riunioni, qui il comandante e l’equipaggio discutono le decisioni da prendere, ma visto che sei da solo non credo ci sia molto di cui discutere.");
        meetingRoom.setLook("Vedi un sacco di poltrone, dei quadri e un grande tavolo rotondo al centro della stanza.");
        getRooms().add(meetingRoom);
        
        Room controlRoom = new Room(17, "Stanza di comando", "Sei nella stanza di comando. All’epoca gestita dal comandante, ora controllata dall’intelligenza artificiale dell’astronave.");
        controlRoom.setLook("Riesci finalmente a vedere la teca contenente i biscotti, che acquolina!");
        getRooms().add(controlRoom);
        
        Room livingRoom = new Room(18, "Salotto", "Sei nel salotto, stanza utilizzata frequentemente dall’ultimo comandante della navicella.");
        livingRoom.setLook("Vedi un divano e un enorme proiettore olografico.");
        getRooms().add(livingRoom);
        
        Room captainsCabin = new Room(19, "Cabina del comandante", "Sei nella cabina del comandante, è molto più spaziosa a differenza della tua.");
        captainsCabin.setLook("Vedi una scrivania, un pianoforte e una chitarra.");
        getRooms().add(captainsCabin);
        
        Room researchLab = new Room(20, "Laboratorio di ricerca", "Sei nel laboratorio di ricerca, qui venivano condotti esperimenti e altre ricerche in un ambiente a gravità zero impossibile da riprodurre sulla Terra.");
        researchLab.setLook("Vedi un microscopio, un libro e un tastierino numerico… appesa al muro c’è anche una tavola periodica degli elementi.");
        getRooms().add(researchLab);
        
        Room secretLab = new Room(21, "Laboratorio segreto COVID-19", "Sei entrato in una stanza dall’aspetto molto cupo e tenebroso, sulla targhetta della porta da cui sei entrato leggi \"Laboratorio segreto Codiv-19\"");
        secretLab.setLook("Il soffitto è pieno di pipistrelli e sulle pareti ci sono delle antenne. Noti anche una foto appesa al muro.");
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
