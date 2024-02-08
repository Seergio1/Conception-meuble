<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector" %>
<%
    Vector<Style> allStyle = (Vector<Style>)request.getAttribute("allStyle");
    Vector<Categorie> allCategorie = (Vector<Categorie>)request.getAttribute("allCategorie");
    Vector<Taille> allTaille = (Vector<Taille>)request.getAttribute("allTaille");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>insert meuble</title>
    <link rel="stylesheet" href="./assets/css/index.css">
    <link rel="stylesheet" href="./assets/css/insertion.css">
</head>
<body>
    <div class="redirect-home">HOME</div>
    <div class="liste-container">
        <div class="titre">Insertion meuble</div>
        <form action="insertMeuble" method="post">
            <div class="liste-item">
                <label for="style_meuble">Style</label>
                <select name="style_meuble" id="style_meuble">
                    <% for(int i = 0;i<allStyle.size();i++){ %>
                            <option value=<% out.println(allStyle.get(i).getId()); %>> <% out.println(allStyle.get(i).getNom()); %> </option>
                    <% } %>
                </select>
            </div>
            <div class="liste-item">
                <label for="categorie_meuble">Categorie</label>
                <select name="categorie_meuble" id="categorie_meuble">
                    <% for(int i = 0;i<allCategorie.size();i++){ %>
                            <option value=<% out.println(allCategorie.get(i).getId()); %>> <% out.println(allCategorie.get(i).getNom()); %> </option>
                    <% } %>
                </select>
            </div>
            <div class="liste-item">
                <label for="taille_meuble">Taille</label>
                <select name="taille_meuble" id="taille_meuble">
                    <% for(int i = 0;i<allTaille.size();i++){ %>
                            <option value=<% out.println(allTaille.get(i).getId()); %>> <% out.println(allTaille.get(i).getNom()); %> </option>
                    <% } %>
                </select>
            </div>
            <div class="liste-item">
                <label for="prix_meuble">Prix vente</label>
                <input type="text" name="prix_meuble" id="prix_meuble">
            </div>
            <button type="submit">Valider</button>
        </form>

    </div>
</body>
</html>
<script src="./assets//js/index.js"></script>