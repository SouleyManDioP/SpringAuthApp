<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des inscriptions</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; margin: 0; padding: 40px; }
        .card { max-width: 900px; margin: 0 auto; background: #fff; padding: 30px 35px;
                border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); }
        h1 { font-size: 22px; margin-bottom: 20px; color: #2c3e50; }
        table { width: 100%; border-collapse: collapse; margin-top: 10px; }
        th, td { padding: 10px 12px; border-bottom: 1px solid #e5e5e5; text-align: left; font-size: 14px; }
        th { background: #2c7be5; color: #fff; }
        tr:hover { background: #f0f6ff; }
        .vide { padding: 20px; color: #888; text-align: center; }
        .lien-form { display: inline-block; margin-bottom: 16px; background: #2c7be5; color: #fff;
                     padding: 8px 14px; border-radius: 4px; text-decoration: none; }
        .supprimer { color: #d9534f; text-decoration: none; }
    </style>
</head>
<body>

    <form method="post" action="${pageContext.request.contextPath}/logout" style="display:inline;">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn-logout">Se déconnecter</button>
    </form>

<div class="card">

    <h1>Liste des inscriptions</h1>
    <a class="lien-form" href="${pageContext.request.contextPath}/inscriptions/nouveau">+ Nouvelle inscription</a>

    <c:choose>
        <c:when test="${empty inscriptions}">
            <p class="vide">Aucune inscription pour le moment.</p>
        </c:when>
        <c:otherwise>
            <table>
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Date de naissance</th>
                    <th>Téléphone</th>
                    <th>Type d'événement</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="i" items="${inscriptions}">
                    <tr>
                        <td>${i.id}</td>
                        <td>${i.nom}</td>
                        <td>${i.prenom}</td>
                        <td>${i.dateNaissance}</td>
                        <td>${i.telephone}</td>
                        <td>${i.typeEvenement}</td>
                        <td>
                            <a class="supprimer"
                               href="${pageContext.request.contextPath}/inscriptions/supprimer/${i.id}"
                               onclick="return confirm('Supprimer cette inscription ?');">Supprimer</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>

<c:if test="${param.logout != null}">
    <p style="color:green;">Vous avez été déconnecté.</p>
</c:if>
</body>
</html>
