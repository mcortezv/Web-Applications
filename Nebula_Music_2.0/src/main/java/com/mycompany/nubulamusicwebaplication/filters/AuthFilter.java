package com.mycompany.nubulamusicwebaplication.filters;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"})
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getServletPath();

        HttpSession session = req.getSession(false);

        boolean loggedIn = session != null && session.getAttribute("usuario") != null;

        boolean loginRequest = path.contains("iniciar-sesion.jsp") || path.equals("registro.jsp") || path.equals("autenticacion.jsp");


        boolean apiRequest = path.contains("/api/");

        boolean resourcesStaticRequest = path.contains("/assets/") || path.equals("css") || path.equals("img");

        if (apiRequest || loggedIn || loginRequest || resourcesStaticRequest || path.endsWith("tyc.jsp")) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(req.getContextPath() + "/views/auth/iniciar-sesion.jsp");
        }
    }


}
