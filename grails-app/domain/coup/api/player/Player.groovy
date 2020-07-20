package coup.api.player

import coup.api.game.Game
import grails.gorm.transactions.NotTransactional

/**
 * Player class for the Coup game.
 * Created on 07/16/2020 by @benjamindburke. Last modified 07/20/2020 by @benjamindburke.
 */
class Player {

/********************************************************
 *      Attributes                                      *
 ********************************************************/

    /** Unique identifier to distinguish the player's device from other players. */
    String playerId

    /** Number 1-6 that determines the player's order once the turn starts. */
    Integer turnOrder

    /** The player's displayed nickname. 1-40 characters. */
    String nickname

    /** The time of the last received action. Determines whether the player's session is still active. */
    Long lastActive

    /**
     * The status of the game.
     * Values: [ALIVE, DEAD]
     */
    PlayerStatus status

    /** Whether the player is the winner. */
    Boolean winner

    /** The player's first card. */
    BigInteger cardID1

    /** The player's second card. */
    BigInteger cardID2

/********************************************************
 *      GORM Relationships & Constraints                *
 ********************************************************/

    /** Database & data binding constraints. */
    static constraints = {
        playerId blank: false, bindable: true, nullable: false, size: 1..100
        turnOrder blank: false, bindable: false, nullable: false, inList: 1..6
        nickname blank: false, bindable: true, nullable: false, size: 1..40
        lastActive blank: true, bindable: false, nullable: false
        status blank: false, bindable: false, nullable: false
        cardID1 blank: false, bindable: false, nullable: true
        cardID2 blank: false, bindable: false, nullable: true
    }

    /** Domain objects that own the Player class. */
    static belongsTo = [
        game: Game
    ]

    /** One-to-many relationships between Player objects and other domain classes. Uncomment to use. */
    // static hasMany = [
    //
    // ]

    /** One-to-one relationships between Player objects and other domain classes. Uncomment to use. */
    // static hasOne = [
    //
    // ]

    /** Custom attribute mapping for Player attributes if necessitated by other domain objects. Uncomment to use. */
    // static mapping = {
    //
    // }

/********************************************************
 *      Accessor functions                              *
 ********************************************************/

    /**
     * Check if the player is still active.
     * @return Boolean
     */
    @NotTransactional
    Boolean getIsActive() {

        // The player is active if they are still alive and the
        //     last received action was less than 5 minutes ago
        isAlive && (lastActive >= System.currentTimeMillis() - 300000)  // 5 min. in ms
    }

    /**
     * Check if the player is still in the game.
     * @return Boolean
     */
    @NotTransactional
    Boolean getIsAlive() {

        status == PlayerStatus.ALIVE
    }

/********************************************************
 *      Convenience functions                           *
 ********************************************************/



}
