package br.com.springkafka.consumer;

import br.com.springkafka.People;
import br.com.springkafka.domain.Book;
import br.com.springkafka.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@Slf4j
@AllArgsConstructor
public class PeopleConsumer {

    private final PeopleRepository peopleRepository;



    @KafkaListener(topics = "${topic.name}")
    public void consumer (ConsumerRecord<String, People> record, Acknowledgment ack){

        var people = record.value();

        log.info("mensagem consumida" + people.toString());

        var peopleEntity = br.com.springkafka.domain.People.builder().build();

        peopleEntity.setId(people.getId().toString());
        peopleEntity.setCpf(people.getCpf().toString());
        peopleEntity.setName(people.getName().toString());
        peopleEntity.setBooks(people.getBooks().stream()
                .map(book -> Book.builder()
                .people(peopleEntity)
                .name(book.toString())
                .build()).collect(Collectors.toList()));



        peopleRepository.save(peopleEntity);

        ack.acknowledge();
    }
}
