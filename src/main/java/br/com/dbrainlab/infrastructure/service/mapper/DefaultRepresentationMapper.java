package br.com.dbrainlab.infrastructure.service.mapper;

import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;
import br.com.dbrainlab.infrastructure.service.representation.IdentityRepresentation;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public abstract class DefaultRepresentationMapper<R extends IdentityRepresentation, M extends IdentityModel>
				extends BidirectionalConverter<R, M>
				implements Mapper<R, M> {

	private Class<M> modelClass;
	private Class<R> representationClass;
	
	@SuppressWarnings("unused")
	private DefaultRepresentationMapper() {}
	
	protected DefaultRepresentationMapper(Class<M> modelClass, Class<R> representationClass) {
		DefaultMapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.getConverterFactory().registerConverter(this);
		super.mapperFacade = mapperFactory.getMapperFacade();
		
		this.modelClass = modelClass;
		this.representationClass = representationClass;
	}
	
	protected abstract M doMap(R representation);
	
	protected abstract R doMapBack(M model);
	
	@Override
	public M convertTo(R representation, Type<M> destinationType) {
		return doMap(representation);
	}
	
	@Override
	public R convertFrom(M model, Type<R> destinationType) {
		return doMapBack(model);
	}
	
	@Override
	public M map(R representation) {
		if (representation == null) {
			return null;
		}
		
		return mapperFacade.map(representation, modelClass);
	}
	
	@Override
	public R mapBack(M model) {
		if (model == null) {
			return null;
		}
		
		return mapperFacade.map(model, representationClass);
	}
	
	@Override
	public Collection<M> map(Collection<R> representations) {
		if (representations == null) {
			return Collections.emptyList();
		}
		
		return representations.stream()
					.map(this::map)
					.collect(Collectors.toUnmodifiableList());
	}
	
	@Override
	public Collection<R> mapBack(Collection<M> models) {
		if (models == null) {
			return Collections.emptyList();
		}
		
		return models.stream()
					.map(this::mapBack)
					.collect(Collectors.toUnmodifiableList());
	}
	
}
