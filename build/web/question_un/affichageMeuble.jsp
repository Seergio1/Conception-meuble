<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector" %>

<%
try{
    Vector<V_meuble> allMeubles = (Vector<V_meuble>)request.getAttribute("allMeubles");
%>



<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>affichage matière & style</title>
    <link rel="stylesheet" href="./assets/css/index.css">
    <link rel="stylesheet" href="./assets/css/insertion.css">
    <link rel="stylesheet" href="./assets/css/table.css">
</head>

<body>
    <div class="redirect-home">HOME</div>
    <div class="table-container">
        <div class="titre">Liste meuble</div>
        <table>
            <thead>
                <tr>
                    <th>Meuble</th>
                </tr>
            </thead>
            <tbody>
                <% for(int i = 0;i<allMeubles.size();i++){ %>
                    <tr>
                        <td> <% out.println(allMeubles.get(i).getNom_categorie()+"/"+allMeubles.get(i).getNom_style()+"/"+allMeubles.get(i).getNom_taille()); %> </td>
                    </tr>
                <% } %>
                
            </tbody>
        </table>
    </div>
</body>

</html>
<script src="./assets//js/index.js"></script>
<%}catch(Exception e){
    System.out.println(e.getMessage());
}

%>