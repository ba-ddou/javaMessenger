package dp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Observer.Observer;

public class ChatWindow extends JFrame implements Observer {
    // private DataStore dataStoreRef = null;

    // public ChatWindow(DataStore dataStore) {
    // dataStoreRef = dataStore;
    // }

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Controller controllerRef = null;
    private JPanel chatPanel = null;
    private String username = "";

    public ChatWindow(Controller controller, String username) {
        super("Messsenger - " + username);
        this.username = username;
        controllerRef = controller;
        chatPanel = new JPanel();
        // chatPanel.add(new JLabel("Chat Panel"));
        chatPanel.setSize(new Dimension(480, 600));
        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
        add("West", chatPanel);

        ControlCPanel controlCPanel = new ControlCPanel(this);

        add("South", controlCPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        setVisible(true);
    }

    @Override
    public void onUpdate(Message message) {
        System.out.println("****Chat Window****\nfrom: " + message.from + "\nmessage:" + message.message
                + "\ntimestamp:" + message.timestamp);
        renderNewMessage(message);

    }

    public void sendMessage(String message) {
        controllerRef.sendMessage(message);
        // renderNewMessage(username, message);
    }

    private void renderNewMessage(Message message) {
        // JPanel MessagePanel = new JPanel();
        // MessagePanel.add(new JLabel(from + ": " + message));
        // MessagePanel.setBackground(new Color(255, 0, 0));
        // MessagePanel.setSize(new Dimension(400, 40));
        JLabel time = new JLabel(message.timestamp);
        time.setFont(new Font("SansSerif", Font.PLAIN, 11));
        time.setForeground(new Color(100, 100, 100));
        chatPanel.add(time);
        chatPanel.add(new JLabel(message.from + ": " + message.message));
        chatPanel.updateUI();
    }

}
