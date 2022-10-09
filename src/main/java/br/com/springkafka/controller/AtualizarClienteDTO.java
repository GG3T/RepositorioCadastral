package br.com.springkafka.controller;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
public class AtualizarClienteDTO {

    private String name;
    private String cpf;
    private String email;
    private String telefone;
}
