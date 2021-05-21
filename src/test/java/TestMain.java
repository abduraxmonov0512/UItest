import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class TestMain {
    public static void main(String[] args) {
//        System.out.println("Hello world");
//       String s =  "1221312,60";
//        System.out.println(s.replace(",", "."));

        Locale locale = new Locale("sk", "SK");

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
        symbols.setGroupingSeparator(' ');
        symbols.setDecimalSeparator('.');



        String pattern = "###,###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);

        String number = decimalFormat.format(123456789);
        System.out.println(number);
    }
}
