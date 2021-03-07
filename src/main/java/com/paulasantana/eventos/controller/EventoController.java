package com.pedropbazzo.eventos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedropbazzo.eventos.exception.EventoNaoEncontradoException;
import com.pedropbazzo.eventos.model.Evento;
import com.pedropbazzo.eventos.service.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {

	@Autowired
	EventoService eventoService;
	
	@GetMapping
	public List<Evento> getNameEvento() {
		return eventoService.getEventos();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?> getNameEvento(@PathVariable Long codigo) throws Exception {
		return new ResponseEntity<>(eventoService.getEvento(codigo), HttpStatus.OK);
	}
	
	@PostMapping
	public String novoEvento(@Valid @RequestBody Evento evento){
		eventoService.novoEvento(evento);
		return "Evento adicionado com sucesso";
	}
	
	@DeleteMapping("/{codigo}")
	public String apagaEvento(@PathVariable Long codigo) throws EventoNaoEncontradoException{
		eventoService.apagaEvento(codigo);
		return "Evento apagado com sucesso";
	}
	
	@PutMapping("/{codigo}")
	public String editaEvento(@PathVariable Long codigo,@Valid @RequestBody Evento evento) throws EventoNaoEncontradoException{
		eventoService.editaEvento(codigo, evento);
		return "Evento atualizado com sucesso";
	}
}
