package com.eclipseoptions.javatest.tuple.api;

import java.util.*;

public class TupleArrayImpl<T> implements Tuple<T> {
    private final T[] bucket;

    private TupleArrayImpl(T[] bucket){
        this.bucket = bucket;
    }

    public TupleArrayImpl(Collection<T> collection) {
        this.bucket = (T[]) collection.toArray();
    }

    @Override
    public T get(int index) {
        return this.bucket[index];
    }

    @Override
    public Tuple<T> replace(int index, T value) {
        T[] newBucket = Arrays.copyOf(this.bucket, this.size());
        newBucket[index] = value;
        return new TupleArrayImpl<>(newBucket);
    }

    @Override
    public int size() {
        return this.bucket.length;
    }

    @Override
    public Object[] toArray() {
        // to make Tuple immutable, return the clone of bucket
        return Arrays.copyOf(this.bucket, this.size());
    }

    @Override
    public Iterator<T> iterator() {
        return Arrays.asList(this.bucket).iterator();
    }

    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }

        if (o instanceof Tuple) {
            final Tuple<T> other = (Tuple<T>) o;
            return Arrays.equals(this.toArray(), other.toArray());
        }
        return false;
    }

    @Override
    public int hashCode(){
        // Don't cache the hashcode even tuple is immutable
        // as the elements stored could be mutable
        return Arrays.hashCode(this.bucket);

    }

    @Override
    public String toString() {
        return Arrays.toString(this.bucket);
    }
}
