
public class Main {
    public static void main(String[] args) {

        UserInputHandler userInputHandler = new UserInputHandler();
        WordsLoader wordsLoader = new WordsLoader();
        HandlerWord handlerWord = new HandlerWord(wordsLoader);
        HandlerSecretWord handlerSecretWord = new HandlerSecretWord(handlerWord);
        ContainerWithEnteredLetters containerWithEnteredLetters = new ContainerWithEnteredLetters(userInputHandler);
        WordAndLetterManager wordAndLetterManager = new WordAndLetterManager(userInputHandler, handlerWord, handlerSecretWord, containerWithEnteredLetters);
        Game game = new Game(userInputHandler, handlerSecretWord, wordAndLetterManager,containerWithEnteredLetters);

        GameView.startGame();
        GameView.printInfoAboutStartStopGame();
        game.startGameOrExit();
    }
}