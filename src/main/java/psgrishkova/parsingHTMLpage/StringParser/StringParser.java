package psgrishkova.parsingHTMLpage.StringParser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StringParser {
    private static final List<Character> splitter =
            Arrays.asList(' ', ',', '.', ':', '!', '?', ';', '(', ')', '[', ']', '{', '}', '"', '-', '\n', '\t', '\r');

    private String testString;
    private final HashMap<String,Integer> words;

    public StringParser(String testString) {
        this.testString = testString;
        words = new HashMap<>();
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    public HashMap<String,Integer> getWords() {
        return words;
    }

    public void splitText() {
        int i = -1;
        String word = "";
        while (i < testString.length()) {
            if (testString.length() != i + 1 && !splitter.contains(testString.charAt(i + 1))) {
                word += testString.charAt(i + 1);
            } else if (word.length() != 0) {
                if(words.containsKey(word)) words.replace(word,words.get(word),words.get(word)+1);
                else words.put(word,1);
                word="";
            }
            i++;
        }
    }
}
