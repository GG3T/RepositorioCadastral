package br.com.springkafka.dao.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa_fisica extends Cliente{

    private String cpf, nm_cliente, sexo, estado_civil;
    private String dt_nascimento;

    // Construtor para cadastrar Cliente Pessoa F�sica
    public Pessoa_fisica(String telefone01, String telefone02, String tp_cliente, String email, String senha,
                         String cpf, String nm_cliente, String dt_nascimento, String sexo, String estado_civil) {
        super(telefone01, telefone02, tp_cliente, email, senha);
        this.cpf = cpf;
        this.nm_cliente = nm_cliente;
        this.dt_nascimento = dt_nascimento;
        this.sexo = sexo;
        this.estado_civil = estado_civil;
    }

    // Construtor para buscar Cliente Pessoa F�sica
    public Pessoa_fisica(Integer id_cliente, String telefone01, String telefone02, String tp_cliente, String email,
                         String ind_cliente_novo, String cpf, String nm_cliente, String dt_nascimento, String sexo,
                         String estado_civil) {
        super(id_cliente, telefone01, telefone02, tp_cliente, email, ind_cliente_novo);
        this.cpf = cpf;
        this.nm_cliente = nm_cliente;
        this.dt_nascimento = dt_nascimento;
        this.sexo = sexo;
        this.estado_civil = estado_civil;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNm_cliente() {
        return nm_cliente;
    }

    public void setNm_cliente(String nm_cliente) {
        this.nm_cliente = nm_cliente;
    }

    public String getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }
}
