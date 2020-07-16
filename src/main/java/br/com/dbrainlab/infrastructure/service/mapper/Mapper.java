package br.com.dbrainlab.infrastructure.service.mapper;

import java.util.Collection;

public interface Mapper<S, D> {
	
	D map(S source);
	
	S mapBack(D destination);

	Collection<D> map(Collection<S> sources);

	Collection<S> mapBack(Collection<D> destinations);
	
}
