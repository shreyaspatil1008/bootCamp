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

public abstract class Collection {
	protected static final int INITIAL_CAPACITY = 10;
	protected Object[] elements = new Object[INITIAL_CAPACITY];
	protected int size = 0;
	protected boolean readOnly;

	public boolean isEmpty() {
		return size == 0;
	}

	public void addAll(Collection s) {
		for (int i=0; i < s.size(); i++) {
            if (!contains(s.get(i))) {
                add(s.get(i));
            }
        }
	}

	public int size() {
		return size;
	}

	public abstract void add(Object element);

	protected void grow() {
		int newSize = size + 1;
		if (newSize > elements.length) {
            Object[] newElements =
                new Object[elements.length + INITIAL_CAPACITY];
            for (int i = 0; i < size; i++)
                newElements[i] = elements[i];
            elements = newElements;
        }
	}

	public boolean remove(Object element) {
		if (readOnly)
			return false;
		for (int i = 0; i < size; i++)
			if (elements[i].equals(element)) {
				elements[i] = null;
				Object[] newElements = cloneObject();
				size--;
				elements = newElements;
				return true;
			}
		return false;
	}

	private Object[] cloneObject() {
		Object[] newElements = new Object[size - 1];
		int k = 0;
		for (int j = 0; j < size; j++) {
            if (elements[j] != null)
                newElements[k++] = elements[j];
        }
		return newElements;
	}

	protected void addElement(Object element) {
		elements[size++] = element;
	}
	public Object get(int i) {
		return elements[i];
	}

	public boolean contains(Object element) {
		for (int i=0; i<size; i++)
			if (elements[i].equals(element))
				return true;
		return false;
	}

	public int capacity() {
		return elements.length;
	}

	public void setReadOnly(boolean b) {
		readOnly = b;
	}
}
