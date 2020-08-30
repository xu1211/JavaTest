package typeConversion;

import java.lang.String;

/**
 * @author xuyuc
 * @since 2020/8/23 12:00
 */
public class Int {

    public static void main(String[] args) {
        int i = 10;

        /*
         ing -> string
        */

        // 1.通过Integer
        String a = Integer.toString(i);
        System.out.println(getType(a));

        // 2.String.valueOf封装了Integer
        String b = String.valueOf(i);
        System.out.println(getType(b));

        // 3.强制转换
        String c = i + "";
        System.out.println(getType(c));
    }

    private static String getType(Object a) {
        return a.getClass().toString();
    }

}
