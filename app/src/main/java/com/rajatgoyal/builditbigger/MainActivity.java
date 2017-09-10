package com.rajatgoyal.builditbigger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.Joke;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.rajatgoyal.jokelibrary.DisplayJokeActivity;

public class MainActivity extends AppCompatActivity {

    private InterstitialAd interstitialAd;
    private AdRequest request;

    public static final String TAG = "MainActivity";

    private Joke joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                loadAd();
            }
        });

        loadAd();

        joke = new Joke();
    }

    public void loadAd() {
        request = new AdRequest.Builder()
                .addTestDevice("1F45267EC1DC80D3BB57C61903D4631F")
                .build();
        interstitialAd.loadAd(request);
    }

    public void showJoke(View view) {
        String jokeString = joke.getRandomJoke();
        Intent intent = new Intent(this, DisplayJokeActivity.class);
        intent.putExtra("joke", jokeString);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void showAd(View view) {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            Log.d(TAG, "The interstitial wasn't loaded yet.");
            loadAd();
        }
    }
}
