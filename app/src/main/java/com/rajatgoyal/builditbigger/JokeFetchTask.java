package com.rajatgoyal.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.rajatgoyal.builditbigger.backend.jokesApi.JokesApi;
import com.rajatgoyal.builditbigger.backend.jokesApi.model.JokeBean;
import com.rajatgoyal.jokelibrary.DisplayJokeActivity;

import java.io.IOException;

/**
 * Created by rajat on 10/9/17.
 */

public class JokeFetchTask extends AsyncTask<Void, Void, String> {

    private static JokesApi jokesApi;

    @Override
    protected String doInBackground(Void... params) {
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
}
