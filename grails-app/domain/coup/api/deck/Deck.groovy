package coup.api.deck

import coup.api.game.Game

/**
 * Deck class for the Coup game.
 * Created on 07/16/2020 by @benjamindburke. Last modified 07/17/2020 by @benjamindburke.
 */
class Deck {

/********************************************************
 *      Attributes                                      *
 ********************************************************/



/********************************************************
 *      GORM Relationships & Constraints                *
 ********************************************************/

    /** Database & data binding constraints. */
    static constraints = {
        id unique: true
    }

    /** Domain objects that own the Deck class. */
    static belongsTo = [
        game: Game
    ]

    /** One-to-many relationships between Deck objects and other domain classes. */
    static hasMany = [
        cards: Card
    ]

    /** One-to-one relationships between Deck objects and other domain classes. Uncomment to use. */
    // static hasOne = [
    //
    // ]

    /** Custom attribute mapping for Deck attributes if necessitated by other domain objects. */
    static mappedBy = {
        id: game.id
    }

/********************************************************
 *      Accessor functions                              *
 ********************************************************/



/********************************************************
 *      Convenience functions                           *
 ********************************************************/



}
