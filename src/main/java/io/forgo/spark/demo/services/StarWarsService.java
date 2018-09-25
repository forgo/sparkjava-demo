package io.forgo.spark.demo.services;

import spark.Route;

public class StarWarsService {
    public static Route index() {
        return (req, res) -> "Star Wars";
    }

    public static Route character() {
        return (req, res) -> "Star Wars Characters";
    }
}
