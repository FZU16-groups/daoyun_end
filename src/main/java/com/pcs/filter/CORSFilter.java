package com.pcs.filter;

import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CORSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        return;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT,DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,X-LC-Key,X-LC-Id,Content-Type");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        System.out.println(request.getMethod());
//        if (request.getMethod().equals(RequestMethod.OPTIONS.name())) {
//            System.out.println("Run here");
//            response.setStatus(200);
//            return;
//        }
//        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
