public class Game {

    private static final int MAX_ERROR_COUNT = 6;
    private static final String USER_INPUT_VALUE_FOR_START = "1";
    private static final String USER_INPUT_VALUE_FOR_STOP = "0";

    private final UserInputHandler userInputHandler;
    private final HandlerSecretWord handlerSecretWord;
    private final WordAndLetterManager wordAndLetterManager;
    private ContainerWithEnteredLetters containerWithEnteredLetters;
    private int counterError;

    public Game(UserInputHandler userInputHandler, HandlerSecretWord handlerSecretWord, WordAndLetterManager wordAndLetterManager,
                ContainerWithEnteredLetters containerWithEnteredLetters) {
        this.userInputHandler = userInputHandler;
        this.handlerSecretWord = handlerSecretWord;
        this.wordAndLetterManager = wordAndLetterManager;
        this.containerWithEnteredLetters = containerWithEnteredLetters;
    }

    public void startGameOrExit() {
        boolean resultInputUser = true;
        while (resultInputUser) {
            String value = userInputHandler.readInputUser();
            if (value.equals(USER_INPUT_VALUE_FOR_START)) {
                GameView.printInfoRulesGame();
                handlerSecretWord.convertWordInMask();
                startGamePlay();
                GameView.printInfoAboutStartStopGame();
            } else if (value.equals(USER_INPUT_VALUE_FOR_STOP)) {
                resultInputUser = false;
                GameView.stopGame();
            } else {
                GameView.userInputErrorWhenLaunchingGame();
            }
        }
    }

    private void startGamePlay() {
        while (!isGameOver()) {
            makeMove();
        }
        if (isLose()) {
            GameView.userLose(wordAndLetterManager.getCharArrayWord());
            wordAndLetterManager.clearSet();
            counterError = 0;
        } else if (isWin()) {
            GameView.userWin();
            wordAndLetterManager.clearSet();
            counterError = 0;
        }
    }

    private void makeMove() {
        if (wordAndLetterManager.isInSetInputLetters()) {
            GameView.correctCharInWord(userInputHandler.getEnteredLetter());
            wordAndLetterManager.revealLetter(userInputHandler.getEnteredLetter());
            System.out.println(handlerSecretWord.getMaskLetters());
            GameView.charMaskOutDisplay(containerWithEnteredLetters.getSetAccessibleChars());
        } else {
            GameView.noCharInWord(userInputHandler.getEnteredLetter());
            counterError++;
            GameView.gallowsInDisplay(counterError);
            GameView.counterErrorInDisplay(counterError);
            GameView.charMaskOutDisplay(containerWithEnteredLetters.getSetAccessibleChars());
        }
    }

    private boolean isGameOver() {
        return isLose() || isWin();
    }

    private boolean isWin() {
        return wordAndLetterManager.checkIfLettersAreOpen();
    }

    private boolean isLose() {
        return counterError == MAX_ERROR_COUNT;
    }
}