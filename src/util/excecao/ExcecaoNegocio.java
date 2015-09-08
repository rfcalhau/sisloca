
package util.excecao;


public class ExcecaoNegocio extends Exception {

    public ExcecaoNegocio(String msg, ExcecaoPersistencia ex) {
        super(msg, ex);
    }
    
}
