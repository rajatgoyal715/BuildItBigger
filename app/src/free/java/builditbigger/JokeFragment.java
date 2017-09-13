package builditbigger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.rajatgoyal.builditbigger.R;

/**
 * Created by rajat on 13/9/17.
 */

public class JokeFragment extends Fragment {

    private AdView adView;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke, container, false);

        progressBar = (ProgressBar) rootView.findViewById(R.id.progress_bar);

        rootView.findViewById(R.id.show_joke_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JokeFetchTask(getContext(), progressBar).execute();
            }
        });

        MobileAds.initialize(getContext(), getString(R.string.app_id));

        adView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(getString(R.string.test_device)).build();
        adView.loadAd(adRequest);

        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (adView != null) {
            adView.pause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }
}
