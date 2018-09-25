package io.forgo.spark.demo.config;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

public class Configuration {

    private Build build;
    private Server server;

    public Build getBuild() {
        return build;
    }

    public void setBuild(Build build) {
        this.build = build;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    /* -- helper methods -- */
    static public Configuration load(String path) {
        // stream in YML config
        Yaml yaml = new Yaml(new Constructor(Configuration.class));
        InputStream inputStream = Configuration.class
                .getClassLoader()
                .getResourceAsStream(path);

        // attempt to load YML stream into Configuration object
        Configuration configuration = yaml.load(inputStream);
        return configuration;
    }
}
