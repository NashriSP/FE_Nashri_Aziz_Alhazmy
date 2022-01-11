package id.co.lua.polua.services.apps;

import id.co.lua.polua.models.apps.Product;

import java.util.List;

public interface ProdukService {
    void create(Product product);

    List<Product> getAll();

    Product getById(Long id);
}
