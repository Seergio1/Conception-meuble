<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector" %>
    <% try{ if(request.getAttribute("allMatiere")!=null){ Vector<Matiere>dataMatiere=(Vector<Matiere>
            )request.getAttribute("allMatiere");
            }

            %>
            < !DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>insertion prix matiere</title>
                    <link rel="stylesheet" href="./assets/css/index.css">
                    <link rel="stylesheet" href="./assets/css/insertion.css">
                </head>

                <body>
                    <div class="redirect-home">HOME</div>
                    <div class="liste-container">
                        <div class="titre">Insertion prix matière</div>
                        <form action="/insertionMatiereStyle" method="post">

                            <div class="liste-item">

                                <label for="matiere_meuble">Matiere</label>
                                <select name="matiere_meuble" id="matiere_meuble">
                                    <%for(int i=0; i<dataMatiere.size(); i++) {%>
                                        <option value=<% out.println(dataMatiere.get(i).getId());%>> <%
                                                out.println(dataMatiere.get(i).getNom());%>
                                        </option>
                                        <% } %>
                                </select>

                            </div>

                            <div class="liste-item">

                                <label for="matiere_meuble">Prix</label>
                                <input type="number" name="prix">

                            </div>

                            <button type="submit">Valider</button>

                        </form>
                    </div>
                </body>

                </html>
                <script src="./assets//js/index.js"></script>

                <%} catch(Exception e) { // } %>