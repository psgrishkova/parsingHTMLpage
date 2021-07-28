package psgrishkova.parsingHTMLpage.StringAnalysis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StringSplitter {
    private static final List<Character> splitter =
            Arrays.asList(' ', ',', '.', ':', '!', '?', ';', '(', ')', '[', ']', '{', '}', '"', '-', '—', '«', '»', '/', '%', '^', '&', '|', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '\n', '\t', '\r');

    private String testString;
    private HashMap<String, Integer> words;

    public StringSplitter(String testString) {
        setTestString(testString);
    }

    public StringSplitter() {
    }

    public void setTestString(String testString) {
        this.testString = testString;
        words = new HashMap<>();
    }

    public HashMap<String, Integer> getWords() {
        return words;
    }

    public void splitText() {
        int i = -1;
        String word = "";
        while (i < testString.length()) {
            if (testString.length() != i + 1 && !splitter.contains(testString.charAt(i + 1))) {
                word += testString.charAt(i + 1);
            } else if (word.length() != 0) {
                if (words.containsKey(word)) words.replace(word, words.get(word), words.get(word) + 1);
                else words.put(word.toLowerCase(), 1);
                word = "";
            }
            i++;
        }
    }
}
