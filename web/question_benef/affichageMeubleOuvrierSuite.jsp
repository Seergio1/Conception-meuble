<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector" %>
<%
    Vector<Employe> allEmployes = (Vector<Employe>)request.getAttribute("allEmployes");
    int idM = (int)request.getAttribute("idMeuble");
    double coeff = (double)request.getAttribute("coeff");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meuble & employé</title>
    <link rel="stylesheet" href="./assets/css/index.css">
    <link rel="stylesheet" href="./assets/css/insertion.css">
</head>
<body>
    <div class="redirect-home">HOME</div>
    <div class="liste-container">
        <div class="titre">Insertion meuble employé</div>
        <form action="insertionMeubleOuvrierSuite" method="post">
            <% for(int j = 0;j<coeff;j++){ %>
                <div class="liste-item">
                    <label for="employe<%out.println(j);%>">Employé <% out.println(j+1); %></label>
                    <select name="employe<%= j %>" id="employe<%out.println(j);%>">
                        <% for(int i = 0;i<allEmployes.size();i++){ %>
                            <option value=<% out.println(allEmployes.get(i).getId()); %>> <% out.println(allEmployes.get(i).getNom()); %> </option>
                        <% } %>
                    </select>
                </div>
            <% } %>
            <input type="hidden" name="idMeuble" value=<% out.println(idM); %>>
            <input type="hidden" name="coefficient" value=<% out.println(coeff); %>>
            <button type="submit">Valider</button>
        </form>

    </div>
</body>
</html>
<script src="./assets//js/index.js"></script>