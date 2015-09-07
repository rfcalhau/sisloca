
package util.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class Conexao {
    //private static String url = "jdbc:postgresql://localhost:5432/locadora";
    //private static String classe = "org.postgresql.Driver";
    
    private static String classe = "org.sqlite.JDBC";
    private static String url = "jdbc:sqlite:db_locadora.db";
    private static Connection CONEXAO;
    
    public static Connection conectar() throws SQLException, 
            ClassNotFoundException{
        
        Connection c;
        c = DriverManager.getConnection(url);
           
        Class.forName(classe);
        CONEXAO = c;
        return c;
    }
    
    public static void desconectar() throws SQLException{
        CONEXAO.close();
    }
}
