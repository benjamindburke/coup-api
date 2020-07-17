package coup.api.turn

/**
 * Type constants for the Action domain object.
 * Created on 07/17/2020 by @benjamindburke. Last modified 07/17/2020 by @benjamindburke.
 */
enum ActionType {

    AMBASSADOR("Ambassador"),
    ASSASSIN("Assassin"),
    BULLSHIT("Bullshit"),
    CAPTAIN("Captain"),
    CONTESSA("Contessa"),
    COUP("Coup"),
    DUKE("Duke"),
    FOREIGN_AID("Foreign Aid"),
    INCOME("Income"),
    NO_CONTEST("No Contest")

    private final String s

    ActionType(String type) {
        s = type
    }

    String toString() { s }

}