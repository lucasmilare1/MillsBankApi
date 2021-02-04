package com.millsbak.MillsBankApi.Repository;

import com.millsbak.MillsBankApi.Model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;




@Repository
@Transactional(readOnly = false)
public abstract class ContaRepository implements JpaRepository<Conta, Long> {
    @Modifying
    @Query("update Conta c set c.saldo = c.saldo + ?1 where c.idConta = ?2")
    public abstract void setFixedSaldoFor(double quantidade, Long id);


    public abstract Conta findByIdConta(Long id);

    @Modifying
    @Query("update Conta c set c.saldo = c.saldo - ?1 where c.idConta = ?2")
    public abstract void setFixedSaldo(double quant, Long id);

}

