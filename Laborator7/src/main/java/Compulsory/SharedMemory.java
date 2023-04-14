package Compulsory;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SharedMemory {
    private final List<Token> tokens;
    private int current = 0;

    public SharedMemory(int n) {
        tokens = new ArrayList<>();
        for (int i = 0; i < n * n * n; i++)
            tokens.add(new Token(i));
    }

    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            extracted.add(tokens.get(current + i));
        }
        current += howMany;
        return extracted;
    }

}
