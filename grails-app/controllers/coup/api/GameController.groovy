package coup.api

import coup.api.Game

import grails.rest.*
import grails.converters.*

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
            render( template: "/game/game", model: [ game: game ])
        } catch (e) {
            e.printStackTrace()
            render(view: "/error", model: [ error: e ])
        }
    }
}
