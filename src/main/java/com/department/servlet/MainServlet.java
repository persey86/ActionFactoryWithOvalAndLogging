package com.department.servlet;

import com.department.exceptions.DepartmentRepositoryException;
import com.department.servlet.actions.Action;
import com.department.servlet.actions.ActionFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 02.04.2017.
 */
public class MainServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(MainServlet.class);

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Action action = ActionFactory.getAction(request);
            action.execute(request,response);

        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            response.sendRedirect("errorPage");
            LOGGER.error("This error has occupied main controller", e);
        }
    }
}
