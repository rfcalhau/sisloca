
package locadora.controleAcervo.negocio;

import locadora.controleAcervo.persistencia.PersistenciaFilme;
import java.util.List;
import locadora.controleAcervo.persistencia.PersistenciaDistribuidora;


public class Funcionario {

    static public void inserirDistribuidora(String razao, String cnpj) {
        // cria a classe de dominio: 
        Distribuidora d = new Distribuidora(razao, cnpj);
       
        // manda inserir no BD
        PersistenciaDistribuidora.inserir(d);
    }
    
    static public List<Distribuidora> obterDistribuidoras() {
        // recupera distribuidoras do banco
        return PersistenciaDistribuidora.obter();
    }

    public static void inserirFilme(Distribuidora dis, String tituloOr, 
            String tituloPort, String genero, int duracao, String atores, 
            String diretores, boolean ehLancamento, String sinopse,
            int ano, String paises) {
        
        Filme f = new Filme(tituloOr, tituloPort, sinopse, genero, paises, 
                atores, diretores, duracao, ano, ehLancamento, dis);
        
        PersistenciaFilme.inserir(f);
        
        
    }
    
    
    
}
