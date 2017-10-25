package lection03.task01;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
	private static final int CAPACITY = 10;
	private String name;
	private Student[] storage = new Student[CAPACITY];

	public Group() {
		super();
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	public boolean addStudent(Student student) throws GroupOutOfBoundsException {
		if (student == null) {
			return false;
		}
		for (int i = 0; i < storage.length; i++) {
			Student tempStudent = storage[i];
			if (tempStudent == null) {
				storage[i] = student;
				return true;
			} else {
				if (tempStudent.equals(student)) {
					System.err.print(tempStudent.getId() + " ID is already registered" + System.lineSeparator());
					return false;
				}
			}
		}
		throw new GroupOutOfBoundsException();
	}

	public Student remove(Student student) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i].equals(student)) {
				storage[i] = null;
				return student;
			}
		}
		return null;
	}

	public Student remove(int index) throws GroupOutOfBoundsException {
		checkIndex(index);
		Student student = storage[index];
		storage[index] = null;
		return student;
	}

	private void checkIndex(int index) throws GroupOutOfBoundsException {
		if (index >= storage.length || index < 0) {
			throw new GroupOutOfBoundsException();
		}
	}

	public Student findStudent(String surname) {
		Student studentFound = null;

		if (surname == null) {
			for (Student student : storage) {
				if (student != null && student.getSurname() == null) {
					studentFound = student;
					break;
				}
			}
		} else {
			for (Student student : storage) {
				if (student != null && student.getSurname() != null && student.getSurname().equals(surname)) {
					studentFound = student;
					break;
				}
			}
		}

		return studentFound;
	}

	public void clear() {
		storage = new Student[CAPACITY];
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

	public Student[] getStorage() {
		return storage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student[] getStudents() {
		return storage;
	}

	public void setStudents(Student[] students) {
		this.storage = students;
	}

	@Override
	public String toString() {
		String result = sortBySurname().toString();
		return result;
	}

	protected StringBuilder sortBySurname() {
		Student[] sortedArray = new Student[storage.length];
		StringBuilder sb = new StringBuilder();
		sb.append("Group list sorted by Surname:" + System.lineSeparator());

		System.arraycopy(storage, 0, sortedArray, 0, storage.length);

		Arrays.sort(sortedArray, new Comparator<Student>() {

			@Override
			public int compare(Student student1, Student student2) {
				int res = 0;
				if (student1 != null && student1.getSurname() != null) {
					if (student2 != null && student2.getSurname() != null) {
						res = student1.getSurname().compareTo(student2.getSurname());
					}
				}
				return res;
			}

		});

		for (Student student : sortedArray) {
			if (student != null) {
				sb.append(student + System.lineSeparator());
			}
		}

		return sb;
	}

}
