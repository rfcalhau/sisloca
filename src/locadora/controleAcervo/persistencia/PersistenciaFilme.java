
package locadora.controleAcervo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import locadora.controleAcervo.negocio.Filme;


public class PersistenciaFilme {

    public static void inserir(Filme f) {
try {
            Connection c = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/locadora",
                    "postgres", "postgres");
           
            Class.forName("org.postgresql.Driver");
            
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
                    + f.getDistribuidora().getCnpj() + "' );";
            
            st.execute(consulta);
            
            
          
            st.close();
            c.close();

        } catch (SQLException | java.lang.ClassNotFoundException ex) {
            Logger.getLogger(PersistenciaDistribuidora.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e){
            System.err.println("erro ao inserir");
            e.printStackTrace();
            
        }
        }
    
}
