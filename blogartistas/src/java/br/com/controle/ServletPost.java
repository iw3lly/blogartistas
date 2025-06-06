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
import br.com.bean.Post;
import br.com.bean.Usuario;
import br.com.dao.PostDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
/**
 *
 * @author W3lly
 */



public class ServletPost extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        try {
            String acao = req.getParameter("acao");
            HttpSession sessao = req.getSession();
            Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

            PostDAO dao = new PostDAO();

            if ("novo".equals(acao)) {
                Post p = new Post();
                p.setTitulo(req.getParameter("titulo"));
                p.setConteudo(req.getParameter("conteudo"));
                p.setUsuarioId(usuario.getId());
                dao.cadastrar(p);
                res.sendRedirect("blog.jsp");

            } else if ("excluir".equals(acao)) {
                int id = Integer.parseInt(req.getParameter("id"));
                dao.excluir(id, usuario.getId());
                res.sendRedirect("blog.jsp");

            } else if ("editar".equals(acao)) {
                Post p = new Post();
                p.setId(Integer.parseInt(req.getParameter("id")));
                p.setTitulo(req.getParameter("titulo"));
                p.setConteudo(req.getParameter("conteudo"));
                p.setUsuarioId(usuario.getId());
                dao.atualizar(p);
                res.sendRedirect("blog.jsp");
            }

        } catch (Exception e) {
            res.getWriter().println("Erro: " + e.getMessage());
        }
    }
}
