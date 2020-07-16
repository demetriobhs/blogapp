package br.com.dbrainlab.domain.category;

import org.springframework.stereotype.Repository;

import br.com.dbrainlab.infrastructure.persistence.repository.impl.DefaultRepository;

@Repository
public interface CategoryRepository extends DefaultRepository<Category> {

}
