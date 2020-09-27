package dp;

public class Controller {
    private WebSocket webSocketRef = null;

    public Controller() {
        webSocketRef = WebSocket.getInstance(this);
    }

    public void onNewMessage(Message message) {
        System.out
                .println("from: " + message.from + "\nmessage:" + message.message + "\ntimestamp:" + message.timestamp);
    }
}
