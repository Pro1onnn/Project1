import java.util.*;

public class HandlerWord {

    private final Random random = new Random();
    private String selectedWord;
    private final List<String> words;

    public HandlerWord(WordsLoader wordsLoader) {
        this.words = wordsLoader.getWords();
    }

    public void getRandomWordFromList() {
        selectedWord = words.get(random.nextInt(words.size())).toLowerCase();
    }

    public String getSelectedWord() {
        return selectedWord;
    }
}