/*
 * SPACE COOKIES by DLC © 2020
 */
package it.uniba.dlc.type;

/**
 * Elenco dei tipi di comando presenti nel gioco.
 */
public enum CommandType {
    NORD, SOUTH, WEST, EAST,
    HELP,
    INVENTORY,
    LOOK, // Osserva
    EXAMINE, // Esamina (oggetto)
    TAKE, // Prendi (oggetto)
    END, OPEN, CLOSE, PUSH, PULL, WALK_TO, PICK_UP, TALK_TO, GIVE, USE, LOOK_AT, TURN_ON, TURN_OFF
}
