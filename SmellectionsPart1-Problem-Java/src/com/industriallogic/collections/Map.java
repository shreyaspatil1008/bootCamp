/// ***************************************************************************
/// Copyright (c) 2009, Industrial Logic, Inc., All Rights Reserved.
///
/// This code is the exclusive property of Industrial Logic, Inc. It may ONLY be
/// used by students during Industrial Logic's workshops or by individuals
/// who are being coached by Industrial Logic on a project.
///
/// This code may NOT be copied or used for any other purpose without the prior
/// written consent of Industrial Logic, Inc.
/// ****************************************************************************

package com.industriallogic.collections;

public class Map {
    private static final int INITIAL_CAPACITY = 10;
    private Set keys = new Set();
    private List values = new List();
    private int size = 0;
    private int indexWhereKeyFound;
    private boolean readOnly;

    public void addAll(Map c) {
        for (int i = 0; i < c.size(); i++)
            add(c.getKey(i), c.getValue(i));
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Object key, Object value) {
        if (!readOnly) {
            if (hasReplaced(key, value)) return;

            if (shouldGrow()) {
                grow();
            }

            setKey(size, key);
            setValue(size, value);
            size++;
        }
    }

    private boolean hasReplaced(Object key, Object value) {
        for (int i = 0; i < size; i++)
            if (getKey(i).equals(key)) {
                values.set(i,null);
                values.set(i, value);
                return true;
            }
        return false;
    }

    private boolean shouldGrow() {
        return size + 1 > capacity();
    }

    private void grow() {
        keys.grow();
        values.grow();
    }

    public int capacity() {
        return keys.capacity();
    }

    public int size() {
        return size;
    }

    public boolean remove(Object key) {
        if (readOnly)
            return false;
        for (int i = 0; i < size; i++)
            if (getKey(i).equals(key)) {
                keys.remove(key);
                Object value = values.get(i);
                values.remove(value);
                size--;
                return true;
            }
        return false;
    }

    public boolean contains(Object value) {
        for (int i = 0; i < size; i++)
            if ((value == null && getValue(i) == null)
                    || (getValue(i) != null && getValue(i).equals(value)))
                return true;
        return false;
    }

    public boolean containsKey(Object key) {
        for (int i = 0; i < size; i++)
            if (getKey(i) != null && getKey(i).equals(key)) {
                indexWhereKeyFound = i;
                return true;
            }
        return false;
    }

    public Object get(Object key) {
        if (!containsKey(key))
            return null;
        return getValue(indexWhereKeyFound);
    }

    public void setReadOnly(boolean b) {
        readOnly = b;
    }

    private Object getValue(int i) {
        return values.get(i);
    }

    private void setValue(int i, Object value) {
        values.add(value);
    }

    private Object getKey(int i) {
        return keys.get(i);
    }

    private void setKey(int i, Object value) {
        keys.add(value);
    }
}
