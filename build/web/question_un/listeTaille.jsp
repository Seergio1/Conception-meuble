<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector" %>

<%
try{
    Vector<Taille> allTaille = (Vector<Taille>)request.getAttribute("allTaille");
%>



<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Taille</title>
    <link rel="stylesheet" href="./assets/css/index.css">
    <link rel="stylesheet" href="./assets/css/insertion.css">
    <link rel="stylesheet" href="./assets/css/table.css">
</head>

<body>
    <div class="redirect-home">HOME</div>
    <div class="table-container">
        <div class="titre">Liste taille</div>
        <table>
            <thead>
                <tr>
                    <th>Taille</th>
                </tr>
            </thead>
            <tbody>
                <% for(int i = 0;i<allTaille.size();i++){ %>
                    <tr>
                        <td> <% out.println(allTaille.get(i).getNom()); %> </td>
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