import java.util.LinkedHashSet;
import java.util.Set;

public class ContainerWithLetters {

    UserInputHandler userInputHandler;

    public ContainerWithLetters(UserInputHandler userInputHandler) {
        this.userInputHandler = userInputHandler;
    }

    private Set<Character> setAccessibleChars = new LinkedHashSet<>();

    public boolean checkCharAddSet() {
        return setAccessibleChars.add(userInputHandler.getEnteredLetter());
    }

    public void clearSet() {
        setAccessibleChars.clear();
    }

    public Set<Character> getSetAccessibleChars() {
        return setAccessibleChars;
    }
}
