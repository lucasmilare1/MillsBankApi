package com.millsbak.MillsBankApi.Controller;

import com.millsbak.MillsBankApi.Exceptions.Exceptions;
import com.millsbak.MillsBankApi.Model.Conta;
import com.millsbak.MillsBankApi.Model.Transacao;
import com.millsbak.MillsBankApi.Service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @Controller
    @RestController
    @RequestMapping("conta")
    public class ContaController {
        @Autowired
        private ContaService contaService;
    //salva uma conta
        @RequestMapping(method= RequestMethod.POST, path="salvar" )
        public ResponseEntity<?> salvar(@RequestBody Conta conta ){


        Conta c = this.contaService.salvar(conta);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    //realiza um deposito em uma determinada conta
        @RequestMapping(method=RequestMethod.PUT, path="depositar/{quantidade}/{id}" )
        public ResponseEntity<?> depositar(@PathVariable double quantidade, @PathVariable Long id){

        this.contaService.deposita(quantidade, id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    //retorna um saldo de uma determinada conta
         @RequestMapping(method=RequestMethod.GET, path="saldo/{id}" )
        public ResponseEntity<?> saldo( @PathVariable Long id){

        Conta c = contaService.buscarSado(id);

        return new ResponseEntity<>(c.getSaldo(), HttpStatus.OK);
    }
    //realiza um saque em uma conta
        @RequestMapping(method=RequestMethod.PUT, path="sacar/{quantidade}/{id}" )
        public ResponseEntity<?> sacar(@PathVariable double quantidade, @PathVariable Long id){
        if (quantidade <= 0) {
            throw new Exceptions("valor incorreto");
        }
        this.contaService.sacar(quantidade, id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    //retorna uma lista de contas
        @RequestMapping(method=RequestMethod.GET, path="listar" )
         public ResponseEntity<?> listar(){

        List<Conta> contas = contaService.listar();

        return new ResponseEntity<>(contas, HttpStatus.OK);
    }
    //busca uma lista de transacoes em uma determinada conta
         @RequestMapping(method=RequestMethod.GET, path="extratoConta/{id}" )
         public ResponseEntity<?> extratoConta(@PathVariable Long id){
        List<Transacao> transacoes = contaService.extratoConta(id);

        return new ResponseEntity<>(transacoes,HttpStatus.OK);
    }
    //verrifica se a conta existe pelo flag
          @RequestMapping(method=RequestMethod.GET, path="buscarConta/{id}" )
          public ResponseEntity<?> verificarContaAtiva(@PathVariable Long id){

             Conta conta = contaService.verificarConta(id) ;
             if (conta.isFlagAtivo() == false) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(conta.getCliente(),HttpStatus.OK);
    }

}
