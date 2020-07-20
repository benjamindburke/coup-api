package coup.api.deck

import grails.gorm.transactions.NotTransactional
import grails.gorm.transactions.Transactional

/**
 * Card domain class service methods for the Coup game.
 * Created on 07/18/2020 by @benjamindburke. Last modified 07/20/2020 by @benjamindburke.
 */
@Transactional
class CardService {

    /**
     * Randomize the order of the cards in the deck.
     * @return List<Integer>
     */
    @NotTransactional
    List<Integer> randomizeCardOrders() {

        Random rand = new Random()
        List<Integer> orders = (1..15).toList()
        Collections.shuffle(orders, rand)

        orders
    }

    /**
     * Create each individual card.
     * @param type
     * @param order
     * @return Card
     */
    @NotTransactional
    Card createCard(CardType type, Integer order) {

        new Card(
                type: type,
                cardOrder: order,
                status: CardStatus.DECK
        )
    }

    /**
     * Create 15 cards for the deck.
     * @param deck
     * @return
     */
    @NotTransactional
    void createCardsInDeck(Deck deck) {

        // Generate exactly 15 cards with shuffled orders
        randomizeCardOrders()
        .eachWithIndex({ Integer order, int i ->

            CardType type = CardType.DUKE

            // Generate 5 of each card type
            switch(i % 5) {

                // Determine the type of the card being generated based on card order
                case 0:
                    type = CardType.AMBASSADOR
                    break
                case 1:
                    type = CardType.ASSASSIN
                    break
                case 2:
                    type = CardType.CAPTAIN
                    break
                case 3:
                    type = CardType.CONTESSA
                    break
                case 4:
                    // Duke is the default value, so just break
                    break
            }

            // Add the new Card to the Deck
            deck.addToCards(createCard(type, order))
        })
    }
}
