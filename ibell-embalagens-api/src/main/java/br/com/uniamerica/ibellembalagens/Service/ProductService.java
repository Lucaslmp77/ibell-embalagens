package br.com.uniamerica.ibellembalagens.Service;

import br.com.uniamerica.ibellembalagens.Entity.Product;
import br.com.uniamerica.ibellembalagens.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    public List<Product> listAll() {
        return this.productRepository.findAll();
    }

    public Product findById(Long id) {
        return this.productRepository.findById(id).orElse(new Product());
    }

    @Transactional
    public void update(Long id, Product product) {
        if(id == product.getId()) {
            this.productRepository.save(product);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id, Product product){
        if (id == product.getId()) {
            this.productRepository.disable(product.getId());
        }
        else {
            throw new RuntimeException();
        }
    }

}
