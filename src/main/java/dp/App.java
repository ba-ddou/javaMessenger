package dp;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

/**
 * Hello world!
 *
 */
public class App {
    private static Socket socket = null;

    public static void main(String[] args) {
        System.out.println("Java Messenger");
        try {
            socket = IO.socket("http://127.0.0.1:4500");
            socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

                @Override
                public void call(Object... args) {
                    System.out.println("*******socket connected*******");
                }

            }).on("message", new Emitter.Listener() {

                @Override
                public void call(Object... args) {
                    System.out.println("message received");
                    System.out.println("argument length: " + args.length);
                    System.out.println(args[0]);
                }

            }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

                @Override
                public void call(Object... args) {
                }

            });
            socket.connect();
        } catch (URISyntaxException excep) {
            excep.printStackTrace();
        }

    }
}
