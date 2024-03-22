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
        int a = getTwinsCount(texts);


    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }
    public static int getPalCount (String [] texts){
        int result = 0;
        boolean check;
        boolean check1;
        for (int i = 0; i < texts.length; i++) {
            check = true;
            String a = "";
            String b = null;
            String s = texts[i];
            System.out.println("s = " + s);

            if (s.length()%2 == 0){
                for (int j = 0; j < s.length()/2 - 1; j++) {
                    a = a + s.charAt(j);
                }
                System.out.println( "a = " + a);
                for (int j = s.length() - 1; j > s.length()/2 + 1; j--) {
                    b = "" + s.charAt(j);;

                }
                System.out.println("b = " + b);
                if (a.equals(b)){
                    result ++;
                    System.out.println("PAL = " + s + ";" + "result = " + result);
                }
            }
        }

        return result;

    }

    public static int getTwinsCount (String [] texts){
        int result = 0;
        for (int t = 0; t < texts.length; t++) {
            String s = texts[t];
            if (getTwinsCheck(s)){
               result ++;
               System.out.println("TWINS = " + s + ";" + "result = " + result);
            }

        }
        return result;

    }
    public static int getStairsCount (String [] text){
        return 0;
    }
    public static boolean getPalCheck (String s){
        return true;
    }
    public static boolean getTwinsCheck (String s){
            for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)){
                return false;
            }
        }
        return true;
    }

    public static boolean getStairsCheck (String s){
        return true;
    }

}