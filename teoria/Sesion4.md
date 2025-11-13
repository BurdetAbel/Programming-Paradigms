INTERBLOQUEOS
---
🔸**DEFINICION**  
Bloqueo permanente de un conjunto de procesos o hilos de ejecución en un sistema concurrente que compiten por recursos del sistema o bien se comunican entre ellos
  - También denominado deadlock o abrazo mortal
<img width="1050" height="470" alt="image" src="https://github.com/user-attachments/assets/a6941d4e-5dcd-4621-9522-98a2af306b12" />

---

🔸**Condiciones que generan interbloqueo** -> Condiciones de Coffman  
1. Exclusión mutua
    - Al menos existe un recurso compartido, al cual sólo puede acceder un proceso a la vez
2. Asignación parcial de recursos
    - Cada proceso va adquiriendo (y bloqueando) los recursos a medida que los va necesitando
3. No expulsión de recursos
    - Una vez adquirido un recurso, no se libera hasta no haber adquirido el resto
4. Espera circular
    - Cada proceso espera la liberación de un recurso por otro proceso, que a su vez espera un tercero, y así sucesivamente hasta completar el círculo con el primer proceso  

---

🔸**Ejemplo de interbloqueo (Java)**  

```java
public class Interbloqueo
{
  public static void main(String[] args)
  {
    //Hay 2 objetos (recursos) para los
    //que intentaremos obtener el lock
    final Object recurso1 = "recurso1";
    final Object recurso2 = "recurso2";

    Hilo h1 = new Hilo(1, recurso1, recurso2);
    Hilo h2 = new Hilo(2, recurso1, recurso2);

    //Se lanzan los dos hilos.
    //El interbloqueo sucede, y el programa nunca finaliza
    h1.start();
    h2.start();
  }
}


public class Hilo extends Thread {
    int id;
    Object recurso1, recurso2;
    public Hilo(int i, Object recurso1, Object recurso2) {
        id = i;
        this.recurso1 = recurso1;
        this.recurso2 = recurso2;
    }
    public void run() {
        if(id==1){
            synchronized(recurso1) {
                System.out.println("Hilo 1: bloquea recurso 1");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {}

                synchronized(recurso2) {
                    System.out.println("Hilo 1: bloquea recurso 2");
                }
            }
        }
        else if(id==2){
            synchronized(recurso2) {
                System.out.println("Hilo 2: bloquea recurso 2");
                try {
                Thread.sleep(50);
                    } catch (InterruptedException e){}
                synchronized(recurso1) {
                    System.out.println("Hilo 2: bloquea recurso 1");
        }
} } } }
```

Ejecución  
run:  
Hilo 1: bloquea recurso 1  
Hilo 2: bloquea recurso 2  
BUILD STOPPED (total time: 3 seconds)  

---

🔸**Evitar interbloqueos** -> Asegurando que no suceda alguna de las condiciones de Coffman  
- Eliminando la exclusión mutua
  - Ningún proceso puede tener acceso exclusivo a un recurso
- Eliminando la asignación parcial de recursos
  - Haciendo que todos los procesos pidan todos los recursos que van a necesitar antes de empezar
- Eliminando la condición de no expulsión de recursos
  - Liberando los recursos adquiridos o expropiándoselos a los hilos que los tengan bloqueados y estén a la espera
- Eliminando la condición de espera circular
  - Se le permite a un proceso poseer sólo un recurso en un determinado momento, o establecer una jerarquía para evitar ciclos
