package com.rajatgoyal.builditbigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.rajatgoyal.Joke;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    private InterstitialAd interstitialAd;
    private AdRequest request;

    public static final String TAG = "MainActivity";

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
    }

    public void loadAd() {
        request = new AdRequest.Builder()
                .addTestDevice("1F45267EC1DC80D3BB57C61903D4631F")
                .build();
        interstitialAd.loadAd(request);
    }

    public void showJoke(View view) {
        new JokeFetchTask(getApplicationContext(), null).execute();
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
