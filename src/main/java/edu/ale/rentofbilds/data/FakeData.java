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
            new Item("1", "Coca-Cola", "Drink",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Item("2", "Pepsi", "Drink",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Item("3", "Sprite", "Drink",
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
            new Client("1", "Alexandr NeBotezat", "1507072384",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Client("2", "Alexandr Gotezat", "2507072384",
                    LocalDateTime.now(), LocalDateTime.now())
    ).collect(Collectors.toList());

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
