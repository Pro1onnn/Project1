import java.util.Arrays;

public class HandlerSecretWord {

    private final HandlerWord handlerWord;
    private char[] maskLetters;

    public HandlerSecretWord(HandlerWord handlerWord) {
        this.handlerWord = handlerWord;
    }

    public void convertWordInMask() {
        handlerWord.getRandomWordFromList();
        maskLetters = handlerWord.getSelectedWord().toCharArray();
        Arrays.fill(maskLetters, '*');
        maskLetters.clone();
    }

    public char[] getMaskLetters() {
        return maskLetters;
    }
}
