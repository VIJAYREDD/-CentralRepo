package or.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import or.edu.domain.Login;
import or.edu.domain.Student;
import or.edu.service.StudentService;

@Controller
public class LoginController {
	private static final String userList = "userList";
	private static final String loginForm = "login";
	@Autowired
	StudentService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.put("login", new Login());
		return loginForm;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String userList(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		List<Student> list = null;
		list = service.listPersons();
		model.put("msg", list);
		model.put("users", list);
		return userList;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Login login, ModelMap model) {
		if (service.findUser(login.getUsername(), login.getPassword())) {
			List<Student> list = service.listPersons();
			model.put("users", list);
			return userList;
		} else {
			model.put("message", "Please enter valid Username or Password !!");
			return loginForm;
		}
	}

	@RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") Long id, ModelMap model) {
		service.removePerson(id);
		model.put("users", service.listPersons());
		return userList;
	}
}
