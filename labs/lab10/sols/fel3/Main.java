
import java.util.Arrays;

class Main
{
    public static <T> void swap(T[] a, int i, int j)
    {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args)
    {
        Integer[] arr1 = {1, 3, 5, 9, 7};
        swap(arr1, 3, 4);
        System.out.println(Arrays.toString(arr1));

        Double[] arr2 = {2.3, 5.6, -3.4, 12.2};
        swap(arr2, 0, 2);
        System.out.println(Arrays.toString(arr2));
    }
}

