package com.mycompany.nubulamusicwebaplication.apirest;
import com.mycompany.nubulamusicwebaplication.dto.ResponseMessageDTO;
import com.mycompany.nubulamusicwebaplication.dto.UsuarioDTO;
import com.mycompany.nubulamusicwebaplication.model.Usuario;
import com.mycompany.nubulamusicwebaplication.service.IUsuarioService;
import com.mycompany.nubulamusicwebaplication.service.UsuarioService;
import com.mycompany.nubulamusicwebaplication.util.JSONMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "UsuarioServletAPI", urlPatterns = "/api/usuario")
public class UsuarioServletAPI extends HttpServlet {
    private IUsuarioService usuarioService = new UsuarioService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            String pathInfo = request.getPathInfo();

            if (pathInfo == null || pathInfo.isEmpty() || pathInfo.equals("/")) {
                List<Usuario> usuarios = usuarioService.listarTodos();

                List<UsuarioDTO> usuariosDTOS = usuarios.stream().map(u -> {
                    UsuarioDTO dto = new UsuarioDTO();
                    dto.setId(u.getId());
                    dto.setCorreo(u.getCorreo());
                    dto.setNombre(u.getNombre());
                    dto.setPseudonimo(u.getPseudonimo());
                    return dto;
                }).collect(Collectors.toList());

                JSONMapper.mapper.writeValue(response.getWriter(), usuariosDTOS);
            } else {
                Long id = Long.parseLong(pathInfo.substring(1));
                Usuario usuario = usuarioService.buscarPorId(id);
                if (usuario == null) {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);

                    ResponseMessageDTO msg = new ResponseMessageDTO();
                    msg.setSuccess(false);
                    msg.setMessage("Usuario no encontrado");
                    JSONMapper.mapper.writeValue(response.getWriter(), msg);
                    return;
                }
                UsuarioDTO dto = new UsuarioDTO();
                dto.setId(usuario.getId());
                dto.setCorreo(usuario.getCorreo());
                dto.setNombre(usuario.getNombre());
                dto.setPseudonimo(usuario.getPseudonimo());

                JSONMapper.mapper.writeValue(response.getWriter(), dto);
            }

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            ResponseMessageDTO msg = new ResponseMessageDTO();
            msg.setSuccess(false);
            msg.setMessage("Ocurrio un error al procesar la solicitud: ");
            JSONMapper.mapper.writeValue(response.getWriter(), msg);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {

    }
}
