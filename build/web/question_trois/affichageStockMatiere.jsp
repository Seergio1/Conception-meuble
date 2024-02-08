<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector" %>

<%
try{
    Vector<V_stock_materiel> allStockMatiere = (Vector<V_stock_materiel>)request.getAttribute("allStockMateriel");
%>



<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stock matière</title>
    <link rel="stylesheet" href="./assets/css/index.css">
    <link rel="stylesheet" href="./assets/css/insertion.css">
    <link rel="stylesheet" href="./assets/css/table.css">
</head>

<body>
    <div class="redirect-home">HOME</div>
    <div class="table-container">
        <div class="titre">Etat stock matière</div>
        <table>
            <thead>
                <tr>
                    <th>Matiere</th>
                    <th>Quantité</th>
                </tr>
            </thead>
            <tbody>
                <% for(int i = 0;i<allStockMatiere.size();i++){ %>
                    <tr>
                        <td> <% 
                            out.println(allStockMatiere.get(i).getNom()); 
                            %>
                        </td>
                        <td> <% 
                            out.println(allStockMatiere.get(i).getQuantite_actuelle()); 
                            %>
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