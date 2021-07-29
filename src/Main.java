public class Main {

    static void swap(int[] arr, int i, int j)
    {
        int holder = arr[i];
        arr[i] = arr[j];
        arr[j] = holder;
    }

    static int divide(int[] arr, int left, int right)
    {

        int chosen = arr[right];

        int i = (left - 1);

        for(int j = left; j <= right - 1; j++)
        {
            if (arr[j] < chosen)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return (i + 1);
    }

    static void quickSort(int[] arr, int left, int right)
    {
        if (left < right)
        {
            int chosen = divide(arr, left, right);

            quickSort(arr, left, chosen - 1);
            quickSort(arr, chosen + 1, right);
        }
    }

    static void print(int[] arr)
    {
        int size = arr.length;

        System.out.print("[");
        for(int i = 0; i < size; i++)
        {
            System.out.print(arr[i]);
            if (i != size - 1) System.out.print(", ");
        }
        System.out.print("]");

        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] arr = { 100,123,32,43,123,543,32,52 };
        int n = arr.length;

        System.out.println("Original array");
        print(arr);
        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array");
        print(arr);
    }
}
