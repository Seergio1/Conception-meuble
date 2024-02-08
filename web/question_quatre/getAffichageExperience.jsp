<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector" %>
<% 
    Vector<Poste> dataPoste = (Vector<Poste>)request.getAttribute("allPoste");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Experience</title>
    <link rel="stylesheet" href="./assets/css/index.css">
    <link rel="stylesheet" href="./assets/css/insertion.css">
</head>           
<body>
    <div class="redirect-home">HOME</div>
    <div class="liste-container">
        <div class="titre">Insertion Employé</div>
        <form action="Embauche" method="post">

            <div class="liste-item">
                <label for="nom">Nom</label>
                <input name="nom" type="text" id="nom" required>
            </div>

            <div class="liste-item">
                <label for="poste">Poste</label>
                <select name="poste" id="poste" required>
                    <%for(int i=0; i<dataPoste.size(); i++) {%>
                        <option value=<%out.println(dataPoste.get(i).getId());%> > <%
                                out.println(dataPoste.get(i).getNom());%>
                        </option>
                        <% } %>
                </select>
            </div>

            <div class="liste-item">
                <label for="experience">Experience</label>
                <input name="experience" type="number" id="experience" required min="0" required>
            </div>

            <div class="liste-item">
                <label for="date_embauche">Date embauche</label>
                <input name="date_embauche" type="date" id="date_embauche" required>
            </div>
            <button type="submit">Valider</button>
        </form>

    </div>               
</body>

</html>
<script src="./assets//js/index.js"></script>
<script src="./assets//js/date.js"></script>