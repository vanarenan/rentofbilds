package edu.ale.rentofbilds.controllers.web;

import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("web/client")
public class ClientWebController {
    List<Client> clients = Stream.of(
            new Client("0", "Alexandr Botezat", "0507072384",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Client("1", "Alexandr NeBotezat", "1507072384",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Client("2", "Alexandr Gotezat", "2507072384",
                    LocalDateTime.now(), LocalDateTime.now())
    ).collect(Collectors.toList());
    @RequestMapping("/list")
    String getList(Model model){
        model.addAttribute("clients", clients);
        return "clientsTable";
    }
    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id){
        Client client = clients.stream().filter(element -> element.getId().equals(id))
                .findFirst().orElse(null);
        clients.remove(client);
        return "redirect:/web/client/list";
    }
}
