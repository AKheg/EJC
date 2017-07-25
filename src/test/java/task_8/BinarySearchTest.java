package task_8;

import org.junit.Assert;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testFind() {
        int[] array = {8, 11, 12, 24, 24, 25, 30, 36, 37, 42, 44, 58, 61, 61, 64, 64, 74, 87, 93, 96};
        Assert.assertEquals(9, new BinarySearch().find(array, 42));
    }

}