package br.com.dbrainlab.contact;

import br.com.dbrainlab.infrastructure.persistence.DefaultEnumConverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter(autoApply = true)
public class ContactMessageStatusConverter extends DefaultEnumConverter<ContactMessageStatus> {

    @Override
    protected ContactMessageStatus[] getValues() {
        return ContactMessageStatus.values();
    }

}
