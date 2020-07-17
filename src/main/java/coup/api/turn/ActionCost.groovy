package coup.api.turn

/**
 * Cost constants for the Action domain object.
 * Created on 07/17/2020 by @benjamindburke. Last modified 07/17/2020 by @benjamindburke.
 */
enum ActionCost {

    AMBASSADOR(0),
    ASSASSIN(-3),
    BULLSHIT( 0),
    CAPTAIN(2),
    CONTESSA(0),
    COUP(-7),
    DUKE(3),
    FOREIGN_AID(2),
    INCOME(1),
    NO_CONTEST(0)

    private final Integer c

    ActionCost(Integer cost) {
        c = cost
    }

    Integer toInteger() { c }

}