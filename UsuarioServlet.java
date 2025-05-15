package Services;

import BusinessEntity.UsuarioBE;
import DataAccessObject.UsuarioDAO;
import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/Usuario"})
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAO dao = new UsuarioDAO();
        ArrayList<UsuarioBE> lista = dao.obtenerTodos();
        
        if (lista == null) {
    System.out.println("❌ Lista de usuarios es null");
} else {
    System.out.println("✅ Lista cargada con " + lista.size() + " usuarios");
}

        
        request.setAttribute("usuarios", lista);
        request.getRequestDispatcher("/usuariolist.jsp").forward(request, response);
    }
}
