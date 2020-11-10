package edu.ale.rentofbilds.service.client.interfaces;

import edu.ale.rentofbilds.model.Client;

import java.util.List;

public interface ICRUDClientService {
        Client create(Client Client);
        Client get(String id);
        Client update(Client Client);
        Client delete(String id);

        List<Client> getAll();
    }

