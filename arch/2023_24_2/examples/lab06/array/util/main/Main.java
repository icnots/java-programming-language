package array.util.main;

import static array.util.ArrayUtil.minMax;

public class Main{
    public static void main(String[] args){
        String arrayLenTxt = System.console().readLine();
        int arrayLen = Integer.parseInt(arrayLenTxt);

        int[] intArray = new int[arrayLen];

        for (int i = 0; i < arrayLen; i++){
            intArray[i] = Integer.parseInt(
                System.console().readLine()
            );
        }

        System.out.println(java.util.Arrays.toString(intArray));
        int[] minMax = minMax(intArray);
        System.out.println(java.util.Arrays.toString(array.util.ArrayUtil.minMax(intArray)));
    }
}