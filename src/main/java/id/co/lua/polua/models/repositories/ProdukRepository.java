package id.co.lua.polua.models.repositories;

import id.co.lua.polua.models.apps.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdukRepository extends JpaRepository<Product, Long> {
    
}
