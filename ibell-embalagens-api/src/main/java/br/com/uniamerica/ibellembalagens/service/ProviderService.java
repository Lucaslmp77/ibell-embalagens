package br.com.uniamerica.ibellembalagens.service;

import br.com.uniamerica.ibellembalagens.entity.Provider;
import br.com.uniamerica.ibellembalagens.repository.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ProviderService {

    private final ProviderRepository providerRepository;

    @Transactional
    public Provider save(Provider provider) {
        return this.providerRepository.save(provider);
    }

    public List<Provider> listAll() {
        return this.providerRepository.findAll();
    }

    public Provider findById(Long id) {
        return this.providerRepository.findById(id).orElse(new Provider());
    }

    @Transactional
    public void update(Long id, Provider provider) {
        if(id == provider.getId()) {
            this.providerRepository.save(provider);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id){
        var provider = this.providerRepository.findById(id);
        if (id == provider.get().getId()) {
            this.providerRepository.disable(id);
        }
        else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void enabled(Long id){
        var provider = this.providerRepository.findById(id);
        if (id == provider.get().getId()) {
            this.providerRepository.enabled(id);
        }
        else {
            throw new RuntimeException();
        }
    }

    public List<Provider> findByActiveProviders() {
        return this.providerRepository.findByActiveProviders();
    }

    public List<Provider> findByInactiveProviders() {
        return this.providerRepository.findByInactiveProviders();
    }

}
