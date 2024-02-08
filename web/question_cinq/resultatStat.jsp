<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector" %>
<%
Vector<V_vente> stat = (Vector<V_vente>)request.getAttribute("stat");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>insert meuble</title>
    <link rel="stylesheet" href="./assets/css/index.css">
    <link rel="stylesheet" href="./assets/css/insertion.css">
    <script src="./assets/chart.js/dist/chart.umd.js"></script>
    <link rel="stylesheet" href="./assets/css/table.css">
</head>

<style>
  .box_chart{
    width: 300px;
    height: 300px;
    margin: 5%;
  }
</style>
<body>
  <div class="redirect-home">HOME</div>
  <div class="box_chart">
    <canvas id="donutChart" ></canvas>
  </div>
  <div class="table-container">
    <table>
        <thead>
            <tr>
                <th>Meuble</th>
                <!-- <th>Genre</th> -->
                <th>Homme</th>
                <th>Femme</th>
            </tr>
        </thead>
        <tbody>
            
            <% for(int i = 0;i<stat.size();i++){ %>
                <tr>
                    <td> <% out.println(stat.get(i).getNomCategorie()+"/"+stat.get(i).getNomStyle()+"/"+stat.get(i).getNomTaille()); %></td>
                    <!-- <td> <% out.println(stat.get(i).getNom_genre()); %> </td> -->
                    <td> <% out.println(stat.get(i).getNombreHomme()); %> </td>
                    <td> <% out.println(stat.get(i).getNombreFemme()); %> </td>
                </tr>
            <% } %>
            
            
        </tbody>
    </table>
</div>

    
</body>
</html>

<script>
  // Récupérez le contexte du canvas
  var ctx = document.getElementById('donutChart').getContext('2d');

  // Données du graphique
  var data = {
      labels: [<% for (int i = 0; i < stat.size(); i++) { %>'<%= stat.get(i).getNomCategorie() %>/<%= stat.get(i).getNomStyle() %>/<%= stat.get(i).getNomTaille() %>',<% } %>],
      datasets: [{
          data: [<% for (int i = 0; i < stat.size(); i++) { %><%= stat.get(i).getNombreHomme() + stat.get(i).getNombreFemme() %>,<% } %>],
          backgroundColor: [ 'orange', 'purple', 'pink','brown'], // Ajoutez plus de couleurs si nécessaire
      }]
  };

  // Configuration du graphique en donut
  var options = {
      cutoutPercentage: 50, // Pourcentage de découpe pour créer le trou du donut
  };

  // Créer le graphique en donut
  var myDonutChart = new Chart(ctx, {
      type: 'doughnut',
      data: data,
      options: options
  });
</script>

  <script src="./assets//js/index.js"></script>