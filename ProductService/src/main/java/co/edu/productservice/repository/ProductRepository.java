package co.edu.productservice.repository;

import co.edu.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategoria(String categoria);
    List<Product> findByProveedorId(Integer proveedorId);
    List<Product> findByNombreContaining(String nombre);
}