// PartitionTest.java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// This class tests both Lomuto and Hoare partition methods
public class PartitionTest {

    @Test
    void testLomutoWithSortedArray() {
        // Already sorted array
        int[] arr = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};

        int index = Partition.lomutoPartition(arr);

        // Since pivot is the largest element, it should end at the last index
        assertEquals(9, index);
    }

    @Test
    void testLomutoWithEmptyArray() {
        int[] arr = {};

        int index = Partition.lomutoPartition(arr);

        // Empty array should return -1
        assertEquals(-1, index);
    }

    @Test
    void testLomutoWithUnsortedArray() {
        int[] arr = {84, 3, 7, 1, 9, 6, 2, 5};

        int index = Partition.lomutoPartition(arr);

        // Just checking that the returned index is valid
        assertTrue(index >= 0 && index < arr.length);
    }

    @Test
    void testHoareWithSortedArray() {
        // Already sorted array
        int[] arr = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};

        int index = Partition.hoarePartition(arr);

        // Pivot is the smallest element, so partition index should be 0
        assertEquals(0, index);
    }

    @Test
    void testHoareWithEmptyArray() {
        int[] arr = {};

        int index = Partition.hoarePartition(arr);

        // Empty array should return -1
        assertEquals(-1, index);
    }

    @Test
    void testHoareWithUnsortedArray() {
        int[] arr = {84, 3, 7, 1, 9, 6, 2, 5};

        int index = Partition.hoarePartition(arr);

        // Make sure partition index is within array bounds
        assertTrue(index >= 0 && index < arr.length);
    }
}
