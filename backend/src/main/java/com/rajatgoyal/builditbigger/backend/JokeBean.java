package com.rajatgoyal.builditbigger.backend;

import com.rajatgoyal.Joke;

/**
 * The object model for the data we are sending through endpoints
 */
public class JokeBean {

    private Joke joke;

    public JokeBean() {
        joke = new Joke();
    }

    public String getJoke() {
        return joke.getRandomJoke();
    }
}