import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ShortLister {
    public static void main(String[] args) {
        // Create a file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a text file");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.setFileFilter(filter);

        // Display the file chooser dialog
        int result = fileChooser.showOpenDialog(null);

        // If a file is selected
        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            java.io.File selectedFile = fileChooser.getSelectedFile();

            // Read the contents of the file and display short words
            displayShortWordsFromFile(selectedFile);
        }
    }

    private static void displayShortWordsFromFile(java.io.File file) {
        // Create a ShortWordFilter instance
        ShortWordFilter shortWordFilter = new ShortWordFilter();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words
                String[] words = line.split("\\s+");

                // Collect and display short words
                List<Object> shortWords = Filter.collectAll(words, shortWordFilter);
                for (Object word : shortWords) {
                    System.out.println(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
