package dp;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Controller {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private WebSocket webSocketRef = null;
    private DataStore dataStore;
    private ChatWindow chatWindow = null;
    private AuthenticationWindow authenticationWindow = null;

    public Controller() {

        renderAuthenticationWindow();
    }

    private void renderAuthenticationWindow() {

        authenticationWindow = new AuthenticationWindow(this);
    }

    private void renderChatWindow() {
        dataStore = new DataStore(new User("Badou", "uyge75wrfeywgvyuer"));
        chatWindow = new ChatWindow();
        dataStore.addObserver(chatWindow);
        webSocketRef = WebSocket.getInstance(this);
    }

    public void onNewMessage(Message message) {
        System.out
                .println("from: " + message.from + "\nmessage:" + message.message + "\ntimestamp:" + message.timestamp);
        dataStore.addMessage(message);
        sendMessage("Hello motherfucker");
    }

    public void sendMessage(String text) {

        webSocketRef.emitEvent("message", new Message(dataStore.getUsername(), text));
    }
}
