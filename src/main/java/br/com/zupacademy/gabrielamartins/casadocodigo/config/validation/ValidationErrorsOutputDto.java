package br.com.zupacademy.gabrielamartins.casadocodigo.config.validation;

public class ValidationErrorsOutputDto {

    private String campo;
    private String erro;
    public ValidationErrorsOutputDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
