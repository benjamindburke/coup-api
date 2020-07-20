package coup.api.game

import grails.gorm.transactions.NotTransactional
import grails.gorm.transactions.Transactional

/**
 * Game domain class service methods for the Coup game.
 * Created on 07/16/2020 by @benjamindburke. Last modified 07/20/2020 by @benjamindburke.
 */
@Transactional
class GameService {

    def deckService

    /**
     * Create a new 5-char gameId from a random UUID.
     * @return String
     */
    @NotTransactional
    String createGameIdFromUUID() {

        // Create a new UUID and reduce it to the last segment
        String uuid = UUID.randomUUID().toString().split(/-/)[4]

        // Capitalize the last 5 characters
        uuid.substring(uuid.size() - 5).toUpperCase()
    }

    /**
     * Create a new game.
     * @return Game
     */
    @Transactional
    Game createGame() {

        Game game = new Game(
                gameId: createGameIdFromUUID(),
                status: GameStatus.NOT_STARTED,
        )

        // Create the Deck and Cards after creating the Game
        deckService.createDeck(game)

        if (game.validate()) {
            game.save()

            // Return the Game after the Deck has been created
            game
        } else {
            if (game.hasErrors()) {
                for (e in game.errors) {
                    throw new Exception(e as Error)
                }
            } else {
                throw new Exception("Game doesn't validate")
            }
        }
    }
}
