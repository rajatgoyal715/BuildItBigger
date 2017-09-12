package com.rajatgoyal.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.ads.InterstitialAd;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.rajatgoyal.builditbigger.backend.jokesApi.JokesApi;
import com.rajatgoyal.builditbigger.backend.jokesApi.model.JokeBean;
import com.rajatgoyal.jokelibrary.DisplayJokeActivity;

import java.io.IOException;

/**
 * Created by rajat on 10/9/17.
 */

public class JokeFetchTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private static JokesApi jokesApi;
    private Context context;
    private ProgressBar progressBar;

    private String jokeString;
    private InterstitialAd interstitialAd;

    public JokeFetchTask(Context context, ProgressBar progressBar) {
        this.context = context;
        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (jokesApi == null) {
            JokesApi.Builder builder = new JokesApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(BuildConfig.googleEndpointsUrl);
            jokesApi = builder.build();
        }

        try {
            return jokesApi.fetchJoke(new JokeBean()).execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        jokeString = s;
        startJokeDisplayActivity();
    }

    private void startJokeDisplayActivity() {
        Intent intent = new Intent(context, DisplayJokeActivity.class);
        intent.putExtra("joke", jokeString);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
