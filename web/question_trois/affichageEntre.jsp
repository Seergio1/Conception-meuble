<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector,Utils.ErreurStock" %>
<%
    Vector<Matiere> dataMatiere = (Vector<Matiere>)request.getAttribute("allMatiere");
    ErreurStock erreurStock = (ErreurStock)request.getAttribute("erreurStock");
        
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stock</title>
    <link rel="stylesheet" href="./assets/css/index.css">
    <link rel="stylesheet" href="./assets/css/insertion.css">
</head>
<body>
    <div class="redirect-home">HOME</div>
    <div class="liste-container">
        <div class="titre">Entrée de stock</div>
        <form action="insertionEnter" method="post">
            <div class="liste-item">
                <label for="matiere_meuble">Matiere</label>
                <select name="matiere_meuble" id="matiere_meuble">
                    <% for(int i = 0;i<dataMatiere.size();i++){ %>
                        <option value=<% out.println(dataMatiere.get(i).getId()); %>> <% out.println(dataMatiere.get(i).getNom()); %> </option>
                    <% } %>
                </select>
            </div>
            <div class="liste-item">
                <label for="entrer">Quantité</label>
                <input name="entrer" type="number" id="prix" required>
            </div>
            
            <button type="submit">Valider</button>
            <% if((ErreurStock)request.getAttribute("erreurStock")!=null){ %>
                <div class="erreur">
                    <% out.println(erreurStock.getErreur()); %>
                    <% for(int i = 0;i<erreurStock.getNom_matiere().size();i++){ %>
                        <p>Nom : <% out.println(erreurStock.getNom_matiere().get(i)); %></p>
                        <p>Demande : <% out.println(erreurStock.getQuantiteDemande().get(i)); %></p>
                        <p>En stock : <% out.println(erreurStock.getQuantiteStock().get(i)); %></p>      
                    <% } %>
                </div>
            <% } %>
        </form>

    </div>
</body>
</html>
<script src="./assets//js/index.js"></script>