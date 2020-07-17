package coup.api.deck

/**
 * Type constants for the Card domain object.
 * Created on 07/17/2020 by @benjamindburke. Last modified 07/17/2020 by @benjamindburke.
 */
enum CardType {

    AMBASSADOR("Ambassador"), ASSASSIN("Assassin"), CAPTAIN("Captain"), CONTESSA("Contessa"), DUKE("Duke")

    private final String s

    CardType(String type) {
        s = type
    }

    String toString() { s }

}