package co.edu.userservice.service;

import co.edu.userservice.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClienteService {
    List<Cliente> getAllClientes();
    Optional<Cliente> getClienteById(Integer id);
    Cliente createCliente(Cliente cliente);
    Optional<Cliente> updateCliente(Integer id, Cliente cliente);
    Optional<Cliente> deleteCliente(Integer id);
}
