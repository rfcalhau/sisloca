
package locadora.controleAcervo.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import locadora.controleAcervo.negocio.Distribuidora;
import util.excecao.ExcecaoPersistencia;
import util.persistencia.Conexao;


public class PersistenciaDistribuidora {
    
    public static void inserir (Distribuidora d) throws ExcecaoPersistencia {
     try {
            Connection c = Conexao.conectar();
            
            Statement st = c.createStatement();
            String consulta = "INSERT INTO distribuidoras (razaosocial, cnpj) VALUES ('"
                    + d.getRazaoSocial() + "', '" + d.getCnpj() + "');";
            st.execute(consulta);
            
            st.close();
            
            Conexao.desconectar();

        } catch (SQLException | java.lang.ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            ExcecaoPersistencia ep = new ExcecaoPersistencia("erro ao inserir"
                    + "na tabela distribuidoras", ex);
            throw ep;
        }
    
    }
    
    public static List<Distribuidora> obter() throws ExcecaoPersistencia{
        List<Distribuidora> distribuidoras;
        distribuidoras = new ArrayList<>();
        
        try {
            // faz conexao com o banco
            Connection c = Conexao.conectar();
            
            // realiza consulta
            Statement st = c.createStatement();
            String consulta = "SELECT * FROM distribuidoras;";
            ResultSet rs = st.executeQuery(consulta);

            //obtem resultados
            while(rs.next()) {
                String cnpj = rs.getString("cnpj");
                int id = rs.getInt("id");
                String razaoSocial = rs.getString("razaosocial");
                Distribuidora d = new Distribuidora(razaoSocial, cnpj);
                d.setId(id);
                distribuidoras.add(d);
            }
            
            st.close();
            Conexao.desconectar();

        } catch (SQLException | java.lang.ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            ExcecaoPersistencia ep = new ExcecaoPersistencia("erro ao consultar"
                    + "a tabela distribuidoras", ex);
            throw ep;
        }
        return distribuidoras;
    }
}
