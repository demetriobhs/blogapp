package br.com.dbrainlab.infrastructure.service.representation;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public abstract class IdentityRepresentation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;

}
