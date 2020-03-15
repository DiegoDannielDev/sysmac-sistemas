package br.com.sysmac.servico;

import br.com.sysmac.entitys.Cliente;
import br.com.sysmac.repositorys.ClienteRepository;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private Cliente cliente;


    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente findClienteId(Long id) {
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return this.cliente = cliente.get();
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            throw new RuntimeException("Cliente não encontrado");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
