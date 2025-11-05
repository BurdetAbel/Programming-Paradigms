
/*
Productores y Consumidores. 
En este programa Java se crean cuatro procesos Productor y un proceso Consumidor 
que se comunican a través de un buzón de mensajes. 
Su funcionamiento es el siguiente: el Buzon, cuyo código se muestra incompleto, 
tiene una variable de tipo String para guardar un único mensaje y dos métodos 
(enviaMensaje(msg) y recibeMensaje()). Los productores envían mensajes al buzón 
y el consumidor los saca del buzón y los escribe en la pantalla
*/

/*
 * Programa que lanza cuatro lectores y un escritor.
 * que se comunican a través de un buzón de mensajes.
 * Debe comprobarse que no se pierden los mensajes ni se leen dos veces
 */

/*
* En este ejemplo hay un error -> se produce Condicion de Carrera. 
* Hay mensajes que se pisan entre los distintos hilos
* Introducir mensanismo de mejora para sincronizar (CONDITION)
*/

package ejemplo1;

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
