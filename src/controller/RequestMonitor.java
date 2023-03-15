package controller;


import entity.Users;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Revision History:
 * Date            Author           Task ID                         Notes
 * ==========   =================   ==============  ===============================================
 * 2023.03.13   Mahsa.h
 */
public class RequestMonitor implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Users user = (Users) request.getSession().getAttribute("user");
        if (user != null &&
                request
                        .getRequestURI()
                        .split("/")[1]
                        .trim()
                        .equals(user
                                .getRoleName())) {
            filterChain.doFilter(request, response);
        } else {
            response.sendError(403);
        }
    }

    @Override
    public void destroy() {

    }
}
