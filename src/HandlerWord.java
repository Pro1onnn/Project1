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
        return words.get(random.nextInt(words.size())).toLowerCase();
    }

    public char[] getCharArrayWord() {
        return selectedWord.toCharArray().clone();
    }
}