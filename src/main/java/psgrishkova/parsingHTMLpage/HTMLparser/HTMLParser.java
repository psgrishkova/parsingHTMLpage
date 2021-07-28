package psgrishkova.parsingHTMLpage.HTMLparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HTMLParser {
    private final Document document;

    public HTMLParser(String address) throws IOException {
        document = Jsoup.connect(address).get();
    }

    public String getText() {
        return document.getAllElements().get(0).text();
    }
}
