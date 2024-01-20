import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterApp extends JFrame {
    private JTextArea textArea;
    private JLabel resultLabel;

    public WordCounterApp() {
        
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        textArea = new JTextArea();
        JButton countButton = new JButton("Count Words");
        resultLabel = new JLabel("Word count: 0");

        
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JScrollPane(textArea));
        add(countButton);
        add(resultLabel);

        
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });
    }

    private void countWords() {
        String text = textArea.getText();
        String[] words = text.split("\\s+"); 

        int wordCount = words.length;
        resultLabel.setText("Word count: " + wordCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WordCounterApp wordCounterApp = new WordCounterApp();
                wordCounterApp.setVisible(true);
            }
        });
    }
}
