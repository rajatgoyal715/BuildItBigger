package com.example;

import java.util.Random;

public class Joke {

    private String[] jokes;
    private Random random;

    public Joke() {
        jokes = new String[10];
        jokes[0] = "There are only 10 types of people in the world: those that understand binary and those that don’t.";
        jokes[1] = "My software never has bugs. It just develops random features.";
        jokes[2] = "If at first you don’t succeed; call it version 1.0.";
        jokes[3] = "I’m not anti-social; I’m just not user friendly.";
        jokes[4] = "Programmers are tools for converting caffeine into code.";
        jokes[5] = "You never finish a program, you just stop working on it.";
        jokes[6] = "Windows is NOT a virus. Viruses DO something.";
        jokes[7] = "The program is absolutely right; therefore the computer must be wrong.";
        jokes[8] = "Press CTRL-ALT-DEL to continue....";
        jokes[9] = "Ever notice how fast Windows runs? Neither did I...";

        random = new Random();
    }

    public String getRandomJoke() {
        return jokes[random.nextInt(jokes.length)];
    }

    public String[] getJokes() {
        return jokes;
    }

}
