
package locadora.controleAcervo.persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import locadora.controleAcervo.negocio.Filme;
import util.persistencia.Conexao;


public class PersistenciaFilme {

    public static void inserir(Filme f) {
try {
            Connection c = Conexao.conectar();
            
            Statement st = c.createStatement();
            String consulta = 
                    "INSERT INTO filmes (titulooriginal, tituloportugues,"
                    + " paises, ano, diretores, atores, sinopse, duracao, genero, "
                    + "lancamento, distribuidora) VALUES ('" 
                    + f.getTituloOriginal() + "','"
                    + f.getTituloPortugues() + "','"
                    + f.getPaises() + "','"
                    + f.getAno() + "','"
                    + f.getDiretores() + "','"
                    + f.getAtores() + "','"
                    + f.getSinopse() + "','"
                    + f.getDuracao() + "','"
                    + f.getGenero() + "','"
                    + f.isEhLancamento()+ "','"
                    + f.getDistribuidora().getId() + "' );";
            
            st.execute(consulta);
                      
            st.close();
            Conexao.desconectar();

        } catch (SQLException | java.lang.ClassNotFoundException ex) {
            Logger.getLogger(PersistenciaDistribuidora.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
    
}
