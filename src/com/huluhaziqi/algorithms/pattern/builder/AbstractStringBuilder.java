package com.huluhaziqi.algorithms.pattern.builder;

import java.util.Arrays;

public class AbstractStringBuilder {

    protected char[] value;

    protected  int count;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public AbstractStringBuilder(int capacity) {
        count = 0;
        value = new char[capacity];
    }

    public AbstractStringBuilder append(char c){
        expandCapacity(count + 1);
        value[count++] = c;
        return this;
    }


    void expandCapacity(int minimumCapacity){
        int newCapacity = (value.length << 1) + 2;
        if(newCapacity - minimumCapacity < 0){
            newCapacity = minimumCapacity;
        }
        newCapacity = (newCapacity < 0 || MAX_ARRAY_SIZE - newCapacity < 0) ? hugeCapacity(minimumCapacity) : newCapacity;
        value = Arrays.copyOf(value,newCapacity);
    }

    int hugeCapacity(int minimumCapacity){
        if(Integer.MAX_VALUE - minimumCapacity < 0){
            throw new OutOfMemoryError();
        }
        return minimumCapacity > MAX_ARRAY_SIZE ? minimumCapacity : MAX_ARRAY_SIZE;
    }
}
