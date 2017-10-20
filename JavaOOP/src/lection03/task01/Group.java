package lection03.task01;

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

	/* It's "dumb" method of sorting. Works only for Latin alphabet
	 * Sorts only by first letter, ignoring all the other
	 * Array of objects remains the same.
	 * Just creates StringBuilder object which represents sorted data
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Group list sorted by Surname first letter:" + System.lineSeparator());

		// handling strange users without surnames to show first
		for (Student student : storage) {
			if (student != null && (student.getSurname() == null || student.getSurname() == "")) {
				sb.append(student + System.lineSeparator());
			}
		}

		char ch = 'a';
		for (int i = 0; i < 26; i++) { // 26 Latin letters
			for (Student student : storage) {
				if (student != null) {
					if (student.getSurname() == null || student.getSurname() == "") {
						// previous foreach already did the work
					} else {
						if (student.getSurname().substring(0, 1).toUpperCase()
								.equals(String.valueOf(ch).toUpperCase())) {
							sb.append(student + System.lineSeparator());
						}
					}
				}
			}
			ch++;
		}
		return sb.toString();
	}

}
