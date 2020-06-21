/*
 * SPACE COOKIES by DLC © 2020
 */
package it.uniba.dlc.type;

/**
 * Elenco dei tipi di comando presenti nel gioco.
 */
public enum CommandType {
    NORTH, SOUTH, WEST, EAST,
    HELP,
    END,
    INVENTORY,
    LOOK, EXAMINE,
    TAKE, USE,
    OPEN, CLOSE,
    PUSH, PULL,
    WALK_TO, TALK_TO, TURN_ON, TURN_OFF
}
