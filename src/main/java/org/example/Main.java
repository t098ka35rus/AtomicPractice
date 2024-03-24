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
        new Thread(() -> {
            for (int i = 3; i < 6; i++) {
                count3.addAndGet(getCount(texts, "pal", i));
            }
        }).start();
        new Thread(() -> {
            for (int i = 3; i < 6; i++) {
                count4.addAndGet(getCount(texts, "twins", i));
            }
        }).start();
        new Thread(() -> {
            for (int i = 3; i < 6; i++) {
                count5.addAndGet(getCount(texts, "stairs", i));
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

    public static boolean getCheck(String s, String mode) {

        switch (mode) {
            case ("pal"):
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
            case ("twins"):
                for (int i = 0; i < s.length() - 1; i++) {
                    if (s.charAt(i) != s.charAt(i + 1)) {
                        return false;
                    }
                }
                return true;
            case ("stairs"):
                for (int i = 0; i < s.length() - 1; i++) {
                    if (!(s.charAt(i + 1) >= s.charAt(i))) {
                        return false;
                    }
                }
                return true;
        }
        return false;
    }

    public static int getCount(String[] texts, String mode, int length) {
        switch (mode) {

            case ("pal"):
                int result = 0;
                for (String s : texts) {
                    if (s.length() != length) {
                        continue;
                    }
                    if (getCheck(s, "pal")) {
                        result++;
                    }

                }
                return result;

            case ("twins"):
                int result1 = 0;
                for (String s : texts) {
                    if (s.length() != length) {
                        continue;
                    }
                    if (getCheck(s, "twins")) {
                        result1++;
                    }

                }
                return result1;
            case ("stairs"):
                int result2 = 0;
                for (String s : texts) {
                    if (s.length() != length) {
                        continue;
                    }
                    if (getCheck(s, "stairs")) {
                        result2++;
                    }

                }
                return result2;
        }
        return 0;
    }


}