<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector" %>
<%
    Vector<MeublePrix> dataMeubleMatiere = (Vector<MeublePrix>)request.getAttribute("allMeuble");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultat recherche par prix des meubles</title>
    <link rel="stylesheet" href="./assets/css/index.css">
    <link rel="stylesheet" href="./assets/css/insertion.css">
    <link rel="stylesheet" href="./assets/css/table.css">
</head>
<body>
    <div class="redirect-home">HOME</div>
    <div class="table-container">
        <div class="titre">Resultat recherche par prix des meubles</div>
        <table>
            <thead>
                <tr>
                    <th>Meuble</th>
                    <th>Prix</th>
                </tr>
            </thead>
            <tbody>
                
                <% for(int i = 0;i<dataMeubleMatiere.size();i++){ %>
                    <tr>
                        <td> <% out.println(dataMeubleMatiere.get(i).getNom_categorie()+"/"+dataMeubleMatiere.get(i).getNom_style()+"/"+dataMeubleMatiere.get(i).getNom_taille()); %></td>
                        <td> <% out.println(dataMeubleMatiere.get(i).getPrix()); %> </td>
                    </tr>
                <% } %>
                
                
            </tbody>
        </table>
    </div>
</body>
</html>
<script src="./assets//js/index.js"></script>