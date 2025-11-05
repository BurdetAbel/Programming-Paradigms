
package Ejercicio3;

/**
 *
 * @author crist
 */
public class TerminadosThread extends Thread{
    
    private int x, y;
    private int suma = 0;

    public TerminadosThread(int x, int y){
        this.x = x;
        this.y = y;
    }

    // Función que devuelve true si el número termina en 3 o en 5
    private boolean termina3o5(int n){
        int ultDigito = n % 10;
        return (ultDigito == 3 || ultDigito == 5);
    }

    @Override
    public void run(){
        for(int i = x; i <= y; i++){
            if(termina3o5(i)){
                suma += i;  // acumula la suma
            }
        }
    }

    // Devuelve la suma acumulada
    public int total(){
        return suma;
    }
    
}
