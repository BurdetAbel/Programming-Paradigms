//Modificar el Ejemplo 1 para que, además de calcular el tiempo necesario para calcular cuántos primos hay en total, se imprima el tiempo
// que ha tardado el cálculo de cada uno de los tramos. Verificar que el tiempo total es mayor o igual que la suma de los tiempos de los cinco
// tramos
package Ejercicio1;
import java.util.*;

/**
 *
 * @author crist
 */

public class TiempoTramos {
    public static void main(String[] x){
           long t0 = (new Date()).getTime(); //t0=instante de inicio de los cálculos
           ejemplo1.Primos p1 = new ejemplo1.Primos(1,2000000);
           ejemplo1.Primos p2 = new ejemplo1.Primos(2000001,4000000);
           ejemplo1.Primos p3 = new ejemplo1.Primos(4000001,6000000);
           ejemplo1.Primos p4 = new ejemplo1.Primos(6000001,8000000);
           ejemplo1.Primos p5 = new ejemplo1.Primos(8000001,10000000);
           p1.calcular();
           long t1 = (new Date()).getTime(); 
           p2.calcular();
           long t2 = (new Date()).getTime(); 
           p3.calcular();
           long t3 = (new Date()).getTime(); 
           p4.calcular();
           long t4 = (new Date()).getTime(); 
           p5.calcular();
           long t5 = (new Date()).getTime(); 
           int n = p1.cuantos() + p2.cuantos() + p3.cuantos() + p4.cuantos() + p5.cuantos();
           
           System.out.println(" (sin hilos) Número de primos menores que 10.000.000: "+ n +" TOTALES "+ (t5-t0) +" miliseg. Por tramos sería:  Primer tramo:"+ (t1-t0) +"  Segundo:"+ (t2-t1) +"  Tercero:"+ (t3-t2) +"  Cuarto:"+ (t4-t3) +"  Quinto:"+ (t5-t4) +" miliseg. La suma total seria:"+ ((t1-t0)+(t2-t1)+(t3-t2)+(t4-t3)+(t5-t4)) +".");
    }
}
