public class HeapSort
{
    public void sort(int[] arr)
    {
        int n = arr.Length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i >= 0; i--)
        {
            (arr[0], arr[i]) = (arr[i], arr[0]);
            heapify(arr, i, 0);
        }
    }

    void heapify(int[] arr, int n, int i)
    {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;
        if (largest != i)
        {
            (arr[i], arr[largest]) = (arr[largest], arr[i]);
            heapify(arr, n, largest);
        }
    }

    static void printArray(int[] arr) => Console.WriteLine(string.Join(", ", arr));

    public static void Main(string[] args)
    {
        int[] array = { 12, 11, 13, 5, 6, 7 };
        int n = array.Length;

        HeapSort ob = new HeapSort();
        ob.sort(array);

        printArray(array);
    }
}