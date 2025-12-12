package com.senac.darley_a.controller;



import com.senac.darley_a.entity.GrupoDTORequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rabbit/grupo")
public class GrupoController {
  private RabbitTemplate rabbitTemplate;

  public GrupoController(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @PostMapping("/prova")

  public void prova() {
    GrupoDTORequest grupo = new GrupoDTORequest(
        "Prova", "FFFFFF", 2
    );
    rabbitTemplate.convertAndSend("provaPW1Darley", grupo);

  }

  @PostMapping("/criar")
  public void criar(
      @RequestBody GrupoDTORequest dtoRequest
  ){
    rabbitTemplate.convertAndSend("provaPW1Darley", dtoRequest);
  }
}
