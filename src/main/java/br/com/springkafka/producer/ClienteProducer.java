package br.com.springkafka.producer;
import br.com.springkafka.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ClienteProducer {

    //variavel que contem o nome do topico
    private final String topicName;

    //aqui tem o kafkatemplante, reponsavel por transformar o objeto de json para avro.
    private final KafkaTemplate<String, Cliente> kafkaTemplate;

    //Aqui é o produtor Pessoa.
    //passando como parametro o nome do topico que sera postado.
    // o template do kafka. no formarto STRING objeto pessoa.
    public ClienteProducer(@Value("${topic.name}")String topicName, KafkaTemplate<String, Cliente> kafkaTemplate) {
        this.topicName = topicName;
        this.kafkaTemplate = kafkaTemplate;
    }
    //Aqui envia a menssagem para o topico.
    public void sendMenssage(Cliente cliente){
        kafkaTemplate.send(topicName, cliente).addCallback(
                success -> log.info("Mensagem Enviada com sucesso !"),
                failure -> log.error("Falha ao Enviar Mensagem !")
        );
    }
}

