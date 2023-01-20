package com.groupeisi.moneytransfer.services;


import com.groupeisi.moneytransfer.wsdl.ClientRequest;

public interface IClientService {
    ClientRequest createClient(ClientRequest clientType);
}
