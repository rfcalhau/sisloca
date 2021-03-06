
package locadora.controleAcervo.negocio;

import util.excecao.ExcecaoNegocio;


public class Distribuidora {
    
    private int id; // chave primaria do banco
    private String cnpj;
    private String razaoSocial;
    private String endereco;
    private String telefone;
    private String pessoaContato;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setPessoaContato(String pessoaContato) {
        this.pessoaContato = pessoaContato;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getPessoaContato() {
        return pessoaContato;
    }

    public boolean isAtiva() {
        return ativa;
    }
    private boolean ativa;

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

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String toString() {
        return  razaoSocial;
    }

    public Distribuidora(String cnpj, String razaoSocial, String endereco, String telefone, String pessoaContato, boolean ativa) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.telefone = telefone;
        this.pessoaContato = pessoaContato;
        this.ativa = ativa;
    }
    
    
  
     
    public  void validarCnpj( ) throws ExcecaoNegocio { 
        if (this.cnpj.contains("9") )
            throw new ExcecaoNegocio("CNPJ invalido!", null);
    } 
    
    
    
    
}
