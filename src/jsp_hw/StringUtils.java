package jsp_hw;

public class StringUtils {

    public static boolean isEmptyOrBlank(String s) {
        return s == null ||
               s.isEmpty() ||
               s.trim().length() == 0;
    }

}
