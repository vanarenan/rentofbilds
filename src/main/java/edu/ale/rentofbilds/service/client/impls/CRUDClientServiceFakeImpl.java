package edu.ale.rentofbilds.service.client.impls;

import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.client.interfaces.ICRUDClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CRUDClientServiceFakeImpl implements ICRUDClientService {
    @Autowired
    FakeData trash;

    @Override
    public Client create(Client Client) {
        UUID id = UUID.randomUUID();
        Client.setId(id.toString());
        Client.setCreated_at(LocalDateTime.now());
        Client.setModified_at(LocalDateTime.now());
        trash.getClients().add(Client);
        return Client;
    }

    @Override
    public Client get(String id) {
        return null;
    }

    @Override
    public Client update(Client Client) {
        String id = Client.getId();
        Client ClientToUpdate = this.getAll().stream().filter(el -> el.getId().equals(id))
                .findFirst().orElse(null);
        int index = this.getAll().indexOf(ClientToUpdate);
        Client.setModified_at(LocalDateTime.now());
        this.getAll().set(index, Client);
        return Client;
    }

    @Override
    public Client delete(String id) {
        Client client = this.getAll().stream().filter(element -> element.getId().equals(id))
        .findFirst().orElse(null);
        return null;
    }

    @Override
    public List<Client> getAll() {
        return trash.getClients();
    }
}
