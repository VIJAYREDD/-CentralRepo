package or.edu.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import or.edu.domain.Student;
import or.edu.exception.ResourceNotFoundException;
import or.edu.repo.StudentRepo;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepo repo;

	@Override
	public void register(Student student) {
		repo.addPerson(student);
	}

	@Override
	public void updatePerson(Student p) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Student> listPersons() {
		List<Student> list = repo.listPersons();
		if (list.isEmpty()) {
			throw new ResourceNotFoundException("data is not available");
		}
		return list;
	}

	@Override
	public Student getPersonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void removePerson(Long id) {
		this.repo.removePerson(id);
	}

	@Override
	public boolean findUser(String username, String password) {
		boolean user = repo.findUser(username, password);
		return user;
	}

}
