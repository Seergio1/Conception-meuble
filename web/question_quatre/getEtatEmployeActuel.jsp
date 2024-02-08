<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector" %>

<%
try{
    Vector<V_info_employe_actuel> dataEmpActu = (Vector<V_info_employe_actuel>)request.getAttribute("allDataEmpActu");
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
        <div class="titre">Etat employé</div>
        <table>
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Profil</th>
                    <th>Poste</th>
                    <th>Date promo/embauche</th>
                    <th>Salaire</th>
                    <!-- <th>Année d'experience</th> -->
                </tr>
            </thead>
            <tbody>
                <% for(int i = 0;i<dataEmpActu.size();i++){ %>
                    <tr>
                        <td> <% out.println(dataEmpActu.get(i).getNomEmp()); %> </td>
                        <td> <% out.println(dataEmpActu.get(i).getNomProfil()); %> </td>
                        <td> <% out.println(dataEmpActu.get(i).getNom_poste()); %> </td>
                        <td> <% out.println(dataEmpActu.get(i).getDatePromo()); %> </td>
                        <td> <% out.println(dataEmpActu.get(i).getSalaire()); %> </td>
                        <!-- <td> <% out.println(dataEmpActu.get(i).getAnnee_exp()); %> </td> -->
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