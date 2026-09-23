public class WordManager {

    private UserInputHandler userInputHandler;
    private HandlerWord handlerWord;
    private HandlerSecretWord handlerSecretWord;
    private ContainerWithLetters containerWithLetters;

    public WordManager(UserInputHandler userInputHandler, HandlerWord handlerWord,
                       HandlerSecretWord handlerSecretWord, ContainerWithLetters containerWithLetters) {
        this.userInputHandler = userInputHandler;
        this.handlerWord = handlerWord;
        this.handlerSecretWord = handlerSecretWord;
        this.containerWithLetters = containerWithLetters;
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
            if (containerWithLetters.checkCharAddSet()) {
                return checkLetterInputUserInWords();
            } else {
                GameView.repeatedInputCharUser();
                System.out.println("Список введенных бУкВ: " + containerWithLetters.getSetAccessibleChars());
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
        containerWithLetters.getSetAccessibleChars().clear();
    }
}
