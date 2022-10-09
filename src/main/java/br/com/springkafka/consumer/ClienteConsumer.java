package br.com.springkafka.consumer;

import br.com.springkafka.Cliente;
import br.com.springkafka.dao.ClienteDAO;
import br.com.springkafka.domain.Book;
import br.com.springkafka.repository.ClienteRepository;
import br.com.springkafka.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@AllArgsConstructor
@Component
@Slf4j
public class ClienteConsumer {

    private final ClienteRepository clienteRepository;




    @KafkaListener(topics = "${topic.name}")
    public void consumer (ConsumerRecord<String, Cliente> record, Acknowledgment ack){

        var cliente = record.value();

        log.info("mensagem consumida" + cliente.toString());

        var peopleEntity = br.com.springkafka.domain.Cliente.builder().build();

        peopleEntity.setId(cliente.getId().toString());
        peopleEntity.setCpf(cliente.getCpf().toString());
        peopleEntity.setName(cliente.getName().toString());
        peopleEntity.setEmail(cliente.getEmail().toString());
        peopleEntity.setTelefone(cliente.getTelefone().toString());





        clienteRepository.save(peopleEntity);

        ack.acknowledge();
    }
}
