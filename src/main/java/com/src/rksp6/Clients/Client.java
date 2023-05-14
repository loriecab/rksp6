package com.src.rksp6.Clients;

import com.src.rksp6.Servers.ServerRequest;

import java.util.HashMap;

public class Client {
    private HashMap<String, IClient> clients;
    String activeClient;

    public Client(String _activeClient){
        clients = new HashMap<String, IClient>();
        //var tcp = new ClientTCP();
        //tcp.startConnection("127.0.0.1", 4443);
        var udp = new ClientUDP(4444, "UTF-8");

        //clients.put("TCP", tcp);
        clients.put("UDP", udp);

        activeClient = _activeClient;
    }

    public IClient getClient(String clientType){
        return clients.get(clientType);
    }

    public void send(String message, String clientType){
        getClient(activeClient).send(message);
    }

    public String request(ServerRequest request){ return this.getClient(activeClient).request(request); }

    public boolean getConnectionStatus(){ return false; }

    public boolean startConnection(String shit, int shot) { return false; }

    public boolean stopConnection() { return false; }

    public boolean sendShape(String shape) { return false; }
}