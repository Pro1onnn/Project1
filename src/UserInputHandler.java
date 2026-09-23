import java.util.Scanner;

public class UserInputHandler {

    private Scanner scanner = new Scanner(System.in);
    private char enteredLetter;
    private String inputUser;

    public String readInputUser() {
        inputUser = scanner.nextLine().toLowerCase();
        return inputUser;
    }

    private char conversionLetterIntoSymbol() {
        return enteredLetter = inputUser.charAt(0);
    }

    public boolean isValidLetterInput() {
        while (true) {
            readInputUser();
            if (!inputUser.isEmpty() && inputUser.matches("[а-яё]")) {
                conversionLetterIntoSymbol();
                return true;
            } else {
                GameView.errorInputCharUser();
            }
        }
    }

    public char getEnteredLetter() {
        return enteredLetter;
    }
}
