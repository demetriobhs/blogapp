package br.com.dbrainlab.domain.contact;

import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Lob;
import java.io.Serializable;
import java.util.Date;

@Entity
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class ContactMessage extends IdentityModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String contactName;

    private String contactEmail;

    private String subject;

    @Lob
    private String textMessage;

    private Date creationDate;

    private ContactMessageStatus status;

}
