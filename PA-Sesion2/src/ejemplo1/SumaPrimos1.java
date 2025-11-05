// SumaPrimos1 calcula la suma de los primos entre 1 y 10.000.000 en un solo hilo

/*
Programa Java que sirve para calcular la suma de todos los primos menores que 10.000.000.
Como el resultado de dicha suma excede del mayor número entero representable en Java, creamos un objeto de la clase Resultado, que
contiene un atributo BigInteger donde guardar la suma y los métodos apropiados para manejarlo: getSuma() y sumar(int). El cálculo lo
hace un objeto de la clase Calculador, que recibe el intervalo de valores a calcular y el objeto Resultado donde tiene que ir sumando los
primos que va encontrando.
El programa principal SumaPrimos1, hace el cálculo sin utilizar concurrencia. También muestra el tiempo que tarda en el cálculo
*/
package ejemplo1;
import java.util.*;

public class SumaPrimos1 {
    public static void main(String[] x){
        
        Resultado suma = new Resultado();
        long t0 = (new Date()).getTime(); //t0=instante de inicio de los cálculos
        Calculador p1 = new Calculador(1,10000000,suma); // Calculamos desde 1-10M
        p1.start();
        try {
            p1.join();//Espera a que objeto p1 haya terminado
        } catch (InterruptedException e){}
        long t1 = (new Date()).getTime(); //t1=instante de final de los cálculos
        System.out.println("La suma de los números primos hasta 10000000 es: "+suma.getSuma()+" calculado en "+(t1-t0)+" miliseg.");
    }
}

