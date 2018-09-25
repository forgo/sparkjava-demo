package io.forgo.spark.demo.services;

import spark.Route;

public class AdminService {
    public static Route dashboard() {
        return (req, res) -> "Admin dashboard";
    }
}
