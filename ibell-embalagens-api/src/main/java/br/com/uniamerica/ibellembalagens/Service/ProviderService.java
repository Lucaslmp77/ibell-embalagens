package br.com.uniamerica.ibellembalagens.Service;

import br.com.uniamerica.ibellembalagens.Repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

}
