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
import br.com.bean.Estilo;
import br.com.dao.EstiloDAO;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
/**
 *
 * @author W3lly
 */
public class ServletEstilo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try {
            Estilo estilo = new Estilo();
            estilo.setNome(request.getParameter("nome"));

            EstiloDAO dao = new EstiloDAO();
            dao.cadastrar(estilo);

            response.sendRedirect("lista_estilos.jsp");
        } catch (Exception e) {
            response.getWriter().println("Erro ao cadastrar estilo: " + e.getMessage());
        }
    }
}

