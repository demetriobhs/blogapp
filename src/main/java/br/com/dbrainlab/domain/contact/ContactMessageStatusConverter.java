package br.com.dbrainlab.domain.contact;

import br.com.dbrainlab.infrastructure.persistence.repository.helper.DefaultEnumConverter;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class ContactMessageStatusConverter extends DefaultEnumConverter<ContactMessageStatus> {

    @Override
    protected ContactMessageStatus[] getValues() {
        return ContactMessageStatus.values();
    }

}
