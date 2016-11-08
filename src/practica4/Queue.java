package practica4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Nodo para una estructura de datos concurrente.
 *
 * @param <E> - El tipo de datos a mantener en la estructura de datos.
 * @author <a href="mailto:manuel_castillo_cc@ciencias.unam.mx" >Manuel
 * "nachintoch" Castillo</a>
 * @version 1.0, october 2016
 * @since Computaci&oacute;n concurrente 2017-1
 */
public class Queue<E> implements ADTConcurrentQueue {

    // atributos de clase
    Node<E> dummy;

    Node<E> cola;

    private AtomicInteger size;

    // TODO IMPLEMENT
    public Queue() {
        dummy = new Node<>();
        cola = dummy;
        size = new AtomicInteger(0);
    }

    public void push(E payload) {
        int local = cola.etiqueta.get();
        E localValue = cola.cargaUtil;

        if (cola.etiqueta.incrementAndGet() == ++local) {
            Node p = new Node<>(payload);
            if (dummy.siguiente.get() == null) {
                dummy.siguiente.compareAndSet(null, p);
                p.siguiente.set(cola);
                size.getAndAdd(1);
            } else {
                aux(dummy).siguiente.compareAndSet(cola, p);
                p.siguiente.set(cola);
                size.getAndAdd(1);
            }
        } else {
            push(payload);
        }
    }

    private Node<E> aux(Node<E> n) {
        if (n.siguiente.get() != cola) {
            return aux(n.siguiente.get());
        } else {
            return n;
        }
    }

    public E pop() {
        if (size.get() == 0) {
            return null;
        } else if (size.get() == 1) {
            Node<E> primero = dummy.siguiente.get();
            dummy.siguiente.compareAndSet(primero, null);
            dummy = cola;
            size.getAndDecrement();
            return primero.cargaUtil;
        } else {
            Node<E> primero = dummy.siguiente.get();
            dummy.siguiente.compareAndSet(primero, primero.siguiente.get());
            size.getAndDecrement();
            return primero.cargaUtil;
        }
    }

    public E top() {
        return dummy.siguiente.get().cargaUtil;

    }

    public boolean isEmpty() {
        if (size.get() == 0) {
            return true;
        }
        return false;

    }

    public int getSize() {
        return size.get();

    }

    public void empty() {
        dummy = null;
        cola = null;
        size.set(0);

    }

}//Node

