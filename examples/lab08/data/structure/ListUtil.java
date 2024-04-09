package data.structure;

import java.util.ArrayList;

public class ListUtil{
    public static ArrayList<Integer> divisors(int number){
        ArrayList<Integer> divisorList = new ArrayList<Integer>(2);
        for (int divisor = 1; divisor <= number; divisor++){
            if (number % divisor == 0){
                divisorList.add(divisor);
            }
        }
        return divisorList;
    }
    public static ArrayList<String> withSameStartEnd(ArrayList<String> words){
        ArrayList<String> result = new ArrayList<>();
        for (String word : words){
            if (word != null && word.length() > 0 && word.charAt(0) == word.charAt(word.length()-1)){
                result.add(word);
            }
        }

        return result;
    }
    public static void maxToFront(ArrayList<String> words){
        if (null != words && words.size() > 1){
            String maxElem = java.util.Collections.max(words);
    
            words.remove(maxElem);
            words.add(0, maxElem);
        }
    }
}