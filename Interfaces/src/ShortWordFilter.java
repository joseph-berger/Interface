import java.util.List;

public class ShortWordFilter implements Filter {
    @Override
    public boolean accept(Object x) {
        if (x instanceof String) {
            String word = (String) x;
            return word.length() < 5;
        }
        return false;
    }

    public static void main(String[] args) {
        // Example usage
        Object[] words = {"apple", "banana", "pear", "kiwi", "orange", "grape"};

        // Create a ShortWordFilter instance
        ShortWordFilter shortWordFilter = new ShortWordFilter();

        // Collect all short words
        List<Object> shortWords = Filter.collectAll(words, shortWordFilter);

        // Print the collected short words
        System.out.println("Short words: " + shortWords);
    }
}
