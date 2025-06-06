package br.com.controle;

import br.com.bean.Artista;
import br.com.dao.ArtistaDAO;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,        // 1MB
    maxFileSize = 5 * 1024 * 1024,          // 5MB
    maxRequestSize = 10 * 1024 * 1024       // 10MB
)
@WebServlet("/cadastrarArtista")
public class ServletArtista extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try {
            Part filePart = request.getPart("foto");
            String contentDisp = filePart.getHeader("content-disposition");
String[] items = contentDisp.split(";");
String fileName = "";
for (String s : items) {
    if (s.trim().startsWith("filename")) {
        fileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
    }
}
            String uploadPath = null;


            filePart.write(uploadPath + File.separator + fileName);

            Artista artista = new Artista();
            artista.setNome(request.getParameter("nome"));
            artista.setBiografia(request.getParameter("biografia"));
            artista.setEstiloId(Integer.parseInt(request.getParameter("estilo_id")));
            artista.setFoto("imagens/" + fileName);

            ArtistaDAO dao = new ArtistaDAO();
            dao.cadastrar(artista);

            response.sendRedirect("lista_artistas.jsp");

        } catch (Exception e) {
            response.getWriter().println("Erro ao cadastrar artista: " + e.getMessage());
        }
    }
}
