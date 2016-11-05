/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.io.File;

/**
 *
 * @author Marco
 */
public class Supervisor extends Thread {
    
    private Thread[] writers;
    private Thread readers;
    
    public Supervisor(Thread[] write, Thread read){
        this.readers = read;
        this.writers = write;
        
    }
    
    public void run(){
        readers.start();
        for(Thread t : writers){
            t.start();
        }
        
        
    }
    
}
