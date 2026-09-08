import java.util.*;

public class Game {
    Scanner scan = new Scanner(System.in);
    Words words = new Words();
    Message message = new Message();

    public void gameStartStop() {
        boolean playAgain = true;
        while (playAgain) {
            message.choiceGame();
            int result = scan.nextInt();
            scan.nextLine();
            if (result == 1) {
                words.clearSet();
                words.getWord(words.loadWords());
                char[] charUser = words.getCharMassiveWord(words.word);
                char[] charMask = words.getMaskWord(words.word);
                checkCharInWord(charUser, charMask);
            } else if (result == 0) {
                message.stopGame();
                playAgain = false;
            } else {
                System.out.println("Неверный ввод. Попробуйте снова.");
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
                message.errorInputCharUser();
            }
        }
    }

    public void checkCharInWord(char[] charUser, char[] charMask) {
        message.startGame();
        int counterError = 0;
        while (counterError < 6 && new String(charMask).contains("*")) {
            char charInputUser = checkCharInputUser();
            boolean isFound = false;
            if (!words.checkCharAddSet(charInputUser)) {
                message.repeatedInputCharUser();
                continue;
            }
            for (int i = 0; i < charUser.length; i++) {
                if (charUser[i] == charInputUser) {
                    isFound = true;
                    charMask[i] = charInputUser;
                }
            }
            if (isFound) {
                message.correctCharInWord(charInputUser);
            } else {
                counterError++;
                message.noCharInWord(charInputUser);
                message.gallowsInDisplay(counterError);
                message.counterErrorInDisplay(counterError);
            }
            message.charMaskInDisplay(charMask);
        }
        if (counterError == 6) {
            message.userLose(charUser);
        } else {
            message.userWin();
        }
    }
}
