package dp;

import java.awt.Dimension;

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
        renderNewMessage(message.from, message.message);

    }

    public void sendMessage(String message) {
        controllerRef.sendMessage(message);
        renderNewMessage(username, message);
    }

    private void renderNewMessage(String from, String message) {
        JPanel MessagePanel = new JPanel();
        MessagePanel.add(new JLabel(from + ": " + message));
        MessagePanel.setSize(new Dimension(500, 40));
        chatPanel.add(MessagePanel);
        chatPanel.updateUI();
    }

}
