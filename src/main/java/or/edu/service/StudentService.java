package or.edu.service;

import java.util.List;

import or.edu.domain.Student;

public interface StudentService {

	void register(Student student);

	public void updatePerson(Student p);

	public List<Student> listPersons();

	public Student getPersonById(int id);

	public void removePerson(Long id);

	boolean findUser(String username, String password);

}
