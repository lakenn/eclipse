package com.eclipseoptions.javatest.tuple.api;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class TupleArrayImplTest {

    @Test
    public void testGetSize() {
        List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        Tuple<String> tuple = new TupleArrayImpl<>(messages);
        assertEquals(messages.size(), tuple.size());
    }

    @Test
    public void testGetByIndex() {
        List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        Tuple<String> tuple = new TupleArrayImpl<>(messages);

        String element = tuple.get(0);
        assertEquals(messages.get(0), element);

        element = tuple.get(messages.size()-1);
        assertEquals(messages.get(messages.size()-1), element);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetIndexOutOfBound() {
        List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        Tuple<String> tuple = new TupleArrayImpl<>(messages);
        tuple.get(messages.size());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetNegativeIndex() {
        List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        Tuple<String> tuple = new TupleArrayImpl<>(messages);
        tuple.get(-1);
    }

    @Test
    public void testReplaceReturnNewTuple() {
        List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        Tuple<String> tuple = new TupleArrayImpl<>(messages);
        Tuple<String> newTuple = tuple.replace(0, "Morning");
        assertEquals("Morning", newTuple.get(0));
        assertEquals("Hello", tuple.get(0));
    }

    @Test
    public void testToArray() {
        List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        Tuple<String> tuple = new TupleArrayImpl<>(messages);
        assertArrayEquals(messages.toArray(), tuple.toArray());
    }

    @Test
    public void testIsTupleImmutable() {
        List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        Tuple<String> tuple = new TupleArrayImpl<>(messages);
        String[] tupleArray = (String[])tuple.toArray();
        tupleArray[0] = "Morning";
        assertEquals("hello", tuple.get(0));
    }

    @Test
    public void testIterator() {
        List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        Tuple<String> tuple = new TupleArrayImpl<>(messages);

        Iterable<String> iterable = () -> tuple.iterator();
        List<String> tupleList = StreamSupport
                .stream(iterable.spliterator(), false)
                .collect(Collectors.toList());

        assertEquals(messages, tupleList);
    }

    @Test
    public void testEqualsWithEmptyTuple() {
        Tuple<String> tuple1 = new TupleArrayImpl<>(new ArrayList<String>());
        Tuple<String> tuple2 = new TupleArrayImpl<>(new ArrayList<String>());
        assertEquals(tuple1, tuple2);
    }

    @Test
    public void testEqualsTuples() {
        List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        Tuple<String> tuple1 = new TupleArrayImpl<>(messages);
        List<String> secondMessage = Arrays.asList("Hello", "World!", "How", "Are", "You");
        Tuple<String> tuple2 = new TupleArrayImpl<>(secondMessage);
        assertEquals(tuple1, tuple2);
    }

    @Test
    public void testEqualsWithAllNullElements() {
        List<String> messages = Arrays.asList(null, null);
        Tuple<String> tuple1 = new TupleArrayImpl<>(messages);
        List<String> secondMessage = Arrays.asList(null, null);
        Tuple<String> tuple2 = new TupleArrayImpl<>(secondMessage);
        assertEquals(tuple1, tuple2);
    }


    @Test
    public void testNotEqualsWithNullElements() {
        List<String> messages = Arrays.asList(null, "Start");
        Tuple<String> tuple1 = new TupleArrayImpl<>(messages);
        List<String> secondMessage = Arrays.asList("Start", null);
        Tuple<String> tuple2 = new TupleArrayImpl<>(secondMessage);
        assertNotEquals(tuple1, tuple2);
    }


    @Test
    public void testNotEqualsWithSameElementsInDifferentOrder() {
        List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        Tuple<String> tuple1 = new TupleArrayImpl<>(messages);
        List<String> secondMessage = Arrays.asList("Hello", "How", "World!", "Are", "You");
        Tuple<String> tuple2 = new TupleArrayImpl<>(secondMessage);
        assertNotEquals(tuple1, tuple2);
    }

    @Test
    public void testNotEqualsWithTuplesWithDifferentLength() {
        List<String> messages = Arrays.asList("Hello");
        Tuple<String> tuple1 = new TupleArrayImpl<>(messages);
        List<String> secondMessage = Arrays.asList("Hello", "How", "World!", "Are", "You");
        Tuple<String> tuple2 = new TupleArrayImpl<>(secondMessage);
        assertNotEquals(tuple1, tuple2);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorRemoveException() {
        List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        Tuple<String> tuple = new TupleArrayImpl<>(messages);
        Iterator<String> it = tuple.iterator();
        it.next();
        it.remove();
    }
}