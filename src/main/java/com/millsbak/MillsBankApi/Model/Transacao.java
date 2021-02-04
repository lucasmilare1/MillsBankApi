package com.millsbak.MillsBankApi.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transacao {


    /**
     * @author lucas
     */


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idTransacao;

    @ManyToOne()
    private Conta conta;

    @Column
    private double valor;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date dataTransacao;

    public Long getIdTransacao() {
        return idTransacao;
    }
    public void setIdTransacao(Long idTransacao) {
        this.idTransacao = idTransacao;
    }
    public Conta getConta() {
        return conta;
    }
    public void setConta(Conta conta) {
        this.conta = conta;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public Date getDataTransacao() {
        return dataTransacao;
    }
    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idTransacao == null) ? 0 : idTransacao.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transacao other = (Transacao) obj;
        if (idTransacao == null) {
            if (other.idTransacao != null)
                return false;
        } else if (!idTransacao.equals(other.idTransacao))
            return false;
        return true;
    }


}

