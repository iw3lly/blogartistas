<%-- 
    Document   : blog
    Created on : 5 de jun. de 2025, 23:59:28
    Author     : W3lly
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="br.com.bean.Post, br.com.dao.PostDAO, java.util.*" %>
<%
    br.com.bean.Usuario usuario = (br.com.bean.Usuario) session.getAttribute("usuarioLogado");
    if (usuario == null) response.sendRedirect("login.jsp");

    PostDAO dao = new PostDAO();
    List<Post> posts = dao.listar();
%>
<html>
<head><title>Blog</title></head>
<body>
<h2>Blog dos Usuários</h2>
<a href="novo_post.jsp">Novo Post</a>
<hr>
<%
    for (Post p : posts) {
%>
    <div>
        <h3><%= p.getTitulo() %></h3>
        <p><%= p.getConteudo() %></p>
        <small>Por <%= p.getAutor() %> em <%= p.getData() %></small><br>
        <% if (p.getUsuarioId() == usuario.getId()) { %>
            <a href="editar_post.jsp?id=<%= p.getId() %>">Editar</a> |
            <a href="postagem?acao=excluir&id=<%= p.getId() %>" onclick="return confirm('Excluir este post?')">Excluir</a>
        <% } %>
        <hr>
    </div>
<% } %>
</body>
</html>
