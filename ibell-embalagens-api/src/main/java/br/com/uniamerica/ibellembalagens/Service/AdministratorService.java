package br.com.uniamerica.ibellembalagens.Service;

import br.com.uniamerica.ibellembalagens.Repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository userRepository;

}
