package co.edu.userservice.service.impl;


import co.edu.userservice.model.Proveedor;
import co.edu.userservice.repository.ClienteRepository;
import co.edu.userservice.repository.ProveedorRepository;
import co.edu.userservice.service.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    @Override
    public Optional<Proveedor> getProveedorById(Integer id) {
        return proveedorRepository.findById(id);
    }

    @Override
    public Proveedor createProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Optional<Proveedor> updateProveedor(Integer id, Proveedor proveedor) {
        return proveedorRepository.findById(id)
                .map(existingProveedor -> {
                    proveedor.setNombre(proveedor.getNombre());
                    proveedor.setEmail(proveedor.getEmail());
                    proveedor.setTelefono(proveedor.getTelefono());
                    proveedor.setDireccion(proveedor.getDireccion());
                    proveedor.setProductos(proveedor.getProductos());
                    return proveedorRepository.save(proveedor);
                });
    }

    @Override
    public Optional<Proveedor> deleteProveedor(Integer id) {
        return proveedorRepository.findById(id)
                .map(proveedor -> {
                    proveedorRepository.delete(proveedor);
                    return proveedor;
                });
    }
}
