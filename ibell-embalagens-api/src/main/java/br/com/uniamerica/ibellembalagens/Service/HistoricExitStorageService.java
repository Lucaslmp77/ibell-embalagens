package br.com.uniamerica.ibellembalagens.Service;

import br.com.uniamerica.ibellembalagens.Repository.HistoricExitStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricExitStorageService {

    @Autowired
    private HistoricExitStorageRepository historicExitStorageRepository;

}
