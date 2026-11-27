import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GameWindow {

    //all the Swing components
    static JFrame frame;
    static JTextArea hintArea;
    static JTextField guessArea;
    static JLabel label;
    static JButton guessButton;
    static JLabel imageLabel;

    static String[] hints = {
            "Hint 1 (continent): " + Main.data.continents[Main.index],
            "Hint 2 (population): " + Main.data.countryPops[Main.index],
            "Hint 3 (landmark): " + Main.data.landmarks[Main.index]
    };
    static int hintsShown = 1;

    //initializes all the swing components and builds the window
    public static void main(String[] agrs) {
        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Country Guesser");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout(10, 10));

            hintArea = new JTextArea(hints[0]);
            hintArea.setEditable(false);
            hintArea.setFont(new Font("SansSerif", Font.PLAIN, 20));


            guessArea = new JTextField(10);
            label = new JLabel("Guess the Country!", SwingConstants.CENTER);
            label.setFont(new Font("SansSerif", Font.BOLD, 20));
            guessButton = new JButton("Guess");
            imageLabel = new JLabel("", SwingConstants.CENTER);

            JPanel inputPanel = new JPanel();
            inputPanel.add(guessArea);
            inputPanel.add(guessButton);

            JPanel bottom = new JPanel(new GridLayout(2, 1));
            bottom.add(inputPanel);
            bottom.add(label);


            guessButton.addActionListener(e -> {
                checkAnswer();
            });

            JPanel centerPanel = new JPanel(new BorderLayout());
            centerPanel.add(hintArea, BorderLayout.NORTH);
            centerPanel.add(imageLabel, BorderLayout.CENTER);

            frame.add(centerPanel, BorderLayout.CENTER);
            frame.add(bottom, BorderLayout.SOUTH);
            frame.setVisible(true);
        });
    }

    //checks whether the answer submitted is correct and updates the window accordingly
    public static void checkAnswer() {
        String guess = guessArea.getText();
        if (guess.isBlank()) {
            return;
        }
        guessArea.setText("");
        if (Main.check(guess)) {
            label.setText("Correct!");
            label.setForeground(new Color(0, 150, 0));
            guessArea.setEnabled(false);
            guessArea.setEnabled(false);
        } else if (hintsShown >= hints.length) {
            label.setText("Out of guesses. The answer was " + Main.data.countryNames[Main.index]);
            label.setForeground(Color.RED);
            guessArea.setEnabled(false);
            guessButton.setEnabled(false);
        } else {
            hintArea.append("\n" + hints[hintsShown]);
            hintsShown++;
            if (hintsShown == hints.length) {
                ImageIcon icons = loadLandmarkImage();
                if (icons != null) {
                    imageLabel.setIcon(icons);
                }
            }
            label.setText("Incorrect, next hint");
            label.setForeground(Color.RED);
        }
    }

    //loads the landmarks images from the resources/images/ folder in the repo based on todays puzzle.
    static ImageIcon loadLandmarkImage() {
        String name = Main.data.countryNames[Main.index].toLowerCase().replace(" ", "_");
        File file = new File("resources/images/" + name + ".jpg");
            if (!file.exists()) {
            return null;
        }
        ImageIcon icon = new ImageIcon(file.getPath());
        Image scaled = icon.getImage().getScaledInstance(350, -1, Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }
}
