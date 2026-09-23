import java.util.Scanner;

public class UserInputHandler {

    private final Scanner scanner = new Scanner(System.in);
    private char enteredLetter;
    private String inputUser;

    public String readInputUser() {
        return inputUser = scanner.nextLine().toLowerCase();
    }

    private void conversionLetterIntoSymbol() {
        enteredLetter = inputUser.charAt(0);
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
