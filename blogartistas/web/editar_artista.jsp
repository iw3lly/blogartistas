<%-- 
    Document   : editar_artista
    Created on : 5 de jun. de 2025, 23:27:08
    Author     : W3lly
--%>
<%@ page import="br.com.bean.Artista, br.com.dao.ArtistaDAO, br.com.dao.Conexao" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    ArtistaDAO dao = new ArtistaDAO();
    Artista a = dao.buscarPorId(id);
%>
<html>
<head><title>Editar Artista</title></head>
<body>
<h2>Editar Artista</h2>
<form action="atualizarArtista" method="post">
    <input type="hidden" name="id" value="<%= a.getId() %>">
    <label>Nome:</label><br>
    <input type="text" name="nome" value="<%= a.getNome() %>" required><br>
    <label>Biografia:</label><br>
    <textarea name="biografia"><%= a.getBiografia() %></textarea><br>
    <label>Estilo:</label><br>
    <select name="estilo_id">
        <%
            Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM estilos");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int estId = rs.getInt("id");
        %>
            <option value="<%= estId %>" <%= (a.getEstiloId() == estId ? "selected" : "") %>>
                <%= rs.getString("nome") %>
            </option>
        <%
            }
            con.close();
        %>
    </select><br><br>
    <input type="submit" value="Atualizar">
</form>
</body>
</html>
