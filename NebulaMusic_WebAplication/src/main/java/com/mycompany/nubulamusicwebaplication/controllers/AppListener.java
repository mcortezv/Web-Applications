package com.mycompany.nubulamusicwebaplication.controllers;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce){
        ServletContext app = sce.getServletContext();

        app.setAttribute("appname", "Nubula Music");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce){
        // todo el codigo que tu quieras ejucutar una vez que se detenga la aplicacion
    }
}
