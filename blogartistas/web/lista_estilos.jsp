<%-- 
    Document   : lista_estilos
    Created on : 5 de jun. de 2025, 23:37:50
    Author     : W3lly
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="br.com.artistas.dao.EstiloDAO, br.com.artistas.bean.Estilo, java.util.*" %>
<%
    EstiloDAO dao = new EstiloDAO();
    List<Estilo> estilos = dao.listar();
%>
<html>
<head>
    <title>Estilos Cadastrados</title>
</head>
<body>
    <h2>Estilos de Arte</h2>
    <a href="form_estilo.jsp">Cadastrar novo estilo</a><br><br>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Nome</th>
        </tr>
        <%
            for (Estilo e : estilos) {
        %>
        <tr>
            <td><%= e.getId() %></td>
            <td><%= e.getNome() %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
