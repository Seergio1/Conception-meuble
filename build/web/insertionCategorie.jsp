<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector" %>
<%
    String erreur = (String)request.getAttribute("erreur");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>insertion style</title>
    <link rel="stylesheet" href="./assets/css/index.css">
    <link rel="stylesheet" href="./assets/css/insertion.css">
</head>

<body>
    <div class="redirect-home">HOME</div>
    <div class="insertion">
        <div class="titre">Insertion categorie</div>
        <form action="insertCategorie" method="post">
            <input type="text" placeholder="Categorie" name="categorie">
            <button type="submit">Valider</button>
        </form>
        <% if(request.getAttribute("erreur")!=null){ %>
            <div class="erreur">
               <% out.println(erreur); %>
            </div>
        <% } %>
    </div>
</body>

</html>
<script src="./assets//js/index.js"></script>