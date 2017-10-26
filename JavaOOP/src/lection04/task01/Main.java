package lection04.task01;

import java.util.Date;

import lection04.task01.Group;
import lection04.task01.GroupOutOfBoundsException;
import lection04.task01.Human;
import lection04.task01.Student;

public class Main {

	public static void main(String[] args) {
		Group group = new Group("Math17");

		System.out.println("Adding new members with Surnames to sort to the group");
		Student st1 = new Student("Jack", "Brown", new Date(), true, 23);
		Student st2 = new Student("Mike", "White", new Date(), true, 23);
		Student st3 = new Student("Bill", "Yellow", new Date(), true, 23);
		Student st4 = new Student("Ann", "Green", new Date(), false, 32);
		Student st5 = new Student("Maria", "Red", new Date(), false, 43);
		Student st6 = new Student("Mark", "Purple", new Date(), true, 4);
		Student st7 = new Student("John", "Borm", new Date(), true, 24);
		Student st8 = new Student("Jack", "Black", new Date(), true, 9);
		try {
			group.addStudent(st1);
			group.addStudent(st2);
			group.addStudent(st3);
			group.addStudent(st4);
			group.addStudent(st5);
			group.addStudent(st6);
			group.addStudent(st7);
			group.addStudent(st8);
			group.addStudent(new Student("Null", "Null", new Date(), true, 23));
		} catch (GroupOutOfBoundsException e) {
			e.printStackTrace();
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		System.out.println(group);
		System.out.println("Total places left: " + (group.capacity() - group.size()));

		try {
			group.addStudent();
			group.addStudent();
		} catch (GroupOutOfBoundsException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		System.out.println(group);

	}

}
