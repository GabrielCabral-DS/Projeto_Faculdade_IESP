package br.com.gabrielcabral.servicex.ordemservico.domain;
import br.com.gabrielcabral.servicex.pagamento.domain.Pagamento;
import br.com.gabrielcabral.servicex.servico.domain.Servico;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDEM_SERVICOS")
public class OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrdemServico;
    @Column(name = "DATA_SOLICITACAO")
    @JsonFormat(pattern = "dd/MM/yyy  HH:mm")
    private Date dataSolicitacao;
    @Column(name = "VALOR")
    private Double valorOrdemServico;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ordemServico")
    private Pagamento pagamento;
    @ManyToMany
    @JoinTable(name = "SERVICO_OS_BRIDGE", joinColumns = @JoinColumn(name = "OS_ID"), inverseJoinColumns = @JoinColumn(name = "SERVICO_ID"))
    private Set<Servico> servicos;

}
