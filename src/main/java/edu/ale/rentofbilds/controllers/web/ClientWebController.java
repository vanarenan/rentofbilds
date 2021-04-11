package edu.ale.rentofbilds.controllers.web;

import edu.ale.rentofbilds.forms.ClientForm;
import edu.ale.rentofbilds.forms.ItemForm;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.client.impls.CRUDClientServiceFakeImpl;
import edu.ale.rentofbilds.service.client.impls.CRUDClientServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("web/client")
public class ClientWebController {
    @Autowired
    CRUDClientServiceMongoImpl service;
/*    List<Client> clients = Stream.of(
            new Client("0", "Alexandr Botezat", "0507072384",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Client("1", "Alexandr NeBotezat", "1507072384",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Client("2", "Alexandr Gotezat", "2507072384",
                    LocalDateTime.now(), LocalDateTime.now())
    ).collect(Collectors.toList());*/
    @RequestMapping("/list")
    String getList(Model model){
        model.addAttribute("clients", service.getAll());
        return "clientsTable";
    }
    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id){
        service.delete(id);
        /*Client client = clients.stream().filter(element -> element.getId().equals(id))
                .findFirst().orElse(null);*/
/*        clients.remove(client);*/
        return "redirect:/web/client/list";
    }
    @RequestMapping("/update/{id}")
    String editById(@PathVariable("id") String id){
        return null;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(@ModelAttribute("form") ClientForm clientForm, Model model) {
        Client client = new Client();
        model.addAttribute("form", clientForm);
        return "redirect:/web/client/list";
    }
}
