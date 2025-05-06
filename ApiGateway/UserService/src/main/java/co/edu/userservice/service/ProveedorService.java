package co.edu.userservice.service;

import co.edu.userservice.model.Proveedor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProveedorService {
    List<Proveedor> getAllProveedores();
    Optional<Proveedor> getProveedorById(Integer id);
    Proveedor createProveedor(Proveedor Proveedor);
    Optional<Proveedor> updateProveedor(Integer id, Proveedor Proveedor);
    Optional<Proveedor> deleteProveedor(Integer id);
}
