package br.com.springkafka.dao.modelo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {

        private Integer id_cliente;
        private String  nomeCliente;
        private String  dtCliente;
        private String tpclinete;
        private String celular;
        private String email;
        private String telefone;
        private String cep;
        private String endereço;
        private String nr_endereco;
        private String complpemento;
        private String idcidade;
        private String uf;
        private String telefone01, telefone02, tp_cliente, ind_cliente_novo, senha;

        // Construtor para cadastrar Cliente
	public Cliente(String telefone01, String telefone02, String tp_cliente, String email, String senha) {
        super();
        this.id_cliente = null;
        this.telefone01 = telefone01;
        this.telefone02 = telefone02;
        this.tp_cliente = tp_cliente;
        this.email = email;
        this.senha = senha;
        this.ind_cliente_novo = "S";
    }

        // Construtor para buscar Cliente
	public Cliente(Integer id_cliente, String telefone01, String telefone02, String tp_cliente, String email,
            String ind_cliente_novo) {
        super();
        this.id_cliente = id_cliente;
        this.telefone01 = telefone01;
        this.telefone02 = telefone02;
        this.tp_cliente = tp_cliente;
        this.email = email;
        this.ind_cliente_novo = ind_cliente_novo;
    }

    public Cliente(int id_cliente, String nm_cliente, String dt_nascimento, String tp_cliente, String celular, String email, String telefone, String cep, String endereço, String nr_endereco, int nr_endereco1, String complemento, int id_cidade, String uf) {
    }

    public Integer getId_cliente () {
        return id_cliente;
    }

        public void setId_cliente (Integer id_cliente){
        this.id_cliente = id_cliente;
    }

        public String getTelefone01 () {
        return telefone01;
    }

        public void setTelefone01 (String telefone01){
        this.telefone01 = telefone01;
    }

        public String getTelefone02 () {
        return telefone02;
    }

        public void setTelefone02 (String telefone02){
        this.telefone02 = telefone02;
    }

        public String getTp_cliente () {
        return tp_cliente;
    }

        public void setTp_cliente (String tp_cliente){
        this.tp_cliente = tp_cliente;
    }

        public String getEmail () {
        return email;
    }

        public void setEmail (String email){
        this.email = email;
    }

        public String getInd_cliente_novo () {
        return ind_cliente_novo;
    }

        public void setInd_cliente_novo (String ind_cliente_novo){
        this.ind_cliente_novo = ind_cliente_novo;
    }

        public String getSenha () {
        return senha;
    }

        public void setSenha (String senha){
        this.senha = senha;
    }

    }
