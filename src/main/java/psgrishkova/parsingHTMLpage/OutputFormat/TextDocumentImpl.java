package psgrishkova.parsingHTMLpage.OutputFormat;

import java.io.FileWriter;
import java.io.IOException;

public class TextDocumentImpl implements OutputFormat {
    public void output(Object outputData) {
        try (FileWriter writer = new FileWriter("outputData.txt", false)) {
            writer.write(outputData.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
