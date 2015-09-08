
package util.excecao;

public class ExcecaoPersistencia extends Exception {

    public ExcecaoPersistencia(String msg, Exception ex) {
        super(msg, ex);
    }
    
}
