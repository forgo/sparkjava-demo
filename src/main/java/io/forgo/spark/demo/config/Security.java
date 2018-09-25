package io.forgo.spark.demo.config;

public class Security {

    String keystoreAlias;
    String keystoreFile;
    String keystorePassword;
    String truststoreFile;
    String truststorePassword;

    public String getKeystoreAlias() { return keystoreAlias; }

    public void setKeystoreAlias(String keystoreAlias) { this.keystoreAlias = keystoreAlias; }

    public String getKeystoreFile() {
        return keystoreFile;
    }

    public void setKeystoreFile(String keystoreFile) {
        this.keystoreFile = keystoreFile;
    }

    public String getKeystorePassword() {
        return keystorePassword;
    }

    public void setKeystorePassword(String keystorePassword) {
        this.keystorePassword = keystorePassword;
    }

    public String getTruststoreFile() {
        return truststoreFile;
    }

    public void setTruststoreFile(String truststoreFile) {
        this.truststoreFile = truststoreFile;
    }

    public String getTruststorePassword() {
        return truststorePassword;
    }

    public void setTruststorePassword(String truststorePassword) {
        this.truststorePassword = truststorePassword;
    }
}