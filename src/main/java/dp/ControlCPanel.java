package dp;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlCPanel extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ChatWindow chatWindowRef = null;
    private JTextArea messageTextArea = new JTextArea(3, 30);
    private JButton sendButton = new JButton("Send");

    public ControlCPanel(ChatWindow chatWindow) {
        chatWindowRef = chatWindow;
        setSize(new Dimension(500, 50));
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = messageTextArea.getText();
                if (!message.isEmpty()) {
                    chatWindowRef.sendMessage(message);
                    messageTextArea.setText("");
                }

            }
        });
        // messageTextArea.setSize(new Dimension(360, 50));
        add(messageTextArea);
        sendButton.setSize(new Dimension(100, 50));
        add(sendButton);
    }

}
