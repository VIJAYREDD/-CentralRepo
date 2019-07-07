package or.edu.repo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import or.edu.domain.Student;

@Repository
public class StudentRepoImpl implements StudentRepo {

	@Autowired
	SessionFactory factory;

	public Session getsession() {
		return factory.getCurrentSession();
	}

	@Override
	public void addPerson(Student student) {
		getsession().save(student);
	}

	@Override
	public void updatePerson(Student p) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Student> listPersons() {
		Query query = getsession().getNamedQuery("getAllStudents");
		List<Student> list = query.list();
		return list;
	}

	@Override
	public Student getPersonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removePerson(Long id) {
		Query query = getsession().getNamedQuery("deleteStudent");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	public boolean findUser(String username, String password) {

		boolean userFound = false;
		Query query = getsession().getNamedQuery("findUser");
		query.setParameter("username", username);
		query.setParameter("password", password);
		List<Student> list = query.list();

		if ((list != null) && (list.size() > 0)) {
			userFound = true;
		}
		return userFound;
	}

}
