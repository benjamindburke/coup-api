package coup.api.action

import coup.api.game.Game
import coup.api.player.Player
import grails.gorm.transactions.NotTransactional

/**
 * Action class for the Coup game.
 * Created on 07/17/2020 by @benjamindburke. Last modified 07/19/2020 by @benjamindburke.
 */
class Action {

/********************************************************
 *      Attributes                                      *
 ********************************************************/

    /** Unique BigInt identifier in the database. */
    BigInteger id

    /** An action that this action is responding to. */
    Action responseTo

    /** The type of the action. */
    ActionType type

    /** The cost of the action. */
    ActionCost cost

    /** Whether the action has succeeded. */
    Boolean successful

    /** The source of the action. */
    Player source

    /** The target of the action. */
    Player target

/********************************************************
 *      GORM Relationships & Constraints                *
 ********************************************************/

    /** Database & data binding constraints. */
    static constraints = {
        id generator: "sequence", params: [sequence: "action_id_seq"]
        type blank: false, bindable: true, nullable: false
        cost blank: false, bindable: true, nullable: false
        successful blank: false, bindable: false, nullable: false
        source blank: false, bindable: true, nullable: false
        target blank: false, bindable: true, nullable: false
        responseTo blank: false, bindable: true, nullable: true
    }

    /** Domain objects that own the Action class. */
    static belongsTo = [
        game: Game
    ]

    /** One-to-many relationships between Action objects and other domain classes. Uncomment to use. */
    // static hasMany = [
    //
    // ]

    /** One-to-one relationships between Action objects and other domain classes. Uncomment to use. */
    // static hasOne = [
    //
    // ]

    /** Custom attribute mapping for Action attributes if necessitated by other domain objects. Uncomment to use. */
    // static mapping = {
    //
    // }

/********************************************************
 *      Accessor functions                              *
 ********************************************************/

    /**
     * Get the action that this action responds to.
     * @return Action
     */
    @NotTransactional
    Action getResponseTo() {
        responseTo ?: null
    }

/********************************************************
 *      Convenience functions                           *
 ********************************************************/



}