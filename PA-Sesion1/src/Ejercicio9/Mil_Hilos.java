// Escribir un programa que cree 1000 hilos. Cada hilo tendrá un identificador que se generará secuencialmente y deberá imprimir por pantalla
// dicho identificador. ¿Se ejecutan los hilos secuencialmente, en el mismo orden en el que se crearon?
// RESPUESTA: No se ejecutan en orden, el planificador decide, ademas de que se entrmezclan si se imprimen al mismo tiempo en maquinas con varios nucleos
package Ejercicio9;

public class Mil_Hilos {
    public static void main(String[] args) {
        // Lanzamos 1000 hilos, cada hilo imprime su id (orden no garantizado)
        for (int i = 1; i <= 1000; i++) {
            new HiloID(i).start();
        }
    }
}

// Clase HiloID no es public (puede estar en el mismo archivo)
class HiloID extends Thread {
    private final int id;

    HiloID(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Hilo ID: " + id);
    }
}


