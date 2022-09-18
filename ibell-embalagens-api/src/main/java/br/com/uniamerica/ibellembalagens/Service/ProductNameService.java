package br.com.uniamerica.ibellembalagens.Service;

import br.com.uniamerica.ibellembalagens.Repository.InventoryRepository;
import br.com.uniamerica.ibellembalagens.Repository.ProductNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductNameService {

    @Autowired
    private ProductNameRepository productNameRepository;

}
