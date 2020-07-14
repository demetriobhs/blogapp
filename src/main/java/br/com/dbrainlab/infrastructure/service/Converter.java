package br.com.dbrainlab.infrastructure.service;

import java.util.Collection;

public interface Converter<S, D> {
	
	D convert(S source);
	
	S convertBack(D destination);

	Collection<D> convert(Collection<S> sources);

	Collection<S> convertBack(Collection<D> destinations);
	
}
