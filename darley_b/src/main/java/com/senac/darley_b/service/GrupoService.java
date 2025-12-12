package com.senac.darley_b.service;

import com.senac.darley_b.entity.Grupo;
import com.senac.darley_b.entity.GrupoDTORequest;

import com.senac.darley_b.repository.GrupoRepository;
import jakarta.transaction.Transactional;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class GrupoService {
  private final GrupoRepository repository;
  private RabbitTemplate rabbitTemplate;


  public GrupoService(GrupoRepository repository, RabbitTemplate rabbitTemplate) {
    this.repository = repository;
    this.rabbitTemplate = rabbitTemplate;
  }

  @Transactional
  @RabbitListener(queues = "provaPW1Darley")
  public void criar(GrupoDTORequest dtoRequest) {
    Grupo grupo = new Grupo();
    grupo.setNome(dtoRequest.nome());
    grupo.setCor(dtoRequest.cor());
    grupo.setTipo(dtoRequest.tipo());
    grupo.setStatus(1);

    Grupo salvo = repository.save(grupo);

     // conversao manual no proprio método, evitando model mapper  }
  }
}
