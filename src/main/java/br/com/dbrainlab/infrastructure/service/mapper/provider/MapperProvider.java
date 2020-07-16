package br.com.dbrainlab.infrastructure.service.mapper.provider;

import br.com.dbrainlab.infrastructure.service.mapper.Mapper;

import java.util.HashMap;
import java.util.Map;

public class MapperProvider {

    private static final Map<Map<Class<?>, Class<?>>, Mapper<?, ?>> MAPPER_MAP = new HashMap<>();

    public static void registerMap(Class<?> sourceClazz, Class<?> destinationClazz, Mapper<?, ?> mapper) {
        Map<Class<?>, Class<?>> clazzKey = createClazzKey(sourceClazz, destinationClazz);

        MAPPER_MAP.put(clazzKey, mapper);
    }

    @SuppressWarnings("unchecked")
    public static <S, D> Mapper<S, D> getMapper(Class<S> sourceClazz, Class<D> destinationClazz) {
        Map<Class<?>, Class<?>> clazzKey = createClazzKey(sourceClazz, destinationClazz);

        return (Mapper<S, D>) MAPPER_MAP.get(clazzKey);
    }

    private static <S, D> Map<Class<?>, Class<?>> createClazzKey(Class<S> sourceClazz, Class<D> destinationClazz) {
        Map<Class<?>, Class<?>> clazzKey = new HashMap<>();
        clazzKey.put(sourceClazz, destinationClazz);

        return clazzKey;
    }

}
