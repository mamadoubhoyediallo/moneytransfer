package com.groupeisi.moneytransfer.services.impl;

import com.groupeisi.moneytransfer.model.Client;
import com.groupeisi.moneytransfer.repositories.ClientRepository;
import com.groupeisi.moneytransfer.services.IClientService;
import com.groupeisi.moneytransfer.wsdl.ClientRequest;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements IClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientRequest createClient(ClientRequest clientType) {
        Client client = new Client();
        client.setNom(clientType.getNom());
        client.setPrenom(clientType.getPrenom());
        client.setAdresse(clientType.getAddresse());
        clientRepository.save(client);
        clientType.setId(client.getId());
        return clientType;
    }
}
