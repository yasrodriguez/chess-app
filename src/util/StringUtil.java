package util;

public class StringUtil {

    public final static String NEWLINE = System.getProperty("line.separator");

    private StringUtil(){

    }

    public static String appendNewLine(String text){
        return text + NEWLINE;
    }
}
