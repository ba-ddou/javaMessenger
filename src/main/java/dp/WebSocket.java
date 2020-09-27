package dp;

import java.net.URISyntaxException;

import com.google.gson.Gson;

import org.json.JSONObject;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class WebSocket {
    private static Socket socketConnection = null;
    private static WebSocket instance = null;
    private static Controller ControllerRef = null;

    private WebSocket() {
    }

    public static WebSocket getInstance(Controller controllerRef) {
        if (instance == null) {
            ControllerRef = controllerRef;
            instance = new WebSocket();
            init();
        }
        return instance;
    }

    private static void init() {
        try {
            socketConnection = IO.socket("http://127.0.0.1:4500");
            socketConnection.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

                @Override
                public void call(Object... args) {
                    System.out.println("*******socket connected*******");
                }

            }).on("message", new Emitter.Listener() {

                @Override
                public void call(Object... args) {
                    // System.out.println("message received");
                    // System.out.println(args[0]);

                    Message msg = new Gson().fromJson((String) args[0], Message.class);

                    ControllerRef.onNewMessage(msg);

                }

            }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

                @Override
                public void call(Object... args) {
                    // init();
                }

            });
            socketConnection.connect();
        } catch (URISyntaxException excep) {
            excep.printStackTrace();
        }

    }

    public void emitEvent(String eventName, Message message) {
        // System.out.println(
        // "from: " + message.from + "\nmessage:" + message.message + "\ntimesstaamp:" +
        // message.timestamp);
        socketConnection.emit(eventName, "{\"from\":\"" + message.from + "\",\"message\":\"" + message.message
                + "\",\"timestamp\":\"" + message.timestamp + "\"}");
    }
}
