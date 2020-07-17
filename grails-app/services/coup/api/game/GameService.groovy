package coup.api.game

import grails.gorm.transactions.Transactional

class GameService {

    @Transactional
    Game createGame() {

        // Generate all-capital 5 letter game code from UUID class
        String uuid = UUID.randomUUID().toString().split(/-/)[4]
        String processedId = uuid.substring(uuid.size() - 5).toUpperCase()

        // TODO: create player one and update for additional game attributes

        Game game = new Game(gameId: processedId, dateCreated: new Date().getTime())

        if (game.validate()) {
            game.save()

            game
        } else {
            throw new Exception("Game doesn't validate")
        }
    }
}
