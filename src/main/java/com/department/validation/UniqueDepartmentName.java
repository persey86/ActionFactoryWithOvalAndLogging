package com.department.validation;

import com.department.exceptions.DepartmentRepositoryException;
import com.department.models.Department;
import com.department.repository.DepartmentRepository;
import com.department.repository.impl.DepartmentRepositoryImpl;
import net.sf.oval.constraint.CheckWithCheck;
import org.apache.log4j.Logger;



/**
 * Created on 20.04.17.
 */
public class UniqueDepartmentName implements CheckWithCheck.SimpleCheck {

    private DepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
    private static final Logger LOGGER = Logger.getLogger(UniqueDepartmentName.class);

    @Override
    public boolean isSatisfied(Object validatedObject, Object value) {
        try {
            Department department = departmentRepository.getByName(value.toString());
            if (department == null || department.getId().equals(((Department) validatedObject).getId())) {
                return true;
            }
        } catch (DepartmentRepositoryException e) {
            LOGGER.error("Error while getting validation for department", e);
        }
        return false;
    }
}