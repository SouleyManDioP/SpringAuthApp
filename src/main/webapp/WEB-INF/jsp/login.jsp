<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <title>Connexion</title>
</head>
<body>
    <h2>Connexion</h2>

    <c:if test="${param.error != null}">
        <p style="color:red;">Nom d'utilisateur ou mot de passe incorrect.</p>
    </c:if>
    <c:if test="${param.logout != null}">
        <p style="color:green;">Vous avez été déconnecté.</p>
    </c:if>

    <form method="post" action="${pageContext.request.contextPath}/login">
        <label>Nom d'utilisateur :</label>
        <input type="text" name="username" required/><br/><br/>

        <label>Mot de passe :</label>
        <input type="password" name="password" required/><br/><br/>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <input type="submit" value="Se connecter"/>
    </form>
    </form>
</body>
</html>