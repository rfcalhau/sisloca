
package projetobiblioteca.negocio;

import projetobiblioteca.persistencia.PersistenciaDistribuidora;


public class Funcionario {

    static public void inserirDistribuidora(String razao, String cnpj) {
        // cria a classe de dominio: 
        Distribuidora d = new Distribuidora(razao, cnpj);
       
        // manda inserir no BD
        PersistenciaDistribuidora.inserir(d);
    }
    
}
