package br.com.dbrainlab.infrastructure.persistence.repository.provider;

import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;
import br.com.dbrainlab.infrastructure.persistence.repository.impl.DefaultRepository;

import java.util.HashMap;
import java.util.Map;

public class RepositoryProvider {

    private static final Map<Class<?>, DefaultRepository<?>> REPOSITORY_MAP = new HashMap<>();

    public static void registerRepository(Class<?> clazz, DefaultRepository<?> repository) {
        REPOSITORY_MAP.put(clazz, repository);
    }

    @SuppressWarnings("unchecked")
    public static <M extends IdentityModel> DefaultRepository<M> getRepository(Class<M> clazz) {
        return (DefaultRepository<M>) REPOSITORY_MAP.get(clazz);
    }

}
