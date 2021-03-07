package com.pedropbazzo.eventos.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.pedropbazzo.eventos.entity.EventoEntity;

public class Evento {

	private Long codigo;
	
	@NotBlank(message = "O título do evento deve ser preenchido")
	private String titulo;
	
	@NotBlank(message = "O Local do evento deve ser preenchido")
	private String local;
	
	private LocalDate data;
	
	public Evento(Long codigo, String titulo, String local, LocalDate data) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.local = local;
		this.data = data;
	}
	
	public Evento(EventoEntity eventoEntity) {
		this.codigo = eventoEntity.getCodigo();
		this.titulo = eventoEntity.getTitulo();
		this.local = eventoEntity.getLocal();
		this.data = eventoEntity.getData();
	}

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
	
}
