package br.com.dbrainlab.infrastructure.service;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import br.com.dbrainlab.infrastructure.persistence.IdentityModel;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;

public abstract class DefaultConverter<M extends IdentityModel, D extends IdentityDTO> extends BidirectionalConverter<M, D> implements Converter<M, D> {

	private DefaultMapperFactory mapperFactory;
	
	private Class<M> modelClass;
	private Class<D> dtoClass;
	
	@SuppressWarnings("unused")
	private DefaultConverter() {}
	
	protected DefaultConverter(Class<M> modelClass, Class<D> dtoClass) {
		this.mapperFactory = new DefaultMapperFactory.Builder().build();
		this.mapperFactory.getConverterFactory().registerConverter(this);
		super.mapperFacade = mapperFactory.getMapperFacade();
		
		this.modelClass = modelClass;
		this.dtoClass = dtoClass;
	}
	
	protected abstract D doConvert(M model);
	
	protected abstract M doConvertBack(D dto);
	
	@Override
	public D convertTo(M model, Type<D> destinationType) {
		return doConvert(model);
	}
	
	@Override
	public M convertFrom(D dto, Type<M> destinationType) {
		return doConvertBack(dto);
	}
	
	@Override
	public D convert(M model) {
		if (model == null) {
			return null;
		}
		
		return mapperFacade.map(model, dtoClass);
	}
	
	@Override
	public M convertBack(D dto) {
		if (dto == null) {
			return null;
		}
		
		return mapperFacade.map(dto, modelClass);
	}
	
	@Override
	public Collection<D> convert(Collection<M> models) {
		if (models == null) {
			return Collections.emptyList();
		}
		
		return models.stream()
					.map(m -> convert(m))
					.collect(Collectors.toUnmodifiableList());
	}
	
	@Override
	public Collection<M> convertBack(Collection<D> dtos) {
		if (dtos == null) {
			return Collections.emptyList();
		}
		
		return dtos.stream()
					.map(d -> convertBack(d))
					.collect(Collectors.toUnmodifiableList());
	}
	
}
