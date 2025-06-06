<%-- 
    Document   : login
    Created on : 5 de jun. de 2025, 21:27:43
    Author     : W3lly
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>

    <form action="login" method="post">
        <label>Email:</label><br>
        <input type="email" name="email" required><br>
        <label>Senha:</label><br>
        <input type="password" name="senha" required><br><br>
        <input type="submit" value="Entrar">
    </form>

    <c:if test="${param.erro == 1}">
        <p style="color:red;">Usuário ou senha inválidos.</p>
    </c:if>
</body>
</html>
