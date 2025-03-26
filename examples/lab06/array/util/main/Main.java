package array.util.main;

import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        System.out.print("length of array: ");
        String arrayLenTxt = System.console().readLine();
        int arrayLen = Integer.parseInt(arrayLenTxt);
        int[] arr = new int[arrayLen];
        for (int i = 0; i < arrayLen; i++){
            arr[i] = Integer.parseInt(System.console().readLine());
        }

        System.out.println("The array: " + Arrays.toString(arr));
        System.out.println("Max: " + array.util.ArrayUtil.max(arr));
        System.out.println("Min, Max: " + Arrays.toString(array.util.ArrayUtil.minMax(arr)));
    }

}