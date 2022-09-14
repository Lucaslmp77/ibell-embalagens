package br.com.uniamerica.ibellembalagens.Service;

import br.com.uniamerica.ibellembalagens.Repository.InventoryRepository;
import br.com.uniamerica.ibellembalagens.Repository.StockOutputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockOutputService {

    @Autowired
    private StockOutputRepository stockOutputRepository;

}
