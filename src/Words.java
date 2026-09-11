import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class Words {

    private static final File PATH_FILE = Path.of("resources", "wordsGame.txt").toFile();

    private List<String> words = new ArrayList<>();
    private Set<Character> setAccessibleChars = new LinkedHashSet<>();
    private Random rand = new Random();
    private String word;

    Words() {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(PATH_FILE))) {
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String returnsRandomWordFromList() {
        word = words.get(rand.nextInt(words.size())).toLowerCase();
        return word;
    }

    public char[] getCharMassiveWord() {
        return word.toCharArray();
    }

    public char[] getMaskWord() {
        return word.replaceAll("[а-яё]", "*").toCharArray();
    }

    public boolean checkCharAddSet(char charWord) {
        return setAccessibleChars.add(charWord);
    }

    public void clearSet() {
        setAccessibleChars.clear();
    }

    public List<String> getWords() {
        return words;
    }
}