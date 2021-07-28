package psgrishkova.parsingHTMLpage;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import psgrishkova.parsingHTMLpage.StringParser.StringParser;

public class StringParsingTests {
    @Test
    public void splitTest(){
        StringParser stringParser=new StringParser(" tratata -lalala - ebkjerknke bkbk bjkerfjkwk -r erkjwf lalala");
        stringParser.splitText();
        System.out.println(stringParser.getWords());
        Assert.assertEquals(7,stringParser.getWords().size());
    }
}
