public class MessageUtil {

    public static void startGame() {
        System.out.println("Добро пожаловать в игру виселица!");
    }

    public static void printInfoRulesGame() {
        System.out.println("Вводите по одной букве на кириллице в нижнем регистре за раз: ");
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
        System.out.println("Вы ввели букву НЕ на кириллице или НЕ в нижнем регистре или вы ввели НЕ букву вовсе");
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

        StringBuilder sb = new StringBuilder();

        sb.append("--------\n");
        sb.append("|      |\n");
        sb.append("|      ").append(errorCounter >= 1 ? "o\n" : "\n");
        if (errorCounter >= 4) {
            sb.append("|     /|\\\n");
        } else if (errorCounter >= 3) {
            sb.append("|     /|\n");
        } else if (errorCounter >= 2) {
            sb.append("|      |\n");
        } else {
            sb.append("|\n");
        }
        sb.append("|     ").append(errorCounter >= 6 ? "/ \\\n" : (errorCounter >= 5 ? "  \\\n" : "\n"));
        sb.append("|\n");
        System.out.println(sb);
    }
}
