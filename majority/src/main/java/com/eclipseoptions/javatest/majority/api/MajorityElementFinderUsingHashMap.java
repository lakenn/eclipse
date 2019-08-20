package com.eclipseoptions.javatest.majority.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Drawback: Extra space needed
 */
public class MajorityElementFinderUsingHashMap implements MajorityElementFinder {

    public int majorityElement(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        int threshold = numbers.length / 2;

        for(int num : numbers){
            int count = map.merge(num, 1, Integer::sum);
            if (count > threshold){
                return num;
            }
        }
        throw new RuntimeException("No majority element found");
    }
}
