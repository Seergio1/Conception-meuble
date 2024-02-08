
    // Obtenez la date actuelle au format "YYYY-MM-DD"
    function getCurrentDate() {
        const today = new Date();
        const year = today.getFullYear();
        const month = (today.getMonth() + 1).toString().padStart(2, '0');
        const day = today.getDate().toString().padStart(2, '0');
        return `${year}-${month}-${day}`;
    }

    // Attribuez la date actuelle au champ de date
    document.getElementById('date_embauche').value = getCurrentDate();
