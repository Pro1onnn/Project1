
public final class GameView {

    public static void startGame() {
        System.out.println("Добро пожаловать в игру виселица!");
    }

    public static void printInfoRulesGame() {
        System.out.println("Вводите по одной букве русского алфавита: ");
    }

    public static void printInfoAboutStartStopGame() {
        System.out.println("Нажмите " + 1 + " чтобы продолжить.");
        System.out.println("Нажмите " + 0 + " чтобы выйти.");
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

    public static void repeatedInputCharUser() {
        System.out.println("Вы уже вводили эту букву");
    }

    public static void correctCharInWord(char result) {
        System.out.println("Буква: " + result + " есть в этом слове.");
    }

    public static void noCharInWord(char result) {
        System.out.println("В этом слове нет буквы " + result);
    }

    public static void userWin() {
        System.out.println("Вы выиграли!");
    }

    public static void userLose(char[] result) {
        System.out.println("Вы проиграли! Слово было: " + new String(result));
    }

    public static void counterErrorInDisplay(int errorCounter) {
        System.out.println("Количество ошибок: " + errorCounter);
    }

    public static void charMaskInDisplay(char[] mask) {
        System.out.println(mask);
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
                        "|\n";

        gallowsPrint[2] =
                "________\n" +
                        "|      |\n" +
                        "|      O\n" +
                        "|      |\n" +
                        "|\n" +
                        "|\n" +
                        "|\n";

        gallowsPrint[3] =
                "________\n" +
                        "|      |\n" +
                        "|      O\n" +
                        "|     /|\n" +
                        "|\n" +
                        "|\n" +
                        "|\n";

        gallowsPrint[4] =
                "________\n" +
                        "|      |\n" +
                        "|      O\n" +
                        "|     /|\\\n" +
                        "|\n" +
                        "|\n" +
                        "|\n";

        gallowsPrint[5] =
                "________\n" +
                        "|      |\n" +
                        "|      O\n" +
                        "|     /|\\\n" +
                        "|     /\n" +
                        "|\n" +
                        "|\n";

        gallowsPrint[6] =
                "________\n" +
                        "|      |\n" +
                        "|      O\n" +
                        "|     /|\\\n" +
                        "|     / \\\n" +
                        "|\n" +
                        "|\n";

        for (int i = 0; i < gallowsPrint.length; i++) {
            if (i == errorCounter) {
                System.out.println(gallowsPrint[i]);
            }
        }
    }
}