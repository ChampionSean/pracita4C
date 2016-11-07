/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Marco
 */
public class Writer extends Thread{
    
    Queue que;
    File file;
    
    public Writer(Queue q, File f){
        this.que = q;
        this.file = f;
        
    }
    
    @Override
    public void run(){
                BufferedReader reader = null;
        try {
            String s;
            reader = new BufferedReader(new FileReader(file));
            while ((s = reader.readLine()) != null) {
            }
        } catch (Exception e) {
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
            }
        }
    }
    
}
