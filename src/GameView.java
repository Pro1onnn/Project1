import java.util.Set;
import java.util.stream.Collectors;

public final class GameView {

    public static void startGame() {
        System.out.println("Добро пожаловать в игру виселица!");
    }

    public static void printInfoRulesGame() {
        System.out.println("Вводите по одной букве русского алфавита: ");
    }

    public static void printInfoAboutStartStopGame() {
        System.out.printf("Нажмите %s чтобы продолжить. \n", 1);
        System.out.printf("Нажмите %s чтобы выйти. \n", 0);
    }

    public static void userInputErrorWhenLaunchingGame() {
        System.out.println("Неверный ввод. Попробуйте снова.");
    }

    public static void stopGame() {
        System.out.println("Досвидания!");
    }

    public static void errorInputCharUser() {
        System.out.println("Вы ввели букву НЕ русского алфавита");
    }

    public static void repeatedInputCharUser(char result) {
        System.out.printf("Вы уже вводили букву %S \n", result);
    }

    public static void correctCharInWord(char result) {
        System.out.printf("Буква: %C есть в этом слове.  \n", result);
    }

    public static void noCharInWord(char result) {
        System.out.printf("Буквы: %C нет в этом слове.  \n", result);
    }

    public static void userWin() {
        System.out.println("Вы выиграли!");
    }

    public static void userLose(char[] result) {
        System.out.printf("Вы проиграли! Слово было: %s. \n", new String(result));
    }

    public static void counterErrorInDisplay(int errorCounter) {
        System.out.printf("Количество ошибок: %d \n", errorCounter);
    }

    public static void charMaskInDisplay(char[] mask) {
        System.out.println(mask);
    }

    public static void charMaskOutDisplay(Set<Character> setAccessibleChars) {
        String result = setAccessibleChars.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.printf("Список уже введенных вами букв: %S\n", result);
    }


    public static void gallowsInDisplay(int errorCounter) {
        String gallowsPrint[] = new String[7];

        gallowsPrint[0] =
                "________\n" +
                        "|      |\n" +
                        "|\n" +
                        "|\n" +
                        "|\n" +
                        "|\n" +
                        "|\n";

        gallowsPrint[1] =
                "________\n" +
                        "|      |\n" +
                        "|      O\n" +
                        "|\n" +
                        "|\n" +
                        "|\n" +
                        "|";

        gallowsPrint[2] =
                "________\n" +
                        "|      |\n" +
                        "|      O\n" +
                        "|      |\n" +
                        "|\n" +
                        "|\n" +
                        "|";

        gallowsPrint[3] =
                "________\n" +
                        "|      |\n" +
                        "|      O\n" +
                        "|     /|\n" +
                        "|\n" +
                        "|\n" +
                        "|";

        gallowsPrint[4] =
                "________\n" +
                        "|      |\n" +
                        "|      O\n" +
                        "|     /|\\\n" +
                        "|\n" +
                        "|\n" +
                        "|";

        gallowsPrint[5] =
                "________\n" +
                        "|      |\n" +
                        "|      O\n" +
                        "|     /|\\\n" +
                        "|     /\n" +
                        "|\n" +
                        "|";

        gallowsPrint[6] =
                "________\n" +
                        "|      |\n" +
                        "|      O\n" +
                        "|     /|\\\n" +
                        "|     / \\\n" +
                        "|\n" +
                        "|";

        for (int i = 0; i < gallowsPrint.length; i++) {
            if (i == errorCounter) {
                System.out.println(gallowsPrint[i]);
            }
        }
    }
}