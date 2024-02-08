package Utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Vector;

public class Utils {
    public static boolean hasDuplicates(Vector<Integer> vector) {
        HashSet<Integer> set = new HashSet<>();

        for (Integer element : vector) {
            // Si l'élément existe déjà dans le HashSet, il y a un doublon
            if (!set.add(element)) {
                return true;
            }
        }

        return false;
    }

    public static Timestamp convertDate(String dateString){
        // Append the time part "00:00:00" to the date string
        String dateTimeString = dateString + " 00:00:00";

        // Define the format for the date with time
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            // Convert the combined string to a Timestamp
            Date parsedDate = dateFormat.parse(dateTimeString);
            Timestamp timestamp = new Timestamp(parsedDate.getTime());

            return timestamp;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
