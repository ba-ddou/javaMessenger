package dp;

public class Controller {
    private WebSocket webSocketRef = null;
    private DataStore dataStore;

    public Controller() {
        webSocketRef = WebSocket.getInstance(this);
        dataStore = new DataStore(new User("Badou", "uyge75wrfeywgvyuer"));
    }

    public void onNewMessage(Message message) {
        System.out.println(
                "from: " + message.from + "\nmessage:" + message.message + "\ntimesstamp:" + message.timestamp);
        sendMessage("Hello motherfucker");
    }

    public void sendMessage(String text) {

        webSocketRef.emitEvent("message", new Message(dataStore.getUsername(), text));
    }
}
