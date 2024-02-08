<%@page contentType="text/html" pageEncoding="UTF-8" import="Models.*,java.util.Vector" %>


    <% try{ 
        Vector<Style> dataMatiere = (Vector<Style>)request.getAttribute("allStyle");
        %>
       
        <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0"><title>insertion matière & style</title>
                <link rel="stylesheet" href="./assets/css/index.css">
                <link rel="stylesheet" href="./assets/css/insertion.css">
            </head>
            <div class="redirect-home">HOME</div>
                <body>
                    <div class="liste-container">
                        <div class="titre">Insertion matière & style</div>
                        <form action="ListeMatiereStyle" method="post">
                            <div class="liste-item">

                            <label for="style_meuble">Style</label>
                            <select name="style_meuble" id="style_meuble">
                            <%for(int i=0; i<dataMatiere.size(); i++) {%>
                                <option value=<% out.println(dataMatiere.get(i).getId());%>> <% out.println(dataMatiere.get(i).getNom());%> </option>
                            <% } %>
                            </select>
                    
                            </div>
                            <button type="submit">Valider</button>
                        </form>

                    </div>
                </body>
            </html>
            <script src="./assets//js/index.js"></script>
        
        <% }catch(Exception e){ System.out.println("error page jsp"); } %>
    




            
            