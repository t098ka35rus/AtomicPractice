package org.example;


import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static AtomicInteger count3;
    static AtomicInteger count4;
    static AtomicInteger count5;


    public static void main(String[] args) {
        System.out.println("Поехали");
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }
        System.out.println(getCheck("aqdsz", "stairs"));
        int a = getCount(texts, "pal");


    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    public static int getPalCount(String[] texts) {
        int result = 0;
        boolean check;
        boolean check1;
        for (int i = 0; i < texts.length; i++) {
            check = true;
            String a = "";
            String b = null;
            String s = texts[i];
            System.out.println("s = " + s);

            if (s.length() % 2 == 0) {
                for (int j = 0; j < s.length() / 2 - 1; j++) {
                    a = a + s.charAt(j);
                }
                System.out.println("a = " + a);
                for (int j = s.length() - 1; j > s.length() / 2 + 1; j--) {
                    b = "" + s.charAt(j);
                    ;

                }
                System.out.println("b = " + b);
                if (a.equals(b)) {
                    result++;
                    System.out.println("PAL = " + s + ";" + "result = " + result);
                }
            }
        }

        return result;

    }
/*
    public static int getTwinsCount(String[] texts) {
        int result = 0;
        for (String s : texts) {
            if (getTwinsCheck(s)) {
                result++;
                System.out.println("TWINS = " + s + ";" + "result = " + result);
            }

        }
        return result;

    }

    public static int getStairsCount(String[] text) {
        return 0;
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

  */

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

    public static int getCount(String[] texts, String mode) {
        switch (mode) {

            case  ("pal"):
                int result = 0;
                for (String s : texts) {
                    if (getCheck(s, "pal")) {
                        result++;
                        System.out.println("PAL = " + s + ";" + "result = " + result);
                    }

                }
                return result;

            case ("twins"):
                int result1 = 0;
                for (String s : texts) {
                    if (getCheck(s,"twins" )) {
                        result1++;
                        System.out.println("TWINS = " + s + ";" + "result = " + result1);
                    }

                }
                return result1;
                case ("stairs"):
                    int result2 = 0;
                    for (String s : texts) {
                        if (getCheck(s,"stairs")) {
                            result2++;
                            System.out.println("STAIRS = " + s + ";" + "result = " + result2);
                        }

                    }
                    return result2;
        }
        return 0;
    }

}