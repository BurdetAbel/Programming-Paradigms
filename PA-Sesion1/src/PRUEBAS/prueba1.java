package PRUEBAS;

// Calcula cuántos primos hay hasta 10.000.000 y muestra el tiempo que tarda en calcularlo
import java.util.*;
public class prueba1 {
    public static void main(String[] x){
           long t0 = (new Date()).getTime(); // t0 = instante de inicio de los cálculos

           // Cada tramo será de 625.000 números para llegar hasta 10.000.000
           PrimosThread p1  = new PrimosThread(      1,  625000);
           PrimosThread p2  = new PrimosThread( 625001, 1250000);
           PrimosThread p3  = new PrimosThread(1250001, 1875000);
           PrimosThread p4  = new PrimosThread(1875001, 2500000);
           PrimosThread p5  = new PrimosThread(2500001, 3125000);
           PrimosThread p6  = new PrimosThread(3125001, 3750000);
           PrimosThread p7  = new PrimosThread(3750001, 4375000);
           PrimosThread p8  = new PrimosThread(4375001, 5000000);
           PrimosThread p9  = new PrimosThread(5000001, 5625000);
           PrimosThread p10 = new PrimosThread(5625001, 6250000);
           PrimosThread p11 = new PrimosThread(6250001, 6875000);
           PrimosThread p12 = new PrimosThread(6875001, 7500000);
           PrimosThread p13 = new PrimosThread(7500001, 8125000);
           PrimosThread p14 = new PrimosThread(8125001, 8750000);
           PrimosThread p15 = new PrimosThread(8750001, 9375000);
           PrimosThread p16 = new PrimosThread(9375001,10000000);

           p1.start();  p2.start();  p3.start();  p4.start();
           p5.start();  p6.start();  p7.start();  p8.start();
           p9.start();  p10.start(); p11.start(); p12.start();
           p13.start(); p14.start(); p15.start(); p16.start();

           long t1=0,t2=0,t3=0,t4=0,t5=0,t6=0,t7=0,t8=0,
                t9=0,t10=0,t11=0,t12=0,t13=0,t14=0,t15=0,t16=0;
           try{
             p1.join();  t1  = (new Date()).getTime();
             p2.join();  t2  = (new Date()).getTime();
             p3.join();  t3  = (new Date()).getTime();
             p4.join();  t4  = (new Date()).getTime();
             p5.join();  t5  = (new Date()).getTime();
             p6.join();  t6  = (new Date()).getTime();
             p7.join();  t7  = (new Date()).getTime();
             p8.join();  t8  = (new Date()).getTime();
             p9.join();  t9  = (new Date()).getTime();
             p10.join(); t10 = (new Date()).getTime();
             p11.join(); t11 = (new Date()).getTime();
             p12.join(); t12 = (new Date()).getTime();
             p13.join(); t13 = (new Date()).getTime();
             p14.join(); t14 = (new Date()).getTime();
             p15.join(); t15 = (new Date()).getTime();
             p16.join(); t16 = (new Date()).getTime();
           } catch (InterruptedException e){}

           int n = p1.cuantos()+p2.cuantos()+p3.cuantos()+p4.cuantos()+
                   p5.cuantos()+p6.cuantos()+p7.cuantos()+p8.cuantos()+
                   p9.cuantos()+p10.cuantos()+p11.cuantos()+p12.cuantos()+
                   p13.cuantos()+p14.cuantos()+p15.cuantos()+p16.cuantos();

           System.out.println(" (CON HILOS) Número de primos menores que 10.000.000: "+ n +
             " TOTALES "+ (t16 - t0) +" miliseg. Por tramos sería:" +
             " 1:"+ (t1 - t0) +
             " 2:"+ (t2 - t1) +
             " 3:"+ (t3 - t2) +
             " 4:"+ (t4 - t3) +
             " 5:"+ (t5 - t4) +
             " 6:"+ (t6 - t5) +
             " 7:"+ (t7 - t6) +
             " 8:"+ (t8 - t7) +
             " 9:"+ (t9 - t8) +
             " 10:"+ (t10 - t9) +
             " 11:"+ (t11 - t10) +
             " 12:"+ (t12 - t11) +
             " 13:"+ (t13 - t12) +
             " 14:"+ (t14 - t13) +
             " 15:"+ (t15 - t14) +
             " 16:"+ (t16 - t15) +
             " miliseg. La suma total seria:" +
             ((t1 - t0)+(t2 - t1)+(t3 - t2)+(t4 - t3)+(t5 - t4)+(t6 - t5)+(t7 - t6)+(t8 - t7)+
              (t9 - t8)+(t10 - t9)+(t11 - t10)+(t12 - t11)+(t13 - t12)+(t14 - t13)+(t15 - t14)+(t16 - t15))
             +".");
            int cores = Runtime.getRuntime().availableProcessors();
            System.out.println("Procesadores lógicos disponibles: " + cores);

    }
}

       
    

