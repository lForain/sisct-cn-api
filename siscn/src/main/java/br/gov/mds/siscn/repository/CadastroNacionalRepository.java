package br.gov.mds.siscn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.gov.mds.siscn.entity.CadastroNacional;

@RepositoryRestResource(collectionResourceRel = "cadastroNacional", path = "cadastro-nacional")
public interface CadastroNacionalRepository extends JpaRepository<CadastroNacional, Long> {
    Optional<CadastroNacional> findOneByCnpj(String cnpj);
}
