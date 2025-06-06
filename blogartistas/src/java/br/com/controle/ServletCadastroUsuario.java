/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.controle;

import br.com.bean.Usuario;
import br.com.dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author W3lly
 */

public class ServletCadastroUsuario extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try {
            Usuario usuario = new Usuario();
            usuario.setNome(request.getParameter("nome"));
            usuario.setEmail(request.getParameter("email"));
            usuario.setSenha(request.getParameter("senha"));

            UsuarioDAO dao = new UsuarioDAO();
            dao.cadastrar(usuario);

            response.sendRedirect("login.jsp"); // redireciona após cadastro
        } catch (Exception e) {
            response.getWriter().println("Erro ao cadastrar: " + e.getMessage());
        }
    }
}

