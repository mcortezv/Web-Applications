/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.nubulamusicwebaplication.controllers;
import java.io.IOException;
import com.mycompany.nubulamusicwebaplication.service.IUsuarioService;
import com.mycompany.nubulamusicwebaplication.service.UsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
/**
 *
 * @author martinbl
 */
@WebServlet(name = "RegistroServlet", urlPatterns = {"/registro"})
public class RegistroServlet extends HttpServlet {
    private final IUsuarioService usuarioService = new UsuarioService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{

        response.setCharacterEncoding("UTF-8");

        String nombre = request.getParameter("txt_nombre");
        String correo = request.getParameter("txt_correo");
        String contrasenia = request.getParameter("txt_contrasenia");
        String pseudonimo = request.getParameter("txt_pseudonimo");
        String tipoCuenta = request.getParameter("sel_cuenta");
        String fechaNacimientoStr = request.getParameter("txt_fecha_nacimiento");
        String terminos = request.getParameter("chk_terminos");

        try {
            boolean terminosAceptados = Boolean.parseBoolean(terminos);

            usuarioService.registrar(nombre, correo, contrasenia, pseudonimo, "activo", tipoCuenta, LocalDate.parse(fechaNacimientoStr), terminosAceptados);

            request.setAttribute(terminos, this);

            request.getRequestDispatcher("/views/auth/iniciar-sesion.jsp").forward(request, response);
        } catch (IllegalArgumentException e) {
            throw new ServletException("Error al registrar usuario", e);
        } catch (Exception e) {
            throw new ServletException("Error al registrar usuario", e);
        }
    }
}
