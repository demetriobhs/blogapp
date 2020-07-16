package br.com.dbrainlab.domain.post.service.representation;

import br.com.dbrainlab.infrastructure.service.representation.IdentityRepresentation;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class PostRepresentation extends IdentityRepresentation {

}
