<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector" %>
<% 
    Vector<Profil> dataProfil = (Vector<Profil>)request.getAttribute("allProfil");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profil durée</title>
    <link rel="stylesheet" href="./assets/css/index.css">
    <link rel="stylesheet" href="./assets/css/insertion.css">
</head>           
<body>
    <div class="redirect-home">HOME</div>
    <div class="liste-container">
        <div class="titre">Insertion profil durée</div>
        <form action="insertionProfilDuree" method="post">
            <div class="liste-item">
                <label for="profil">Profil</label>
                <select name="profil" id="profil" required>
                    <%for(int i=0; i<dataProfil.size(); i++) {%>
                        <option value=<%out.println(dataProfil.get(i).getId());%> > <%
                                out.println(dataProfil.get(i).getNom());%>
                        </option>
                    <% } %>
                </select>
            </div>

            <div class="liste-item">
                <label for="experience">Experience</label>
                <input value="0" name="experience" type="number" id="experience" required min="0" required>
            </div>

            <div class="liste-item">
                <label for="coeff">Coefficient</label>
                <input value="1" name="coeff" type="number" id="coeff" required min="1" required>
            </div>
            <button type="submit">Valider</button>
        </form>

    </div>               
</body>

</html>
<script src="./assets//js/index.js"></script>
<script src="./assets//js/date.js"></script>