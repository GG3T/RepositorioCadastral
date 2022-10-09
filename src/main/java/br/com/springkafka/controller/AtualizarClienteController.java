package br.com.springkafka.controller;

import br.com.springkafka.Cliente;
import br.com.springkafka.dao.ClienteDAO;
import br.com.springkafka.producer.ClienteProducer;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.client.Client;
import java.util.UUID;
import java.util.stream.Collectors;
@Controller
@AllArgsConstructor
@RestController
public class AtualizarClienteController {



    //Aqui é onde eu faço a requisição od Json

    //instancio um PeopleProducer para enviar menssagem para o topico
    //ele recebe produz mensagem para o topico que veio na requisição
    private final ClienteProducer clienteProducer;


    @RequestMapping(method = RequestMethod.GET, value = "/popup")
    public String popup(){

        return "popup";
    }

    //Aqui é o metodo POST, para postar as informações que veio no body da requisição
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/popup")
    public ResponseEntity<Void> sendMessage(@RequestBody AtualizarClienteDTO peopleDTO) {

        var id = UUID.randomUUID().toString();


        //Criar um Avro pessoa, utilizando @Builder. para pegar os dados que veio na requisição a transformar em objeto avro
        var message = Cliente.newBuilder().setId(id)
                .setName(peopleDTO.getName())
                .setCpf(peopleDTO.getCpf())
                //aqui manipula lista.
                .setEmail(peopleDTO.getEmail())
                .setTelefone(peopleDTO.getTelefone())
                .build();


        //chama o metodo enviar mensagem para o topico, enviando o objeto avro.
        clienteProducer.sendMenssage(message);

        //Aqui retorna o status da requisição.
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
