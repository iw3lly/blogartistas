/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.bean.Artista;
import br.com.dao.ArtistaDAO;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
/**
 *
 * @author W3lly
 */




public class ServletAtualizarArtista extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try {
            Artista artista = new Artista();
            artista.setId(Integer.parseInt(request.getParameter("id")));
            artista.setNome(request.getParameter("nome"));
            artista.setBiografia(request.getParameter("biografia"));
            artista.setEstiloId(Integer.parseInt(request.getParameter("estilo_id")));

            ArtistaDAO dao = new ArtistaDAO();
            dao.atualizar(artista);

            response.sendRedirect("lista_artistas.jsp");
        } catch (Exception e) {
            response.getWriter().println("Erro: " + e.getMessage());
        }
    }
}
