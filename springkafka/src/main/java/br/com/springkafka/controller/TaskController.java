package br.com.springkafka.controller;


import br.com.springkafka.dao.ClienteDAO;
import br.com.springkafka.dao.modelo.Cliente;
import br.com.springkafka.dao.modelo.Pessoa_juridica;
import br.com.springkafka.domain.People;
import br.com.springkafka.repository.PeopleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
@Slf4j
@Controller
public class TaskController {


    ClienteDAO clienteDAO = new ClienteDAO();

    @Autowired
    PeopleRepository peopleRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String inicio( ) {
           return "/login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cadastro")
    public String cadastro(People people) {
        peopleRepository.save(people);
        return "/cadastro";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/salvarcadastro")
    public String salvarcadastro(People people) {
        log.info("Cadastro Realizado.");
        peopleRepository.save(people);
        return "/cadastro";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/consultar")
    public String consultar(Cliente cliente, Model model){
        Cliente clientes = clienteDAO.pesquisar(1);
        model.addAttribute("consultar", clientes);
        return "consultar";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cadastropj")
    public String cadastroPJ(Cliente cliente, Model model){
        Cliente clientes = clienteDAO.pesquisar(1);
        model.addAttribute("cadastropj", clientes);
        return "consultar";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cadastropf")
    public String cadastroPF(Cliente cliente, Model model){
        Cliente clientes = clienteDAO.pesquisar(1);
        model.addAttribute("cadastropf", clientes);
        return "consultar";
    }






}
