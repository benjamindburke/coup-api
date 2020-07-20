package coup.api.game

import groovy.transform.CompileStatic

/**
 * Status constants for the Game domain object.
 * Created on 07/16/2020 by @benjamindburke. Last modified 07/18/2020 by @benjamindburke.
 */
@CompileStatic
enum GameStatus {

    NOT_STARTED("Not Started"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed")

    private final String s

    GameStatus(String status) {
        s = status
    }

    String toString() { s }
}
