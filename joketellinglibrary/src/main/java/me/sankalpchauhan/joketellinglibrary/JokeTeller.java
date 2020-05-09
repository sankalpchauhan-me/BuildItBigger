package me.sankalpchauhan.joketellinglibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * List is initialised with a set of jokes which are then fetched in a random order
 */
public class JokeTeller {
    private static List<String> jokeList = new ArrayList<>();

    private static void jokeListInitializer(){
        jokeList.add("https://i.chzbgr.com/full/9195092224/h08083A8B/programmer-meme-text-hide-and-seek-champion-since-1958 $A: ");
        jokeList.add("Q: What is a programmer's favorite hangout place? $A: Foo Bar");
        jokeList.add("Q: Why do Java Programmers have to wear glasses $A: Because they don't C#");
        jokeList.add("Q: What is a programmer's favorite hangout place? $A: Foo Bar");
        jokeList.add("https://assets.hongkiat.com/uploads/programming-jokes/joke--comic_life-of-programmer.jpg $A: ");
        jokeList.add("https://hackernoon.com/hn-images/1*j80tBUC6gFi6E6mCqGUTrw.jpeg $A: ");
        jokeList.add("https://i.chzbgr.com/full/9195088640/h189BD147/programmer-meme-text-daddy-what-are-clouds-made-of-linux-servers-mo-sily $A: ");
        jokeList.add("Q: Why did the developer cross the road? $A: There was something he wanted to C.");
        jokeList.add("https://hackernoon.com/hn-images/1*h9RucVrMEx7xx3AuFzL64Q.jpeg $A: ");
        jokeList.add("https://devhumor.com/content/uploads/images/April2020/logic.jpg $A: ");
        jokeList.add("Q: A new database query walks into the bar $A: The server says \"Sorry, cache only\" ");
        jokeList.add("Q: Why did the functions stop calling each other $A: Because they had constant arguments. ");
        jokeList.add("Q: How many developers does it take to change a light bulb? $A: None. It's a hardware issue");
        jokeList.add("Q: What did the computer do at lunchtime? $A: Had a byte");

    }

    public static String getJoke(){
        jokeListInitializer();
        return jokeList.get(new Random().nextInt(jokeList.size()));
    }
}
