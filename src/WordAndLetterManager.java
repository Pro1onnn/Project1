public class WordAndLetterManager {

    private final UserInputHandler userInputHandler;
    private final HandlerWord handlerWord;
    private final HandlerSecretWord handlerSecretWord;
    private final ContainerWithEnteredLetters containerWithEnteredLetters;

    public WordAndLetterManager(UserInputHandler userInputHandler, HandlerWord handlerWord,
                                HandlerSecretWord handlerSecretWord, ContainerWithEnteredLetters containerWithEnteredLetters) {
        this.userInputHandler = userInputHandler;
        this.handlerWord = handlerWord;
        this.handlerSecretWord = handlerSecretWord;
        this.containerWithEnteredLetters = containerWithEnteredLetters;
    }

    public char[] getCharArrayWord() {
        return handlerWord.getSelectedWord().toCharArray().clone();
    }

    public void revealLetter(char letter) {
        for (int i = 0; i < getCharArrayWord().length; i++) {
            if (getCharArrayWord()[i] == letter) {
                handlerSecretWord.getMaskLetters()[i] = letter;
            }
        }
    }

    public boolean checkIfLettersAreOpen() {
        for (int i = 0; i < handlerSecretWord.getMaskLetters().length; i++) {
            if (handlerSecretWord.getMaskLetters()[i] == '*') {
                return false;
            }
        }
        return true;
    }

    public boolean isInSetInputLetters() {
        while (userInputHandler.isValidLetterInput()) {
            if (containerWithEnteredLetters.checkCharAddSet()) {
                return checkLetterInputUserInWords();
            } else {
                GameView.repeatedInputCharUser(userInputHandler.getEnteredLetter());
            }
        }
        return false;
    }

    public boolean checkLetterInputUserInWords() {
        for (int i = 0; i < getCharArrayWord().length; i++) {
            if (getCharArrayWord()[i] == userInputHandler.getEnteredLetter()) {
                return true;
            }
        }
        return false;
    }

    public void clearSet() {
        containerWithEnteredLetters.getSetAccessibleChars().clear();
    }
}
