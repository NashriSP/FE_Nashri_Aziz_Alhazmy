package id.co.lua.polua.services.apps;

import id.co.lua.polua.models.apps.Product;
import id.co.lua.polua.models.repositories.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdukServiceImpl implements ProdukService {
    @Autowired
    ProdukRepository produkRepository;

    @Override
    public void create(Product product) {
        
        // product.setSick(0);

        produkRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return produkRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        Optional<Product> produkOptional = produkRepository.findById(id);
        if (!produkOptional.isPresent()) {
            throw new RuntimeException();
        }
        return produkOptional.get();
    }
}
