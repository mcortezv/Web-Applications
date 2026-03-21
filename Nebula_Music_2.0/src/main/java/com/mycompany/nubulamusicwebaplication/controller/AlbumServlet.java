package com.mycompany.nubulamusicwebaplication.controller;
import com.mycompany.nubulamusicwebaplication.model.Album;
import com.mycompany.nubulamusicwebaplication.model.Usuario;
import com.mycompany.nubulamusicwebaplication.service.AlbumService;
import com.mycompany.nubulamusicwebaplication.service.IAbumService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "AlbumServlet", urlPatterns = "/album")
public class AlbumServlet extends HttpServlet {
    private final IAbumService albumService = new AlbumService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {

        HttpSession session = request.getSession(false);

        Usuario usuario = (Usuario) session.getAttribute("usuario");

        String action = request.getParameter("accion");

        if (action == null){
            action = "list";
        }

        try {
            switch (action) {
                case "new":
                    request.getRequestDispatcher("/views/admin/album-form.jsp").forward(request, response);
                    break;
                case "edit":
                    Long id = Long.parseLong(request.getParameter("id"));

                    Album album = albumService.obtenerAlbum(id, usuario.getId());

                    request.setAttribute("album", album);

                    request.getRequestDispatcher("/views/admin/album-form.jsp").forward(request, response);
                    break;
                case "delete":
                    Long deleteId = Long.parseLong(request.getParameter("id"));

                    albumService.eliminarAlbum(deleteId, usuario.getId());

                    response.sendRedirect("/albums");
                    break;
                default:
                    List<Album> albums = albumService.obtenerAlbumsUsuario(usuario.getId());

                    request.setAttribute("albums", albums);

                    request.getRequestDispatcher("/views/admin/mis-albums.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {
        HttpSession session = request.getSession(false);

        Usuario usuario = (Usuario) session.getAttribute("usuario");

        String idParam = request.getParameter("id");
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");

        Part filePart = request.getPart("imagen");

        String fileName = filePart.getSubmittedFileName();

        if (!fileName.endsWith(".png")) {
            throw new ServletException("Solo se permiten imagenes en formato PNG.");
        }
        String newFileName = System.currentTimeMillis() + "_" + fileName;

        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";

        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String filePath = uploadPath + File.separator + newFileName;
        filePart.write(filePath);

        String imageUrl = "/uploads/" + newFileName;

        Album album = new Album(titulo, descripcion, imageUrl, usuario);

        album.setDescripcion(descripcion);
        album.setTitulo(titulo);
        album.setImageUrl(imageUrl);
        album.setUsuario(usuario);

        try {
            if (idParam != null && !idParam.isEmpty()) {
                albumService.crearAlbum(album);
            } else {
                assert idParam != null;
                album.setId(Long.parseLong(idParam));
                albumService.actualizarAlbum(album, usuario.getId());
            }
            response.sendRedirect("/albums");
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("album", album);
        }

    }
}
