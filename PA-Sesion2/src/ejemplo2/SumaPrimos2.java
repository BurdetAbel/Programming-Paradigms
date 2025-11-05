
/*
Como Calculador es un Thread, podemos hacer el cálculo dividiendo el intervalo 1-10.000.000 en cinco tramos (1-2.000.000,
2.000.001-4.000.000, 4.000.001-6.000.000, 6.000.001-8.000.000 y 8.000.001-10.000.000). Si disponemos de un ordenador con
varios núcleos, podremos ganar tiempo en el cálculo.
(Tras ejecutar el programa sumaPrimos2, hacer los Ejercicios 1 y 2)

*/
// SumaPrimos2 calcula la suma de los primos entre 1 y 10.000.000
// dividiendo la tarea en cinco hilos
package ejemplo2;
import Ejercicio2.*;
import java.util.*;

public class SumaPrimos2 {
    public static void main(String[] x){
        
        Resultado suma = new Resultado();
        long t0 = (new Date()).getTime(); //t0=instante de inicio de los cálculos
        Calculador p1 = new Calculador(1,2000000,suma);
        Calculador p2 = new Calculador(2000001,4000000,suma);
        Calculador p3 = new Calculador(4000001,6000000,suma);
        Calculador p4 = new Calculador(6000001,8000000,suma);
        Calculador p5 = new Calculador(8000001,10000000,suma);
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        try {
            p1.join();
            p2.join();
            p3.join();
            p4.join();
            p5.join(); //esperamos a que terminen todos
        } catch (InterruptedException e){}
        long t1 = (new Date()).getTime(); //t1=instante de final de los cálculos
        System.out.println("La suma de los números primos hasta 10000000 es: "+suma.getSuma()+" calculado en "+(t1-t0)+" miliseg.");
    }
}

/*
Problema debido a la corrupcion al acceder varios hilos a la misma variable compartida
por tanto el resultado no es el correcto
*/