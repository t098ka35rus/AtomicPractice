package org.example;


import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static AtomicInteger count3 = new AtomicInteger(0);
    static AtomicInteger count4 = new AtomicInteger(0);
    static AtomicInteger count5 = new AtomicInteger(0);


    public static void main(String[] args) {

        //System.out.println("Поехали");
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }
        new Thread(() -> {//pal
            for (String s : texts) {
                if (getPalCheck(s)) {
                    if (s.length() == 3) {
                        count3.getAndIncrement();
                    }
                    if (s.length() == 4) {
                        count4.getAndIncrement();
                    }
                    if (s.length() == 5) {
                        count5.getAndIncrement();
                    }

                }
            }

        }).start();
        new Thread(() -> {
            for (String s : texts) {
                if (getTwinsCheck(s)) {
                    if (s.length() == 3) {
                        count3.getAndIncrement();
                    }
                    if (s.length() == 4) {
                        count4.getAndIncrement();
                    }
                    if (s.length() == 5) {
                        count5.getAndIncrement();
                    }

                }
            }

        }).start();
        new Thread(() -> {
            for (String s : texts) {
                if (getStairsCheck(s)) {
                    if (s.length() == 3) {
                        count3.getAndIncrement();
                    }
                    if (s.length() == 4) {
                        count4.getAndIncrement();
                    }
                    if (s.length() == 5) {
                        count5.getAndIncrement();
                    }

                }
            }
        }).start();

        System.out.println("Красивых слов с длиной 3: " + count3 + " шт");
        System.out.println("Красивых слов с длиной 4: " + count4 + " шт");
        System.out.println("Красивых слов с длиной 5: " + count5 + " шт");


    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();

    }

    public static boolean getPalCheck(String s) {
        int max;
        if (s.length() % 2 == 0) {
            max = s.length() / 2;
        } else max = (s.length() - 1) / 2;

        for (int i = 0; i < max; i++) {
            if (s.charAt(i) != s.charAt((s.length() - 1) - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean getTwinsCheck(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean getStairsCheck(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (!(s.charAt(i + 1) >= s.charAt(i))) {
                return false;
            }
        }
        return true;
    }


}