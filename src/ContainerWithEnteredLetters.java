import java.util.LinkedHashSet;
import java.util.Set;

public class ContainerWithEnteredLetters {

    private final UserInputHandler userInputHandler;
    private final Set<Character> setAccessibleChars = new LinkedHashSet<>();

    public ContainerWithEnteredLetters(UserInputHandler userInputHandler) {
        this.userInputHandler = userInputHandler;
    }

    public boolean checkCharAddSet() {
        return setAccessibleChars.add(userInputHandler.getEnteredLetter());
    }

    public Set<Character> getSetAccessibleChars() {
        return setAccessibleChars;
    }
}
