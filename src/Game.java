import java.util.*;

public class Game {

    private static final int MAX_ERROR_COUNT = 6;
    private static final String USER_INPUT_VALUE_FOR_START = "1";
    private static final String USER_INPUT_VALUE_FOR_STOP = "0";

    private Scanner scan = new Scanner(System.in);
    private Words words = new Words();

    public void gameStart() {
        boolean playAgain = true;
        MessageUtil.startGame();
        while (playAgain) {
            MessageUtil.printInfoAboutStartStopGame();
            String result = scan.nextLine();
            if (result.equals(USER_INPUT_VALUE_FOR_START)) {
                words.clearSet();
                words.returnsRandomWordFromList();
                char[] charUser = words.getCharMassiveWord();
                char[] charMask = words.getMaskWord();
                checkCharInWord(charUser, charMask);
            } else if (result.equals(USER_INPUT_VALUE_FOR_STOP)) {
                MessageUtil.stopGame();
                playAgain = false;
            } else {
                MessageUtil.userInputErrorWhenLaunchingGame();
            }
        }
    }

    public char checkCharInputUser() {
        while (true) {
            String str = scan.nextLine();
            if (str.matches("[а-яё]")) {
                char ch = str.charAt(0);
                return ch;
            } else {
                MessageUtil.errorInputCharUser();
            }
        }
    }

    public void checkCharInWord(char[] charUser, char[] charMask) {
        MessageUtil.printInfoRulesGame();
        int counterError = 0;
        while (counterError < MAX_ERROR_COUNT && new String(charMask).contains("*")) {
            char charInputUser = checkCharInputUser();
            boolean isFound = false;
            if (!words.checkCharAddSet(charInputUser)) {
                MessageUtil.repeatedInputCharUser();
                continue;
            }
            for (int i = 0; i < charUser.length; i++) {
                if (charUser[i] == charInputUser) {
                    isFound = true;
                    charMask[i] = charInputUser;
                }
            }
            if (isFound) {
                MessageUtil.correctCharInWord(charInputUser);
            } else {
                counterError++;
                MessageUtil.noCharInWord(charInputUser);
                MessageUtil.gallowsInDisplay(counterError);
                MessageUtil.counterErrorInDisplay(counterError);
            }
            MessageUtil.charMaskInDisplay(charMask);
        }
        if (counterError == MAX_ERROR_COUNT) {
            MessageUtil.userLose(charUser);
        } else {
            MessageUtil.userWin();
        }
    }
}