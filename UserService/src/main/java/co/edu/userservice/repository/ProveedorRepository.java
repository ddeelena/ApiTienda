package co.edu.userservice.repository;

import co.edu.userservice.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProveedorRepository extends JpaRepository<Proveedor,Integer> {
    Optional<Proveedor> findByUser_Username(String username);

}
