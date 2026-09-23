import java.util.*;

public class HandlerWord {

    private Random random = new Random();
    private String selectedWord;
    private final List<String> words;

    public HandlerWord(WordsLoader wordsLoader) {
        this.words = wordsLoader.getWords();
        getRandomWordFromList();
    }

    public String getRandomWordFromList() {
        int randomIndex = random.nextInt(words.size());
        selectedWord = words.get(randomIndex).toLowerCase();
        return selectedWord;
    }

    public char[] getCharArrayWord() {
        return selectedWord.toCharArray().clone();
    }
}