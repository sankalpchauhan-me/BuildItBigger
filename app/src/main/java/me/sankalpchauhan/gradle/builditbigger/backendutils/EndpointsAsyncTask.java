package me.sankalpchauhan.gradle.builditbigger.backendutils;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;


import java.io.IOException;

import me.sankalpchauhan.gradle.builditbigger.backend.jokeApi.JokeApi;
import me.sankalpchauhan.gradle.builditbigger.callbacks.ResponseFetch;


/**
 * As mentioned in project Instructions in Step 3: Setup GCE I followed Official Google Cloud Platform Guide
 * (https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/77e9910911d5412e5efede5fa681ec105a0f02ad/HelloEndpoints#2-connecting-your-android-app-to-the-backend)
 * to implement this with slight modifications
 */
public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    public static final String DEFAULT = "http://10.0.2.2:8080/_ah/api/";
    private static JokeApi jokeApiService = null;
    private ResponseFetch responsecallback;
    private static final String APP_NAME = "Joke Teller";

    public EndpointsAsyncTask(ResponseFetch responsecallback) {
        this.responsecallback = responsecallback;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        responsecallback.startExecution();
        // Emulate Delay
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if (jokeApiService == null) {
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(DEFAULT)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    }).setApplicationName(APP_NAME);

            jokeApiService = builder.build();
        }


        try {
            return jokeApiService.getJokeResponse().execute().getData();
        } catch (IOException e) {
//            Log.e("Test2", e.getCause().toString());
            responsecallback.error(e);
            Log.e("Test", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
//        Log.d("Test", result);
        responsecallback.onGet(result);
    }
}
