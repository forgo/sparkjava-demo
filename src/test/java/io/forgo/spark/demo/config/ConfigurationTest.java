package io.forgo.spark.demo.config;

import org.junit.Test;
import static org.junit.Assert.*;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

public class ConfigurationTest {

    private static final String TEST_BUILD_VERSION = "1.0";
    private static final String TEST_BUILD_DATE = "2018-09-22";

    private static final int TEST_PORT = 5678;

    private static final int TEST_THREAD_POOL_MAX = 8;
    private static final int TEST_THREAD_POOL_MIN = 2;
    private static final int TEST_THREAD_POOL_TIMEOUT = 30000;

    private static final String TEST_SECURITY_KEYSTORE_ALIAS = null;
    private static final String TEST_SECURITY_KEYSTORE_FILE = "keystore.jks";
    private static final String TEST_SECURITY_KEYSTORE_PASSWORD = "password";
    private static final String TEST_SECURITY_TRUSTSTORE_FILE = null;
    private static final String TEST_SECURITY_TRUSTSTORE_PASSWORD = null;

    @Test
    public void
    whenLoadYAMLConfiguration_thenLoadCorrectJavaObjectWithNestedObjects() {

        // attempt to load YML stream into Configuration object
        Configuration configuration = Configuration.load("test-config.yml");
        assertNotNull(configuration);

        // test build configs
        Build build = configuration.getBuild();
        assertNotNull(build);
        assertEquals(TEST_BUILD_VERSION, build.getVersion());
        assertEquals(TEST_BUILD_DATE, build.getDate());

        // test server configs
        Server server = configuration.getServer();
        assertNotNull(server);
        assertEquals(TEST_PORT, server.getPort());

        // test thread pool configs
        ThreadPool threadPool = server.getThreadPool();
        assertNotNull(threadPool);
        assertEquals(TEST_THREAD_POOL_MAX, threadPool.getMaxThreads());
        assertEquals(TEST_THREAD_POOL_MIN, threadPool.getMinThreads());
        assertEquals(TEST_THREAD_POOL_TIMEOUT, threadPool.getTimeOutMillis());

        // test security configs
        Security security = server.getSecurity();
        assertNotNull(security);
        assertEquals(TEST_SECURITY_KEYSTORE_ALIAS, security.getKeystoreAlias());
        assertEquals(TEST_SECURITY_KEYSTORE_FILE, security.getKeystoreFile());
        assertEquals(TEST_SECURITY_KEYSTORE_PASSWORD, security.getKeystorePassword());
        assertEquals(TEST_SECURITY_TRUSTSTORE_FILE, security.getTruststoreFile());
        assertEquals(TEST_SECURITY_TRUSTSTORE_PASSWORD, security.getTruststorePassword());
    }

}
