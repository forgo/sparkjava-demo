package io.forgo.spark.demo.routes;

import io.forgo.spark.demo.services.AdminService;

import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.redirect;

public class AdminRoutes {
    public static void routes() {
        redirect.get("/admin", "/api/admin/dashboard");
        path("/admin", () -> {
            get("/dashboard", AdminService.dashboard());
        });
    }
}
