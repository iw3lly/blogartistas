<%-- 
    Document   : novo_post
    Created on : 5 de jun. de 2025, 23:58:01
    Author     : W3lly
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%
    br.com.bean.Usuario usuario = (br.com.bean.Usuario) session.getAttribute("usuarioLogado");
    if (usuario == null) response.sendRedirect("login.jsp");
%>
<html>
<head><title>Novo Post</title></head>
<body>
<h2>Novo Post</h2>
<form action="postagem" method="post">
    <input type="hidden" name="acao" value="novo">
    <label>Título:</label><br>
    <input type="text" name="titulo" required><br>
    <label>Conteúdo:</label><br>
    <textarea name="conteudo" rows="5" required></textarea><br>
    <input type="submit" value="Publicar">
</form>
</body>
</html>
