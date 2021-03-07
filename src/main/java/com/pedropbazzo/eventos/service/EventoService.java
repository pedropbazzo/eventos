package com.pedropbazzo.eventos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedropbazzo.eventos.entity.EventoEntity;
import com.pedropbazzo.eventos.exception.EventoNaoEncontradoException;
import com.pedropbazzo.eventos.model.Evento;
import com.pedropbazzo.eventos.repository.EventoRepository;

@Service
public class EventoService {

	@Autowired
	EventoRepository eventoRepository;
	
	public List<Evento> getEventos(){
		
		List<Evento> eventos = getEventosAll(eventoRepository.findAll());
		
		return eventos;
	}
	
	private List<Evento> getEventosAll(Iterable<EventoEntity> iterable){
		List<Evento> eventos = new ArrayList<Evento>();

		iterable.forEach(
				e -> eventos.add(
						new Evento(e.getCodigo(),e.getTitulo(), e.getLocal(), e.getData())
						)
				);
		
		return eventos;
	}
	
	public void novoEvento(Evento evento) {
		eventoRepository.save(new EventoEntity(evento));
	}

	public Evento getEvento(Long codigo) throws Exception {
		Evento evento = null;
		
		try {
			evento = new Evento(eventoRepository.findById(codigo).get());
		}catch (Exception e) {
			throw new EventoNaoEncontradoException("Seu dado não existe");
		}
		
		return evento;
	}

	public void apagaEvento(Long codigo) throws EventoNaoEncontradoException {
		try {
			EventoEntity eventoEntity = eventoRepository.findById(codigo).get();
			eventoRepository.delete(eventoEntity);
		}catch (Exception e) {
			throw new EventoNaoEncontradoException("Seu dado não existe");
		}
	}

	public void editaEvento(Long codigo, Evento evento) throws EventoNaoEncontradoException {
		try {
			EventoEntity eventoEntity = eventoRepository.findById(codigo).get();
			eventoEntity.editaEventoEntity(evento);
			eventoRepository.save(eventoEntity);
		}catch (Exception e) {
			throw new EventoNaoEncontradoException("Seu dado não existe");
		}
	}
	
}
