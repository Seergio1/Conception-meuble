<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector" %>
<%
    Resultat_benefice dataBenefice = (Resultat_benefice)request.getAttribute("dataBenefice");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meuble & benefice</title>
    <link rel="stylesheet" href="./assets/css/index.css">
    <link rel="stylesheet" href="./assets/css/insertion.css">
    <link rel="stylesheet" href="./assets/css/table.css">
</head>
<body>
    <div class="redirect-home">HOME</div>
    <div class="table-container">
        <div class="titre">Resultat recherche de benefice par meuble</div>
        <table>
            <thead>
                <tr>
                    <th>Meuble</th>
                    <th>Bénéfice</th>
                    <th>PV</th>
                    <th>PR</th>
                </tr>
            </thead>
            <tbody>
                
                <% for(int i = 0;i<dataBenefice.getBenefice().size();i++){ %>
                    <tr>
                        <td> <% out.println(dataBenefice.getNom_meuble().get(i)); %></td>
                        <td> <% out.println(dataBenefice.getBenefice().get(i)); %> </td>
                        <td> <% out.println(dataBenefice.getPrix_vente().get(i)); %> </td>
                        <td> <% out.println(dataBenefice.getPrix_revient().get(i)); %> </td>
                    </tr>
                <% } %>
                
                
            </tbody>
        </table>
    </div>
</body>
</html>
<script src="./assets//js/index.js"></script>