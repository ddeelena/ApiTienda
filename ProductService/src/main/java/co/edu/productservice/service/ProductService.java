package co.edu.productservice.service;

import co.edu.productservice.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Integer id);
    Product createProduct(Product product);
    Optional<Product> updateProduct(Integer id, Product product);
    Optional<Product> deleteProduct(Integer id);
    List<Product> getProductsByCategory(String categoria);
    List<Product> getProductsByProveedor(Integer proveedorId);
    List<Product> searchProducts(String keyword);
}