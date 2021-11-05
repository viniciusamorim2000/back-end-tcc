package com.auresgate.back.end.models.enumeration;

public enum Status {
    ABERTO("ABERTO"), ANDAMENTO("EM ANDAMENTO"), FECHADO("FECHADO");

    private String status_chamado;

    Status(String status_chamado){
        this.status_chamado = status_chamado;
    }
}
