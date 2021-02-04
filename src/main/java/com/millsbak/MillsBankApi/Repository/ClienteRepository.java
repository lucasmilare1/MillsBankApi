package com.millsbak.MillsBankApi.Repository;

import ch.qos.logback.core.net.server.Client;
import com.millsbak.MillsBankApi.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
    public abstract class ClienteRepository implements JpaRepository<Cliente, Long> {
    abstract Optional<Cliente> findByNome(String nome);
    abstract Cliente findByCpf(String cpf);
}

