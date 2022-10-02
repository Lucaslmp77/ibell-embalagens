package br.com.uniamerica.ibellembalagens.Controller;

import br.com.uniamerica.ibellembalagens.Service.InventoryService;
import br.com.uniamerica.ibellembalagens.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProviderController {

    @Autowired
    private ProviderService providerService;

}
