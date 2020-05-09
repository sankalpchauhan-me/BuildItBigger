package me.sankalpchauhan.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import me.sankalpchauhan.androidjokelib.JokeTellerActivity;
import me.sankalpchauhan.gradle.builditbigger.backendutils.EndpointsAsyncTask;
import me.sankalpchauhan.gradle.builditbigger.callbacks.ResponseFetch;

/**
 * Fetching Execution status from ResposeFetch
 */
public class MainActivity extends AppCompatActivity implements ResponseFetch {
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress_circular);

    }


    public void tellJoke(View view) {
            new EndpointsAsyncTask(this).execute();
    }


    @Override
    public void onGet(String joke) {
        progressBar.setVisibility(View.INVISIBLE);
        if (joke != null && !joke.isEmpty()) {
            Log.d("Test", joke);
            String[] fulljoke = joke.split("\\$A:");
            String question = fulljoke[0];
            String answer = fulljoke[1];
            //Toast.makeText(this, question + "" + answer, Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, JokeTellerActivity.class);
            i.putExtra(JokeTellerActivity.JOKEANSWER, answer);
            i.putExtra(JokeTellerActivity.JOKEQUESTION, question);
            startActivity(i);
        }

    }

    @Override
    public void startExecution() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void error(Exception e) {
        final Exception e1 =e;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, e1.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
