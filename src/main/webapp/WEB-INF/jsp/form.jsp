<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inscription à un événement</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; margin: 0; padding: 40px; }
        .card { max-width: 480px; margin: 0 auto; background: #fff; padding: 30px 35px;
                border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); }
        h1 { font-size: 22px; margin-bottom: 20px; color: #2c3e50; }
        label { display: block; margin-top: 14px; margin-bottom: 4px; font-weight: bold; color: #333; }
        input[type=text], input[type=date], select {
            width: 100%; padding: 8px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px;
        }
        button {
            margin-top: 22px; width: 100%; padding: 10px; background: #2c7be5; color: #fff;
            border: none; border-radius: 4px; font-size: 15px; cursor: pointer;
        }
        button:hover { background: #1a5bb8; }
        .lien-liste { display: block; text-align: center; margin-top: 16px; color: #2c7be5; }
    </style>
</head>
<body>
<div class="card">
    <h1>Formulaire d'inscription à un événement</h1>

    <form:form method="post" action="${pageContext.request.contextPath}/inscriptions" modelAttribute="inscription">
        <label for="nom">Nom</label>
        <form:input path="nom" id="nom" required="required" />

        <label for="prenom">Prénom</label>
        <form:input path="prenom" id="prenom" required="required" />

        <label for="dateNaissance">Date de naissance</label>
        <form:input path="dateNaissance" id="dateNaissance" type="date" required="required" />

        <label for="telephone">Téléphone</label>
        <form:input path="telephone" id="telephone" required="required" />

        <label for="typeEvenement">Type d'événement</label>
        <form:select path="typeEvenement" id="typeEvenement">
            <form:option value="" label="-- Choisir --" />
            <form:option value="Conférence" label="Conférence" />
            <form:option value="Concert" label="Concert" />
            <form:option value="Formation" label="Formation" />
            <form:option value="Sport" label="Sport" />
            <form:option value="Autre" label="Autre" />
        </form:select>

        <button type="submit">S'inscrire</button>
    </form:form>

    <a class="lien-liste" href="${pageContext.request.contextPath}/inscriptions">Voir la liste des inscriptions</a>
</div>
</body>
</html>
