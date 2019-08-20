package com.eclipseoptions.javatest.tuple.api;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TupleFactoryImplTest {

    private TupleFactory tupleFactory;

    @Before
    public void setUp(){
        tupleFactory = new TupleFactoryImpl();
    }

    @Test
    public void testCreationWithCollection() {
        List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        Tuple<String> tuple = tupleFactory.newTuple(messages);
        Tuple<String> tuple2 = new TupleArrayImpl<>(messages);
        assertEquals(tuple, tuple2);
    }

    @Test
    public void testCreationWithArray() {
        List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        Tuple<String> tuple = tupleFactory.newTuple((String[])messages.toArray());
        Tuple<String> tuple2 = new TupleArrayImpl<>(messages);
        assertEquals(tuple, tuple2);
    }


    @org.junit.Test
    public void testNewTupleWithEmptyCollection() {
        List<String> messages = Arrays.asList();
        Tuple<String> tuple = tupleFactory.newTuple(messages);
        assertEquals(0, tuple.size());
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void testNewTupleWithNullCollection() {
        List<String> messages = null;
        Tuple<String> tuple = tupleFactory.newTuple(messages);
        assertEquals(0, tuple.size());
    }

    @org.junit.Test
    public void testNewTupleWithCollectionOfNull() {
        List<String> messages = Arrays.asList(null, null);
        Tuple<String> tuple = tupleFactory.newTuple(messages);
        assertEquals(messages.size(), tuple.size());
    }

    @org.junit.Test
    public void testNewTupleWithEmptyArray() {
        Tuple<String> tuple = tupleFactory.newTuple(new String[0]);
        assertEquals(0, tuple.size());
    }

    @org.junit.Test
    public void testNewTupleEmptyArgs() {
        Tuple<String> tuple = tupleFactory.newTuple();
        assertEquals(0, tuple.size());
    }

    @org.junit.Test
    public void testNewTupleVargs() {
        Tuple<Integer> tuple = tupleFactory.newTuple(1, 2, 3, 4);
        assertEquals(4, tuple.size());

    }
}