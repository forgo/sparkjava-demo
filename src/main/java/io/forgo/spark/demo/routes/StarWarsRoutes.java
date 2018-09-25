package io.forgo.spark.demo.routes;

import io.forgo.spark.demo.services.StarWarsService;

import static spark.Spark.get;
import static spark.Spark.path;

public class StarWarsRoutes {
    public static void routes() {
        get("/starwars", StarWarsService.index());
        path("/starwars", () -> {
            get("/character", StarWarsService.character());
        });
    }
}
