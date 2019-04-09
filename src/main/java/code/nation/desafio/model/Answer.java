package code.nation.desafio.model;

//{"numero_casas":1,"token":"22a9e36c01e7e69ffbb74f24dfd6a28550f3c610","cifrado":"jo eftjho, dpnqmfyjuz jt upyjd. nfmwjo dpoxbz","decifrado":"","resumo_criptografico":""}
public class Answer {

    public Answer() {
    }

    public int numeroCasas;
    public String token;
    public String cifrado;
    public String decifrado;
    public String resumoCriptografico;

    public int getNumeroCasas() {
        return numeroCasas;
    }

    public void setNumeroCasas(int numeroCasas) {
        this.numeroCasas = numeroCasas;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCifrado() {
        return cifrado;
    }

    public void setCifrado(String cifrado) {
        this.cifrado = cifrado;
    }

    public String getDecifrado() {
        return decifrado;
    }

    public void setDecifrado(String decifrado) {
        this.decifrado = decifrado;
    }

    public String getResumoCriptografico() {
        return resumoCriptografico;
    }

    public void setResumoCriptografico(String resumoCriptografico) {
        this.resumoCriptografico = resumoCriptografico;
    }
}
