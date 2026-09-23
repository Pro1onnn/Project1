
public class Main {
    public static void main(String[] args) {

        final String USER_INPUT_VALUE_FOR_START = "1";
        final String USER_INPUT_VALUE_FOR_STOP = "0";

        UserInputHandler userInputHandler = new UserInputHandler();
        WordsLoader wordsLoader = new WordsLoader();
        HandlerWord handlerWord = new HandlerWord(wordsLoader);
        HandlerSecretWord handlerSecretWord = new HandlerSecretWord(handlerWord);
        ContainerWithLetters containerWithLetters = new ContainerWithLetters(userInputHandler);
        Game game = new Game(userInputHandler, wordsLoader, handlerWord, handlerSecretWord, containerWithLetters);

        GameView.startGame();
        GameView.printInfoAboutStartStopGame();
        System.out.println();
//        System.out.println(handlerSecretWord.getMaskLetters());
        System.out.println();

        while (true) {
            String startAndExit = userInputHandler.readInputUser();
            if (startAndExit.equals(USER_INPUT_VALUE_FOR_START)) {
                GameView.printInfoRulesGame();
                game.start();
            } else if (startAndExit.equals(USER_INPUT_VALUE_FOR_STOP)) {
                GameView.stopGame();
            } else {
                GameView.userInputErrorWhenLaunchingGame();
            }
        }
    }
}