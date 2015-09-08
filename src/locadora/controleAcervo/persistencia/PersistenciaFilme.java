
package locadora.controleAcervo.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import locadora.controleAcervo.negocio.Filme;
import locadora.controleAcervo.negocio.Pais;
import util.excecao.ExcecaoPersistencia;
import util.persistencia.Conexao;


public class PersistenciaFilme {

    public static void inserir(Filme f) throws ExcecaoPersistencia {
        try {
            Connection c = Conexao.conectar();
            
            Statement st = c.createStatement();
            String consulta = 
                    "INSERT INTO filmes (titulooriginal, tituloportugues,"
                    + "  ano, diretores, atores, sinopse, duracao, genero, "
                    + "lancamento, distribuidora) VALUES ('" 
                    + f.getTituloOriginal() + "','"
                    + f.getTituloPortugues() + "','"
                    + f.getAno() + "','"
                    + f.getDiretores() + "','"
                    + f.getAtores() + "','"
                    + f.getSinopse() + "','"
                    + f.getDuracao() + "','"
                    + f.getGenero() + "','"
                    + f.isEhLancamento()+ "','"
                    + f.getDistribuidora().getId() + "' );";
            st.execute(consulta);
            
            // obtem o ID gerado para o filme inserido
            st.execute("select last_insert_rowid();");
            ResultSet rs = st.getResultSet();
            int idFilme = 0;
            if (rs.next())
                idFilme = rs.getInt(1);
            
            
            // insere as relacoes entre pais e filme
            consulta = "INSERT INTO filme_pais (id_pais, id_filme) VALUES";
            List<Pais> paises = f.getPaises();
            for (Pais p : paises) {
                consulta += "('"+ p.getId() + "', '" + idFilme + "'),";
            }
            consulta = consulta.substring (0, consulta.length() - 1);
            consulta += ";";
            st.execute(consulta);
                        
            st.close();
            Conexao.desconectar();

        } catch (SQLException | java.lang.ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            ExcecaoPersistencia ep = new ExcecaoPersistencia("Erro ao inserir"
                    + "na tabela filmes", ex);
            throw ep;
        } 
    }
    
   
    
    
    public static List<Pais> obterPaises() throws  ExcecaoPersistencia{
        List<Pais> paises;
        paises = new ArrayList<>();
        
        try {
            // faz conexao com o banco
            Connection c = Conexao.conectar();
            
            // realiza consulta
            Statement st = c.createStatement();
            String consulta = "SELECT * FROM paises;";
            ResultSet rs = st.executeQuery(consulta);

            //obtem resultados
            while(rs.next()) {
                String nome = rs.getString("nome");
                int id = rs.getInt("id_pais");
                Pais p = new Pais(nome);
                p.setId(id);
                paises.add(p);
            }
            
            st.close();
            Conexao.desconectar();

        } catch (SQLException | java.lang.ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            ExcecaoPersistencia ep = new ExcecaoPersistencia("erro os consultar"
                    + "a tabela paises", ex);
            throw ep;
        }
        return paises;
    }
    
}
