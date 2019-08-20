package com.eclipseoptions.javatest.tuple.api;

import java.util.Arrays;
import java.util.Collection;

public class TupleFactoryImpl implements TupleFactory{

    @Override
    public <T> Tuple<T> newTuple(T... arr) {
        return new TupleArrayImpl<>(Arrays.asList(arr));
    }

    @Override
    public <T> Tuple<T> newTuple(Collection<T> collection) {
        return new TupleArrayImpl<>(collection);

    }
}
