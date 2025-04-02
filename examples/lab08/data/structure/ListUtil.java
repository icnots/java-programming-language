package data.structure;

import java.util.ArrayList;
import java.util.Collections;

public class ListUtil{
    public static ArrayList<Integer> divisors(int n){
        ArrayList<Integer> divisors =  new ArrayList<Integer>();

        for (int i = 1; i <= n; i++){
            if (n % i == 0){
                divisors.add(i);
            }
        }

        return divisors;
    }

    public static ArrayList<String> withSameStartEnd(ArrayList<String> texts){
        ArrayList<String> res = new ArrayList<String>();

        for (String text : texts){
            if (null == text){
                continue;
            }

            if (text.length() > 0 && text.charAt(0) == text.charAt(text.length()-1)){
                res.add(text);
            }
        }

        return res;
    }

    public static void maxToFront(ArrayList<String> texts){
        if (null == texts || texts.size() == 0){
            return;
        }
        System.out.println("texts: "+texts);
        String maxValue = Collections.max(texts);
        texts.remove(maxValue);
        System.out.println("texts: "+texts);
        texts.add(0, maxValue);
        System.out.println(maxValue);
        System.out.println("texts: "+texts);
    }
}