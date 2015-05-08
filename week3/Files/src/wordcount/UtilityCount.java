package wordcount;

import java.io.File;
import java.nio.file.Path;

public class UtilityCount {
    WordCountResult wordCount(Path path) {
        File file = path.toFile();
        return this.wordCount(file);

    }

    WordCountResult wordCount(File file) {
        return new WordCountResult(file);
    }
}
