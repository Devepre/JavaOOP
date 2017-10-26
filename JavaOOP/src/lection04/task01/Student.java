package lection04.task01;

import java.util.Date;

public class Student extends Human {
	private double stipend;

	public Student() {
		super();
	}

	public Student(String name, String surname, Date dateOfBirth, boolean male, double stipend) {
		super(name, surname, dateOfBirth, male);
		if (name == null || surname == null || dateOfBirth == null) {
			throw new IllegalArgumentException("Namre, Surname and date of birth can't be null");
		}
		this.stipend = stipend;
	}

	@Override
	public void printInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("I'm a Student");
		sb.append(System.lineSeparator());
		sb.append("My name is " + super.getName());
		sb.append(System.lineSeparator());
		sb.append("My Surname is " + super.getSurname());
		sb.append(System.lineSeparator());
		System.out.println(sb.toString());
		// super.printInfo();
	}

	@Override
	public String toString() {
		return super.toString() + " | stipend=" + stipend + "]";
	}

}
