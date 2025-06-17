package io.github.mateusblm.domain.http;

public enum SituacaoCadastral {
    ATIVA("Ativa"),
    SUSPENSA("Suspensa"),
    BAIXADA("Baixada"),
    NULA("Nula"),
    INAPTA("Inapta");

    private final String descricao;

    SituacaoCadastral(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
