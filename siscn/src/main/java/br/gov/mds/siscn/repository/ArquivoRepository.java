package br.gov.mds.siscn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import br.gov.mds.siscn.entity.Arquivo;

@RepositoryRestResource(collectionResourceRel = "arquivo", path = "arquivo")
public interface ArquivoRepository extends JpaRepository<Arquivo, Integer> {
}
