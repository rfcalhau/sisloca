
package locadora.controleAcervo.negocio;

import locadora.controleAcervo.persistencia.PersistenciaFilme;
import java.util.List;
import locadora.controleAcervo.persistencia.PersistenciaDistribuidora;
import util.excecao.ExcecaoNegocio;
import util.excecao.ExcecaoPersistencia;


public class Funcionario {

    static public void inserirDistribuidora(String razao, String cnpj) throws ExcecaoNegocio {
        // cria a classe de dominio: 
        Distribuidora d;
        
       
        try {
            d = new Distribuidora(razao, cnpj);
            d.validarCnpj();
            PersistenciaDistribuidora.inserir(d);
        } catch (ExcecaoPersistencia ex) {
            System.err.println(ex.getMessage());
            ExcecaoNegocio en = new ExcecaoNegocio("Erro ao inserir distribuidora", ex);
            throw en;
        }
    }
    
    static public List<Distribuidora> obterDistribuidoras() throws ExcecaoNegocio {
        List<Distribuidora> distribuidoras = null;
        try {
            distribuidoras= PersistenciaDistribuidora.obter();
        } catch (ExcecaoPersistencia ex) {
            System.err.println(ex.getMessage());
            ExcecaoNegocio en = new ExcecaoNegocio("Erro ao obter distribuidoras", ex);
            throw en;
        }
        return distribuidoras;
    }

    public static void inserirFilme(Distribuidora dis, String tituloOr, 
            String tituloPort, Genero genero, int duracao, String atores, 
            String diretores, boolean ehLancamento, String sinopse,
            int ano, List<Pais> paises) throws ExcecaoNegocio {
        
        Filme f;
        
        
        try {
            f = new Filme(tituloOr, tituloPort, sinopse, genero, paises, 
                atores, diretores, duracao, ano, ehLancamento, dis);
            PersistenciaFilme.inserir(f);
        } catch (ExcecaoPersistencia ex) {
            System.err.println(ex.getMessage());
            ExcecaoNegocio en = new ExcecaoNegocio("Erro ao inserir um Filme", ex);
            throw en;
        }
        
        
    }
    
    
    static public List<Pais> obterPaises() throws ExcecaoNegocio {
        List<Pais> paises = null;
        try {
            paises= PersistenciaFilme.obterPaises();
        } catch (ExcecaoPersistencia ex) {
            System.err.println(ex.getMessage());
            ExcecaoNegocio en = new ExcecaoNegocio("Erro ao obter paises", ex);
            throw en;
        }
        return paises;
    }
    
    
    
}
