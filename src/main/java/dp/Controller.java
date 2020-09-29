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

    public void onSuccessfullAuthentication(String username, String token) {
        renderChatWindow(username, token);
    }

    private void renderChatWindow(String username, String token) {
        authenticationWindow.dispose();
        dataStore = new DataStore(new User(username, token));
        chatWindow = new ChatWindow(this, username);
        dataStore.addObserver(chatWindow);
        webSocketRef = WebSocket.getInstance(this);
    }

    public void onNewMessage(Message message) {
        System.out
                .println("from: " + message.from + "\nmessage:" + message.message + "\ntimestamp:" + message.timestamp);
        dataStore.addMessage(message);
        // sendMessage("Hello motherfucker");
    }

    public void sendMessage(String text) {
        dataStore.addMessage(new Message(dataStore.getUsername(), text));
        webSocketRef.emitEvent("message", new Message(dataStore.getUsername(), text));
    }
}
