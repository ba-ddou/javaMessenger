package controler;

import service.WebSocket;

public class app {
    public static void main(String[] args) {
        System.out.println("Java Messenger");
        WebSocket socket = new WebSocket();
        socket.init();

    }
}