package br.com.uniamerica.ibellembalagens.Controller;

import br.com.uniamerica.ibellembalagens.Service.HistoricExitStorageService;
import br.com.uniamerica.ibellembalagens.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HistoricExitStorageController {

    @Autowired
    private HistoricExitStorageService historicExitStorageService;

}
