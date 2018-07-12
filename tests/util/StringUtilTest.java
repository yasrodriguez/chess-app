package util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringUtilTest {

    @Test
    public void testAppendNewline(){
        assertEquals("line1" + StringUtil.NEWLINE + "line2" + StringUtil.NEWLINE, StringUtil.appendNewLine("line1") +
        StringUtil.appendNewLine("line2"));
    }
}
