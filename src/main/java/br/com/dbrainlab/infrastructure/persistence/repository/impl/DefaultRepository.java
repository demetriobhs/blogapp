package br.com.dbrainlab.infrastructure.persistence.repository.impl;

import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface DefaultRepository<M extends IdentityModel> extends JpaRepository<M, Long> {

}
