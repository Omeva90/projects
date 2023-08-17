import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MindReader {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mind Reader");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Think of a number between 1-10:");
        JTextField textField = new JTextField(5);
        JButton button = new JButton("Read my mind");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField.getPreferredSize().height));
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(textField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        frame.add(panel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                if (text.matches("\\d") && Integer.parseInt(text) >= 1 && Integer.parseInt(text) <= 10) {
                    JFrame loadingFrame = new JFrame("Loading");
                    JPanel loadingPanel = new JPanel();
                    JProgressBar progressBar = new JProgressBar(0, 100);
                    JLabel loadingLabel = new JLabel("Analyzing brainwaves...");

                    loadingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    loadingFrame.setSize(300, 100);
                    loadingFrame.setLocationRelativeTo(null);

                    loadingPanel.setLayout(new BoxLayout(loadingPanel, BoxLayout.Y_AXIS));
                    loadingPanel.add(Box.createRigidArea(new Dimension(0, 20)));
                    progressBar.setAlignmentX(Component.CENTER_ALIGNMENT);
                    progressBar.setPreferredSize(new Dimension(200, 15));
                    loadingPanel.add(progressBar);
                    loadingPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                    loadingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    loadingPanel.add(loadingLabel);
                    loadingPanel.add(Box.createRigidArea(new Dimension(0, 20)));

                    loadingFrame.add(loadingPanel);

                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                for (int i = 0; i <= 100; i++) {
                                    progressBar.setValue(i);
                                    Thread.sleep(70);
                                    if (i == 10) {
                                        loadingLabel.setText("Scanning memories...");
                                    } else if (i == 30) {
                                        loadingLabel.setText("Analyzing thought patterns...");
                                    } else if (i == 60) {
                                        loadingLabel.setText("Reading subconscious mind...");
                                    }
                                }
                                loadingFrame.dispose();
                                JOptionPane.showMessageDialog(frame, "You are thinking of the number " + text + "!");
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                    thread.start();

                    loadingFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a number between 1-10.");
                }
            }
        });

        frame.setVisible(true);
    }
}