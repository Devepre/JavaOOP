package lection04.task01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import javax.swing.JOptionPane;

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

	public void addStudent() throws GroupOutOfBoundsException {
		String stuSurname;
		String stuName;
		Date stuDate;
		Boolean isMale;
		Double stuStipend;

		stuSurname = getInputString("Please provide Surname", "Wrong Surname");
		if (stuSurname != null) {
			stuName = getInputString("Please provide Name", "Wrong Name");
			if (stuName != null) {
				stuDate = getInputDate("Please provide birth date", "Wrong birth date", "dd-MM-yyyy");
				if (stuDate != null) {
					isMale = getInputBoolean("Is it a man?", "Wrong sex input");
					if (isMale != null) {
						stuStipend = getInputDouble("Please provide stipend value", "Wrong number");
						if (stuStipend != null) {
							addStudent(new Student(stuName, stuSurname, stuDate, isMale, stuStipend));
							return;
						}
					}
				}
			}
		}

		System.out.println("User canceled creating Student");
	}

	protected String getInputString(String displayMessage, String errorMessage) {
		String result = null;
		for (;;) {
			try {
				result = JOptionPane.showInputDialog(displayMessage);
				if (result != null && result.equals("")) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, errorMessage);
			}
		}
		return result;

	}

	protected Date getInputDate(String displayMessage, String errorMessage, String dateView) {
		Date result = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateView);
		for (;;) {
			try {
				result = dateFormat.parse((JOptionPane.showInputDialog(displayMessage + " " + dateView)));
				break;
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, errorMessage);
			} catch (NullPointerException e) {
				break;
			}
		}
		return result;

	}

	protected Boolean getInputBoolean(String displayMessage, String errorMessage) {
		Boolean result = null;
		for (;;) {
			try {
				String text = JOptionPane.showInputDialog(displayMessage + " (yes/no)");
				if (text.equals("yes")) {
					result = true;
				} else if (text.equals("no")) {
					result = false;
				} else {
					throw new IllegalArgumentException();
				}
				break;
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, errorMessage + " (Should be \"yes\" or \"no\")");
			} catch (NullPointerException e) {
				break;
			}
		}
		return result;

	}

	protected Double getInputDouble(String displayMessage, String errorMessage) {
		Double result = null;
		for (;;) {
			try {
				result = Double.parseDouble(JOptionPane.showInputDialog(displayMessage));
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, errorMessage);
			} catch (NullPointerException e) {
				break;
			}
		}
		return result;

	}

	public boolean addStudent(Student student) throws GroupOutOfBoundsException, IllegalArgumentException {
		if (student == null) {
			throw new IllegalArgumentException("Student can't be null");
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
		StringBuilder sb = new StringBuilder();
		sb.append("Group list sorted by Surname:" + System.lineSeparator());

		for (Student student : sortBySurname()) {
			if (student != null) {
				sb.append(student + System.lineSeparator());
			}
		}

		return sb.toString();
	}

	protected Student[] sortBySurname() {
		Student[] sortedArray = new Student[storage.length];
		System.arraycopy(storage, 0, sortedArray, 0, storage.length);

		Arrays.sort(sortedArray, new Comparator<Student>() {

			@Override
			public int compare(Student student1, Student student2) {
				int res = 0;
				if (student1 != null && student1.getSurname() != null) {
					if (student2 != null && student2.getSurname() != null) {
						res = student1.getSurname().compareToIgnoreCase(student2.getSurname());
					}
				}
				return res;
			}

		});

		return sortedArray;
	}

}
