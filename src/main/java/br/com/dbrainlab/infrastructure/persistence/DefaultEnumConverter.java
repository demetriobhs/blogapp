package br.com.dbrainlab.infrastructure.persistence;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

public abstract class DefaultEnumConverter<E extends Enum<E>> implements AttributeConverter<Enum<E>, String> {

    @Override
    public String convertToDatabaseColumn(Enum<E> e) {
        if (e == null) {
            return null;
        }

        return e.name();
    }

    @Override
    public Enum<E> convertToEntityAttribute(String name) {
        if (name == null) {
            return null;
        }

        return Arrays.stream(getValues())
                .filter(value -> value.name().equals(name))
                .findFirst()
                .orElseThrow((IllegalArgumentException::new));
    }

    protected abstract E[] getValues();

}
