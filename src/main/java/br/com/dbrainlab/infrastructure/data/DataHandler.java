package br.com.dbrainlab.infrastructure.data;

public interface DataHandler<E> extends DataCreator<E>,
		DataRetriever<E>,
		DataUpdater<E>,
		DataDeletor<E> {
	
}
