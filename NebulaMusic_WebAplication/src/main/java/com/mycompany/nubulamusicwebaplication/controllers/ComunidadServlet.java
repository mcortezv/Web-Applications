package com.mycompany.nubulamusicwebaplication.controllers;
import com.mycompany.nubulamusicwebaplication.models.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ComunidadServlet", urlPatterns = {"/comunidad"})
public class ComunidadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletRequest response) throws ServletException, IOException{
        int pagina = 1;
        int tamanioPagina = 10;

        String paginaParam = request.getParameter("pagina");

        if (paginaParam != null && !paginaParam.isEmpty()) {
            try {
                pagina = Integer.parseInt(paginaParam);
            } catch (Exception e) {
                pagina = 1;
            }
        }
        List<Usuario> usuarios = usuarioService.listarPaginado(pagina, tamanioPagina);
        long totalUsuarios = usuariosSevice.contarUsuarios();

        long totalPaginas = (long) Math.ceil((double) totalUsuarios / tamanioPagina);

        request.setAttribute("usuarios", usuarios);
        request.setAttribute("paginaActual", pagina);
        request.setAttribute("totalPaginas", totalPaginas);
        request.setAttribute("totalUsuarios", totalUsuarios);

        request.getRequestDispatcher("/views/aplication/comunidad.jsp").forward(request, response);
    }
}
