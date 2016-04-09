/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package guava.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * <P>
 * Description:TODO
 * </p>
 * @author zhengmiao
 * @version 1.0
 * @Date 2015年7月16日上午11:42:19
 */
public class TestGuavaEventBusSocket {
    public static void main(String[] args) {
        EventBus channel = new EventBus();
        ServerSocket socket;
        try {
            socket = new ServerSocket(4444);
            while (true) {
                Socket connection = socket.accept();
                UserThread newUser = new UserThread(connection, channel);
                channel.register(newUser);
                newUser.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class UserThread extends Thread {
        private Socket connection;
        private EventBus channel;
        private BufferedReader in;
        private PrintWriter out;

        public UserThread(Socket connection, EventBus channel) {
            this.connection = connection;
            this.channel = channel;
            try {
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                out = new PrintWriter(connection.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        @Subscribe
        public void recieveMessage(String message) {
            if (out != null) {
                out.println(message);
                System.out.println("recieveMessage:" + message);
            }
        }

        @Override
        public void run() {
            try {
                String input;
                while ((input = in.readLine()) != null) {
                    channel.post(input);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // reached eof
            channel.unregister(this);
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            in = null;
            out = null;
        }
    }
}
