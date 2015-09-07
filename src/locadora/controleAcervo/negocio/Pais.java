
package locadora.controleAcervo.negocio;


public class Pais {
    private int id;
    private String nome;

    public Pais(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "(" + nome + ") ";
    }

    
}
