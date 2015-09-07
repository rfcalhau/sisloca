
package locadora.controleAcervo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import locadora.controleAcervo.negocio.Distribuidora;


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
            Logger.getLogger(PersistenciaDistribuidora.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static List<Distribuidora> obter(){
        List<Distribuidora> distribuidoras;
        distribuidoras = new ArrayList<>();
        
        try {
            // faz conexao com o banco
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/locadora",
                    "postgres", "postgres");
            // carrega a classe
            Class.forName("org.postgresql.Driver");
            
            // realiza consulta
            Statement st = c.createStatement();
            String consulta = "SELECT * FROM distribuidoras;";
            ResultSet rs = st.executeQuery(consulta);

            //obtem resultados
            while(rs.next()) {
                String cnpj = rs.getString("cnpj");
                
                String razaoSocial = rs.getString("razaosocial");
                Distribuidora d = new Distribuidora(razaoSocial, cnpj);
                distribuidoras.add(d);
            }
            
            st.close();
            c.close();

        } catch (SQLException | java.lang.ClassNotFoundException ex) {
            Logger.getLogger(PersistenciaDistribuidora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return distribuidoras;
    }
}
