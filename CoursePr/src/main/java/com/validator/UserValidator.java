package com.validator;

import com.dao.UsersDAO;
import com.model.Users;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UsersDAO usersDAO;

    @Override
    public boolean supports(Class<?> aClass) {
        return Users.class.equals(aClass);
    }

    static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Users users = (Users) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "Required");
        if (users.getLogin().length() < 8 || users.getLogin().length() > 32) {
            errors.rejectValue("login", "Size.userForm.login");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (users.getPassword().length() < 8 || users.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "Required");


        if (usersDAO.findByUserName(users.getLogin()) != null) {
            errors.rejectValue("login", "Duplicate.userForm.login");
        }


        if (!isValid(users.getEmail())) {
            errors.rejectValue("email", "userForm.email");
        }
    }
}

