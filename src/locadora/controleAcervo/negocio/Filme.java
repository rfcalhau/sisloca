
package locadora.controleAcervo.negocio;

import java.util.List;


public class Filme {
    private int id; // chave primaria
    private String tituloOriginal;
    private String tituloPortugues;
    private String sinopse;
    private Genero genero;
    private List<Pais> paises;
    private String atores;
    private String diretores;
    private int duracao;
    private int ano;
    private boolean ehLancamento;
    private Distribuidora distribuidora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public Filme(String tituloOriginal, String tituloPortugues, String sinopse, 
            Genero genero, List<Pais> paises, String atores, 
            String diretores, int duracao, int ano, boolean ehLancamento, 
            Distribuidora distribuidora) {
        this.tituloOriginal = tituloOriginal;
        this.tituloPortugues = tituloPortugues;
        this.sinopse = sinopse;
        this.genero = genero;
        this.paises = paises;
        this.atores = atores;
        this.diretores = diretores;
        this.duracao = duracao;
        this.ano = ano;
        this.ehLancamento = ehLancamento;
        this.distribuidora = distribuidora;
    }

    Filme(Distribuidora dis, String to, String tp, String ge, int du, String at, String dir, boolean la) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public String getTituloPortugues() {
        return tituloPortugues;
    }

    public boolean isEhLancamento() {
        return ehLancamento;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }

    public void setTituloPortugues(String tituloPortugues) {
        this.tituloPortugues = tituloPortugues;
    }

    public void setEhLancamento(boolean ehLancamento) {
        this.ehLancamento = ehLancamento;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

  

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Genero getGenero() {
        return genero;
    }


    public int getDuracao() {
        return duracao;
    }

    public int getAno() {
        return ano;
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public String getAtores() {
        return atores;
    }

    public String getDiretores() {
        return diretores;
    }

    public Distribuidora getDistribuidora() {
        return distribuidora;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public void setDiretores(String diretores) {
        this.diretores = diretores;
    }

    public void setDistribuidora(Distribuidora distribuidora) {
        this.distribuidora = distribuidora;
    }
       
    
    
}
