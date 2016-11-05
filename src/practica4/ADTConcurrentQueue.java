package practica4;

/**
 * Modela una cola concurrente.
 * @param <E> - El tipo de datos que portar&aacute; la cola.
 * @author <a href="mailto:manuel_castillo_cc@ciencias.unam.mx" >Manuel
 * "nachintoch" Castillo</a>
 * @version 1.0, october 2016
 * @since Computaci&oacute;n concurrente 2017-1
 */
public interface ADTConcurrentQueue<E> {
    
    /**
     * Inserta el elemento dado en la pila.
     * @param payload - El elemento a insertar en la pila. No deber&iacute;a ser
     * nulo.
     * @since ADT Concurrent Queue 1.0, october 2016
     */
    
    
    /**
     * Elimina el elemento con mayor tiempo en la cola de la misma.
     * @return E - La carga &uacute;til con mayor tiempo en la cola.
     * @since ADT Concurrent Queue 1.0, october 2016
     */
    E pop();
    
    /**
     * Indica el valor de la caga &uacute;til con mayor antig&uuml;edad en la cola.
     * @return E - La carga &uacute;til con mayor tiempo en la cola.
     * @since ADT Concurrent Queue 1.0, october 2016
     */
    E top();
    
    /**
     * Indica si la cola es vac&iacute;a.
     * @return boolean - <tt>true</tt> si la cola es vac&iacute;a,
     * <tt>false></tt> en otro caso.
     * @since ADT Concurrent Queue 1.0, october 2016
     */
    boolean isEmpty();

    /**
     * Indica el n&uacute;mero de elementos en la cola.
     * @return int - El tama&ntilde;o de la cola.
     * @since ADT Concurrent Queue 1.0, october 2016
     */
    int getSize();
    
    /**
     * Elimina todos los elementos de la cola.
     * @since ADT Concurrent Queue 1.0, october 2016
     */
    void empty();
    
}//concurrentQueue
