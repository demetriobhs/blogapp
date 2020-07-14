package br.com.dbrainlab.post.reply;

import br.com.dbrainlab.infrastructure.persistence.DefaultEnumConverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ReplyStatusConverter extends DefaultEnumConverter<ReplyStatus> {

    @Override
    protected ReplyStatus[] getValues() {
        return ReplyStatus.values();
    }
}
