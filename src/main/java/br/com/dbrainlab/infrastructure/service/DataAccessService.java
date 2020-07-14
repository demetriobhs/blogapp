package br.com.dbrainlab.infrastructure.service;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dbrainlab.infrastructure.persistence.IdentityModel;

public interface DataAccessService<M extends IdentityModel> extends DataManipulationService<M> {
	
	JpaRepository<M, Long> getRepository();
	
	@Override
	public default M create(M model) {
		return getRepository().save(model);
	}

	@Override
	public default M findById(Long id) {
		return getRepository().findById(id).orElse(null);
	}

	@Override
	public default Collection<M> findAll() {
		return getRepository().findAll();
	}

	@Override
	public default M update(M model) {
		return getRepository().save(model);
	}

	@Override
	public default M deleteById(Long id) {
		M model = findById(id);
		getRepository().delete(model);
		
		return model;
	}
	
}
