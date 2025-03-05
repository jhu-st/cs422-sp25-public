package tests;


import task2.Main;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testFindPairsSumWithNoPairs() {
        // Test case where there are no pairs that sum to the target value
        int[] numbers = {1, 2, 3, 4, 5};
        int k = 10;

        List<Pair<Integer, Integer>> result = Main.findPairsSum(numbers, k);

        // The result should be empty as no pairs sum up to 10
        assertTrue(result.isEmpty());
    }

    @Test
    void testFindPairsSumWithOneElement() {
        // Test case where the input array has less than two elements
        int[] numbers = {5};
        int k = 5;

        List<Pair<Integer, Integer>> result = Main.findPairsSum(numbers, k);

        // The result should be empty as there are not enough numbers to form a pair
        assertTrue(result.isEmpty());
    }

    @Test
    void testFindPairsSumWithValidPair() {
        // Test case where there is exactly one valid pair that sums to k
        int[] numbers = {2, 4, 1, 3, 2, 0};
        int k = 4;

        List<Pair<Integer, Integer>> result = Main.findPairsSum(numbers, k);

        // The result should contain the pair (0, 4), (1, 3), (2, 2)
        assertEquals(3, result.size());
        assertTrue(result.contains(Pair.of(0, 4)));
        assertTrue(result.contains(Pair.of(1, 3)));
        assertTrue(result.contains(Pair.of(2, 2)));
    }

    @Test
    void testFindPairsSumWithSumLessThanK() {
        // Test case where sum of left and right element is less than k
        int[] numbers = {1, 2, 3, 4};
        int k = 10;

        List<Pair<Integer, Integer>> result = Main.findPairsSum(numbers, k);

        // No pairs found because all sums are less than 10
        assertTrue(result.isEmpty());
    }

    @Test
    void testFindPairsSumWithSumGreaterThanK() {
        // Test case where sum of left and right element is greater than k
        int[] numbers = {5, 6, 7, 8};
        int k = 10;

        List<Pair<Integer, Integer>> result = Main.findPairsSum(numbers, k);

        // No pairs found because all sums are greater than 10
        assertTrue(result.isEmpty());
    }

    @Test
    void testFindPairsSumWithMultipleValidPairs() {
        // Test case with multiple pairs that sum to k
        int[] numbers = {1, 2, 3, 3, 4, 5};
        int k = 6;

        List<Pair<Integer, Integer>> result = Main.findPairsSum(numbers, k);

        // The result should contain pairs (1, 5), (2, 4), and (3, 3)
        assertEquals(3, result.size());
        assertTrue(result.contains(Pair.of(1, 5)));
        assertTrue(result.contains(Pair.of(2, 4)));
        assertTrue(result.contains(Pair.of(3, 3)));
    }











    // Added after mutation analysis. To kill "changed conditional boundary → KILLED" on line 18.
    @Test
    void testFindPairsSumWithNoElement() {
        // Test case where the input array has less than two elements
        int[] numbers = {1, 2};
        int k = 3;

        List<Pair<Integer, Integer>> result = Main.findPairsSum(numbers, k);

        // The result should be empty as there are not enough numbers to form a pair
        assertTrue(result.contains(Pair.of(1, 2)));
    }
    // Added after mutation analysis. To kill "replaced return value with Collections.emptyList for task2/Main::findPairsSum → KILLED" on line 19.
    @Test
    void testFindPairsReturnsEmptyArrayList() {
        // Test case where the input array has less than two elements
        int[] numbers = {5};
        int k = 5;

        List<Pair<Integer, Integer>> result = Main.findPairsSum(numbers, k);

        // The result should be empty as there are not enough numbers to form a pair
        assertInstanceOf(ArrayList.class, result);
    }

    // "changed conditional boundary → SURVIVED" on line 35 is not possible to kill!

}
