package com.eclipseoptions.javatest.majority.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MajorityElementFinderUsingHashMapTest {
    private MajorityElementFinder majorElementFinder;

    @Before
    public void init(){
        majorElementFinder = new MajorityElementFinderUsingHashMap();
    }

    @org.junit.Test
    public void testLengthOneArray() {
        int[] numbers = new int[]{1};
        assertEquals(1, majorElementFinder.majorityElement(numbers));

    }

    @org.junit.Test
    public void testOddLengthArray() {
        int[] numbers = new int[]{1, 1, 1, 2, 3};
        assertEquals(1, majorElementFinder.majorityElement(numbers));

    }

    @Test
    public void testEvenLengthArray() {
        int[] numbers = new int[]{1, 1, 1, 2};
        assertEquals(1, majorElementFinder.majorityElement(numbers));
    }

    @Test
    public void testMaxIntegerValueArray() {
        int[] numbers = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0};
        assertEquals(Integer.MAX_VALUE, majorElementFinder.majorityElement(numbers));
    }

    @Test
    public void testMinIntegerValueArray() {
        int[] numbers = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, 0};
        assertEquals(Integer.MIN_VALUE, majorElementFinder.majorityElement(numbers));
    }

    @Test
    public void testAllTheSameValueArray() {
        int[] numbers = new int[]{2, 2, 2, 2};
        assertEquals(2, majorElementFinder.majorityElement(numbers));
    }

    @Test(expected = RuntimeException.class)
    public void testNoSolutionAllDifferentValueArray() {
        int[] numbers = new int[]{0, 1, 2, 3};
        majorElementFinder.majorityElement(numbers);
    }

}