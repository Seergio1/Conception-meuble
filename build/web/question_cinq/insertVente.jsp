<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector,Utils.ErreurStock" %>
<%
    Vector<V_meuble> allMeubles = (Vector<V_meuble>)request.getAttribute("dataMeuble");
    Vector<Client> dataClients = (Vector<Client>)request.getAttribute("dataClient");
    ErreurStock erreurStock = (ErreurStock)request.getAttribute("erreurStock");
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
        <div class="titre">Insertion vente</div>
        <form action="insertionVente" method="post">
            
            <div class="liste-item">
                <label for="client">Client</label>
                <select name="client" id="client">
                    <% for(int i = 0;i<dataClients.size();i++){ %>
                            <option value=<% out.println(dataClients.get(i).getId()); %>> <% out.println(dataClients.get(i).getNom()); %> </option>
                    <% } %>
                </select>
            </div>

            <div class="liste-item">
                <label for="meuble">meuble</label>
                <select name="meuble" id="meuble">
                    <% for(int i = 0;i<allMeubles.size();i++){ %>
                        <option value=<% out.println(allMeubles.get(i).getId_meuble()); %>> <% out.println(allMeubles.get(i).getNom_categorie()+"/"+allMeubles.get(i).getNom_style()+"/"+allMeubles.get(i).getNom_taille()); %> </option>
                    <% } %>
                </select>
            </div>

            <div class="liste-item">
                <label for="nombre">Nombre</label>
                <input type="number" name="nombre" id="nombre" required>
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