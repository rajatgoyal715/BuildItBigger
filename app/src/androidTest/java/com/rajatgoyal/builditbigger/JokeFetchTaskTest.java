package com.rajatgoyal.builditbigger;

import android.util.Log;

import org.junit.Test;

import builditbigger.JokeFetchTask;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by rajat on 12/9/17.
 */

public class JokeFetchTaskTest {

    private static final String TAG = "JokeFetchTaskTest";

    @Test
    public void checkIfJokeFetchTaskReturnsEmptyString() {
        JokeFetchTask jokeFetchTask = new JokeFetchTask(null, null) {
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                String joke = s;
                Log.d(TAG, "checkIfJokeFetchTaskReturnsEmptyString: " + joke);

                assertNotNull(joke);
                assertTrue(joke.length() > 0);
            }
        };
        jokeFetchTask.execute();
    }
}
