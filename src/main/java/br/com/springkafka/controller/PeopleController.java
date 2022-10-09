package br.com.springkafka.controller;

import br.com.springkafka.People;
import br.com.springkafka.producer.PeopleProducer;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/peoples")
@AllArgsConstructor
public class PeopleController {


    //Aqui é onde eu faço a requisição od Json

    //instancio um PeopleProducer para enviar menssagem para o topico
    //ele recebe produz mensagem para o topico que veio na requisição
    private final PeopleProducer peopleProducer;



    //Aqui é o metodo POST, para postar as informações que veio no body da requisição
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendMessage(@RequestBody PeopleDTO peopleDTO) {

        var id = UUID.randomUUID().toString();


        //Criar um Avro pessoa, utilizando @Builder. para pegar os dados que veio na requisição a transformar em objeto avro
        var message = People.newBuilder().setId(id)
                .setName(peopleDTO.getName())
                .setCpf(peopleDTO.getCpf())
                //aqui manipula lista.
                .setBooks(peopleDTO.getBooks().stream().map(p -> (CharSequence) p).collect(Collectors.toList()))
                .build();


        //chama o metodo enviar mensagem para o topico, enviando o objeto avro.
        peopleProducer.sendMenssage(message);

        //Aqui retorna o status da requisição.
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}


