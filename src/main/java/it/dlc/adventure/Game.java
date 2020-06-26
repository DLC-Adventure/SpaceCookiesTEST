/*
* SPACE COOKIES by DLC © 2020
 */
package it.dlc.adventure;

import it.dlc.adventure.parser.ParserOutput;
import it.dlc.adventure.swing.NumberPad;
import it.dlc.adventure.type.Command;
import it.dlc.adventure.type.CommandType;
import it.dlc.adventure.type.Item;
import it.dlc.adventure.type.ItemContainer;
import it.dlc.adventure.type.Room;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;

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
     * Testo di fine gioco.
     */
    public void theEnd() {
	System.out.println("FINE");
	System.exit(0);
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

	Command pick = new Command(CommandType.PICK);
	pick.setAlias(new String[]{"prendi"});
	getCommands().add(pick);

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
	kick.setAlias(new String[]{"caccia", "espelli", "manda", "scaccia", "uccidi"});
	getCommands().add(kick);

	Command sleep = new Command(CommandType.SLEEP);
	sleep.setAlias(new String[]{"dormi", "stenditi"});
	getCommands().add(sleep);

	Command exit = new Command(CommandType.EXIT);
	exit.setAlias(new String[]{"esci"});
	getCommands().add(exit);

	Command teleport = new Command(CommandType.TELEPORT);
	teleport.setAlias(new String[]{"teleport"});
	getCommands().add(teleport);

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
	module2.setAccessible(false); // Non è accessibile, è chiusa a chiave

	Room module3 = new Room(3, "Modulo 3", "Sei nel modulo 3, è simile al modulo 1.");
	module3.setLook("Vedi un tastierino numerico fissato al muro.");
	getRooms().add(module3);
	module3.setAccessible(false); // Non è accessibile, è chiusa a chiave

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

	Room engineRoomS = new Room(9, "Sala motori (sud)", "Sei nella sala motori, questa stanza mantiene attiva la navicella.");
	engineRoomS.setLook("Ci sono molteplici macchinari, qui vedi anche una cassetta degli attrezzi.");
	getRooms().add(engineRoomS);
	engineRoomS.setVisible(false); // Non è visibile, ha la luce spenta

	Room observationDome = new Room(10, "Cupola di osservazione", "Sei nella cupola di osservazione, piccolo modulo progettato per l’osservazione delle operazioni di riparazione effettuate al di fuori della navicella.");
	observationDome.setLook("Vedi 6 finestre laterali, ognuna delle quali è dotata di serrande per la protezione dalla contaminazione e dalle collisioni con detriti orbitanti.");
	getRooms().add(observationDome);

	Room toilette = new Room(11, "Toilette", "Ti trovi nella toilette. L’aria di questa stanza viene sottoposta ad processo di igienizzazione per rimuovere odori e batteri.");
	toilette.setLook("Vedi un wc e un lavandino. Affianco al lavandino vedi un condotto di aerazione.");
	getRooms().add(toilette);

	Room escapePods = new Room(12, "Capsula di salvataggio", "Sei nella capsula di salvataggio, un dispositivo di fuga installato per l’abbandono della navicella in caso di pericolo.");
	escapePods.setLook("Vedi un pulsante e una leva.");
	getRooms().add(escapePods);

	Room medicalRoom = new Room(13, "Stanza medica", "Sei nella stanza medica, fondamentale per la cura dell’equipaggio.");
	medicalRoom.setLook("Vedi un lettino utile per visitare i pazienti e una siringa.");
	getRooms().add(medicalRoom);

	Room meetingRoom = new Room(14, "Sala riunioni", "Sei nella sala riunioni, qui il comandante e l’equipaggio discutono le decisioni da prendere, ma visto che sei da solo non credo ci sia molto di cui discutere.");
	meetingRoom.setLook("Vedi un sacco di poltrone, dei quadri e un gigantesco tavolo di vetro posto al centro della stanza.");
	getRooms().add(meetingRoom);

	Room controlRoom = new Room(15, "Stanza di comando", "Sei nella stanza di comando. All’epoca gestita dal comandante, ora controllata dall’intelligenza artificiale dell’astronave.");
	controlRoom.setLook("Riesci finalmente a vedere la teca contenente i biscotti, che acquolina!");
	getRooms().add(controlRoom);

	Room livingRoom = new Room(16, "Salotto", "Sei nel salotto, stanza utilizzata frequentemente dall’ultimo comandante della navicella.");
	livingRoom.setLook("Vedi un divano e un enorme proiettore olografico.");
	getRooms().add(livingRoom);

	Room captainsCabin = new Room(17, "Cabina del comandante", "Sei nella cabina del comandante, è molto più spaziosa a differenza della tua.");
	captainsCabin.setLook("Vedi una scrivania, un pianoforte e una chitarra.");
	getRooms().add(captainsCabin);

	Room researchLab = new Room(18, "Laboratorio di ricerca", "Sei nel laboratorio di ricerca, qui venivano condotti esperimenti e altre ricerche in un ambiente a gravità zero impossibile da riprodurre sulla Terra.");
	researchLab.setLook("Vedi un microscopio, un libro e un tastierino numerico... Appesa al muro c’è anche una tavola periodica degli elementi.");
	getRooms().add(researchLab);

	Room secretLab = new Room(19, "Laboratorio segreto COVID-19", "Sei entrato in una stanza dall’aspetto molto cupo e tenebroso, sulla targhetta della porta da cui sei entrato leggi \"Laboratorio segreto COVID-19\"");
	secretLab.setLook("Il soffitto è pieno di pipistrelli e sulle pareti ci sono delle antenne. Noti anche una foto appesa al muro.");
	getRooms().add(secretLab);
	secretLab.setAccessible(false); // Non è accessibile, è chiusa a chiave

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

	crewCabin.setNorth(module1);
	crewCabin.setSouth(cafe);

	cafe.setNorth(module1);
	cafe.setEast(engineRoomS);

	engineRoomN.setWest(warehouse);

	engineRoomS.setWest(cafe);

	observationDome.setSouth(module2);

	toilette.setNorth(module2);

	escapePods.setSouth(module3);

	medicalRoom.setNorth(module3);
	medicalRoom.setWest(livingRoom);

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

	// Oggetti
	Item spaceSuit = new Item(0, "Tuta", "È una tuta spaziale, di quelle che vedi nei film.");
	spaceSuit.setAlias(new String[]{"tute"});
	airlock.getItems().add(spaceSuit); // Aggiungi alla stanza

	Item exitDoor = new Item(1, "Porta", "Un'enorme porta che si affaccia all'esterno. Non ti consiglio di uscire!");
	exitDoor.setAlias(new String[]{"portone"});
	airlock.getItems().add(exitDoor); // Aggiungi alla stanza
	exitDoor.setOpenable(true); // È apribile

	Item goodsLift = new Item(2, "Montacarichi", "Trovi un pacco di Space Amazon. Incredibile! Amazon spedisce anche nello spazio.");
	goodsLift.setAlias(new String[]{"montacarichi"});
	module1.getItems().add(goodsLift); // Aggiungi alla stanza

	Item packet = new Item(3, "Pacco", "È vuoto.");
	packet.setAlias(new String[]{});
	module1.getItems().add(packet); // Aggiungi alla stanza
	packet.setOpenable(true); // È apribile

	Item module1to2door = new Item(4, "Porta", "Ha bisogno della chiave per essere aperta.");
	module1to2door.setAlias(new String[]{"portone"});
	module1.getItems().add(module1to2door); // Aggiungi alla stanza
	packet.setOpenable(true); // È apribile

	Item numberPad = new Item(5, "Tastierino", "Necessita di un codice. Potrei provare a inserire qualche combinazione.");
	numberPad.setAlias(new String[]{"tastiera"});
	module3.getItems().add(numberPad); // Aggiungi alla stanza
	numberPad.setUsable(true); // È utilizzabile

	Item beer = new Item(6, "Birra", "Chissà che sapore ha.");
	beer.setAlias(new String[]{});
	beer.setPickupable(true); // Si può prendere
	beer.setDrinkable(true); // È bevibile

	ItemContainer fridge = new ItemContainer(7, "Frigorifero", "Chissà se c'è qualcosa di buono.");
	fridge.setAlias(new String[]{"frigo"});
	kitchen.getItems().add(fridge); // Aggiungi alla stanza
	fridge.add(beer); // Aggiungi nell'oggetto contenitore
	fridge.setOpenable(true); // È apribile

	Item shelf = new Item(8, "Scaffali", "Vedi un ripiano con un accendino.");
	shelf.setAlias(new String[]{"scaffale"});
	kitchen.getItems().add(shelf); // Aggiungi alla stanza

	Item lighter = new Item(9, "Accendino", "Se acceso emette luce! Che innovazione tecnologica.");
	lighter.setAlias(new String[]{"zippo", "clipper"});
	kitchen.getItems().add(lighter); // Aggiungi alla stanza
	lighter.setPickupable(true); // Si può prendere
	lighter.setUsable(true); // Si può utilizzare

	Item kitchenTable = new Item(10, "Tavolo", "Non c'è niente.");
	kitchenTable.setAlias(new String[]{});
	kitchen.getItems().add(kitchenTable); // Aggiungi alla stanza

	Item key = new Item(11, "Chiave", "Una chiave! Chissà cosa apre.");
	key.setAlias(new String[]{});
	key.setPickupable(true); // Si può prendere
	key.setUsable(true); // Si può utilizzare

	ItemContainer locker = new ItemContainer(12, "Armadietto", "È chiuso, ma la serratura sembra rotta. Potresti far leva con qualcosa.");
	locker.setAlias(new String[]{"armadio"});
	warehouse.getItems().add(locker); // Aggiungi alla stanza
	locker.add(key); // Aggiungi nell'oggetto contenitore
	locker.setOpenable(false); // Non è apribile

	Item bed = new Item(13, "Letto", "Comodi letti in lattice, il tuo ha le lenzuola rosa... Quasi quasi viene voglia di farti una pennichella.");
	bed.setAlias(new String[]{"letti"});
	crewCabin.getItems().add(bed); // Aggiungi alla stanza

	Item barCounter = new Item(14, "Bancone", "Ci sono dei bicchieri da cocktail usati.");
	barCounter.setAlias(new String[]{});
	cafe.getItems().add(barCounter); // Aggiungi alla stanza
	barCounter.setCleanable(true); // Si può pulire

	Item glass = new Item(15, "Bicchiere", "È sporco, ha un odore di menta e lime.");
	glass.setAlias(new String[]{"Bicchieri"});
	cafe.getItems().add(glass); // Aggiungi alla stanza
	glass.setCleanable(true); // Si può pulire

	Item engine = new Item(16, "Motori", "I motori utilizzano una particolare miscela di idrogeno e delle celle ad energia solare. Sembra davvero innovativa!");
	engine.setAlias(new String[]{"motore", "macchinario", "macchinari"});
	engineRoomN.getItems().add(engine); // Aggiungi alla stanza
	engineRoomS.getItems().add(engine); // Aggiungi alla stanza

	Item screwdriver = new Item(17, "Cacciavite", "Un cacciavite, non è neanche automatico, però potrebbe tormarmi utile!");
	screwdriver.setAlias(new String[]{"giravite"});
	screwdriver.setPickupable(true); // Si può prendere
	screwdriver.setUsable(true); // Si può utilizzare

	ItemContainer toolbox = new ItemContainer(18, "Cassetta", "Una semplice cassetta degli attrezzi, forse contiene qualcosa di utile.");
	toolbox.setAlias(new String[]{});
	engineRoomS.getItems().add(toolbox); // Aggiungi alla stanza
	toolbox.add(screwdriver); // Aggiungi nell'oggetto contenitore
	toolbox.setOpenable(true); // È apribile

	Item window = new Item(19, "Finestra", "Che vista spettacolare, da qui riesci a vedere anche il pianeta Terra.");
	window.setAlias(new String[]{"finestre"});
	observationDome.getItems().add(window); // Aggiungi alla stanza

	Item wc = new Item(20, "Wc", "Un comune water. Chissà dove finiscono le mie defecazioni.");
	wc.setAlias(new String[]{"cesso", "water", "gabinetto"});
	toilette.getItems().add(wc); // Aggiungi alla stanza
	wc.setCleanable(true); // Si può pulire

	Item sink = new Item(21, "Lavandino", "È sporco di dentifricio.");
	sink.setAlias(new String[]{"lavabo"});
	toilette.getItems().add(sink); // Aggiungi alla stanza
	wc.setCleanable(true); // Si può pulire

	Item duct = new Item(22, "Condotto", "Sembra che ci si possa passare... chissà dove porta.");
	duct.setAlias(new String[]{});
	toilette.getItems().add(duct); // Aggiungi alla stanza
	duct.setWalkable(true); // Si può attraversare

	Item button = new Item(23, "Pulsante", "Un enorme pulsante rosso."); // PREMI
	button.setAlias(new String[]{"bottone"});
	escapePods.getItems().add(button); // Aggiungi alla stanza
	button.setPushable(true); // Si può premere

	Item lever = new Item(24, "Leva", "Una leva di medie dimensioni."); // TIRA
	lever.setAlias(new String[]{});
	escapePods.getItems().add(lever); // Aggiungi alla stanza
	lever.setPullable(true); // Si può tirare

	Item medicalBed = new Item(25, "Lettino", "È fatto di spugna, niente di eccezionale");
	medicalBed.setAlias(new String[]{});
	medicalRoom.getItems().add(medicalBed); // Aggiungi alla stanza

	Item syringe = new Item(26, "Siringa", "C’è uno strano liquido fluorescente al suo interno.");
	syringe.setAlias(new String[]{});
	medicalRoom.getItems().add(syringe); // Aggiungi alla stanza
	syringe.setPickupable(true); // Si può prendere
	syringe.setUsable(true); // Si può utilizzare

	Item armchair = new Item(27, "Poltrona", "Un sacco di poltrone color arcobaleno, sembrano molto comode...");
	armchair.setAlias(new String[]{"poltrone"});
	meetingRoom.getItems().add(armchair); // Aggiungi alla stanza

	Item painting = new Item(28, "Quadro", "Dei quadri raffiguranti quello che probabilmente erano il precedente comandante dell’astronave, in compagnia del suo equipaggio.");
	painting.setAlias(new String[]{"quadri"});
	meetingRoom.getItems().add(painting); // Aggiungi alla stanza

	Item glassTable = new Item(29, "Tavolo", "Un gigantesca tavolo di vetro, ha l'aria di essere molto fragile.");
	glassTable.setAlias(new String[]{});
	meetingRoom.getItems().add(glassTable); // Aggiungi alla stanza

	Item shrine = new Item(30, "Teca", "È chiusa. Sembra possa essere aperta tramite una particolare tessera.");
	shrine.setAlias(new String[]{});
	controlRoom.getItems().add(shrine); // Aggiungi alla stanza
	shrine.setOpenable(true); // È apribile

	Item couch = new Item(31, "Divano", "Un bizzarro divano a 7 piazze.");
	couch.setAlias(new String[]{"sofa"});
	livingRoom.getItems().add(couch); // Aggiungi alla stanza

	Item projector = new Item(32, "Proiettore", "Un proiettore di ultima generazione che trasmette immagini a 5 dimensioni.");
	projector.setAlias(new String[]{});
	livingRoom.getItems().add(projector); // Aggiungi alla stanza

	Item desktop = new Item(33, "Scrivania", ""); // TODO: "Esamina" mostra la foto dei plettri
	desktop.setAlias(new String[]{});
	captainsCabin.getItems().add(desktop); // Aggiungi alla stanza

	Item piano = new Item(34, "Pianoforte", "Un vecchio pianoforte in mogano, avrà un centinaio di anni... Sembra funzioni ancora.");
	piano.setAlias(new String[]{"piano"});
	captainsCabin.getItems().add(piano); // Aggiungi alla stanza
	piano.setPlayable(true); // Si può leggere

	Item guitar = new Item(35, "Chitarra", "Una chitarra acustica, non ha le corde.");
	guitar.setAlias(new String[]{});
	captainsCabin.getItems().add(guitar); // Aggiungi alla stanza
	guitar.setPlayable(true); // È suonabile

	Item microscope = new Item(36, "Microscopio", "Un microscopio ottico con zoom fino a 1500x e un limite di risoluzione teorica di circa 0,2 µm.");
	microscope.setAlias(new String[]{});
	researchLab.getItems().add(microscope); // Aggiungi alla stanza
	microscope.setUsable(true); // È utilizzabile

	Item book = new Item(37, "Libro", "Un libro di biochimica.");
	book.setAlias(new String[]{"libri"});
	researchLab.getItems().add(book); // Aggiungi alla stanza
	book.setReadable(true); // Si può leggere

	Item elementTable = new Item(38, "Tavola", ""); // TODO: "Esamina" mostra l'immagine (swing)
	elementTable.setAlias(new String[]{});
	researchLab.getItems().add(elementTable); // Aggiungi alla stanza

	Item bat = new Item(39, "Pipistelli", "Sembra stiano dormendo, io li lascerei in pace.");
	bat.setAlias(new String[]{"pipistrello"});
	secretLab.getItems().add(bat); // Aggiungi alla stanza
	bat.setKickable(true); // È caccabile

	Item antenna = new Item(40, "Antenne", "Delle antenne 5G di ultimissima generazione.");
	antenna.setAlias(new String[]{"antenna"});
	secretLab.getItems().add(antenna); // Aggiungi alla stanza

	ItemContainer photo = new ItemContainer(41, "Foto", "Una normalissima foto del plurimiliardario Bill Gates, noti una tessera attaccata.");
	photo.setAlias(new String[]{});
	secretLab.getItems().add(photo); // Aggiungi alla stanza

	Item card = new Item(42, "Tessera", "Sembra si possa prendere, qui sopra c'è scritto \"Stanza di comando\".");
	card.setAlias(new String[]{"tesserino"});
	secretLab.getItems().add(card); // Aggiungi alla stanza
	card.setPickupable(true); // Si può prendere
	card.setUsable(true); // Si può utilizzare

	Item chair = new Item(43, "Sedia", "Niente di interessante.");
	chair.setAlias(new String[]{"sedie"});
	kitchen.getItems().add(chair); // Aggiungi alla stanza

	// Stanza di INIZIO GIOCO
	setCurrentRoom(module1);

    } // fine funzione "init()"

    /**
     * Prossima mossa.
     *
     * @param p
     * @param out
     */
    @Override
    public void nextMove(ParserOutput p, PrintStream out) {

	byte move = 0; // 1: hai cambiato stanza, 2: è chiusa a chiave, 3: c'è un muro
	boolean noItem = false; // L'oggetto cercato non è nella stanza (true)

	switch (p.getCommand().getType()) { // Se il comando inserito corrisponde a...

	    case NORTH:
		if (getCurrentRoom().getNorth() != null) { // Se c'è una stanza a nord
		    if (getCurrentRoom().getNorth().isAccessible()) { // Se la stanza a nord è accessibile
			setCurrentRoom(getCurrentRoom().getNorth()); // Imposta la stanza a nord come attuale
			move = 1; // Hai cambiato stanza
		    } else {
			move = 2; // È chiusa a chiave
		    }
		} else {
		    move = 3; // C'è un muro
		}
		break;

	    case SOUTH:
		if (getCurrentRoom().getSouth() != null) { // Se c'è una stanza a sud
		    if (getCurrentRoom().getSouth().isAccessible()) { // Se la stanza a sud è accessibile
			setCurrentRoom(getCurrentRoom().getSouth()); // Imposta la stanza a sud come attuale
			move = 1; // Hai cambiato stanza
		    } else {
			move = 2; // È chiusa a chiave
		    }
		} else {
		    move = 3; // C'è un muro
		}
		break;

	    case WEST:
		if (getCurrentRoom().getWest() != null) { // Se c'è una stanza a ovest

		    // Se la stanza a ovest di quella attuale ha l'ID uguale a 13 (stanza medica)
		    if (getCurrentRoom().getWest().getId() == 13) {
			getCurrentRoom().getWest().getNorth().setAccessible(true); // La stanza "modulo 3" diventa accessibile
		    }

		    if (getCurrentRoom().getWest().isAccessible()) { // Se la stanza a ovest è accessibile
			setCurrentRoom(getCurrentRoom().getWest()); // Imposta la stanza a ovest come attuale
			move = 1; // Hai cambiato stanza
		    } else {
			move = 2; // È chiusa a chiave
		    }
		} else {
		    move = 3; // C'è un muro
		}
		break;

	    case EAST:
		if (getCurrentRoom().getEast() != null) { // Se c'è una stanza a est
		    if (getCurrentRoom().getEast().isAccessible()) { // Se la stanza a est è accessibile
			setCurrentRoom(getCurrentRoom().getEast()); // Imposta la stanza a est come attuale
			move = 1; // Hai cambiato stanza
		    } else {
			move = 2; // È chiusa a chiave
		    }
		} else {
		    move = 3; // C'è un muro
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
			out.println("Hai aperto: " + p.getItem().getName()); // Nome dell'oggetto

			if (p.getItem() instanceof ItemContainer) { // Se l'oggetto è di tipo contenitore

			    ItemContainer container = (ItemContainer) p.getItem(); // Istanzio l'oggetto contenitore

			    if (!container.getList().isEmpty()) { // Se l'oggetto contenitore non è vuoto
				out.println("Al suo interno vedi:"); // Nome dell'oggetto contenitore

				Iterator<Item> it = container.getList().iterator(); // Contenuto dell'oggetto contenitore

				while (it.hasNext()) { // Fintantoché l'oggetto ha un suo successivo
				    Item nextItem = it.next(); // Restituisci l'elemento successivo
				    getCurrentRoom().getItems().add(nextItem); // Aggiungi oggetto alla stanza attuale
				    out.println("- " + nextItem.getName()); // Nome dell'oggetto
				    it.remove(); // Rimuovi dalla lista
				}

			    } else { // Se l'oggetto contenitore è vuoto
				out.println("È vuoto.");
			    }

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
			out.println("Non puoi farlo.");
		    }
		} else { // Se l'oggetto non esiste
		    noItem = true;
		}
		break;

	    case PICK:
		if (p.getItem() != null) { // Se l'oggetto è nella stanza
		    if (p.getItem().isPickupable()) { // Se l'oggetto si può prendere
			getCurrentRoom().getItems().remove(p.getItem()); // Rimuovi oggetto dalla stanza corrente
			getInventory().add(p.getItem()); // Aggiungi oggetto all'inventario
			out.println("Hai preso: " + p.getItem().getName());
		    } else {
			out.println("Non puoi raccogliere questo oggetto.");
		    }
		} else { // Se l'oggetto non esiste
		    noItem = true;
		}
		break;

	    case USE:
		if (p.getItem() != null) { // Se l'oggetto è nella stanza (non ha bisogno di ID oggetto)

		    if (p.getItem().isUsable()) { // Se l'oggetto si può utilizzare

			switch (p.getInventoryItem().getId()) { // Se l'ID dell'oggetto è uguale a...
			    case 3:
				// Tastierino numerico (ID: 3)

				if (getCurrentRoom().getId() == 1) { // Se la stanza attuale è il modulo 3 (ID: 3)

				    String password = "1234";
				    String inputPassword = "0000"; // TODO: Password inserita nella swing

				    NumberPad tastierino = new NumberPad();
				    tastierino.setVisible(true);
				    tastierino.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				    if (inputPassword.equals(password)) { // Se la password inserita è uguale a quella richiesta
					getCurrentRoom().getWest().setAccessible(true); // La stanza "Sala riunioni" diventa accessibile
					getCurrentRoom().getItems().remove(p.getItem()); // Rimuovo il tastierino dalla stanza
					out.println("Hai aperto la porta!");
				    }

				} else if (getCurrentRoom().getId() == 1) { // Se la stanza attuale è il laboratorio di ricerca (ID: 18)

				    String password = "5678";
				    String inputPassword = "0000"; // TODO: Password inserita nella swing

				    NumberPad tastierino = new NumberPad();
				    tastierino.setVisible(true);
				    tastierino.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				    if (inputPassword.equals(password)) { // Se la password inserita è uguale a quella richiesta
					getCurrentRoom().getNorth().setAccessible(true); // La stanza "Laboratorio segreto" diventa accessibile
					getCurrentRoom().getItems().remove(p.getItem()); // Rimuovo il tastierino dalla stanza
					out.println("Hai aperto la porta!");
				    }

				}

				break;
			    case 36:
				// Microscopio (ID: 36)
				out.println("Non è messo a fuoco, non sei un ricercatore, lascia perdere.");
				break;
			    default:
				out.println("Non hai niente in mano.");
				break;
			}

		    } else { // Se l'oggetto non si può utilizzare
			out.println("Non puoi utilizzare questo oggetto.");
		    }

		} else if (p.getInventoryItem() != null) { // Se l'oggetto è nell'inventario (ha bisogno di ID stanza)

		    if (p.getInventoryItem().isUsable()) { // Se l'oggetto si può utilizzare

			if (p.getInventoryItem().getId() == 26) { // Se l'ID dell'oggetto è uguale a 26 (siringa)
			    out.println("Inizi a vedere tutto verde, il tuo corpo si gonfia, i tuoi vestiti si strappano..."
				    + "La tua massa corporea diventa superiore a quella della navicella provocando un'enorme esplosione."
				    + "SEI MORTO.");
			    System.exit(0);
			}

			switch (getCurrentRoom().getId()) { // Se l'ID della stanza attuale è uguale a...
			    case 1:
				// Modulo 1 (ID: 1)
				if (p.getInventoryItem().getId() == 11) { // Se nell'inventario ho la chiave (11)
				    getCurrentRoom().getWest().setAccessible(true); // La stanza "modulo 2" diventa accessibile
				    getInventory().remove(p.getInventoryItem()); // Rimuovo la chiave dall'inventario
				    out.println("Hai aperto la porta!");
				} else { // Se non hai la chiave
				    out.println("Non hai la chiave.");
				}
				break;
			    case 5:
				// Stiva (ID: 5)
				if (p.getInventoryItem().getId() == 17) { // Se nell'inventario ho il cacciavite (17)
				    getCurrentRoom().getItems().get(12).setOpenable(true); // Rendo l'armadietto (12) apribile
				    // TODO: Non funziona

				    out.println("Hai forzato l'armadietto!");
				} else {
				    out.println("Non hai niente con cui poter forzare la serratura");
				}
				//
				break;
			    case 9:
				// Motori Sud (ID: 9)
				if (p.getInventoryItem().getId() == 9) { // Se nell'inventario ho l'accendino (9)
				    getCurrentRoom().setVisible(true); // La stanza diventa visibile (luce accesa)
				    out.println("Ora riesco a vedere!");
				    out.println("Noto la presenza di molteplici macchinari, qui vedo anche una cassetta degli attrezzi.");
				}
				break;
			    case 15:
				// Stanza di comando (ID: 15)
				if (p.getInventoryItem().getId() == 9) { // Se nell'inventario ho la tessera (42)
				    theEnd(); // Fine del gioco.
				}
				break;
			    default:
				out.println("Non puoi utilizzare qui questo oggetto.");
				break;
			}

		    } else { // Se l'oggetto non si può utilizzare
			out.println("Non puoi utilizzare questo oggetto.");
		    }

		} else { // Se l'oggetto non è né nella stanza, né nell'inventario
		    noItem = true;
		}
		break;

	    case PUSH:
		if (p.getItem() != null) { // Se l'oggetto è nella stanza
		    if (p.getItem().isPushable()) { // Se si può premere

			if (p.getItem().getId() == 13) { // Se si tratta dell'oggetto con ID 13 (pulsante)
			    out.println("La capsula di salvataggio viene immediatamente espulsa, vaghi nello spazio. Spera che qualcuno si accorga di te. Buona fortuna.");
			    System.exit(0);
			}

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

			if (p.getItem().getId() == 14) { // Se si tratta dell'oggetto con ID 14 (leva)
			    out.println("Hai acceso l’aria condizionata, brrr...");
			}

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

	    case WALK_TO:
		if (p.getItem() != null) { // Se l'oggetto è nella stanza
		    if (p.getItem().isWalkable()) { // Se è attraversabile
			setCurrentRoom(getCurrentRoom().getWest()); // Imposta la stanza a ovest come attuale
			move = 1; // Hai cambiato stanza
		    } else { // Se non si può attraversare
			out.println("Non puoi farlo.");
		    }
		} else { // Se l'oggetto non esiste
		    noItem = true;
		}
		break;

	    case DRINK:
		if (p.getInventoryItem() != null) { // Se l'oggetto è nella stanza o nell'inventario
		    if (p.getInventoryItem().isDrinkable()) { // Se è bevibile
			if (p.getInventoryItem().getId() == 6) { // Se si tratta dell'oggetto birra (6)
			    out.println("Era alla ciliegia! Che schifo...");
			    getInventory().remove(p.getInventoryItem());
			}
		    } else { // Se non si può bere
			out.println("Non puoi farlo.");
		    }
		} else { // Se l'oggetto non esiste
		    noItem = true;
		}
		break;

	    case CLEAN:
		if (p.getItem() != null) { // Se l'oggetto è nella stanza
		    if (p.getItem().isCleanable()) { // Se è pulibile
			out.println("Non mi va! Lo farò più tardi...");
		    } else { // Se non si può pulire
			out.println("Non puoi farlo.");
		    }
		} else { // Se l'oggetto non esiste
		    noItem = true;
		}
		break;

	    case PLAY:
		if (p.getItem() != null) { // Se l'oggetto è nella stanza
		    if (p.getItem().isPlayable()) { // Se è giocabile-suonabile

			if (p.getItem().getId() == 34) { // Se l'oggetto è il pianoforte (34)
			    out.println("Stai suonando \"Clair de lune\" di Debussy. Quando hai imparato a farlo?");
			} else if (p.getItem().getId() == 35) {
			    out.println("Senza corde mi sembra difficile...");
			}

		    } else { // Se non si può giocare
			out.println("Non puoi farlo.");
		    }
		} else { // Se l'oggetto non esiste
		    noItem = true;
		}
		break;

	    case READ:
		if (p.getItem() != null) { // Se l'oggetto è nella stanza
		    if (p.getItem().isReadable()) { // Se è leggibile

			if (p.getItem().getId() == 37) { // Se l'oggetto è il libro (37)
			    out.println("Vedi solo formule organiche, non capisci niente di questa materia.");
			}

		    } else { // Se non si può leggere
			out.println("Non puoi farlo.");
		    }
		} else { // Se l'oggetto non esiste
		    noItem = true;
		}
		break;

	    case KICK:
		if (p.getItem() != null) { // Se l'oggetto è nella stanza
		    if (p.getItem().isKickable() && getCurrentRoom().getId() == 19) { // Se è caccabile e ti trovi nel laboratorio segreto (19)
			out.println("Si innervosiscono, ti attaccano in massa, ti trasmettono il Covid… E MUORI.");
			System.exit(0);
		    } else { // Se non si può cacciare
			out.println("Cosa stai cercando di fare?");
		    }
		} else { // Se l'oggetto non esiste
		    noItem = true;
		}
		break;

	    case SLEEP:
		// Se ti trovi nella cabina dell'equipaggio (6), stanza medica (13) o salotto (16)
		if (getCurrentRoom().getId() == 6 || getCurrentRoom().getId() == 13 || getCurrentRoom().getId() == 16) {
		    out.println("Ti sembra il momento?!");
		} else {
		    out.println("Vuoi farti un pisolino sul pavimento?");
		}
		break;

	    case EXIT:
		if (getCurrentRoom().getId() == 0) { // Se ti trovi nella camera di equilibrio (ID = 0)
		    out.println("La porta si sta aprendo... Vieni risucchiato all'esterno dell'astronave, il tuo cervello esplode... E MUORI.\n"
			    + "Il tuo corpo fluttuerà per sempre nello spazio più profondo.");
		    System.exit(0);
		}
		break;

	    case TELEPORT:

		Scanner cheat = new Scanner(System.in);
		out.println("Inserisci il punto cardinale: ");
		String cardinal = cheat.next().toUpperCase();
		
		switch (cardinal) {
		    case "N":
			if (getCurrentRoom().getNorth() != null) { // Se c'è una stanza a nord
			    setCurrentRoom(getCurrentRoom().getNorth()); // Imposta la stanza a nord come attuale
			    move = 1; // Hai cambiato stanza
			} else {
			    move = 3; // C'è un muro
			}
			break;
		    case "S":
			if (getCurrentRoom().getSouth() != null) { // Se c'è una stanza a sud
			    setCurrentRoom(getCurrentRoom().getSouth()); // Imposta la stanza a nord come attuale
			    move = 1; // Hai cambiato stanza
			} else {
			    move = 3; // C'è un muro
			}
			break;
		    case "W":
			if (getCurrentRoom().getWest() != null) { // Se c'è una stanza a ovest
			    setCurrentRoom(getCurrentRoom().getWest()); // Imposta la stanza a nord come attuale
			    move = 1; // Hai cambiato stanza
			} else {
			    move = 3; // C'è un muro
			}
			break;
		    case "E":
			if (getCurrentRoom().getEast() != null) { // Se c'è una stanza a est
			    setCurrentRoom(getCurrentRoom().getEast()); // Imposta la stanza a nord come attuale
			    move = 1; // Hai cambiato stanza
			} else {
			    move = 3; // C'è un muro
			}
			break;
		    default:
			out.println("Non consentito.");
			break;
		} // fine switch "cardinal"
		
		out.println("================================================");
		break;

	} // fine switch

	switch (move) {
	    case 1:
		// Se ti sei mosso e quindi hai cambiato stanza
		//out.println(getCurrentRoom().getName()); // Nome della stanza attuale
		//out.println("================================================");
		out.println(getCurrentRoom().getDescription()); // Descrizione della stanza attuale
		break;
	    case 2:
		// Se la stanza è chiusa
		out.println("La porta è chiusa a chiave!");
		break;
	    case 3:
		// Se c'è un muro
		out = randomMessage(out, move); // Mostra messaggio randomico
		break;
	    default:
		break;
	}

	if (noItem) {
	    out.println("Non vedo l'oggetto che mi stai chiedendo.");
	}

    } // fine funzione "nextMove"

    private PrintStream randomMessage(PrintStream out, byte move) {

	if (move == 3) { // Se c'è un muro

	    Random random = new Random();
	    int randomChoice = random.nextInt(4);

	    switch (randomChoice) {
		case 0:
		    out.append("C'è un muro da quella parte.\n");
		    break;
		case 1:
		    out.append("Da quella parte non si puo' andare, c'è un muro!\n");
		    break;
		case 2:
		    out.append("Ahi! Sembra che ci sia un muro qui...\n");
		    break;
		case 3:
		    out.append("Ho preso il muro fratellì!\n");
		    break;
	    }

	}

	return out;

    } // fine funzione "PrintStream"

} // fine funzione principale "Game"
