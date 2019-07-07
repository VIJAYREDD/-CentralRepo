package or.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import or.edu.domain.Student;
import or.edu.service.StudentService;

@Controller
public class Registrationcontroller {

	private static final Logger logger = Logger.getLogger(Registrationcontroller.class);
	private static final String register = "register";
	private static final String welcome = "welcome";

	@Autowired
	StudentService service;

	@Autowired
	@Qualifier("studentValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegister(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		model.put("student", new Student());
		return register;
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public String addUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("student") @Validated Student student, BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			return register;
		}
		service.register(student);
		logger.debug("Register successfully");
		model.put("firstname", student.getFirstname());
		return welcome;
	}

}
