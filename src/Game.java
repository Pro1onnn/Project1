
public class Game {

    private static final int MAX_ERROR_COUNT = 6;

    private final UserInputHandler userInputHandler;
    private final WordsLoader wordsLoader;
    private final HandlerWord handlerWord;
    private final HandlerSecretWord handlerSecretWord;
    private final ContainerWithLetters containerWithLetters;

    private int counterError;

    public Game(UserInputHandler userInputHandler, WordsLoader wordsLoader, HandlerWord handlerWord,
                HandlerSecretWord handlerSecretWord, ContainerWithLetters containerWithLetters) {
        this.userInputHandler = userInputHandler;
        this.wordsLoader = wordsLoader;
        this.handlerWord = handlerWord;
        this.handlerSecretWord = handlerSecretWord;
        this.containerWithLetters = containerWithLetters;
    }

    private boolean isInSetInputLetters() {
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
        for (int i = 0; i < handlerWord.getCharArrayWord().length; i++) {
            if (handlerWord.getCharArrayWord()[i] == userInputHandler.getEnteredLetter()) {
                return true;
            }
        }
        return false;
    }

    public void makeMove() {
        if (isInSetInputLetters()) {
            System.out.println("Такая буква есть"); // Заменить на метод из GameView
            handlerSecretWord.revealLetter(userInputHandler.getEnteredLetter());
            System.out.println(handlerSecretWord.getMaskLetters());
        } else {
            System.out.println("Такой буквы нет"); // Заменить на метод из GameView
            counterError++;
            GameView.gallowsInDisplay(counterError);
            System.out.println("Ошибок " + counterError); // Заменить на метод из GameView
        }
    }

    public void start() {
        while (!isGameOver()) {
            makeMove();
        }
        if (isLose()) {
            GameView.userLose(handlerWord.getCharArrayWord());
            containerWithLetters.clearSet();
        } else if (isWin()) {
            GameView.userWin();
            containerWithLetters.clearSet();
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

    public boolean isWin() {
        return checkIfLettersAreOpen();
    }

    public boolean isLose() {
        return counterError == MAX_ERROR_COUNT;
    }

    public boolean isGameOver() {
        return isLose() || isWin();
    }
}