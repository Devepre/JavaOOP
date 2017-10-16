package lection02.task01;

import java.util.Arrays;

public class Board {
	public static final int CAPACITY = 4;
	private Shape[] storage;

	public Board() {
		super();
		storage = new Shape[CAPACITY];
	}

	public void printBoard() {
		System.out.println(this);
		System.out.println("Total area of " + storage.getClass().getEnclosingClass() + " are: " + getTotalArea());
	}

	protected double getTotalArea() {
		double totalArea = 0;
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null) {
				double area = storage[i].getArea();
				if (area > 0) {
					totalArea += area;
				}
			}
		}
		return totalArea;
	}

	public boolean addShape(Shape shape) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] == null) {
				storage[i] = shape;
				return true;
			}
		}
		return false;
	}

	public boolean addShape(int index, Shape shape) {
		if (!checkIndex(index)) {
			return false;
		}
		if (storage[index] != null) {
			return false;
		}
		storage[index] = shape;
		return true;
	}

	public Shape get(int index) {
		if (checkIndex(index)) {
			Shape shape = storage[index];
			return shape;
		}
		return null;
	}

	public Shape set(int index, Shape shape) {
		if (checkIndex(index)) {
			storage[index] = shape;
			return storage[index];
		}
		return null;
	}

	public Shape remove(int index) {
		if (checkIndex(index)) {
			Shape shape = storage[index];
			storage[index] = null;
			return shape;
		}
		return null;
	}

	private boolean checkIndex(int index) {
		if (index >= storage.length || index < 0) {
			return false;
		}
		return true;
	}

	public void clear() {
		storage = new Shape[CAPACITY];
	}

	public int size() {
		int size = 0;
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null) {
				size++;
			}
		}
		return size;
	}

	public int capacity() {
		return CAPACITY;
	}

	public Shape[] getStorage() {
		return storage;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + Arrays.toString(storage);
	}

}
