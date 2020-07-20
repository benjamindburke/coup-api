package coup.api.action

import groovy.transform.CompileStatic

/**
 * Type constants for the Action domain object.
 * Created on 07/17/2020 by @benjamindburke. Last modified 07/18/2020 by @benjamindburke.
 */
@CompileStatic
enum ActionType {

    AMBASSADOR("Exchange"),
    ASSASSIN("Assassinate"),
    BLOCK("Block"),
    BULLSHIT("Bullshit"),
    CAPTAIN("Steal"),
    COUP("Coup"),
    DUKE("Tax"),
    FOREIGN_AID("Foreign Aid"),
    INCOME("Income"),
    CONCEDE("Concede")

    private final String s

    ActionType(String type) {
        s = type
    }

    String toString() { s }

}