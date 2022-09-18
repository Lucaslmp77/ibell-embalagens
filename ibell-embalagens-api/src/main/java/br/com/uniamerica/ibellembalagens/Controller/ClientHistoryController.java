package br.com.uniamerica.ibellembalagens.Controller;

import br.com.uniamerica.ibellembalagens.Service.ClientHistoryService;
import br.com.uniamerica.ibellembalagens.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClientHistoryController {

    @Autowired
    private ClientHistoryService clientHistoryService;

}
