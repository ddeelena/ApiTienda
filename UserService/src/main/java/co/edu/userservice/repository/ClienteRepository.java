package co.edu.userservice.repository;

import co.edu.userservice.model.Cliente;
import co.edu.userservice.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

}
