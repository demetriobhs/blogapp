package br.com.dbrainlab.domain.post.subdomain.reply;

import br.com.dbrainlab.infrastructure.persistence.repository.helper.DefaultEnumConverter;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class ReplyStatusConverter extends DefaultEnumConverter<ReplyStatus> {

    @Override
    protected ReplyStatus[] getValues() {
        return ReplyStatus.values();
    }
}
