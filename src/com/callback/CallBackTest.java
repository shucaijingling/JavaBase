package com.callback;

public class CallBackTest {
    public static void main(String[] args) {
        Service service = new Service();
        Client client = new Client(service);
        client.sendMsg("Server, Hello!");
    }
}
