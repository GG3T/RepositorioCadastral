package br.com.springkafka.service;

import br.com.springkafka.Cliente;
import br.com.springkafka.dao.ClienteDAO;
import br.com.springkafka.domain.People;
import br.com.springkafka.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service

public class Service {

    @Autowired
    PeopleRepository peopleRepository;

    Cliente cliente = new Cliente();
    ClienteDAO dao = new ClienteDAO();
    People people = new People();

}
