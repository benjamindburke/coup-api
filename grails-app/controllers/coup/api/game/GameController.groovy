package coup.api.game

/**
 * Game domain class controller for the Coup game.
 * Created on 07/16/2020 by @benjamindburke. Last modified 07/17/2020 by @benjamindburke.
 */
class GameController {
	static responseFormats = [ 'json' ]
    static scaffold = true

    def gameService
	
    def index() {
        // TODO : render collection of games? Do I even need to?
        // Game.list()
        // render(template: "/game/game", colletion: games, var: "game")
    }

    def create() {
        try {
            Game game = gameService.createGame()
            render(template: "/game/game", model: [ game: game ])
        } catch (e) {
            e.printStackTrace()
            render(view: "/error", model: [ error: e ])
        }
    }
}
