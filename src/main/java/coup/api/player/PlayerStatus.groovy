package coup.api.player

/**
 * Status constants for the Player domain object.
 * Created on 07/16/2020 by @benjamindburke. Last modified 07/17/2020 by @benjamindburke.
 */
enum PlayerStatus {

    ALIVE("Alive"), DEAD("Dead")

    private final String s

    PlayerStatus(String status) {
        s = status
    }

    String toString() { s }
}
