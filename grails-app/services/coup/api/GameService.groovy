package coup.api

import grails.gorm.transactions.Transactional
import java.util.UUID
import coup.api.Game

class GameService {

    @Transactional
    Game createGame() {

        // Generate all-capital 5 letter game code from UUID class
        String uuid = UUID.randomUUID().toString().split(/-/)[4]
        String processedId = uuid.substring(uuid.size() - 5).toUpperCase()

        Game game = new Game(gameId: processedId, dateCreated: new Date().getTime())

        if (game.validate()) {
            game.save()

            game
        } else {
            throw new Exception("Game doesn't validate")
        }
    }
}
