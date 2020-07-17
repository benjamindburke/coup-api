package coup.api.game

import coup.api.player.Player
import grails.gorm.transactions.NotTransactional

/**
 * Game class for the Coup game.
 * Created on 07/16/2020 by @benjamindburke. Last modified 07/17/2020 by @benjamindburke.
 */
class Game {

/********************************************************
 *      Attributes                                      *
 ********************************************************/

    /** Unique UUID identifier in the database. */
    String id

    /** Short, 5-character Game ID used to connect to the game. */
    String gameId

    /** Datetime when the game was created. */
    Long dateCreated

    /** Datetime when the game started. Game can only start once a minimum of 3 players join. */
    Long dateStarted

    /** Datetime when the game was completed. */
    Long dateEnded

    /**
     * The status of the game.
     * Values: [NOT_STARTED, IN_PROGRESS, COMPLETED]
     */
    GameStatus status

    /** The winner of the game. Null until game completes. */
    Player winner

/********************************************************
 *      GORM Relationships & Constraints                *
 ********************************************************/

    /** Database & data binding constraints. */
    static constraints = {
        id generator: "uuid"
        gameId blank: false, bindable: true, unique: true
        dateCreated blank: false, bindable: true, nullable: false
        dateStarted blank: true, bindable: false, nullable: true
        dateEnded blank: true, bindable: false, nullable: true
        status blank: false, bindable: false, nullable: false
        winner blank: true, bindable: false, nullable: true
        players blank: false, bindable: false, nullable: false, size: 1..6
    }

    /** Domain objects that own the Game class. Uncomment to use. */
    // static belongsTo = [
    //
    // ]

    /** One-to-many relationships between Game objects and other domain classes. */
    static hasMany = [
        players: Player
    ]

    /** One-to-one relationships between Game objects and other domain classes. */
    static hasOne = [
        winner: Player,
    ]

    /** Custom attribute mapping for Game attributes if necessitated by other domain objects. Uncomment to use. */
    // static mapping = {
    //
    // }

/********************************************************
 *      Accessor functions                              *
 ********************************************************/

    /**
     * Synthetic accessor for the date string when the game was created.
     * @return String
     */
    String getDateCreatedStr() {
        new Date(dateCreated).toString()
    }

    /**
     * Synthetic accessor for the date string when the game started.
     * @return String
     */
    String getDateStartedStr() {
        new Date(dateStarted).toString()
    }

    /**
     * Synthetic accessor for the date string when the game ended.
     * @return String
     */
    String getDateEndedStr() {
        new Date(dateEnded).toString()
    }

/********************************************************
 *      Convenience functions                           *
 ********************************************************/

    /**
     * Checks all in-progress and completion flags to determine if the game hasn't finished.
     * @return Boolean
     */
    @NotTransactional
    Boolean isInProgress() {

        (status == GameStatus.IN_PROGRESS)
            && (winner == null)
    }

}
