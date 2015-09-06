
package projetobiblioteca.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetobiblioteca.visao.JanCadastrarDistribuidora;
import projetobiblioteca.negocio.Distribuidora;


public class PersistenciaDistribuidora {
    
    public static void inserir (Distribuidora d) {
     try {
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/locadora",
                    "postgres", "postgres");
           
            Class.forName("org.postgresql.Driver");
            
            Statement st = c.createStatement();
            String consulta = "INSERT INTO distribuidoras (razaosocial, cnpj) VALUES ('"
                    + d.getRazaoSocial() + "', '" + d.getCnpj() + "');";
            st.execute(consulta);
            
            st.close();
            c.close();

        } catch (SQLException | java.lang.ClassNotFoundException ex) {
            Logger.getLogger(JanCadastrarDistribuidora.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
