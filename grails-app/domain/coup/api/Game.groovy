package coup.api

class Game {

    String id
    String gameId
    Long dateCreated

    static constraints = {
        id generator: 'uuid'
        gameId blank: false, bindable: true, unique: true
        dateCreated blank: false, bindable: true
    }
}
