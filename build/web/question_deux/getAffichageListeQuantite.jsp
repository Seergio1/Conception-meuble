<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector" %>
<%
    Vector<V_meuble_matiere> dataMeubleMatiere = (Vector<V_meuble_matiere>)request.getAttribute("allMatiereMeubles");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quantite matiere dans meuble</title>
    <link rel="stylesheet" href="./assets/css/index.css">
    <link rel="stylesheet" href="./assets/css/insertion.css">
    <link rel="stylesheet" href="./assets/css/table.css">
</head>
<body>
    <div class="redirect-home">HOME</div>
    <div class="table-container">
        <div class="titre">Matiere & quantité</div>
        <table>
            <thead>
                <tr>
                    <th>Meuble</th>
                    <th>Matiere</th>
                    <th>Quantité</th>
                </tr>
            </thead>
            <tbody>
                
                <% for(int i = 0;i<dataMeubleMatiere.size();i++){ %>
                    <tr>
                        <td> <% out.println(dataMeubleMatiere.get(i).getNom_categorie()+"/"+dataMeubleMatiere.get(i).getNom_style()+"/"+dataMeubleMatiere.get(i).getNom_taille()); %></td>
                        <td> <% out.println(dataMeubleMatiere.get(i).getNom_matiere()); %> </td>
                        <td> <% out.println(dataMeubleMatiere.get(i).getQuantite()); %> </td>
                    </tr>
                <% } %>
                
                
            </tbody>
        </table>
    </div>
</body>
</html>
<script src="./assets//js/index.js"></script>