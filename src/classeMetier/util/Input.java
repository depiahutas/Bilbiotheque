package classeMetier.util;

public class Input {
    final static String regexMail = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    final static String regexString = "^[A-Z][A-Za-z\\é\\è\\ê\\-]+$";
    final static String regexInt = "[0-9]+";

    public static boolean VerifInt(String x) {
        return x.matches(regexInt);
    }

    public static boolean VerifMail(String mail) {
        return mail.matches(regexMail);
    }

    public static boolean VerifStringNoInt(String s){
        return s.matches(regexString);
    }
}
