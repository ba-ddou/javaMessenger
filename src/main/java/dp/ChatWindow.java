package dp;

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

    public ChatWindow(Controller controller) {
        super("Messsenger");
        controllerRef = controller;
        chatPanel = new JPanel();
        chatPanel.add(new JLabel("Chat Panel"));
        add("Center", chatPanel);
        setSize(500, 700);
        setVisible(true);
    }

    @Override
    public void onUpdate(Message message) {
        System.out.println("****Chat Window****\nfrom: " + message.from + "\nmessage:" + message.message
                + "\ntimestamp:" + message.timestamp);
        chatPanel.add(new JLabel("from: " + message.from + "\nmessage:" + message.message));
        chatPanel.repaint();

    }

}
