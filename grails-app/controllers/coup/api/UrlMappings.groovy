package coup.api

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        "/"(controller: "application", action: "index")
        "500"(view: "/error")
        "404"(view: "/notFound")

        "/game"(controller: "game", action: "index")
        "/game/create"(controller: "game", action: "create")
        "/game/$gameId"(controller: "game", action: "show")
    }
}
