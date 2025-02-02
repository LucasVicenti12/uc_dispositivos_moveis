package com.ifsc.lucasvicenti.tabelataco.model.entities;

public class InformacaoNutricional {
    public final Long codigoAlimento;
    public final double colesterol;
    public final double acidoGraxosSaturados;
    public final double acidoGraxosMonosaturados;
    public final double acidoGraxosPolisaturados;
    public final double acidoGraxosLinoleicos;
    public final double acidoGraxosLinoeinos;
    public final double acidoGraxosTransTotais;
    public final double acucaresTotais;
    public final double acucaresAdicionados;

    public InformacaoNutricional(
            Long codigoAlimento,
            double colesterol,
            double acidoGraxosSaturados,
            double acidoGraxosMonosaturados,
            double acidoGraxosPolisaturados,
            double acidoGraxosLinoleicos,
            double acidoGraxosLinoeinos,
            double acidoGraxosTransTotais,
            double acucaresTotais,
            double acucaresAdicionados
    ) {
        this.codigoAlimento = codigoAlimento;
        this.colesterol = colesterol;
        this.acidoGraxosSaturados = acidoGraxosSaturados;
        this.acidoGraxosMonosaturados = acidoGraxosMonosaturados;
        this.acidoGraxosPolisaturados = acidoGraxosPolisaturados;
        this.acidoGraxosLinoleicos = acidoGraxosLinoleicos;
        this.acidoGraxosLinoeinos = acidoGraxosLinoeinos;
        this.acidoGraxosTransTotais = acidoGraxosTransTotais;
        this.acucaresTotais = acucaresTotais;
        this.acucaresAdicionados = acucaresAdicionados;
    }
}
