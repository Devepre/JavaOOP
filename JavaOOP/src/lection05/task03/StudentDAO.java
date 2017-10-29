package lection05.task03;

import java.io.IOException;

import lection04.task01.Student;

public interface StudentDAO {
	public void saveStudent(Student student) throws IOException;

	public Student loadStudent(int position) throws IOException;

}
