// Modificar el Ejemplo 2 en la misma forma que en el ejercicio anterior. Comprobar que, si el ordenador tiene 2 o más procesadores o núcleos,
// ahora la suma de los tiempos parciales es mucho menor mayor que el tiempo total. Cuantos más procesadores tenga el ordenador, mayor
// será la diferencia. Estudiar la relación entre la ganancia de tiempo de ejecución y el número de procesadores o núcleos

package Ejercicio2;
// Tengo 12 nucleos pero la suma de tramos y el total me da siempre lo mismo (puede ser por calcular mal los tramos)
// Calcula cuántos primos hay hasta 10.000.000 y muestra el tiempo que tarda en calcularlo

import java.util.*;
public class CuantosPrimos2 {
    public static void main(String[] x){
           long t0 = (new Date()).getTime(); //t0=instante de inicio de los cálculos
           PrimosThread p1 = new PrimosThread(1,2000000);
           PrimosThread p2 = new PrimosThread(2000001,4000000);
           PrimosThread p3 = new PrimosThread(4000001,6000000);
           PrimosThread p4 = new PrimosThread(6000001,8000000);
           PrimosThread p5 = new PrimosThread(8000001,10000000);
           p1.start();
           p2.start();
           p3.start();
           p4.start();
           p5.start();
           long t1=0,t2=0,t3=0,t4=0,t5=0;
           try{
            p1.join();  t1 = (new Date()).getTime();
            p2.join();  t2 = (new Date()).getTime();
            p3.join();  t3 = (new Date()).getTime();
            p4.join();  t4 = (new Date()).getTime();
            p5.join();  t5 = (new Date()).getTime();
            
           } catch (InterruptedException e){}
           int n = p1.cuantos() + p2.cuantos() + p3.cuantos() + p4.cuantos() + p5.cuantos();
           
           System.out.println(" (CON HILOS) Número de primos menores que 10.000.000: "+ n +" TOTALES "+ (t5-t0) +" miliseg. Por tramos sería:  Primer tramo:"+ (t1-t0) +"  Segundo:"+ (t2-t1) +"  Tercero:"+ (t3-t2) +"  Cuarto:"+ (t4-t3) +"  Quinto:"+ (t5-t4) +" miliseg. La suma total seria:"+ ((t1-t0)+(t2-t1)+(t3-t2)+(t4-t3)+(t5-t4)) +".");
           int cores = Runtime.getRuntime().availableProcessors();
           System.out.println("Procesadores lógicos disponibles: " + cores);
    }
   
}