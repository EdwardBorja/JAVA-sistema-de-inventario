package ventanas;

import java.awt.Color; 
import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class HiloBarra extends Thread{
    
    JProgressBar barra;
    
    private static int retraso =15;
    
    public HiloBarra(JProgressBar barrar){
        this.barra = barrar;
        
    }
    
    @Override
    public void run(){
        
        
        int minimo = barra.getMinimum();
        int maximo = barra.getMaximum();
        
        Runnable ejecutor = new Runnable(){
            @Override
            public void run(){
                int valorActual = barra.getValue();
                barra.setValue(valorActual + 1);
            }
        };
        
        for(int i=minimo; i<maximo; i++){
            try {
                EventQueue.invokeAndWait(ejecutor);
                Thread.sleep(retraso);
            } catch (InterruptedException ex) {} 
              catch (InvocationTargetException ex) {}   
        }
    }
}