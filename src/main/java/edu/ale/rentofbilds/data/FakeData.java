package edu.ale.rentofbilds.data;

import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Item;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Repository
public class FakeData {
    private List<Item> items = Stream.of(
            new Item("1", "Item 1", "description",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Item("2", "Item 2", "description",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Item("3", "Item 3", "description",
                    LocalDateTime.now(), LocalDateTime.now())
    ).collect(Collectors.toList());

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    List<Client> clients = Stream.of(
            new Client("0", "Alexandr Botezat", "0507072384",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Client("1", "George Light", "0505072584",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Client("2", "Viktor Crawez", "066838473",
                    LocalDateTime.now(), LocalDateTime.now())
    ).collect(Collectors.toList());

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
