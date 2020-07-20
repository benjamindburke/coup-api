package coup.api.deck

import groovy.transform.CompileStatic

/**
 * Status constants for the Card domain object.
 * Created on 07/17/2020 by @benjamindburke. Last modified 07/18/2020 by @benjamindburke.
 */
@CompileStatic
enum CardStatus {

    DECK("Deck"),
    HAND("Hand"),
    KILLED("Killed")

    private final String s

    CardStatus(String status) {
        s = status
    }

    String toString() { s }
}
