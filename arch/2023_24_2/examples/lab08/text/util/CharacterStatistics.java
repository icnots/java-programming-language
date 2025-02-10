package text.util;

import java.util.HashMap;

public class CharacterStatistics{
    private HashMap<Character, Integer> charToCount;

    public CharacterStatistics(String text){
        charToCount = new HashMap<>();

        for (char c : text.toCharArray()){
            int count = charToCount.getOrDefault(c, 0);

            charToCount.put(c, count+1);
        }
    }

    public int getCount(char c){
        return charToCount.getOrDefault(c, 0).intValue();
    }

    @Override
    public String toString(){
        return charToCount.entrySet().toString();
    }
}