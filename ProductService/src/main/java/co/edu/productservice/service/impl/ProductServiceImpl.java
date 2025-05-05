package co.edu.productservice.service.impl;

import co.edu.productservice.model.Product;
import co.edu.productservice.repository.ProductRepository;
import co.edu.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> updateProduct(Integer id, Product product) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setNombre(product.getNombre());
                    existingProduct.setDescripcion(product.getDescripcion());
                    existingProduct.setPrecio(product.getPrecio());
                    existingProduct.setStock(product.getStock());
                    existingProduct.setCategoria(product.getCategoria());
                    existingProduct.setImagen(product.getImagen());
                    existingProduct.setProveedorId(product.getProveedorId());
                    return productRepository.save(existingProduct);
                });
    }

    @Override
    public Optional<Product> deleteProduct(Integer id) {
        return productRepository.findById(id)
                .map(product -> {
                    productRepository.delete(product);
                    return product;
                });
    }

    @Override
    public List<Product> getProductsByCategory(String categoria) {
        return productRepository.findByCategoria(categoria);
    }

    @Override
    public List<Product> getProductsByProveedor(Integer proveedorId) {
        return productRepository.findByProveedorId(proveedorId);
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        return productRepository.findByNombreContaining(keyword);
    }
}