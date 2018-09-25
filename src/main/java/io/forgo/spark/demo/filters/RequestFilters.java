package io.forgo.spark.demo.filters;

import static spark.Spark.before;
import static spark.Spark.halt;

public class RequestFilters {

    public static void disambiguateTrailingSlash(String path) {
        before(path, (req, res) -> {
            String requestPath = req.pathInfo();
            if (requestPath.endsWith("/"))
                res.redirect(requestPath.substring(0, requestPath.length() - 1));
        });
    }

    public static void authenticate(String path) {
        before(path, (request, response) -> {
            boolean authenticated;
            // TODO: ... check if authenticated
            authenticated = false;
            if (!authenticated) {
                halt(401, "You are not welcome here");
            }
        });
    }
}
