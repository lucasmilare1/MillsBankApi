package com.millsbak.MillsBankApi.Service;

import com.millsbak.MillsBankApi.Model.Cliente;
import com.millsbak.MillsBankApi.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository pessoaRepository;

    public Cliente salvar(Cliente cliente) {
        return pessoaRepository.save(cliente);
    }

    public List<Cliente> listar() {
        return pessoaRepository.findAll();
    }

}
