package br.com.springkafka.controller;


import br.com.springkafka.dao.ClienteDAO;
import br.com.springkafka.dao.EnderecoDAO;
import br.com.springkafka.dao.modelo.Cliente;
import br.com.springkafka.dao.modelo.Pessoa_fisica;
import br.com.springkafka.dao.modelo.Pessoa_juridica;
import br.com.springkafka.dao.modelo.localizacao.Endereco;
import br.com.springkafka.domain.People;
import br.com.springkafka.repository.PeopleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Random;

@Slf4j
@Controller
public class TaskController {

    @Autowired
    PeopleRepository peopleRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String inicio( ) {
           return "/login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cadastro")
    public String cadastro() {
        return "/cadastro";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/salvarcadastro")
    public String salvarcadastro(People people) {
        log.info("Cadastro Realizado.");
        peopleRepository.save(people);
        return "/cadastro";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/meusprodutos")
    public String meusprodutos(Cliente cliente, Model model){
        model.addAttribute("meusprodutos", cliente);
        return "meusprodutos";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/informacoes")
    public String informacoes(){
        return "informacoes";
    }




    @RequestMapping(method = RequestMethod.POST, value = "/cadastropf")
    public String cadastropf( Pessoa_fisica pf, Model model){
        ClienteDAO dao = new ClienteDAO();

        Random random = new Random();
        int idRandom = random.nextInt(1000);
        pf.setId_cliente(idRandom);
        pf.setTp_cliente("PF");
        pf.setInd_cliente_novo("S");
        pf.setDt_nascimento("04-06-1998");
        pf.setSexo("F");
        pf.setEstado_civil("S");
        dao.inserir(pf);
        log.debug(model.addAttribute("cadastropf", pf).toString());


        return "endereco";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cadastropf")
    public String cadastroPF(){
                return "cadastropf";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/parabens")
    public String parabens(){
        return "parabens";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/parabensproduto")
    public String parabensproduto() {
        return "parabensproduto";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cadastropj")
    public String parabens(Pessoa_juridica pj, Model model) {
        ClienteDAO dao = new ClienteDAO();

        pj.setId_cliente(0);
        pj.setTp_cliente("PJ");
        pj.setInd_cliente_novo("S");
        dao.inserir(pj);
        model.addAttribute("cadastropj", pj);

        return "cadastroendereco";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cadastropj")
    public String cadastroPJ(){
        return "cadastropj";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/endereco")
    public String cadastroendereco(Endereco endereco, Model model) {
        EnderecoDAO dao = new EnderecoDAO();

        Random random = new Random();
        int randomID = random.nextInt();

        dao.inserir(endereco);
        model.addAttribute("endereco", endereco);

        return "login";
    }




    @RequestMapping(method = RequestMethod.GET, value = "/endereco")
    public String cadastroendereco() {
        return "endereco";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/contratar")
    public String contratar(Endereco endereco, Model model) {


        model.addAttribute("contratar", endereco);

        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/contratar")
    public String contratar() {
        return "contratar";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/menu")
    public String menu(){
        return "menu";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/confimacao")
    public String confimacao(){
        return "confimacao";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/confimacao")
    public String cadastrarconfimacao(Cliente cliente){
        cliente.getId_cliente();
        return null;
    }





}
