package controller;

import entity.Users;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Revision History:
 * Date            Author           Task ID                         Notes
 * ==========   =================   ==============  ===============================================
 * 2023.03.13   Mahsa.h
 */
@WebServlet("/login.do")
public class Login extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users users = new Users().setUsername(req.getParameter("username")).setPassword(req.getParameter("password"));
        try {
            UserService.getInstance().login(users);
            req.getSession().setAttribute("user", users);
            resp.sendRedirect("/" + users.getRoleName());
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/index.jsp");
        }
    }
}
