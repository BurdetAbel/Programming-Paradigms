
/*
Comprobar que el programa del ejemplo 1 falla y reescribir los métodos enviaMensaje(msg) y recibeMensaje(), de forma que no se
pierda ningún mensaje, ni tampoco haya ningún mensaje que sea leído dos o más veces por el consumidor.
Nota: Además de asegurar el acceso exclusivo a las variables compartidas mediante cerrojos (Locks), debe comprobarse
la condición de buzón lleno o vacío (Condition). Si un proceso no puede continuar, deberá esperar (await()) a que la
condición se cumpla. El método await() hace que el proceso se quede bloqueado en una cola de procesos asociada al cerrojo
y deje libre a éste para otros procesos. Cuando un proceso modifique la variable sobre la que se establece la condición en
el Condition, deberá ejecutar el método signal() para desbloquear a uno de los procesos que esperan por la condición, o el
método signalAll() para desbloquear a todos los procesos que esperan en la cola asociada al Condition
*/

/*
 * Programa que lanza cuatro lectores y un escritor.
 * que se comunican a través de un buzón de mensajes.
 * Debe comprobarse que no se pierden los mensajes ni se leen dos veces
 */

/*
* MEJORA DEL EJEMPLO 1 en la que se produce Condicion de Carrera. 
* Hay mensajes que se pisan entre los distintos hilos
* Introducir mensanismo de mejora para sincronizar (CONDITION)
*/

package Ejercicio1;


public class PruebaBuzon1
{
    public static void main(String[] s)
    {
        Buzon buzonX = new Buzon();
        Productor pedro = new Productor("Pedro ",5,buzonX);
        Productor juan = new Productor("Juan ",4,buzonX);
        Productor antonio = new Productor("Antonio ",6,buzonX);
        Productor luis = new Productor("Luis ",7,buzonX);
        Consumidor jose = new Consumidor(22,buzonX);
        pedro.start();
        juan.start();
        antonio.start();
        luis.start();
        jose.start();
    }
}
