/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author stefan
 */
public class ClientThread extends Thread {

    private GameServer server;

    public ClientThread(GameServer server) {
        this.server = server;
    }

    public void run() {

        while (true) {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(this.server.socket.getInputStream()));
                String request = in.readLine();
                                System.out.println("dsadsa");

                System.out.println(request);
                if (request.equals("exit")) {
                    this.server.message_area.setText(this.server.message_area.getText().trim() + "\n Clientul a plecat :" + request);//display the message from client

                    break;

                }
                if (request.equals("stop")) {
                    this.server.isServerRunning = false;
                    this.server.message_area.setText(this.server.message_area.getText().trim() + "\n Server stopped" + request);//display the message from client
                    break;
                }
                this.server.message_area.setText(this.server.message_area.getText().trim() + "\nAm primit raspunsul :" + request);//display the message from client

            } catch (IOException e) {
                System.out.println("Communication error" + e);
            }
        }

        try {
            this.server.socket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

