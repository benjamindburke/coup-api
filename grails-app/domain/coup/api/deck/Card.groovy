package coup.api.deck

import grails.gorm.transactions.NotTransactional

/**
 * Card class for the Coup game.
 * Created on 07/17/2020 by @benjamindburke. Last modified 07/17/2020 by @benjamindburke.
 */
class Card {

/********************************************************
 *      Attributes                                      *
 ********************************************************/

    /** Unique UUID identifier in the database. */
    String id

    /**
     * The status of the card.
     * Values: [DECK, HAND, KILLED]
     */
    CardStatus status

    /**
     * The type of the card.
     * Values: [AMBASSADOR, ASSASSIN, CAPTAIN, CONTESSA, DUKE]
     */
    CardType type

/********************************************************
 *      GORM Relationships & Constraints                *
 ********************************************************/

    /** Database & data binding constraints. */
    static constraints = {
        id generator: "uuid"
    }

    /** Domain objects that own the Card class. */
    static belongsTo = [
        deck: Deck
    ]

    /** One-to-many relationships between Card objects and other domain classes. Uncomment to use. */
    // static hasMany = [
    //
    // ]

    /** One-to-one relationships between Card objects and other domain classes. Uncomment to use. */
    // static hasOne = [
    //
    // ]

    /** Custom attribute mapping for Card attributes if necessitated by other domain objects. Uncomment to use. */
    // static mapping = {
    //
    // }

/********************************************************
 *      Accessor functions                              *
 ********************************************************/



/********************************************************
 *      Convenience functions                           *
 ********************************************************/

    /**
     * Determine whether the card is in the deck.
     * @return Boolean
     */
    @NotTransactional
    Boolean isInDeck() {
        status == CardStatus.DECK
    }

}
