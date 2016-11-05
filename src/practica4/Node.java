package practica4;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Nodo para una estructura de datos concurrente.
 * @param <E> - El tipo de datos a mantener en la estructura de datos.
 * @author <a href="mailto:manuel_castillo_cc@ciencias.unam.mx" >Manuel
 * "nachintoch" Castillo</a>
 * @version 1.0, october 2016
 * @since Computaci&oacute;n concurrente 2017-1
 */
public class Node<E> {
    
    // atributos de clase
    
    AtomicReference<Node<E>> siguiente;
    AtomicInteger etiqueta;
    E cargaUtil;
    
    // TODO IMPLEMENT
    public Node(){
        
    }
    
    public Node(E cargaU) {
		siguiente = new AtomicReference<>();
		cargaUtil = cargaU;
		etiqueta = new AtomicInteger();
    }
    
    // siguiente.compareAndSet(null);
    
}//Node
