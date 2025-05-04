package co.edu.userservice.service.impl;

import co.edu.userservice.model.Cliente;
import co.edu.userservice.model.Proveedor;
import co.edu.userservice.repository.ClienteRepository;
import co.edu.userservice.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getClienteById(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> updateCliente(Integer id, Cliente cliente) {
        return clienteRepository.findById(id)
                .map(existingCliente -> {
                    cliente.setNombre(cliente.getNombre());
                    cliente.setCorreo(cliente.getCorreo());
                    cliente.setTelefono(cliente.getTelefono());
                    cliente.setDireccion(cliente.getDireccion());
                    return clienteRepository.save(cliente);
                });
    }

    @Override
    public Optional<Cliente> deleteCliente(Integer id) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    clienteRepository.delete(cliente);
                    return cliente;
                });
    }

    @Override
    public Optional<Integer> obtenerClienteIdPorUsername(String username) {
        return clienteRepository.findByUser_Username(username)
                .map(Cliente::getId);
    }
}
