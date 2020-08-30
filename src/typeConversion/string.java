package typeConversion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xuyuc
 * @since 2020/8/29 11:36
 */
public class string {
    public static void main(String[] args) throws ParseException {
        String str1 = "12";
        String str2 = "12.34";
        String str3 = "2008-08-08 18:30:00";

        /*
         string -> int
        */
        int i1 = Integer.parseInt(str1);
        System.out.println(getType(i1));

        int i2 = Integer.valueOf(str1).intValue();
        System.out.println(getType(i2));

        /*
         string -> long
        */
        long l1 = Long.parseLong(str1);
        System.out.println(getType(l1));

        long l2 = Long.valueOf(str1).longValue();
        System.out.println(getType(l2));

        /*
         string -> float
        */
        float f = Float.parseFloat(str2);
        System.out.println(getType(f));

        /*
         string -> long
        */
        Double db1 = new Double(str2).doubleValue();
        System.out.println(getType(db1));

        Double db2 = Double.parseDouble(str2);
        System.out.println(getType(db2));

        Double db3 = Double.valueOf(str2).doubleValue();
        System.out.println(getType(db3));

        /*
         string -> Date
        */
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = df.parse(str3);
        System.out.println(getType(date));
    }

    private static String getType(Object a) {
        return a.getClass().toString();
    }

}
