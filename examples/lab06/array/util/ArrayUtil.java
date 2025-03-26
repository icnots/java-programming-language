package array.util;

public class ArrayUtil{
    public static int max(int[] arr){
        int max;
        if (arr.length == 0){
            return 0;
        }else{
            max = Integer.MIN_VALUE;
        }

        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }

        return max;
    }
    public static int max2(int[] arr){
        int max = arr.length == 0 ? 0 : Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++){
            max = arr[i] > max ? arr[i] : max;
        }
        
        return max;
    }
    public static int max3(int[] arr){
        int max = arr.length == 0 ? 0 : Integer.MIN_VALUE;
        
        for (int i = 0; i < arr.length; i++){
            max = Math.max(arr[i], max);
        }
        
        return max;
    }
    public static int max4(int[] arr){
        int max = arr.length == 0 ? 0 : Integer.MIN_VALUE;
        
        for (int elem : arr){
            max = Math.max(elem, max);
        }
        
        return max;
    }
    public static int[] minMax(int[] arr){
        int max = arr.length == 0 ? 0 : Integer.MIN_VALUE;
        int min = arr.length == 0 ? 0 : Integer.MAX_VALUE;

        for (int elem : arr){
            max = elem > max ? elem : max;
            min = elem < min ? elem : min;
        }

        return new int[]{min, max};
    }
}