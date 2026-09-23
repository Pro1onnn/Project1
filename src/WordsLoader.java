import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WordsLoader {

    private final List<String> words;

    public WordsLoader() {
        this.words = loadWordsFromFile();
    }

    private List<String> loadWordsFromFile() {
        List<String> loadedWords = new ArrayList<>();
        try (InputStream inputStream = getClass().getResourceAsStream("/wordsGame.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            if (inputStream == null) {
                throw new IllegalStateException("Файл 'wordsGame.txt' не найден в ресурсах проекта!");
            }
            String line;
            while ((line = reader.readLine()) != null) {
                loadedWords.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return List.copyOf(loadedWords);
    }

    public List<String> getWords() {
        return words;
    }
}

