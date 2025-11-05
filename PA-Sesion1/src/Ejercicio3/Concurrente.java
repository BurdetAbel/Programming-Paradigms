// Hacer un programa que realice concurrentemente los siguientes cálculos:
// a) Suma de los múltiplos de 7 entre el 1 y el 10000;  BIEN
// b) Suma de los números terminados en 3 o en 5 entre el 1 y el 10000;  BIEN
// c) Suma de los números primos entre el 1 y el 10000.  BIEN
// Cada cálculo debe imprimir el resultado y el tiempo que ha tardado. El programa principal debe imprimir la suma de los tres resultados a,b
// y c y el tiempo total que ha tardado.
package Ejercicio3;

/**
 *
 * @author crist
 */
import java.util.*;
public class Concurrente {
    public static void main(String[] x){
            long t0 = (new Date()).getTime(); //t0=instante de inicio de los cálculos
            MultiploThread p1 = new MultiploThread(1,10000);
            TerminadosThread p2 = new TerminadosThread(1,10000);
            PrimosThread p3 = new PrimosThread(1,10000);
            p1.start();
            p2.start();
            p3.start();
            long t1=0,t2=0,t3=0;
    try{
            p1.join(); t1 = (new Date()).getTime();
            p2.join(); t2 = (new Date()).getTime();
            p3.join(); t3 = (new Date()).getTime();
           } catch (InterruptedException e){}
    
            int n = p1.resultado();
            System.out.println("a: la suma es "+ n + " multiplos de 7 entre el 1 y el 10000");
            System.out.println("El tiempo que tardo fue de : "+ (t1-t0) +" miliseg");
            
            int r = p2.total();
            System.out.println("b: la suma es "+ r + " terminados en 3 o 5 entre el 1 y el 10000");
            System.out.println("El tiempo que tardo fue de : "+ (t2-t1) +" miliseg");
            
            int m = p3.cuantos();
            System.out.println("c: la suma es "+ m + "  primos entre el 1 y el 10000");
            System.out.println("El tiempo que tardo fue de : "+ (t3-t2) +" miliseg");
            
            System.out.println("El tiempo total es de : "+ (t3-t0) +" miliseg");
            
            System.out.println("La suma total es "+ (n+r+m) + ".");
            
    }
    
}
