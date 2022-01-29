package co.rivatech.nutrition.constatnts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author vranjan
 * created 11/09/2021
 */
public class DateUtil {

    public static String getTodaysDate(final Date date) {
        final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    public static SimpleDateFormat getFormat() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }
}
