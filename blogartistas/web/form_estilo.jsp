<%-- 
    Document   : form_estilo
    Created on : 5 de jun. de 2025, 23:37:15
    Author     : W3lly
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Cadastrar Estilo</title>
</head>
<body>
    <h2>Novo Estilo Artístico</h2>
    <form action="cadastrarEstilo" method="post">
        <label>Nome do Estilo:</label><br>
        <input type="text" name="nome" required><br><br>
        <input type="submit" value="Cadastrar">
    </form>
    <br>
    <a href="lista_estilos.jsp">Ver estilos cadastrados</a>
</body>
</html>
