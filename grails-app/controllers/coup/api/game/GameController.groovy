package coup.api.game

/**
 * Game domain class controller for the Coup game.
 * Created on 07/16/2020 by @benjamindburke. Last modified 07/20/2020 by @benjamindburke.
 */
class GameController {

	static responseFormats = [ "json" ]
    static scaffold = true

    def gameService
	
    def index() {
        // Essentially a no-op.
        // Redirect to show() with no gameId
        // Returns a server error
        show()
    }

    def create() {
        try {
            Game game = gameService.createGame()

            render(template: "/game/game", model: [ game: game ])
        } catch (error) {
            error.printStackTrace()
            render(view: "/error", model: [ e: error ])
        }
    }

    def show() {

        String gameId = params.get("gameId") ?: null
        Game thisGame = Game.findByGameId(gameId) ?: null

        if (thisGame) {
            render(template: "/game/game", model: [ game: thisGame ])
        } else {
            render(view: "/error", model: [ e: new Exception("Game does not exist") ])
        }

    }
}
