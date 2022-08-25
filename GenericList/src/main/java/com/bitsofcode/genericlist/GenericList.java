package com.bitsofcode.genericlist;

import java.util.Collection;
import java.util.Iterator;

public class GenericList<T> implements Iterable<T> {
	private T[] dataArray;
	private int count = 0;
	
	
	@SafeVarargs
	GenericList(T... data) {
		for (T elmt : data) {
			this.add(elmt);
		}
	}
	
	GenericList(Collection<T> data) {
		for (T elmt : data) {
			this.add(elmt);
		}
	}
	
	public void add(T elmt) {
		dataArray[count++] = elmt;
	}
	
	public T get(int index) {
		return dataArray[index];
	}

	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new GenericListIterator<T>(dataArray);
	}
	
	@SuppressWarnings("hiding")
	private class GenericListIterator<T> implements Iterator<T> {
		T[] list;
		int count = 0;
		
		GenericListIterator(T[] dataArray) {
			list = dataArray;
		}
		
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return count < list.length;
		}

		public T next() {
			// TODO Auto-generated method stub
			return list[count++];
		}
	}
}