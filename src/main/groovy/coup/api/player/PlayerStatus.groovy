package coup.api.player

import groovy.transform.CompileStatic

/**
 * Status constants for the Player domain object.
 * Created on 07/16/2020 by @benjamindburke. Last modified 07/18/2020 by @benjamindburke.
 */
@CompileStatic
enum PlayerStatus {

    ALIVE("Alive"),
    DEAD("Dead")

    private final String s

    PlayerStatus(String status) {
        s = status
    }

    String toString() { s }
}
