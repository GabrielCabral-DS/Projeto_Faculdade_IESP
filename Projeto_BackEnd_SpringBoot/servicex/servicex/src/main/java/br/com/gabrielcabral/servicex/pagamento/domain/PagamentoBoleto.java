package br.com.gabrielcabral.servicex.pagamento.domain;

import br.com.gabrielcabral.servicex.ordemservico.domain.OrdemServico;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@JsonTypeName("pagamentoBoleto")
public class PagamentoBoleto extends Pagamento{
    @Column(name = "DATA_VENCIMENTO")
    @JsonFormat(pattern = "dd/MM/yyy")
    private Date dataVencimento;

    @Column(name = "DATA_PAGAMENTO")
    @JsonFormat(pattern = "dd/MM/yyy")
    private Date dataPagamento;

    public PagamentoBoleto(Integer idPagamento, StatusPagamento statusPagamento, OrdemServico ordemServico, Date dataVencimento, Date dataPagamento) {
        super(idPagamento, statusPagamento, ordemServico);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public PagamentoBoleto(Date dataVencimento, Date dataPagamento) {
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }
}
