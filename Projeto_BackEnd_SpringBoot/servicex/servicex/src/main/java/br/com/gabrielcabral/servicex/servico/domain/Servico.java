package br.com.gabrielcabral.servicex.servico.domain;

import br.com.gabrielcabral.servicex.categoria.domain.Categoria;
import br.com.gabrielcabral.servicex.ordemservico.domain.OrdemServico;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="SERVICO")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SERVICO")
    private Integer idServico;
    @Column(name = "NOME_SERVICO")
    private String nomeServico;
    @Column(name = "VALOR_SERVICO")
    private Double valor;
    @ManyToOne
    @JoinColumn(name = "id_Categoria")
    private Categoria categoria;
    @ManyToMany
    private List<OrdemServico> ordemServicos;


}

