package array.util;

public class ArrayUtil{
    public static int max(int[] t){
        if (0 == t.length){
            return 0;
        }else{
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < t.length; i++){
                if (t[i] > maxValue){
                    maxValue = t[i];
                }
            }
            return maxValue;
        }
    }

    public static int max2(int[] t){
        if (0 == t.length){
            return 0;
        }else{
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < t.length; i++){
                int elem = t[i];
                maxValue = elem > maxValue ? elem : maxValue;
            }
            return maxValue;
        }
    }

    public static int max3(int[] t){
        if (0 == t.length){
            return 0;
        }else{
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < t.length; i++){
                maxValue = Math.max(maxValue, t[i]);
            }
            return maxValue;
        }
    }
    
    public static int max4(int[] t){
        if (0 == t.length){
            return 0;
        }else{
            int maxValue = Integer.MIN_VALUE;
            for (int elem : t){
                maxValue = Math.max(maxValue, elem);
            }
            return maxValue;
        }
    }

    public static int[] minMax(int[] t){
        if (0 == t.length){
            return new int[]{0, 0};
        }else{
            int minValue = t[0];
            int maxValue = t[0];
            for (int i = 1; i < t.length; i++){
                int elem = t[i];
                minValue = Math.min(minValue, elem);
                maxValue = Math.max(maxValue, elem);
            }
            int[] res = new int[]{minValue, maxValue};
            return res;
        }
    }
}