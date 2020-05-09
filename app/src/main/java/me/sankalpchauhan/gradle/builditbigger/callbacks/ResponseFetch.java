package me.sankalpchauhan.gradle.builditbigger.callbacks;

/**
 * A callback to fetch status and results from EndpointsAsyncTask
 */
public interface ResponseFetch{
    void onGet(String joke);
    void startExecution();
    void error(Exception e);
}
