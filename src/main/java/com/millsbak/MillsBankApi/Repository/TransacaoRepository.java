package com.millsbak.MillsBankApi.Repository;

import com.millsbak.MillsBankApi.Model.Conta;
import com.millsbak.MillsBankApi.Model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
    @Repository
    @Transactional(readOnly = false)
    public abstract class TransacaoRepository implements JpaRepository<Transacao, Long> {
    public abstract List<Transacao> findByContaIn(Conta conta);

}

