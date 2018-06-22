package util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringUtilTest {

    @Test
    public void testAppendNewline(){
        assertEquals("line1" + StringUtil.NEWLINE + "line2" + StringUtil.NEWLINE, StringUtil.appendNewLine("line1") +
        StringUtil.appendNewLine("line2"));
    }

    @Test
    public void testGetFirstLetterInUpperCase(){
        assertEquals('H',StringUtil.getFirstLetterInUpperCase("hello"));
    }

    @Test
    public void testGetFirstLetterInLowerCase(){
        assertEquals('h',StringUtil.getFirstLetterInLowerCase("Hello"));
    }
}
