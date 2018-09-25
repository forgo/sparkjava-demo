package io.forgo.spark.demo.config;

public class ThreadPool {
    int maxThreads;
    int minThreads;
    int timeOutMillis;

    public int getMaxThreads() {
        return maxThreads;
    }

    public void setMaxThreads(int maxThreads) {
        this.maxThreads = maxThreads;
    }

    public int getMinThreads() {
        return minThreads;
    }

    public void setMinThreads(int minThreads) {
        this.minThreads = minThreads;
    }

    public int getTimeOutMillis() {
        return timeOutMillis;
    }

    public void setTimeOutMillis(int timeOutMillis) {
        this.timeOutMillis = timeOutMillis;
    }
}
