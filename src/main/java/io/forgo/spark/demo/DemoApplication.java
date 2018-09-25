package io.forgo.spark.demo;

import io.forgo.spark.demo.config.Configuration;
import io.forgo.spark.demo.config.Security;
import io.forgo.spark.demo.config.ThreadPool;
import io.forgo.spark.demo.filters.RequestFilters;
import io.forgo.spark.demo.routes.AdminRoutes;
import io.forgo.spark.demo.routes.StarWarsRoutes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import static spark.Spark.*;

public class DemoApplication {

    public static void main(String[] args) throws IOException {

        /* -- Are we debugging directly? -- */
        String DEBUG_SPARK_DEMO = System.getenv("DEBUG_SPARK_DEMO");

        /* -- Initialize Logger -- */
        Logger log = LoggerFactory.getLogger("io.forgo.spark.demo.DemoApplication");
        log.debug("Initializing DemoApplication");

        /* -- Load Configuration -- */
        Configuration config = null;
        config = Configuration.load("config.yml");

        /* -- Embedded Jetty Server -- */

        // specify the port
        int port = config.getServer().getPort();
        port(port);

        // secure (HTTPS/SSL): must be done before any route mapping
        Security security = config.getServer().getSecurity();
        String keystoreFile = security.getKeystoreFile();
        String keystorePassword = security.getKeystorePassword();
        secure(keystoreFile, keystorePassword, null, null);

        // thread pool configuration
        ThreadPool threadPool = config.getServer().getThreadPool();
        int maxThreads = threadPool.getMaxThreads();
        int minThreads = threadPool.getMinThreads();
        int timeOutMillis = threadPool.getTimeOutMillis();
        threadPool(maxThreads, minThreads, timeOutMillis);

        /* -- initialization exception handler -- */
        initExceptionHandler((e) -> {
            log.debug("Exception occurred during Spark initialization");
            System.exit(100);
        });

        /* -- routing -- */

        // filter all requests
        before("/*", (req, res) -> log.debug("Received api call"));

        // disambiguate endpoints that end in a slash
        RequestFilters.disambiguateTrailingSlash("/*");

        // filter all incoming /api/admin requests (requires authentication)
        RequestFilters.authenticate("/api/admin/*");

        path("/api", () -> {
            StarWarsRoutes.routes();
            AdminRoutes.routes();
        });

    }
}
