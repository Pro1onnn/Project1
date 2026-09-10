import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class Words {

    private File file = Path.of("resources", "wordsGame.txt").toFile();
    private List<String> words = new ArrayList<>();
    private Set<Character> setAccessibleChars = new LinkedHashSet<>();
    private Random rand = new Random();
    private String word;

    Words() {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String returnsRandomWordFromList(List<String> list) {
        return word = list.get(rand.nextInt(list.size())).toLowerCase();
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

