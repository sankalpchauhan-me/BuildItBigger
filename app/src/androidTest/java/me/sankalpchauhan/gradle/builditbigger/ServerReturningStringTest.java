package me.sankalpchauhan.gradle.builditbigger;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import me.sankalpchauhan.gradle.builditbigger.backendutils.EndpointsAsyncTask;
import me.sankalpchauhan.gradle.builditbigger.callbacks.ResponseFetch;

@RunWith(AndroidJUnit4ClassRunner.class)
public class ServerReturningStringTest {

    @Test
    public void isRetrievingString(){
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(new ResponseFetch() {
            @Override
            public void onGet(String joke) {

            }

            @Override
            public void startExecution() {

            }

            @Override
            public void error(Exception e) {

            }
        });
        endpointsAsyncTask.execute();
        String myJoke=null;
        try {
            myJoke = endpointsAsyncTask.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(myJoke);


    }
}
