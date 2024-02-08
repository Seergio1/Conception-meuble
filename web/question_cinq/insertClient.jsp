<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector" %>
<%
    Vector<Genre> allGenres = (Vector<Genre>)request.getAttribute("allGenre");
    String erreur = (String)request.getAttribute("erreur");
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
        <div class="titre">Insertion client</div>
        <form action="insertClient" method="post">
            
            <div class="liste-item">
                <label for="nom">Nom</label>
                <input type="text" name="nom" id="nom" required>
            </div>

            <div class="liste-item">
                <label for="genre">Genre</label>
                <select name="genre" id="genre">
                    <% for(int i = 0;i<allGenres.size();i++){ %>
                            <option value=<% out.println(allGenres.get(i).getId()); %>> <% out.println(allGenres.get(i).getNom()); %> </option>
                    <% } %>
                </select>
            </div>


            
            <button type="submit">Valider</button>
            <% if(request.getAttribute("erreur")!=null){ %>
                <div class="erreur">
                   <% out.println(erreur); %>
                </div>
            <% } %>
        </form>

    </div>
</body>
</html>
<script src="./assets//js/index.js"></script>