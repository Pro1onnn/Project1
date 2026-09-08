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
        switch (errorCounter) {
            case 0:
                System.out.println("--------\n|      |\n|       \n|\n|\n|");
                break;
            case 1:
                System.out.println("--------\n|      |\n|      0\n|\n|\n|");
                break;
            case 2:
                System.out.println("--------\n|      |\n|      0\n|      |\n|\n|");
                break;
            case 3:
                System.out.println("--------\n|      |\n|      0\n|     /|\n|\n|");
                break;
            case 4:
                System.out.println("--------\n|      |\n|      0\n|     /|\\\n|\n|");
                break;
            case 5:
                System.out.println("--------\n|      |\n|      0\n|     /|\\\n|     /\n|");
                break;
            case 6:
                System.out.println("--------\n|      |\n|      0\n|     /|\\\n|     / \\\n|");
                break;
        }
    }
}
