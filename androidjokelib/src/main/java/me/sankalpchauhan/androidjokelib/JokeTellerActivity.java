package me.sankalpchauhan.androidjokelib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import static me.sankalpchauhan.androidjokelib.Utils.isOnline;

public class JokeTellerActivity extends AppCompatActivity {
    public static final String JOKEQUESTION = "JOKE_QUESTION";
    public static final String JOKEANSWER = "JOKE_ANSWER";
    private TextView mQuestion, mAnswer;
    private ImageView mJokeImage;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_teller);
        Intent intent = getIntent();
        final String question = intent.getStringExtra(JOKEQUESTION);
        final String answer = intent.getStringExtra(JOKEANSWER);
        mQuestion = findViewById(R.id.joke_question);
        mAnswer = findViewById(R.id.joke_answer);
        mJokeImage = findViewById(R.id.joke_image);
        progressBar = findViewById(R.id.progress_circular);
        Picasso.get().load(question).into(mJokeImage, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.INVISIBLE);
                mAnswer.setVisibility(View.INVISIBLE);
                mQuestion.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError(Exception e) {
                progressBar.setVisibility(View.INVISIBLE);
                mJokeImage.setVisibility(View.INVISIBLE);
                mAnswer.setVisibility(View.VISIBLE);
                mQuestion.setVisibility(View.VISIBLE);
                mQuestion.setText(question);
                mAnswer.setText(answer);
                //Log.d("TEST", e.toString());
                if(!isOnline()){
                    Toast.makeText(JokeTellerActivity.this, "This image joke cannot be displayed due to network error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
