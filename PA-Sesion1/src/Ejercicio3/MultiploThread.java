
package Ejercicio3;

/**
 *
 * @author crist
 */
public class MultiploThread extends Thread{
    
    private int x, y;
    private int suma = 0;

    public MultiploThread(int x, int y){
        this.x = x;
        this.y = y;
    }

    // Función que devuelve true si n es múltiplo de 7
    private boolean esMultiplo7(int n){
        boolean multiplo = false;
        if(n % 7 == 0)
            multiplo = true;
        return multiplo;
    }

    @Override
    public void run(){
        for(int i = x; i <= y; i++){
            if(esMultiplo7(i)){
                suma += i;  
            }
        }
    }

    public int resultado(){
        return suma;
    }
    
}
