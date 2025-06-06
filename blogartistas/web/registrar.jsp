<%-- 
    Document   : registrar
    Created on : 5 de jun. de 2025, 21:12:15
    Author     : W3lly
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Cadastro de Usuário</title>
</head>
<body>
    <h2>Cadastro de Usuário</h2>
    <form action="cadastrar" method="post">
        <label>Nome:</label><br>
        <input type="text" name="nome" required><br>
        <label>Email:</label><br>
        <input type="email" name="email" required><br>
        <label>Senha:</label><br>
        <input type="password" name="senha" required><br><br>
        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>
