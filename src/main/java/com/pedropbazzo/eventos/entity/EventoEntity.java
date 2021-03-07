package com.pedropbazzo.eventos.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.pedropbazzo.eventos.model.Evento;


@Entity(name = "evento")
public class EventoEntity {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long codigo;
	
	private String titulo;
	
	private String local;
	
	private LocalDate data;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public EventoEntity(Evento evento) {
		this.titulo = evento.getTitulo();
		this.local = evento.getLocal();
		this.data = evento.getData();
	}
	
	public EventoEntity() {
		
	}
	
	public void editaEventoEntity(Evento evento) {
		this.titulo = evento.getTitulo();
		this.local = evento.getLocal();
		this.data = evento.getData();
	}
	
}
