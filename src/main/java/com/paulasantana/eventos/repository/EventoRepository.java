package com.pedropbazzo.eventos.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pedropbazzo.eventos.entity.EventoEntity;

@Repository
public interface EventoRepository extends CrudRepository<EventoEntity, Long> {

	Optional<EventoEntity> findById(Long id);

}
