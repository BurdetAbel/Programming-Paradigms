package Ejercicio5;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
public class Pintor extends Thread {
    
    JButton b;
    Color paleta[] = new Color[8];
    
    public Pintor(JButton b){
        this.b=b;
        paleta[0]=Color.BLACK;
        paleta[1]=Color.RED;
        paleta[2]=Color.GREEN;
        paleta[3]=Color.BLUE;
        paleta[4]=Color.YELLOW;
        paleta[5]=Color.WHITE;
        paleta[6]=Color.ORANGE;
        paleta[7]=Color.PINK;
        start();
    }
    
    public void run(){
          while (true){
            int i = (int)(8. * Math.random());
            b.setBackground(paleta[i]);
        }
    }
}