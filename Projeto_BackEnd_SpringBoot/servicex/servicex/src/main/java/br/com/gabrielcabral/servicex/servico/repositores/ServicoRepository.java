package br.com.gabrielcabral.servicex.servico.repositores;
import br.com.gabrielcabral.servicex.servico.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
