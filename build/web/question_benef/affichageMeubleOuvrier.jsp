<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector" %>
<%
    Vector<V_meuble> allMeubles = (Vector<V_meuble>)request.getAttribute("allMeubles");
    String erreur = (String)request.getAttribute("erreur");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meuble & employé</title>
    <link rel="stylesheet" href="./assets/css/index.css">
    <link rel="stylesheet" href="./assets/css/insertion.css">
</head>
<body>
    <div class="redirect-home">HOME</div>
    <div class="liste-container">
        <div class="titre">Insertion meuble employé</div>
        <form action="insertionMeubleOuvrier" method="post">
            <div class="liste-item">
                <label for="meuble">Meuble</label>
                <select name="meuble" id="meuble">
                    <% for(int i = 0;i<allMeubles.size();i++){ %>
                        <option value=<% out.println(allMeubles.get(i).getId_meuble()); %>> <% out.println(allMeubles.get(i).getNom_categorie()+"/"+allMeubles.get(i).getNom_style()+"/"+allMeubles.get(i).getNom_taille()); %> </option>
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