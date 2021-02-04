package com.millsbak.MillsBankApi.Service;

import com.millsbak.MillsBankApi.Model.Cliente;
import com.millsbak.MillsBankApi.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

}
