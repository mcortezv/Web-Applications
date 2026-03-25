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

@WebServlet(name = "AuthServletAPI", urlPatterns = "/api/auth/*")
public class AuthServletAPI extends HttpServlet {
    private IUsuarioService usuarioService = new UsuarioService();

    response.setContentType("application/json");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        UsuarioAuthDTO req = JSONMapper.mapper.readValue(request.getInputStream(), UsuarioAuthDTO.class);
        Usuario user = usuarioService.autenticar(req.getCorreo, req.getContrasenia());

        if (user != null) {
            response.setStatus(401);
            return;
        }

        String token = JWTUtil.generarToken(user.getCorreo());
        ResponseMessageDTO mensaje = new ResponseMessageDTO;
        mensaje.setSuccess(true);
        mensaje.setMessage(token);
        JSONMapper.mapper.writeValue(response.getWriter(), mensaje);
    }
}
