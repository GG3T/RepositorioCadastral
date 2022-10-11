package br.com.springkafka.controller;


import br.com.springkafka.dao.ClienteDAO;
import br.com.springkafka.dao.EnderecoDAO;
import br.com.springkafka.dao.LoginCliente;
import br.com.springkafka.dao.ProdutoDAO;
import br.com.springkafka.dao.modelo.*;
import br.com.springkafka.dao.modelo.localizacao.Cidade;
import br.com.springkafka.dao.modelo.localizacao.Endereco;
import br.com.springkafka.dao.modelo.produtos.*;
import br.com.springkafka.domain.People;
import br.com.springkafka.repository.ClienteRepository;
import br.com.springkafka.repository.PeopleRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.security.auth.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.*;

@Slf4j
@Controller
public class TaskController {

    @Autowired
    PeopleRepository peopleRepository;
    Random random = new Random();
    int id_endereco_aux, id_login_aux;
    String  nm_cliente_aux, cpf_aux, ind_clinte_aux;
    String  tp_cliente_aux = "PF";
    int opcao = 0;
    ProdutoDAO dao = new ProdutoDAO();

    int aux = random.nextInt(1000);

    @RequestMapping(method = RequestMethod.GET, value = "/atualizar")
    public String Atualizar(Cliente people) {





        return "/parabens";
    }



    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String inicio() {
        return "/login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(LoginCliente dados, Model model) {

        ClienteDAO dao = new ClienteDAO();
        LoginCliente cliente = dao.consultar(dados.getCpfcnpj());


        if (cliente != null) {
            id_login_aux = cliente.getId_cliente();
            tp_cliente_aux = cliente.getTp_cliente();
            nm_cliente_aux = cliente.getNm_cliente();
            Cliente cliente1 = dao.buscarDadosPF(cliente.getId_cliente());
            ind_clinte_aux = cliente1.getInd_cliente_novo();
            cpf_aux = cliente.getCpfcnpj();

            if (ind_clinte_aux.equals("N")){
                ind_clinte_aux = "S";
                model.addAttribute("nm_cliente", nm_cliente_aux);
                dao.inserirIndicador(id_login_aux, "S");
                return "/popup";
            }

            model.addAttribute("nm_cliente", nm_cliente_aux);

            return "/menu";

        } else {
            // TODO caso n exista o login pode por uma msg de erro, assim ele só reseta e volta pro login
            return "/login";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/menu")
    public String menu(LoginCliente dados, ModelMap modelMap) {
        // TODO falta fazer essa variavel aparecer lá no menu.html
        return "menu";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/menu")
    public String postmenu(LoginCliente dados, ModelMap modelMap) {
        ClienteDAO dao = new ClienteDAO();

        modelMap.addAttribute("cpfcnpj", dados.getCpfcnpj());

        // Método que puxa o nome do cliente pelo ID aux e salva na variável
        String nome = dao.buscarNome(id_login_aux, tp_cliente_aux);
        // TODO falta fazer essa variavel aparecer lá no menu.html
        return "menu";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cadastro")
    public String cadastropf() {
        return "/cadastropf";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/salvarcadastro")
    public String salvarcadastro(People people) {
        log.info("Cadastro Realizado.");
        peopleRepository.save(people);
        return "/cadastro";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/meusprodutos")
    public String meusprodutos(Model model, Cliente pessoa_fisica) {

        ProdutoDAO dao = new ProdutoDAO();
        ClienteDAO daoCliente = new ClienteDAO();
        Cliente cliente = new Cliente();

        cliente = daoCliente.buscarDadosPF(id_login_aux);
        if (cliente.getInd_cliente_novo().equals("N")){
            return "/pop-up";
        }
        model.addAttribute("cartao", "Não contratado");
        model.addAttribute("emprestimo", "Contratado");
        model.addAttribute("seguro", "Não contratado");
        model.addAttribute("veiculo", "Não contratado");
        model.addAttribute("conta_cliente", "Não contratado");
        model.addAttribute("consginado", "Não contratado");


        // TODO apresentar todos os produtos na tela


        return "/meusprodutos";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/informacoes")
    public String informacoes(Cliente cliente, Pessoa_fisica pessoa_fisica, Model model) {
        ClienteDAO dao = new ClienteDAO();

        if(tp_cliente_aux.equals("PF")){
            // Nesse método ele puxa : nm_cliente, cpf, dt_nascimento, estado_civil, telefone01, email
            Cliente pf = dao.buscarDadosPF(id_login_aux);
            LoginCliente  lc = dao.consultar(cpf_aux);
            model.addAttribute("email", pf.getEmail());
            model.addAttribute("telefone01", pf.getTelefone01());
            model.addAttribute("nm_cliente",  lc.getNm_cliente());
            model.addAttribute("cpf", cpf_aux );
            Endereco endereco = dao.consultarEndereco(pf.getId_endereco());
            model.addAttribute("logradouro", endereco.getLogradouro());
            // TODO eu sugiro criar 2 pags de informacoesPF e PJ pra poder mostrar esses dados diferentes
        }else {
            // Nesse método ele puxa : razao_social, cnpj, dt_abertura_emp, porte, telefone01, email
            Pessoa_juridica pj = dao.buscarDadosPJ(id_login_aux);
            // TODO mostrar esses dadso na página
            // TODO eu sugiro criar 2 pags de informacoesPF e PJ pra poder mostrar esses dados diferentes
        }

        return "/informacoes";
    }





    @RequestMapping(method = RequestMethod.POST, value = "/cadastropf")
    public String cadastropf(Pessoa_fisica pf, Model model) {
        ClienteDAO dao = new ClienteDAO();

        pf.setTp_cliente("PF");
        pf.setInd_cliente_novo("S");
        pf.setId_endereco(id_endereco_aux);
        pf.setInd_cliente_novo("S");
        ind_clinte_aux = pf.getInd_cliente_novo();
        dao.inserir(pf);
        log.debug(model.addAttribute("cadastropf", pf).toString());


        return "parabens";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cadastropf")
    public String cadastroPF() {
        return "cadastropf";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/parabens")
    public String parabens() {
        return "parabens";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/parabens")
    public String parabenslOGIN() {
        return "login";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/parabensproduto")
    public String parabensproduto() {
        if (ind_clinte_aux != null) {
            return "menu";
        }
        return "menu";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/parabensproduto")
    public String parabensprodutoPost() {

        return "parabensproduto";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/cadastropj")
    public String cadastropj(Pessoa_juridica pj, Model model) {
        ClienteDAO dao = new ClienteDAO();

        pj.setTp_cliente("PJ");
        pj.setInd_cliente_novo("S");
        pj.setId_endereco(id_endereco_aux);
        dao.inserir(pj);
        model.addAttribute("cadastropj", pj);

        return "parabens";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cadastropj")
    public String cadastroPJ() {
        return "cadastropj";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/endereco")
    public String endereco(Endereco endereco, Model model) {
        EnderecoDAO dao = new EnderecoDAO();
        int aux = random.nextInt(1000);
        id_endereco_aux = aux;

        endereco.setId_cidade(1);
        endereco.setId_endereco(id_endereco_aux);
        endereco.setUf("SP");

        dao.inserir(endereco);
        log.debug(model.addAttribute("endereco", endereco).toString());

        return "cadastro";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/endereco")
    public String enderecoo() {
        return "endereco";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/contratar")
    public String teste() {
        return "contratar";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/contratar")
    public String contratarProdutos(Model model, Emprestimo emprestimo,
    Veiculo veiculo, Cartao cartao, Consignado consignado, Conta_cliente conta, Seguro seguro ) {

        ClienteDAO daoCliente = new ClienteDAO();
        Cliente cliente = new Cliente();

        cliente = daoCliente.buscarDadosPF(id_login_aux);




        model.addAttribute("emprestimo", emprestimo);
        model.addAttribute("veiculo", veiculo);
        model.addAttribute("cartao", cartao);
        model.addAttribute("conta", conta);
        model.addAttribute("seguro", seguro);
        model.addAttribute("consignado", consignado);

        if (emprestimo.getEmprestimo() != null){
            emprestimo();
        }
        if (veiculo.getVeiculo() != null){
            //veiculo();
        }
        if (cartao.getCartao() != null){
            //cartao();
        }
        if (conta.getConta() != null){
            conta();
        }
        if (seguro.getSeguro() != null){
            //seguro();
        }
        if (consignado.getConsignado() != null){
            consignado();
        }
        return "parabens";
    }

    public void conta(){
        Conta_cliente ct = new Conta_cliente();
        ct.setId_produto(id_login_aux);
        ct.setInd_produto_cont("0");
        ct.setId_cliente(id_login_aux);
        ct.setNr_agencia(random.nextInt( 9999));
        ct.setNr_conta(random.nextInt(9999999));
        ct.setNr_verificador(random.nextInt(99));
        ct.setTp_conta("CC");

        dao.inserir(ct);
    }
    public void emprestimo(){

        Emprestimo em = new Emprestimo();
        em.setId_produto(id_login_aux);
        em.setInd_produto_cont("0");
        em.setId_cliente(id_login_aux);
        em.setCod_emprestimo(opcao);
        em.setTp_emprestimo("A");
        em.setLimite_emprestimo(10000);

        dao.inserir(em);
    }

    public void cartao(){

        Cartao ca = new Cartao();
        ca.setId_produto(id_login_aux);
        ca.setInd_produto_cont("1");
        ca.setId_cliente(id_login_aux);
        ca.setCod_cartao(opcao);
        ca.setTp_cartao("B");
        ca.setLimite_cartao(10000);
        ca.setBandeira_cartao("Mastercard");

        dao.inserir(ca);
    }

    public void veiculo() {
        Veiculo ve = new Veiculo();
        ve.setId_produto(id_login_aux);
        ve.setInd_produto_cont("4");
        ve.setId_cliente(id_login_aux);
        ve.setCod_veiculo(opcao);
        ve.setModelo_veiculo("Fiat Argo");
        ve.setAno_veiculo("2022");

        dao.inserir(ve);
    }
    public void consignado(){

        Consignado co = new Consignado();
        co.setId_produto(id_login_aux);
        co.setInd_produto_cont("2");
        co.setId_cliente(id_login_aux);
        co.setCod_consignado(opcao);

        dao.inserir(co);
    }

    public void seguro(){
        Seguro se = new Seguro();
        se.setId_produto(aux);
        se.setInd_produto_cont("3");
        se.setId_cliente(id_login_aux);
        se.setCod_seguro(opcao);

        dao.inserir(se);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/popup")
    public String popup() {
        return "popup";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/popup")
    public String popup(Cliente cli, Model model, Pessoa_fisica pessoa_fisica, AtualizarCliente cliente) {
        ClienteDAO dao = new ClienteDAO();
        Cliente c = new Cliente();
        Pessoa_fisica pessoaFisica = new Pessoa_fisica();



        model.addAttribute("nm_cliente", pessoaFisica.getNm_cliente());
        model.addAttribute("email", c.getEmail());
        model.addAttribute("telefone01", "4642976");
        model.addAttribute("cep", "08572000");

        c.setId_cliente(id_login_aux);
        c.setEmail("gilbertomoreira.sjr@gmail.com");
        c.setTelefone01("46429737");
        pessoaFisica.setId_cliente(id_login_aux);
        nm_cliente_aux = pessoaFisica.getNm_cliente();
        dao.atualizarpessoa(pessoa_fisica);
        dao.email(c);
        return "menu";
    }

}
