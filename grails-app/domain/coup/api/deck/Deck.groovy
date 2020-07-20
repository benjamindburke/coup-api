package coup.api.deck

import coup.api.game.Game

/**
 * Deck class for the Coup game.
 * Created on 07/16/2020 by @benjamindburke. Last modified 07/19/2020 by @benjamindburke.
 */
class Deck {

/********************************************************
 *      Attributes                                      *
 ********************************************************/

    /** Unique BigInt identifier in the database. */
    BigInteger id

/********************************************************
 *      GORM Relationships & Constraints                *
 ********************************************************/

    /** Database & data binding constraints. */
    static constraints = {
        id generator: "sequence", params: [sequence: "deck_id_seq"]
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

    /** Custom attribute mapping for Deck attributes if necessitated by other domain objects. Uncomment to use. */
    // static mapping = {
    //
    // }

/********************************************************
 *      Accessor functions                              *
 ********************************************************/

    /**
     * Retrieve all of the cards still in the deck.
     * @return List<Card>
     */
    List<Card> getCardsStillInDeck() {

        cards
            .findAll({ it.status == CardStatus.DECK })
            .sort({ it.cardOrder })
        .toList()
    }

/********************************************************
 *      Convenience functions                           *
 ********************************************************/



}
