package br.com.dbrainlab.infrastructure.service;

import java.util.Collection;

public interface DataManipulationService<E> {
	
	E create(E element);
	
	E findById(Long id);
	
	Collection<E> findAll();
	
	E update(E element);
	
	E deleteById(Long id);

}
