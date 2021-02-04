package com.millsbak.MillsBankApi.Controller;

import com.millsbak.MillsBankApi.Model.Cliente;
import com.millsbak.MillsBankApi.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("pessoa")
@Controller
@RestController
public class ClienteController {
    @Autowired
    ClienteService pessoaService;

    @RequestMapping(method= RequestMethod.POST, path="salvar")
    public ResponseEntity<?> salvar(@RequestBody Cliente cliente){
        Cliente p = pessoaService.salvar(cliente);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.GET, path="listar")
    public ResponseEntity<?> listar(){
        List<Cliente> clientes = pessoaService.listar();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
}

