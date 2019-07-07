package or.edu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import or.edu.domain.Student;

@Component(value = "studentValidator")
public class StudentValidator implements Validator {

	// which objects can be validated by this validator
	@Override
	public boolean supports(Class<?> paramClass) {
		return Student.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "firstname.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "lastname.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "address.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "phone.required");

	}
}