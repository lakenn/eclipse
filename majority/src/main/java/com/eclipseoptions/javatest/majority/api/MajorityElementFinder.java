package com.eclipseoptions.javatest.majority.api;

/**
 * Given an array of n integers, find the element that appears more than n/2 times.
 */
public interface MajorityElementFinder {

    /**
     * Given an array of n integers, find the element that appears more than n/2 times.
     *
     * You can assume that the array is non-empty and that an element will appear more than n/2 times.
     *
     * @param numbers the array of elements from which to find the majority element.
     * @return the value of the element that appears more than n/2 times.
     */
    int majorityElement(int[] numbers);

}
