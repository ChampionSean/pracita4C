/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class Writer<E> extends Thread {

    Queue que;
    File file;

    public Writer(Queue q, File f) {
        this.que = q;
        this.file = f;

    }

    @Override
    public void run() {
        Node<E> nodo = que.cola;
        E str = nodo.cargaUtil;
        BufferedWriter writer = null;
        try {
            FileWriter fw = new FileWriter(file);
            writer = new BufferedWriter(fw);
            writer.write((char[]) str);
        } catch (Exception e) {
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
            }
        }
        if (nodo != null){
        if (nodo.contador.get() >= 1) {
            nodo.contador.set(0);
            que.pop();
        } else {
            try {
                Writer.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
            }
            nodo.contador.getAndIncrement();
        }
        }

    }

}
