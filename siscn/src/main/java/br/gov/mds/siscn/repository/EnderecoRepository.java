package br.gov.mds.siscn.repository;

import br.gov.mds.siscn.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "enderecos", collectionResourceRel = "enderecos", itemResourceRel = "endereco")
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    
    /**
     * Finds all active addresses by cadastro nacional ID
     * 
     * @param cadastroNacionalId ID of the cadastro nacional
     * @param enderecoAtivo Active status ("S" for active)
     * @return List of active addresses
     */
    @RestResource(path = "por-cadastro-ativo", rel = "por-cadastro-ativo")
    List<Endereco> findByCadastroNacionalIdAndEnderecoAtivo(Integer cadastroNacionalId, String enderecoAtivo);
    
    /**
     * Finds all addresses by cadastro nacional ID
     * 
     * @param cadastroNacionalId ID of the cadastro nacional
     * @return List of addresses
     */
    @RestResource(path = "por-cadastro", rel = "por-cadastro")
    List<Endereco> findByCadastroNacionalId(Integer cadastroNacionalId);
    
    /**
     * Finds all addresses by CEP
     * 
     * @param cep CEP (postal code)
     * @return List of addresses with the specified CEP
     */
    @RestResource(path = "por-cep", rel = "por-cep")
    List<Endereco> findByCep(String cep);
    
    /**
     * Finds all addresses containing the specified neighborhood name
     * 
     * @param bairro Name of the neighborhood
     * @return List of addresses in the specified neighborhood
     */
    @RestResource(path = "por-bairro", rel = "por-bairro")
    List<Endereco> findByBairroContainingIgnoreCase(String bairro);
}
