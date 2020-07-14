package br.com.dbrainlab.infrastructure.service;

import java.util.Collection;
import java.util.stream.Collectors;

import br.com.dbrainlab.infrastructure.persistence.IdentityModel;

public interface DataAccessServiceLayerAccessorService<M extends IdentityModel, D extends IdentityDTO> extends DataManipulationService<D> {
	
	DataAccessService<M> getDataAccessService();
	
	Converter<M, D> getConverter();
	
	@Override
	public default D create(D dto) {
		M model = getConverter().convertBack(dto);
		M savedModel = getDataAccessService().create(model);
		D savedDTO = getConverter().convert(savedModel);
		
		return savedDTO;
	}

	@Override
	public default D findById(Long id) {
		M fetchedModel = getDataAccessService().findById(id);
		D fetchedDTO = getConverter().convert(fetchedModel);
		
		return fetchedDTO;
	}

	@Override
	public default Collection<D> findAll() {
		Collection<M> fetchedModels = getDataAccessService().findAll();
		
		return fetchedModels.stream()
				.map(m -> getConverter().convert(m))
				.collect(Collectors.toUnmodifiableList());
	}

	@Override
	public default D update(D dto) {
		M model = getConverter().convertBack(dto);
		M updatedModel = getDataAccessService().update(model);
		D updatedDTO = getConverter().convert(updatedModel);
		
		return updatedDTO;
	}

	@Override
	public default D deleteById(Long id) {
		M deletedModel = getDataAccessService().deleteById(id);
		D deletedDTO = getConverter().convert(deletedModel);
		
		return deletedDTO;
	}

}
