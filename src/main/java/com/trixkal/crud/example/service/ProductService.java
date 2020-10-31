package com.trixkal.crud.example.service;

import com.trixkal.crud.example.entity.Product;
import com.trixkal.crud.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private  ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
        
    }

    public List<Product> saveProducts(List<Product> product) {
        return repository.saveAll(product);

    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduct (int id) {
        repository.deleteById(id);
        return "Product removed " + id;
    }

    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setPrice(product.getPrice());
        }
        return repository.save(existingProduct);
    }

}
