package coup.api.turn

import coup.api.game.Game
import coup.api.player.Player

/**
 * Turn class for the Coup game.
 * Created on 07/17/2020 by @benjamindburke. Last modified 07/17/2020 by @benjamindburke.
 */
class Turn {

/********************************************************
 *      Attributes                                      *
 ********************************************************/

    /** Unique UUID identifier in the database. */
    String id

    /** Turn number identifier in the database. */
    Integer turnId

    /** The player that starts the turn. */
    Player startingPlayer

    /** The player currently taking their turn. */
    Player currentPlayer

    /** The player whose turn is next. */
    Player nextPlayer

    /** The player that ends the turn. */
    Player endingPlayer

/********************************************************
 *      GORM Relationships & Constraints                *
 ********************************************************/

    /** Database & data binding constraints. */
    static constraints = {
        id generator: "uuid"
        turnId blank: false, bindable: false, nullable: false
    }

    /** Domain objects that own the Turn class. */
    static belongsTo = [
        game: Game
    ]

    /** One-to-many relationships between Turn objects and other domain classes. */
    static hasMany = [
        actions: Action
    ]

    /** One-to-one relationships between Turn objects and other domain classes. */
    static hasOne = [
        startingPlayer: Player,
        currentPlayer: Player,
        nextPlayer: Player,
        endingPlayer: Player,
    ]

    /** Custom attribute mapping for Turn attributes if necessitated by other domain objects. Uncomment to use. */
    // static mapping = {
    //
    // }

/********************************************************
 *      Accessor functions                              *
 ********************************************************/



/********************************************************
 *      Convenience functions                           *
 ********************************************************/



}
