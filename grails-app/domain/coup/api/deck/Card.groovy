package coup.api.deck

import grails.gorm.transactions.NotTransactional

/**
 * Card class for the Coup game.
 * Created on 07/17/2020 by @benjamindburke. Last modified 07/20/2020 by @benjamindburke.
 */
class Card {

/********************************************************
 *      Attributes                                      *
 ********************************************************/

    /** Unique BigInt identifier in the database. */
    BigInteger id

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

    /** The position of the card in the deck. */
    Integer cardOrder

/********************************************************
 *      GORM Relationships & Constraints                *
 ********************************************************/

    /** Database & data binding constraints. */
    static constraints = {
        id generator: "sequence", params: [sequence: "card_id_seq"]
        cardOrder inList: 1..15
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

    /**
     * Determine whether the card is in the deck.
     * @return Boolean
     */
    @NotTransactional
    Boolean getIsInDeck() {
        status == CardStatus.DECK
    }

    /**
     * Determine whether the card is still in play.
     * @return Boolean
     */
    @NotTransactional
    Boolean getIsInPlay() {
        status != CardStatus.KILLED
    }

/********************************************************
 *      Convenience functions                           *
 ********************************************************/



}
