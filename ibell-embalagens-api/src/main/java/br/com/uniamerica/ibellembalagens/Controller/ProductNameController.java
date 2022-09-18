package br.com.uniamerica.ibellembalagens.Controller;

import br.com.uniamerica.ibellembalagens.Service.InventoryService;
import br.com.uniamerica.ibellembalagens.Service.ProductNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductNameController {

    @Autowired
    private ProductNameService productNameService;

}
