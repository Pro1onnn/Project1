import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class Words {

    File file = Path.of("resources", "wordsGame.txt").toFile();
    ArrayList<String> words = new ArrayList<>();
    Set<Character> setAccessibleChars = new LinkedHashSet<>();
    Random rand = new Random();
    String word;

    public ArrayList<String> loadWords() {
        String line;
        words.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return words;
    }

    public String getWord(ArrayList<String> list) {
        word = list.get(rand.nextInt(list.size())).toLowerCase();
        return word;
    }

    public char[] getCharMassiveWord(String word) {
        return word.toCharArray();
    }

    public char[] getMaskWord(String word) {
        return word.replaceAll("[а-яё]", "*").toCharArray();
    }

    public boolean checkCharAddSet(char charWord) {
        return setAccessibleChars.add(charWord);
    }

    public void clearSet() {
        setAccessibleChars.clear();
    }
}

