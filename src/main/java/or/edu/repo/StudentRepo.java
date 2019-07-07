package or.edu.repo;

import java.util.List;

import or.edu.domain.Student;

public interface StudentRepo {

	public void addPerson(Student p);

	public void updatePerson(Student p);

	public List<Student> listPersons();

	public Student getPersonById(int id);

	public void removePerson(Long id);

	public boolean findUser(String username, String password);
}
