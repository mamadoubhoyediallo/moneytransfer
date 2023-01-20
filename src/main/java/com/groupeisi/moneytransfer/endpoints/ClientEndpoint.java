package com.groupeisi.moneytransfer.endpoints;

import com.groupeisi.moneytransfer.services.IClientService;
import com.groupeisi.moneytransfer.wsdl.ClientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ClientEndpoint {

    private static final String NAMESPACE_URI = "http://ws.groupeisi.com";

    @Autowired
    private IClientService clientService;

    public ClientEndpoint(IClientService clientService) {
        this.clientService = clientService;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ClientType")
    @ResponsePayload
    public ClientRequest createClient(@RequestPayload ClientRequest client) {
        ClientRequest clientTypeResponse = new ClientRequest();
        client.setNom("ok");
        clientService.createClient(client);
        return client;
    }
}
