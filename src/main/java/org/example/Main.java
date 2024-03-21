package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static AtomicInteger count3;
    static AtomicInteger count4;
    static AtomicInteger count5;
    static Map<Integer,String> alphabetMap = new HashMap<Integer, String>() {
        {

            for (char ch = 'a'; ch <= 'z'; ++ch)
                put((int) ch, String.valueOf(ch));

        }
    };


    public static void main(String[] args) {
        System.out.println("Поехали");
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }
        int a = getPalCount(texts);

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
        for (int i = 0; i < texts.length; i++) {
            String s = texts[i];
            check = true;
                 for (int j = 1; j < s.length() - 2 ; j++) {
                    if (s.charAt(j) != s.charAt(j + 1)){
                        check = false;
                    }
                }
            if (check == true && s.charAt(0) == s.charAt(s.length() - 1)){
                result ++;
                System.out.println("s = " + s + ";" + "result = " + result);
            }



        }

        return result;

    }

    public static int getOneLetterCount (int length,String [] text){
        return 0;
    } public static int getStairsCount (int length,String [] text){
        return 0;
    }


}