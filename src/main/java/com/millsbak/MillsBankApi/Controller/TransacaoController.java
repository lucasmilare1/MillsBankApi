package com.millsbak.MillsBankApi.Controller;

import com.millsbak.MillsBankApi.Model.Transacao;
import com.millsbak.MillsBankApi.Service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("transacao")
@RestController
public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;


    @RequestMapping(method=RequestMethod.POST, path="salvar" )
    public ResponseEntity<?> depositar(@RequestBody Transacao trans){

        Transacao transacao = this.transacaoService.salvar(trans);
        return new ResponseEntity<>(transacao, HttpStatus.OK);
    }


    @RequestMapping(method=RequestMethod.DELETE, path="deletar/{id}" )
    public ResponseEntity<?> saldo( @PathVariable Long id){

        this.transacaoService.delete(id);

        return new ResponseEntity<>( HttpStatus.OK);
    }


    @RequestMapping(method= RequestMethod.GET, path="listar" )
    public ResponseEntity<?> listar(){

        List<Transacao> transacoes = this.transacaoService.listar();
        return new ResponseEntity<>(transacoes, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.GET, path="buscar/{id}"  )
    public ResponseEntity<?> lisbuscarPorId(@PathVariable Long id){
        transacaoService.buscarPeloId(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

}

