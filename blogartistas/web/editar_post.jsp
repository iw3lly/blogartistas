<%-- 
    Document   : editar_post
    Created on : 5 de jun. de 2025, 23:58:47
    Author     : W3lly
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="br.com.bean.Post, br.com.dao.PostDAO" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    PostDAO dao = new PostDAO();
    Post p = dao.buscarPorId(id);

    br.com.bean.Usuario usuario = (br.com.bean.Usuario) session.getAttribute("usuarioLogado");
    if (usuario == null || p.getUsuarioId() != usuario.getId()) {
        response.sendRedirect("blog.jsp");
    }
%>
<html>
<head><title>Editar Post</title></head>
<body>
<h2>Editar Post</h2>
<form action="postagem" method="post">
    <input type="hidden" name="acao" value="editar">
    <input type="hidden" name="id" value="<%= p.getId() %>">
    <label>Título:</label><br>
    <input type="text" name="titulo" value="<%= p.getTitulo() %>" required><br>
    <label>Conteúdo:</label><br>
    <textarea name="conteudo" rows="5"><%= p.getConteudo() %></textarea><br>
    <input type="submit" value="Salvar">
</form>
</body>
</html>
