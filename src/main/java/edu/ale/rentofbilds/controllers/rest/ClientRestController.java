package edu.ale.rentofbilds.controllers.rest;

import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.client.impls.CRUDClientServiceFakeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {

    @Autowired
    CRUDClientServiceFakeImpl service;

    @RequestMapping("/list")
    List<Client> getClients(){
        return service.getAll();
    }

    @RequestMapping("/delete/{id}")
    Client deleteById(@PathVariable("id") String id) {
        return service.delete(id);

    }
    @PostMapping("/get/{id}")
    Client getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @PostMapping ("/create")
    Client create(@RequestBody Client client) {
        return service.create(client);
    }
    @PutMapping ("/update")
    Client update(@RequestBody Client client) {
        return service.update(client);
    }

}
