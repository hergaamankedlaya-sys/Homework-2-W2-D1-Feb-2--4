// Partition.java
// This class contains two different partition methods used in QuickSort.
// The goal of partitioning is to rearrange elements around a pivot.
public class Partition {

    // Lomuto partition
    // We pick the LAST element as the pivot.
    // Everything smaller than or equal to the pivot goes to the left,
    // everything bigger stays on the right.
    public static int lomutoPartition(int[] arr) {

        // If the array is empty, there is nothing to partition
        if (arr.length == 0) return -1;

        int pivot = arr[arr.length - 1]; // choosing the last element as pivot
        int i = -1; // i keeps track of the "smaller than pivot" section

        // Loop through the array except the pivot
        for (int j = 0; j < arr.length - 1; j++) {
            // If current element is smaller than or equal to pivot,
            // move it to the left side
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Finally, put the pivot in its correct position
        swap(arr, i + 1, arr.length - 1);

        // Return the index where the pivot ends up
        return i + 1;
    }

    // Hoare partition
    // We pick the FIRST element as the pivot.
    // Two pointers move toward each other and swap values when needed.
    public static int hoarePartition(int[] arr) {

        // If the array is empty, just return
        if (arr.length == 0) return -1;

        int pivot = arr[0]; // choosing the first element as pivot
        int i = -1;         // left pointer
        int j = arr.length; // right pointer

        while (true) {

            // Move i to the right until we find something >= pivot
            do {
                i++;
            } while (arr[i] < pivot);

            // Move j to the left until we find something <= pivot
            do {
                j--;
            } while (arr[j] > pivot);

            // If pointers cross, partitioning is done
            if (i >= j) {
                return j;
            }

            // Swap elements that are on the wrong side
            swap(arr, i, j);
        }
    }

    // Simple helper method to swap two elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
