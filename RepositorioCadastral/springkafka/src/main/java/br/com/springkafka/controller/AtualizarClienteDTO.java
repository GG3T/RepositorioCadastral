package br.com.springkafka.controller;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class AtualizarClienteDTO {

    private String id;
    private String name;
    private String cpf;
    private String email;
    private String telefone;
}
