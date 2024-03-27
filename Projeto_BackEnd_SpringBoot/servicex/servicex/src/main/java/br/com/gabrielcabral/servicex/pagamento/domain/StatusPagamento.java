package br.com.gabrielcabral.servicex.pagamento.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusPagamento {
    PEDENTE(1, "Pendente"),

    QUITADO(1, "Quitado"),

    CANCELADO(3, "Cancelado");

    private int cod;
    private String descricao;

    public static StatusPagamento toEnum(Integer cod){
        for (StatusPagamento pagamento : StatusPagamento.values()){
            if(cod.equals(pagamento.cod)){
                return pagamento;
            }
        }
        throw new IllegalArgumentException("Código inválido" + cod);
    }
}
