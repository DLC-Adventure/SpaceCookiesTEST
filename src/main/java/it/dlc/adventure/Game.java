/*
* SPACE COOKIES by DLC © 2020
 */
package it.dlc.adventure;

import it.dlc.adventure.parser.ParserOutput;
import it.dlc.adventure.type.Command;
import it.dlc.adventure.type.CommandType;
import it.dlc.adventure.type.Item;
import it.dlc.adventure.type.ItemContainer;
import it.dlc.adventure.type.Room;
import java.io.PrintStream;
import java.util.Random;

/**
 * Classe principale del gioco.
 */
public class Game extends GameDescription {

    /**
     * Testo introduttivo del gioco.
     */
    @Override
    public void intro() {
	System.out.println("Hai commesso un crimine sulla Terra e sei stato condannato a vivere in isolamento per 5 anni in una navicella spaziale, obbligato a svolgere le faccende “di casa” e riparare i circuiti danneggiati dell’astronave.\n"
		+ "La prigionia è dura e snervante, tuttavia hai visto una teca contenente dei biscotti che potrebbero sollevarti un po’ il morale. Chissà come si apre!\n"
		+ "L’astronave è gestita da un’intelligenza artificiale che esegue i tuoi comandi.");
    }

    /**
     * Testo introduttivo del gioco.
     */
    @Override
    public void help() {
	System.out.println("Ricordati che per utilizzare le tue funzioni motorie dovrai utilizzare i seguenti comandi:\n"
		+ "NORD, SUD, OVEST, EST per spostarti. O più semplicemente N, S, O, E.\n"
		+ "Per usare gli occhi digita il comando GUARDA o OSSERVA.\n"
		+ "Se vuoi sembrare arguto digita il comando ESAMINA (QUALCOSA).\n"
		+ "Inoltre la tua tuta spaziale può contenere vari oggetti, per vederne il contenuto digita il comando INVENTARIO o ‘I’.\n"
		+ "Se hai una memoria di pochi byte e dovessi dimenticare tutto, digita il comando ‘?’ per rivedere questi comandi.\n"
		+ "Probabilmente ce ne sono altri... Ma di certo non te li posso dire tutti io!");
    }

    /**
     * Inizializzazione del gioco.
     *
     * @throws Exception
     */
    @Override
    public void init() throws Exception {

	// Comandi
	Command north = new Command(CommandType.NORTH);
	north.setAlias(new String[]{"nord", "n"});
	getCommands().add(north);

	Command sud = new Command(CommandType.SOUTH);
	sud.setAlias(new String[]{"sud", "s"});
	getCommands().add(sud);

	Command west = new Command(CommandType.WEST);
	west.setAlias(new String[]{"ovest", "o", "west", "w"});
	getCommands().add(west);

	Command east = new Command(CommandType.EAST);
	east.setAlias(new String[]{"est", "e"});
	getCommands().add(east);

	Command help = new Command(CommandType.HELP);
	help.setAlias(new String[]{"?", "help", "aiuto"});
	getCommands().add(help);

	Command end = new Command(CommandType.END);
	end.setAlias(new String[]{"end", "termina", "ucciditi", "suicidati"});
	getCommands().add(end);

	Command inventory = new Command(CommandType.INVENTORY);
	inventory.setAlias(new String[]{"inventario", "i"});
	getCommands().add(inventory);

	Command look = new Command(CommandType.LOOK);
	look.setAlias(new String[]{"osserva", "guarda"});
	getCommands().add(look);

	Command examine = new Command(CommandType.EXAMINE);
	examine.setAlias(new String[]{"esamina"});
	getCommands().add(examine);

	Command open = new Command(CommandType.OPEN);
	open.setAlias(new String[]{"apri"});
	getCommands().add(open);

	Command close = new Command(CommandType.CLOSE);
	close.setAlias(new String[]{"chiudi"});
	getCommands().add(close);

	Command take = new Command(CommandType.TAKE);
	take.setAlias(new String[]{"prendi"});
	getCommands().add(take);

	Command use = new Command(CommandType.USE);
	use.setAlias(new String[]{"usa", "utilizza"});
	getCommands().add(use);

	Command push = new Command(CommandType.PUSH);
	push.setAlias(new String[]{"premi", "spingi"});
	getCommands().add(push);

	Command pull = new Command(CommandType.PULL);
	pull.setAlias(new String[]{"tira"});
	getCommands().add(pull);

	Command turnOn = new Command(CommandType.TURN_ON);
	turnOn.setAlias(new String[]{"accendi"});
	getCommands().add(turnOn);

	Command turnOff = new Command(CommandType.TURN_OFF);
	turnOff.setAlias(new String[]{"spegni"});
	getCommands().add(turnOff);

	Command walkTo = new Command(CommandType.WALK_TO);
	walkTo.setAlias(new String[]{"attraversa"});
	getCommands().add(walkTo);

	Command drink = new Command(CommandType.DRINK);
	drink.setAlias(new String[]{"bevi"});
	getCommands().add(drink);

	Command play = new Command(CommandType.PLAY);
	play.setAlias(new String[]{"suona", "gioca"});
	getCommands().add(play);

	Command read = new Command(CommandType.READ);
	read.setAlias(new String[]{"leggi"});
	getCommands().add(read);
	
	Command clean = new Command(CommandType.CLEAN);
	clean.setAlias(new String[]{"pulisci"});
	getCommands().add(clean);

	Command kick = new Command(CommandType.KICK);
	kick.setAlias(new String[]{"caccia", "espelli", "manda", "scaccia"});
	getCommands().add(kick);

	Command exit = new Command(CommandType.EXIT);
	exit.setAlias(new String[]{"esci"});
	getCommands().add(exit);

	Command sit = new Command(CommandType.SIT);
	sit.setAlias(new String[]{"siediti"});
	getCommands().add(sit);

	Command sleep = new Command(CommandType.SLEEP);
	sleep.setAlias(new String[]{"dormi"});
	getCommands().add(sleep);

	// Stanze
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

	Room escapePods = new Room(14, "Capsula di salvataggio", "Sei nella capsula di salvataggio, un dispositivo di fuga installato per l’abbandono della navicella in caso di pericolo.");
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

	Room secretLab = new Room(21, "Laboratorio segreto COVID-19", "Sei entrato in una stanza dall’aspetto molto cupo e tenebroso, sulla targhetta della porta da cui sei entrato leggi \"Laboratorio segreto COVID-19\"");
	secretLab.setLook("Il soffitto è pieno di pipistrelli e sulle pareti ci sono delle antenne. Noti anche una foto appesa al muro.");
	getRooms().add(secretLab);

	// Mappa del gioco
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

	// Stanza di inizio gioco
	setCurrentRoom(module1);

	// Oggetti
	Item goodsLift = new Item(1, "Montacarichi", "Trovi un pacco di Space Amazon. Incredibile! Amazon spedisce anche nello spazio.");
	goodsLift.setAlias(new String[]{});
	module1.getItems().add(goodsLift);

	Item packet = new Item(2, "Pacco", "APRI: e' vuoto."); //TODO e con accento
	packet.setAlias(new String[]{});
	module1.getItems().add(packet);

	Item numberPad1 = new Item(3, "Tastierino", "");
	numberPad1.setAlias(new String[]{});
	module3.getItems().add(numberPad1);

	Item kitchenTable = new Item(4, "Tavolo", "Non c’è niente.");
	kitchenTable.setAlias(new String[]{});
	module3.getItems().add(kitchenTable);

	Item bed = new Item(5, "Lettino", "");
	bed.setAlias(new String[]{});
	crewCabin.getItems().add(bed);

	Item glass = new Item(6, "Bicchiere", "E’ sporco, ha un odore di menta e lime."); // e con accento
	glass.setAlias(new String[]{"Bicchieri"});
	cafe.getItems().add(glass);

	Item engineN = new Item(7, "Motori", "Non c’è nulla di utile qui.");
	engineN.setAlias(new String[]{});
	engineRoomN.getItems().add(engineN);

	Item engineS = new Item(8, "Motori", "I motori utilizzano una particolare miscela di idrogeno e delle celle ad energia solare. Sembra davvero innovativa!");
	engineS.setAlias(new String[]{});
	engineRoomS.getItems().add(engineS);

	Item window = new Item(9, "Finestra", "Che vista spettacolare, da qui riesci a vedere anche il pianeta Terra.");
	window.setAlias(new String[]{"Finestre"});
	observationDome.getItems().add(window);

	Item wc = new Item(10, "Wc", "E’ un comune wc. “Chissà dove finiscono le mie defecazioni”.");
	wc.setAlias(new String[]{"cesso", "water"});
	toilette.getItems().add(wc);

	Item sink = new Item(11, "Lavandino", "E’ sporco di dentifricio.");
	sink.setAlias(new String[]{"Lavabo"});
	toilette.getItems().add(sink);

	Item duct = new Item(12, "Condotto", "Sembra che ci si possa passare… chissà dove porta.");
	duct.setAlias(new String[]{});
	toilette.getItems().add(duct);

	Item button = new Item(13, "Pulsante", ""); //PREMI: ""
	button.setAlias(new String[]{"Bottone"});
	escapePods.getItems().add(button);

	Item lever = new Item(14, "Leva", ""); //TIRA: ""
	lever.setAlias(new String[]{});
	escapePods.getItems().add(lever);

	Item painting = new Item(15, "Quadro", "Dei quadri raffiguranti quello che probabilmente erano il precedente comandante dell’astronave, in compagnia del suo equipaggio.");
	painting.setAlias(new String[]{});
	meetingRoom.getItems().add(painting);

	Item meetingTable = new Item(16, "Tavolo", "Un grande tavolo rotondo.");
	meetingTable.setAlias(new String[]{});
	meetingRoom.getItems().add(meetingTable);

	Item couch = new Item(16, "Divano", "Un comune divano a tre piazze.");
	couch.setAlias(new String[]{"Sofa"});
	livingRoom.getItems().add(couch);

	Item projector = new Item(17, "Proiettore", "Un proiettore di ultima generazione che trasmette immagini a 5 dimensioni.");
	projector.setAlias(new String[]{});
	livingRoom.getItems().add(projector);

	Item piano = new Item(18, "Pianoforte", "Un vecchio pianoforte in mogano, avrà un centinaio di anni..sembra funzioni ancora.");
	piano.setAlias(new String[]{"Piano"});
	captainsCabin.getItems().add(piano);

	Item guitar = new Item(19, "Chitarra", "Una chitarra acustica, non ha le corde.");
	guitar.setAlias(new String[]{});
	captainsCabin.getItems().add(guitar);

	Item microscope = new Item(20, "Microscopio", "Un microscopio ottico con zoom fino a 1500x e un limite di risoluzione teorica di circa 0,2 µm.");
	microscope.setAlias(new String[]{});
	researchLab.getItems().add(microscope);

	Item book = new Item(21, "Libro", "Un libro di biochimica.");
	book.setAlias(new String[]{"Libri"});
	researchLab.getItems().add(book);

	Item elementTable = new Item(22, "Tavola", "");
	elementTable.setAlias(new String[]{});
	researchLab.getItems().add(elementTable);

	Item numberPad2 = new Item(23, "Tastierino", "");
	numberPad2.setAlias(new String[]{"Tastiera"});
	researchLab.getItems().add(numberPad2);

	Item antenna = new Item(24, "Antenne", "Delle antenne 5G di ultimissima generazione.");
	antenna.setAlias(new String[]{"Antenna"});
	secretLab.getItems().add(antenna);

	Item bat = new Item(25, "Pipistelli", "Sembra stiano dormendo, io li lascerei in pace.");
	bat.setAlias(new String[]{"Pipistrello"});
	secretLab.getItems().add(bat);

	Item shrine = new Item(26, "Teca", "È chiusa. Sembra possa essere aperta tramite una particolare tessera.");
	shrine.setAlias(new String[]{""});
	controlRoom.getItems().add(shrine);

	//Oggetti che possono essere presi
	Item beer = new Item(27, "Birra", "Era alla ciliegia! Che schifo…");
	beer.setAlias(new String[]{""});

	Item lighter = new Item(28, "Accendino", "");
	lighter.setAlias(new String[]{"zippo"});

	Item key = new Item(29, "Chiave", "");
	key.setAlias(new String[]{""});

	Item screwdriver = new Item(30, "Cacciavite", "");
	screwdriver.setAlias(new String[]{""});

	Item card = new Item(31, "Tesserino", "");
	card.setAlias(new String[]{""});

	Item syringe = new Item(32, "Siringa", "C’è uno strano liquido fluorescente al suo interno.");
	syringe.setAlias(new String[]{""});

	Item desktop = new Item(38, "Scrivania", "");
	desktop.setAlias(new String[]{""});
	captainsCabin.getItems().add(desktop);

	// Oggetti contenitori
	ItemContainer fridge = new ItemContainer(33, "Frigorifero", "È chiuso!");
	fridge.setOpenable(true);
	fridge.setOpen(false);
	fridge.add(beer);
	kitchen.getItems().add(fridge);

	ItemContainer shelf = new ItemContainer(34, "Scaffale", "");
	shelf.setOpenable(true);
	shelf.add(lighter);
	kitchen.getItems().add(shelf);

	ItemContainer locker = new ItemContainer(35, "Armadietto", "E’ chiuso, la serratura sembra rotta. Potresti far leva con qualcosa. ");
	locker.setOpenable(true);
	locker.setOpen(false);
	warehouse.getItems().add(locker);

	ItemContainer toolbox = new ItemContainer(36, "Cassetta Attrezzi", "È una semplice cassetta degli attrezzi, forse contiene qualcosa di utile. ");
	toolbox.setOpenable(true);
	engineRoomS.getItems().add(toolbox);

	ItemContainer pic = new ItemContainer(37, "Foto", "Una normalissima foto del plurimiliardario Bill Gates, noti una tessera attaccata.");
	pic.setOpenable(true);
	pic.add(card);
	secretLab.getItems().add(pic);

    } // fine funzione "init()"

    /**
     * Prossima mossa.
     *
     * @param p
     * @param out
     */
    @Override
    public void nextMove(ParserOutput p, PrintStream out) {

	boolean moved = false; // Ho cambiato stanza (falso = no)
	boolean cardinal = false; // Si tratta di un punto cardinale (N/S/W/E) (falso = no)
	boolean closed = false; // La stanza è chiusa (falso = no)
	boolean noItem = false; // L'oggetto cercato non è nella stanza (true)

	switch (p.getCommand().getType()) { // Se il comando inserito corrisponde a...

	    case NORTH:
		if (getCurrentRoom().getNorth().isAccessible()) { // Se la stanza a nord è accessibile
		    if (getCurrentRoom().getNorth() != null) { // Se c'è una stanza a nord
			setCurrentRoom(getCurrentRoom().getNorth()); // Imposta la stanza a nord come attuale
			moved = true; // Ti sei spostato
		    }
		    cardinal = true;
		} else {
		    closed = true; // Non è accessibile
		}
		break;

	    case SOUTH:
		if (getCurrentRoom().getSouth().isAccessible()) { // Se la stanza a sud è accessibile
		    if (getCurrentRoom().getSouth() != null) { // Se c'è una stanza a sud
			setCurrentRoom(getCurrentRoom().getSouth()); // Imposta la stanza a sud come attuale
			moved = true; // Ti sei spostato
		    }
		    cardinal = true;
		} else {
		    closed = true; // Non è accessibile
		}
		break;

	    case WEST:
		if (getCurrentRoom().getWest().isAccessible()) { // Se la stanza a ovest è accessibile
		    if (getCurrentRoom().getWest() != null) { // Se c'è una stanza a ovest
			setCurrentRoom(getCurrentRoom().getWest()); // Imposta la stanza a ovest come attuale
			moved = true; // Ti sei spostato
		    }
		    cardinal = true;
		} else {
		    closed = true; // Non è accessibile
		}
		break;

	    case EAST:
		if (getCurrentRoom().getEast().isAccessible()) { // Se la stanza a est è accessibile
		    if (getCurrentRoom().getEast() != null) { // Se c'è una stanza a est
			setCurrentRoom(getCurrentRoom().getEast()); // Imposta la stanza a est come attuale
			moved = true; // Ti sei spostato
		    }
		    cardinal = true;
		} else {
		    closed = true; // Non è accessibile
		}
		break;

	    case HELP:
		help();
		break;

	    case END:
		out.println("L'avventura per te... FINISCE QUI! POLLO");
		System.exit(0);

	    case INVENTORY:
		if (getInventory().isEmpty()) { // Se l'inventario è vuoto
		    out.println("Il tuo inventario è vuoto.");
		} else { // Se l'inventario non è vuoto
		    out.println("Nel tuo inventario ci sono:");
		}
		for (Item item : getInventory()) { // Itera oggetti nell'inventario
		    out.println(item.getName()); // Nome dell'oggetto
		}
		break;

	    case LOOK:
		if (getCurrentRoom().isVisible()) { // Se la stanza è visibile (ha le luce accese)
		    if (getCurrentRoom().getLook() != null) { // Se il comando "OSSERVA" della stanza attuale contiene una descrizione
			out.println(getCurrentRoom().getLook()); // Contenuto del comando "OSSERVA"
		    } else { // Se la descrizione del comando "OSSERVA" è vuota
			out.println("Non c'è niente di interessante qui.");
		    }
		} else { // Se la stanza non è visibile (ha le luci spente)
		    out.println("Non vedo niente! La luce è spenta.");
		}
		break;

	    case EXAMINE:
		if (p.getItem() != null) { // Se l'oggetto è nella stanza
		    if (p.getItem().getDescription() != null) { // Se l'oggetto ha una descrizione
			out.println(p.getItem().getDescription()); // Descrizione dell'oggetto
		    } else {
			out.println("Niente di interessante."); // Se non ha una descrizione
		    }
		} else { // Se l'oggetto non esiste
		    noItem = true;
		}
		break;

	    case OPEN:
		if (p.getItem() != null) { // Se l'oggetto è nella stanza
		    if (p.getItem().isOpenable()) { // Se l'oggetto è apribile
			if (p.getItem().isOpen()) { // Se l'oggetto è aperto
			    // TODO: Mostra contenuto
			} else { // Se l'oggetto è chiuso
			    // if (richiede oggetto chiave) {
				// if (possiedi oggetto chiave) {
				    // p.getItem().setOpen(true); // Cambio lo stato dell'oggetto in aperto
				    // out.println("Sei riuscito ad aprire: " + p.getItem().getName() + " con" + %chiave);
				// } else { // Non possiedi oggetto chiave
				    // out.println("Al momento non sei in grado di aprire questo oggetto.");
				// }
			    // } else { // Se non richiede oggetto chiave
				// p.getItem().setOpen(true); // Cambio lo stato dell'oggetto in aperto
				// out.println("Hai aperto: " + p.getItem().getName());
			    // }
			}
		    } else { // Se l'oggetto non è apribile
			out.println("Quest'oggetto non contiene nulla.");
		    }
		} else { // Se l'oggetto non esiste
		    noItem = true;
		}
		break;

	    case CLOSE:
		if (p.getItem() != null) { // Se l'oggetto è nella stanza
		    if (p.getItem().isOpenable()) { // Se l'oggetto è apribile
			if (p.getItem().isOpen()) { // Se l'oggetto è aperto
			    p.getItem().setOpen(false); // Cambio lo stato dell'oggetto in chiuso
			} else { // Se l'oggetto è chiuso
			    out.println("Quest'oggetto è già chiuso.");
			}
		    } else { // Se l'oggetto non è apribile
			out.println("Quest'oggetto non contiene nulla.");
		    }
		} else { // Se l'oggetto non esiste
		    noItem = true;
		}
		break;
		
	    case TAKE:
		if (p.getItem() != null) { // Se l'oggetto è nella stanza
		    if (p.getItem().isTakeable()) { // Se l'oggetto si può prendere
			getCurrentRoom().getItems().remove(p.getItem()); // Rimuovi oggetto dalla stanza corrente
			getInventory().add(p.getItem()); // Aggiungi oggetto all'inventario
		    } else { // Se l'oggetto non si può prendere
			out.println("Non puoi raccogliere questo oggetto.");
		    }
		} else { // Se l'oggetto non esiste
		    noItem = true;
		}
		break;

	    case USE:
		if (p.getItem() != null || p.getInventoryItem() != null) { // Se l'oggetto è nella stanza o nell'inventario
		    if (p.getItem().isUsable()) { // Se l'oggetto si può utilizzare
			// TODO: Esegui azione
		    } else { // Se l'oggetto non si può utilizzare
			out.println("Non puoi utilizzare questo oggetto.");
		    }
		} else { // Se l'oggetto non esiste
		    noItem = true;
		}
		break;

	    case PUSH:
		if (p.getItem() != null) { // Se l'oggetto è nella stanza
		    if (p.getItem().isPushable()) { // Se si può premere
			// TODO: Esegui azione
		    } else { // Se non si può premere
			out.println("Non puoi farlo.");
		    }
		} else { // Se l'oggetto non esiste
		    noItem = true;
		}
		break;

	    case PULL:
		if (p.getItem() != null) { // Se l'oggetto è nella stanza
		    if (p.getItem().isPullable()) { // Se si può tirare
			// TODO: Esegui azione
		    } else { // Se non si può tirare
			out.println("Non puoi farlo.");
		    }
		} else { // Se l'oggetto non esiste
		    noItem = true;
		}
		break;
		
	    case TURN_ON:
		if (p.getItem() != null) { // Se l'oggetto è nella stanza
		    if (p.getItem().isTurnable()) { // Se si può accendere
			if (p.getItem().isTurned()) { // Se è acceso
			    out.println("È già acceso.");
			} else { // Se è spento
			    p.getItem().setTurned(true); // Cambia stato in acceso
			}
		    } else { // Se non si può accendere
			out.println("Non puoi farlo.");
		    }
		} else { // Se l'oggetto non esiste
		    noItem = true;
		}
		break;
		
	    case TURN_OFF:
		if (p.getItem() != null) { // Se l'oggetto è nella stanza
		    if (p.getItem().isTurnable()) { // Se si può accendere
			if (p.getItem().isTurned()) { // Se è acceso
			    p.getItem().setTurned(false); // Cambia stato in spento
			} else { // Se è spento
			    out.println("È già spento.");
			}
		    } else { // Se non si può accendere
			out.println("Non puoi farlo.");
		    }
		} else { // Se l'oggetto non esiste
		    noItem = true;
		}
		break;

	} // fine switch

	if (cardinal) { // Se si tratta di un punto cardinale (N/S/W/E)
	    if (moved) { // Se ti sei mosso e quindi hai cambiato stanza
		out.println(getCurrentRoom().getName()); // Nome della stanza attuale
		out.println("================================================");
		out.println(getCurrentRoom().getDescription()); // Descrizione della stanza attuale
	    } else { // Se non ti sei mosso
		//out.println("Non puoi andare da questa parte.");
		out = randomMessage(out, moved);
	    }
	}

	if (closed) { // Se la stanza è chiusa
	    out.println("La porta è chiusa a chiave!");
	}
	
	if (noItem) {
	    out.println("Non vedo l'oggetto che mi stai chiedendo.");
	}

	/*if (moved && cardinal) { // Se ti sei mosso e si tratta di un punto cardinale
	    out.println(getCurrentRoom().getName()); // Nome della stanza
	    out.println("================================================");
	    out.println(getCurrentRoom().getDescription()); // Descrizione della stanza
	} else if (!moved && cardinal) {
	    out = randomMessage(out, moved);
	    out.println("Non puoi andare da questa parte.");
	}*/
    } // fine funzione "nextMove"

    private PrintStream randomMessage(PrintStream out, boolean moved) {
	if (moved == false) {
	    Random random = new Random();
	    int randomChoice = random.nextInt(4);
	    switch (randomChoice) {
		case 0:
		    out.append("Non puoi andare da questa parte.");
		    break;
		case 1:
		    out.append("Da quella parte non si puo' andare, c'e' un muro! Non hai ancora acquisito i poteri per oltrepassare i muri...");
		    break;
		case 2:
		    out.append("Sbatti contro il muro e ti fai male al naso.");
		    break;
		case 3:
		    out.append("Ahi! Sembra che ci sia un muro qui...");
		    break;
	    }
	} else {
	    return out;
	}
	return out;
    } // fine funzione "PrintStream"

} // fine funzione principale "Game"
