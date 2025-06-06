<%-- 
    Document   : lista_artistas
    Created on : 5 de jun. de 2025, 21:58:07
    Author     : W3lly
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, br.com.bean.Artista, br.com.dao.ArtistaDAO" %>
<%
    ArtistaDAO dao = new ArtistaDAO();
    List<Artista> lista = dao.listar();
%>
<html>
<head>
    <title>Artistas Cadastrados</title>
</head>
<body>
    <h2>Lista de Artistas</h2>
    <a href="form_artista.jsp">Cadastrar novo artista</a>
    <br><br>
    <table border="1" cellpadding="5">
        <tr>
            <th>Nome</th>
            <th>Estilo</th>
            <th>Biografia</th>
            <th>Foto</th>
            <th>Ações</th>>
        </tr>
        <%
            for (Artista a : lista) {
        %>
        <tr>
            <td><%= a.getNome() %></td>
            <td><%= a.getEstiloNome() %></td>
            <td><%= a.getBiografia() %></td>
             <td>
                <% if (a.getFoto() != null && !a.getFoto().isEmpty()) { %>
                    <img src="<%= a.getFoto() %>" width="100">
                <% } else { %>
                    Sem foto
                <% } %>
                <td>
    <a href="editar_artista.jsp?id=<%= a.getId() %>">Editar</a> |
    <a href="excluirArtista?id=<%= a.getId() %>" onclick="return confirm('Deseja excluir?')">Excluir</a>
</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
