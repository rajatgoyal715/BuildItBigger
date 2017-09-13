package com.rajatgoyal.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.util.Log;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by rajat on 12/9/17.
 */

public class JokeFetchTaskTest {

    private static final String TAG = "JokeFetchTaskTest";

    @Test
    public void checkIfJokeFetchTaskReturnsEmptyString() {
        JokeFetchTask jokeFetchTask = new JokeFetchTask(InstrumentationRegistry.getContext(), null);
        jokeFetchTask.execute();

        try {
            String joke = jokeFetchTask.get();
            Log.d(TAG, "checkIfJokeFetchTaskReturnsEmptyString: " + joke);

            assertNotNull(joke);
            assertTrue(joke.length() > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
