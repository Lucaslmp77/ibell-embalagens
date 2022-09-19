package br.com.uniamerica.ibellembalagens.Service;

import br.com.uniamerica.ibellembalagens.Entity.Client;
import br.com.uniamerica.ibellembalagens.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client save(Client client) {
        return this.clientRepository.save(client);
    }

    public Page<Client> listAll(Pageable pageable) {
        return this.clientRepository.findAll(pageable);
    }

    public Optional<Client> findById(Long id) {
        return this.clientRepository.findById(id);
    }

    @Transactional
    public void update(Long id, Client client) {
        if(id == client.getId()) {
            this.clientRepository.save(client);
        } else {
            throw new RuntimeException();
        }
    }
}
