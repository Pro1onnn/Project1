import java.util.Arrays;

public class HandlerSecretWord {

    private final char[] wordLetters;
    private char[] maskLetters;

    public HandlerSecretWord(HandlerWord handlerWord) {
        this.wordLetters = handlerWord.getCharArrayWord();
        this.maskLetters = wordLetters.clone();
        Arrays.fill(maskLetters, '*');
    }

    public char[] getMaskLetters() {
        return maskLetters.clone();
    }

    public void revealLetter(char letter) {
        for (int i = 0; i < wordLetters.length; i++) {
            if (wordLetters[i] == letter) {
                maskLetters[i] = letter;
            }
        }
    }
}
