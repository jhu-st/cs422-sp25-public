package task2;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /** Given a number 'k', this method finds and returns a list of
     * any two numbers from the array such that their sum equals k.
     * Example: findPairsSum({2, 4, 1, 3, 2, 0}, 4) --> {(0, 4), (1, 3), (2, 2)}
     * @param numbers the input array
     * @param k the target sum value
     **/
    public static List<Pair<Integer, Integer>> findPairsSum(int[] numbers, int k) {
        if(numbers.length < 2) {
            return new ArrayList<>();
        }

        List<Pair<Integer, Integer>> list = new ArrayList<>();

        Arrays.sort(numbers);

        int left = 0;
        int right = numbers.length -1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == k) {
                list.add(new ImmutablePair<>(numbers[left], numbers[right]));
                left = left + 1;
                right = right -1;
            } else if (sum < k) {
                left = left + 1;
            } else {
                right = right - 1;
            }
        }
        return list;
    }
}