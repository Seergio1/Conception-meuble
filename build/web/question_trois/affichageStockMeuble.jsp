<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector" %>

<%
try{
    Vector<V_stock_meuble> allStockMeuble = (Vector<V_stock_meuble>)request.getAttribute("allStockMeuble");
%>



<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stock meuble</title>
    <link rel="stylesheet" href="./assets/css/index.css">
    <link rel="stylesheet" href="./assets/css/insertion.css">
    <link rel="stylesheet" href="./assets/css/table.css">
</head>

<body>
    <div class="redirect-home">HOME</div>
    <div class="table-container">
        <div class="titre">Etat stock meuble</div>
        <table>
            <thead>
                <tr>
                    <th>Meuble</th>
                    <th>Quantité</th>
                </tr>
            </thead>
            <tbody>
                <% for(int i = 0;i<allStockMeuble.size();i++){ %>
                    <tr>
                        <td> <% out.println(allStockMeuble.get(i).getNomMeuble()); %></td>
                        <td> <% out.println(allStockMeuble.get(i).getQuantite_actuelle()); %>
                        </td>
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