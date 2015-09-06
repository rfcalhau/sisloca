
package projetobiblioteca.negocio;


public class Distribuidora {
    
    private String cnpj;
    private String razaoSocial;

    public Distribuidora(String razao, String cnpj) {
        this.cnpj=cnpj;
        this.razaoSocial=razao;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public String getCnpj() {
        return this.cnpj;
    }
    
}
