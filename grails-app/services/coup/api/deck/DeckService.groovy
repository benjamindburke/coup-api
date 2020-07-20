package coup.api.deck

import coup.api.game.Game
import grails.gorm.transactions.NotTransactional
import grails.gorm.transactions.Transactional

/**
 * Deck domain class service methods for the Coup game.
 * Created on 07/18/2020 by @benjamindburke. Last modified 07/19/2020 by @benjamindburke.
 */
@Transactional
class DeckService {

    def cardService

    /**
     * Create a new deck and 15 cards for the game.
     * @param game
     * @return
     */
    @NotTransactional
    void createDeck(Game game) {

        Deck deck = new Deck()

        // Create the Cards after creating the Deck
        cardService.createCardsInDeck(deck)

        // Attach the Deck to the Game
        deck.setGame(game)
        game.setDeck(deck)
    }

}
