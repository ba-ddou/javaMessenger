package dp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AuthenticationWindow extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTextField usernameInput = new JTextField(25);
    private JTextField passwordInput = new JTextField(25);
    private JButton connectButton = new JButton("login");
    private Controller controllerRef = null;

    public AuthenticationWindow(Controller controller) {
        super("Messsenger authentication");
        controllerRef = controller;
        JPanel authenticationPanel = new JPanel();

        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        authenticationPanel.add(new JLabel("Username: "), cs);

        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        authenticationPanel.add(usernameInput, cs);

        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        authenticationPanel.add(new JLabel("Password: "), cs);

        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        authenticationPanel.add(passwordInput, cs);
        // authenticationPanel.setBorder(new LineBorder(Color.GRAY));

        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onLogin();
            }
        });
        authenticationPanel.add(connectButton);

        add("Center", authenticationPanel);
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public void onLogin() {
        String username = usernameInput.getText();
        String password = passwordInput.getText();
        if (username != "" && password != "") {
            // System.out.println("username:" + username + "\npassword:" + password);
            submitAuthenticationCredentials(username, password);
        } else {

        }
    }

    private void submitAuthenticationCredentials(String username, String password) {
        try {
            String response = post("http://127.0.0.1:4500/authentication",
                    "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}");
            System.out.println("response: " + response);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder().url(url).post(body).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

}
