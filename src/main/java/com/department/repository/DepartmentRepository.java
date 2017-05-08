package com.department.repository;

import com.department.exceptions.DepartmentRepositoryException;
import com.department.models.Department;

import java.sql.SQLException;

/**
 * Created on 15.04.2017.
 */
public interface DepartmentRepository extends GeneralRepository <Department, Integer, DepartmentRepositoryException>{

    Department getByName(String name) throws DepartmentRepositoryException;

}
