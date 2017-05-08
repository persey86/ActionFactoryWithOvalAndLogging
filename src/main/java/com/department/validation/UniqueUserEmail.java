package com.department.validation;

import com.department.exceptions.DepartmentRepositoryException;
import com.department.exceptions.UserRepositoryException;
import com.department.models.Department;
import com.department.models.User;
import com.department.repository.UserRepository;
import com.department.repository.impl.UserRepositoryImpl;
import net.sf.oval.constraint.CheckWithCheck;

import org.apache.log4j.Logger;


/**
 * Created on 20.04.17.
 */


public class UniqueUserEmail implements CheckWithCheck.SimpleCheck {

    private UserRepository userRepository = new UserRepositoryImpl();
    private static final Logger LOGGER = Logger.getLogger(UniqueUserEmail.class);

    @Override
    public boolean isSatisfied(Object validatedObject, Object value) {
        try {
            User user = userRepository.getByEmail(value.toString());
            if (user == null || user.getId().equals(((User) validatedObject).getId())) {
                return true;
            }
        } catch (UserRepositoryException e) {
            LOGGER.error("Error while getting validation for user by e-mail", e);
        }
        return false;

    }
}