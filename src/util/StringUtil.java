package util;

public class StringUtil {

    public final static String NEWLINE = System.getProperty("line.separator");

    private StringUtil(){

    }

    public static String appendNewLine(String text){
        return text + NEWLINE;
    }

    public static char getFirstLetterInUpperCase(String word) {
        return word.substring(0,1).toUpperCase().charAt(0);
    }

    public static char getFirstLetterInLowerCase(String word) {
        return word.substring(0,1).toLowerCase().charAt(0);
    }
}
