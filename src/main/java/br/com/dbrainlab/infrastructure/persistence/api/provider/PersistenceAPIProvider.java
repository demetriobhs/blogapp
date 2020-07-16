package br.com.dbrainlab.infrastructure.persistence.api.provider;

import br.com.dbrainlab.infrastructure.persistence.api.PersistenceAPI;
import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;

import java.util.HashMap;
import java.util.Map;

public class PersistenceAPIProvider {

    private static final Map<Class<?>, PersistenceAPI<?>> PERSISTENCE_API_MAP = new HashMap<>();

    public static void registerPersistenceAPI(Class<?> clazz, PersistenceAPI<?> persistenceAPI) {
        PERSISTENCE_API_MAP.put(clazz, persistenceAPI);
    }

    @SuppressWarnings("unchecked")
    public static <M extends IdentityModel> PersistenceAPI<M> getPersistenceAPI(Class<M> clazz) {
        return (PersistenceAPI<M>) PERSISTENCE_API_MAP.get(clazz);
    }

}
