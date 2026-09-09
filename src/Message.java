public class Message {

    public void startGame() {
        System.out.println("Вводите по одной букве на кириллице в нижнем регистре за раз: ");
    }

    public void choiceGame() {
        System.out.println("Добро пожаловать в игру виселица!");
        System.out.println("Нажмите " + 1 + " чтобы продолжить.");
        System.out.println("Нажмите " + 0 + " чтобы выйти.");
    }

    public void stopGame() {
        System.out.println("Досвидания!");
    }

    public void errorInputCharUser() {
        System.out.println("Вы ввели букву НЕ на кириллице или НЕ в нижнем регистре или вы ввели НЕ букву вовсе");
    }

    public void repeatedInputCharUser() {
        System.out.println("Вы уже вводили эту букву");
    }

    public void correctCharInWord(char result) {
        System.out.println("Буква: " + result + " есть в этом слове.");
    }

    public void noCharInWord(char result) {
        System.out.println("В этом слове нет буквы " + result);
    }

    public void userWin() {
        System.out.println("Вы выиграли!");
    }

    public void userLose(char[] result) {
        System.out.println("Вы проиграли! Слово было: " + new String(result));
    }

    public void counterErrorInDisplay(int errorCounter) {
        System.out.println("Вы допустили: " + errorCounter + " ошибок");
    }

    public void charMaskInDisplay(char[] mask) {
        System.out.println(mask);
    }

    public void gallowsInDisplay(int errorCounter) {
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
