package Ejercicio4;

import java.util.*;

public class CuantosPrimos2 {
    public static void main(String[] x){
        long t0 = (new Date()).getTime(); // instante inicio

        PrimosThread r1 = new PrimosThread(1,2000000);
        PrimosThread r2 = new PrimosThread(2000001,4000000);
        PrimosThread r3 = new PrimosThread(4000001,6000000);
        PrimosThread r4 = new PrimosThread(6000001,8000000);
        PrimosThread r5 = new PrimosThread(8000001,10000000);

        Thread t1 = new Thread(r1); // EXPLICACIÓN DE SU UTILIDAD: En java no hay herencia multiple
        Thread t2 = new Thread(r2); // No podemos heredar del hilo y de otra clase a la vez necesitamos Runnable
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);
        Thread t5 = new Thread(r5);

        t1.start(); t2.start(); t3.start(); t4.start(); t5.start();

        try {
            t1.join(); t2.join(); t3.join(); t4.join(); t5.join();
        } catch (InterruptedException e){}

        int n = r1.cuantos() + r2.cuantos() + r3.cuantos() + r4.cuantos() + r5.cuantos();

        long t1_fin = (new Date()).getTime(); // instante final
        System.out.println("CON HILOS Número de primos menores que 10.000.000: "+ n +
                " calculado en "+ (t1_fin-t0) +" miliseg.");
    }
}
