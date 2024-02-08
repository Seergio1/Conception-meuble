<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meuble & benefice</title>
    <link rel="stylesheet" href="./../assets/css/index.css">
    <link rel="stylesheet" href="./../assets/css/insertion.css">
</head>
<body>
    <div class="redirect-home">HOME</div>
    <div class="liste-container">
        <div class="titre">Recherche de meuble par benefice</div>
        <form action="/ProjectServlet/rechercheBenefice" method="post">
            
            <div class="liste-item">
                <label for="min">Min</label>
                <input name="min" type="number" id="min" required>
            </div>
            <div class="liste-item">
                <label for="max">Max</label>
                <input name="max" type="number" id="max" required>
            </div>
            <button type="submit">Valider</button>
        </form>

    </div>
</body>
</html>
<script src="./assets//js/index.js"></script>