package coup.api.turn

import coup.api.player.Player
import grails.gorm.transactions.NotTransactional

/**
 * Action class for the Coup game.
 * Created on 07/17/2020 by @benjamindburke. Last modified 07/17/2020 by @benjamindburke.
 */
class Action {

/********************************************************
 *      Attributes                                      *
 ********************************************************/

    /** Unique UUID identifier in the database. */
    String id

    /** An action that this action is responding to. */
    Action responseTo

    /** The type of the action. */
    ActionType type

    /** The cost of the action. */
    ActionCost cost

    /** Whether the action has succeeded. */
    Boolean successful

/********************************************************
 *      GORM Relationships & Constraints                *
 ********************************************************/

    /** Database & data binding constraints. */
    static constraints = {
        id generator: "uuid"
        responseTo blank: false, bindable: true, nullable: true
    }

    /** Domain objects that own the Action class. */
    static belongsTo = [
        turn: Turn
    ]

    /** One-to-many relationships between Action objects and other domain classes. Uncomment to use. */
    // static hasMany = [
    //
    // ]

    /** One-to-one relationships between Action objects and other domain classes. */
    static hasOne = [
        source: Player,
        target: Player,
    ]

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
    Action getParent() {
        responseTo ?: null
    }

/********************************************************
 *      Convenience functions                           *
 ********************************************************/



}