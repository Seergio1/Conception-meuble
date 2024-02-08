<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
    <html>

    <head>
        <title>Meuble</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./assets/css/index.css">
        <link rel="stylesheet" href="./assets/css/home.css">
    </head>


    <body>
        <div class=" choix_container">
            <div class="box_item_choix">
                <div class="choix_item">
                    Taille
                </div>
                <div class="menu_item">
                    <a href="insertionTaille.jsp">
                        <div class="itemM">Insertion</div>
                    </a>

                    <a href="ListeTaille">
                        <div class="itemM">Liste</div>
                    </a>
                </div>
            </div>

            <div class="box_item_choix">
                <div class="choix_item">
                    Catégorie
                </div>
                <div class="menu_item">
                    <a href="insertionCategorie.jsp">
                        <div class="itemM">Insertion</div>
                    </a>

                    <a href="ListeCategorie">
                        <div class="itemM">Liste</div>
                    </a>
                </div>
            </div>

            <div class="box_item_choix">
                <div class="choix_item">
                    Matiere
                </div>
                <div class="menu_item">
                    <a href="./insertionMatiere.jsp">
                        <div class="itemM">Insertion</div>
                    </a>

                    <a href="ListeMatiere">
                        <div class="itemM">Liste</div>
                    </a>
                </div>
            </div>

            <div class="box_item_choix">
                <div class="choix_item">
                    Style
                </div>
                <div class="menu_item">
                    <a href="./insertionStyle.jsp">
                        <div class="itemM">Insertion</div>
                    </a>

                    <a href="ListeStyle">
                        <div class="itemM">Liste</div>
                    </a>
                </div>
            </div>




            <!-- <div class="box_item_choix">
                <div class="choix_item">
                    Prix matière
                </div>
                <div class="menu_item">
                    <a href="">
                        <div class="itemM">Insertion</div>
                    </a>
                    
                    <a href="">
                        <div class="itemM">Liste</div>
                    </a>
                </div>
            </div> -->

            <div class="box_item_choix">
                <div class="choix_item">
                    Matiere & Style
                </div>
                <div class="menu_item">
                    <a href="affichageMatiereStyle">
                        <div class="itemM">Insertion</div>
                    </a>

                    <a href="pageGetMatiereByStyle">
                        <div class="itemM">Liste</div>
                    </a>
                </div>
            </div>



            <div class="box_item_choix">
                <div class="choix_item">
                    Meuble
                </div>
                <div class="menu_item">

                    <a href="getAffichageMeuble">
                        <div class="itemM">Insertion</div>
                    </a>

                    <a href="getAffichageMeubleMatiere">
                        <div class="itemM">Insertion (meuble & matière)</div>
                    </a>

                    <a href="getAffichageMeubleOuvrier">
                        <div class="itemM">Insertion (meuble & employé)</div>
                    </a>

                    <a href="ListeMeuble">
                        <div class="itemM">Liste (meuble)</div>
                    </a>

                    <a href="getAffichageQuantiteMatiere">
                        <div class="itemM">Recherche (matiere)</div>
                    </a>

                    <a href="./question_deux/getAffichagePrix.jsp">
                        <div class="itemM">Recherche (prix)</div>
                    </a>
                    <a href="./question_benef/affichageBenefice.jsp">
                        <div class="itemM">Recherche (benefice)</div>
                    </a>

                    <a href="getAffichageCreationMeuble">
                        <div class="itemM">Fabrication meuble (stock meuble)</div>
                    </a>



                </div>
            </div>


            <div class="box_item_choix">
                <div class="choix_item">
                    Employé
                </div>
                <div class="menu_item">
                    <a href="getAffichageExperience">
                        <div class="itemM">Insertion</div>
                    </a>
                    <a href="getAffichageProfilDuree">
                        <div class="itemM">Insertion (profil duree)</div>
                    </a>
                    <a href="dataAffichageExperience">
                        <div class="itemM">Etat employé actuel</div>
                    </a>
                </div>
            </div>


            <div class="box_item_choix">
                <div class="choix_item">
                    Stock
                </div>
                <div class="menu_item">
                    <a href="getAfficheEntrerStock">
                        <div class="itemM">Entrer stock</div>
                    </a>
                    <a href="getAffichageStockMatiere">
                        <div class="itemM">Etat stock matière</div>
                    </a>
                    <a href="getAffichageStockMeuble">
                        <div class="itemM">Etat stock meuble</div>
                    </a>
                </div>
            </div>


            <div class="box_item_choix">
                <div class="choix_item">
                    Vente
                </div>
                <div class="menu_item">
                    <a href="getAffichageVente">
                        <div class="itemM">Insertion</div>
                    </a>
                    <a href="getAffichageClient">
                        <div class="itemM">Insertion (client)</div>
                    </a>
                    <a href="getDataMeubleStat">
                        <div class="itemM">Statistique</div>
                    </a>
                </div>
            </div>





        </div>
    </body>

    </html>
    <script>
        let box = document.querySelectorAll(".box_item_choix");
        box.forEach((item) => {
            let menu = item.querySelector(".menu_item");

            item.addEventListener('click', () => {
                // Fermer tous les menus sauf celui actuel
                document.querySelectorAll(".menu_item").forEach((otherMenu) => {
                    if (otherMenu !== menu && otherMenu.classList.contains("open")) {
                        otherMenu.classList.remove("open");
                    }
                });

                // Ouvrir ou fermer le menu actuel
                if (menu.classList.contains("open")) {
                    menu.classList.remove("open");
                } else {
                    menu.classList.add("open");
                }
            })
        })
    </script>