package com.drediki.exp.test;

import java.util.Random;

/**
 * Created by DreDiki on 2016/12/1.
 */
public class RandomInit {
    public static int MAXRANDNUM = 5000;
    public static int MAXRANDLEN = 1000;
    private Random random;
    public static String[] names = {"Green", "Jobs", "Bill", "Lei", "Twilight", "Pinkie", "LiHua", "Jack", "Judy", "Alice"};

    public String createRandomName() {
        if (random == null) random = new Random();
        return names[random.nextInt(names.length)] + random.nextInt(MAXRANDNUM);
    }

    public RandomInit() {
        random = new Random();
    }
}
