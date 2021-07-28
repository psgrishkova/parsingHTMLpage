package psgrishkova.parsingHTMLpage;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import psgrishkova.parsingHTMLpage.HTMLparser.HTMLParser;
import psgrishkova.parsingHTMLpage.OutputFormat.OutputFormat;
import psgrishkova.parsingHTMLpage.OutputFormat.TextDocumentImpl;
import psgrishkova.parsingHTMLpage.StringAnalysis.StringSplitter;

import java.io.File;
import java.io.IOException;

public class HTMLParsingTests {

    @Test
    public void splitTest() {
        StringSplitter stringSplitter = new StringSplitter(" tratata -lalala - ebkjerknke bkbk bjkerfjkwk -r erkjwf lalala");
        stringSplitter.splitText();
        Assert.assertEquals(7, stringSplitter.getWords().size());
    }

    @Test
    public void connectingTest() throws IOException {
        HTMLParser htmLparser = new HTMLParser("https://yandex.ru/");
        Assert.assertNotNull(htmLparser);
    }

    @Test
    public void writeResult() throws IOException {
        HTMLParser htmLparser = new HTMLParser("https://www.simbirsoft.com/");
        StringSplitter stringSplitter = new StringSplitter(htmLparser.getText());
        stringSplitter.splitText();
        OutputFormat writeToFile=new TextDocumentImpl();
        writeToFile.output(stringSplitter.getWords());
        Assert.assertFalse(new File("outputData.txt").length()==0);
    }

    @Test
    public void getStatisticsTest() throws IOException {
        HTMLParser htmLparser = new HTMLParser("https://www.simbirsoft.com/");
        StringSplitter stringSplitter = new StringSplitter(htmLparser.getText());
        stringSplitter.splitText();
        Assert.assertNotNull(stringSplitter.getWords());
    }
}
