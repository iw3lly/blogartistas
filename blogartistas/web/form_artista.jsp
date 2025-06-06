<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.sql.*, br.com.dao.Conexao" %>
<html>
<head>
    <title>Cadastrar Artista</title>
</head>
<body>
    <h2>Novo Artista</h2>

    
    <form action="cadastrarArtista" method="post" enctype="multipart/form-data">
        <label>Nome:</label><br>
        <input type="text" name="nome" required><br>

        <label>Biografia:</label><br>
        <textarea name="biografia" rows="4" required></textarea><br>

        <label>Estilo:</label><br>
        <select name="estilo_id" required>
            <%
                Connection con = Conexao.conectar();
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM estilos");
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
            %>
                <option value="<%= rs.getInt("id") %>"><%= rs.getString("nome") %></option>
            <%
                }
                con.close();
            %>
        </select><br><br>

        <label>Foto:</label><br> 
        <input type="file" name="foto" accept="image/*" required><br><br>

        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>
