package br.com.uniamerica.ibellembalagens.Service;

import br.com.uniamerica.ibellembalagens.Repository.ClientHistoryRepository;
import br.com.uniamerica.ibellembalagens.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

}
