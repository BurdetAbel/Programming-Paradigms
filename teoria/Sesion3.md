## SESION 3

🔸**Cerrojo con Condition**  
Mecanismo que permite controlar el acceso de varios hilos a una sección crítica y realizar acciones de espera y reanudación mediante una condición  
🔸**Crear el cerrojo y el objeto Condition:**  
```java
public class Clase()
{
    private Lock cerrojo = new ReentrantLock();
    private Condition parar = cerrojo.newCondition();
    ...
}
```
  
  - A partir del cerrojo creamos el objeto Condition  
  - Se pueden crear tantos como necesitemos  

🔸**Métodos de sincronización (Condition)**  
Usados sobre la condición, una vez se ha obtenido el cerrojo (cerrojo.lock())  
  - await() -> Ejecuta de forma atómica lo siguiente:
  -     1. El hilo llamante es suspendido y bloqueado
  -     2. Se libera la exclusión mutua sobre el objeto
  -     3. El hilo se coloca en una única cola de espera  
  - signal() -> Uno de los hilos de la cola pasa a listo  
  - signalAll() -> Todos los hilos de la cola son desbloqueados y pasan a listos  

<img width="498" height="540" alt="image" src="https://github.com/user-attachments/assets/96edd497-eef8-46d1-b2a9-4a6005ec2fb6" />

🔸**Consideraciones**  
Dado que signalAll() despierta a todos los hilos, es posible que se active un hilo que no cumple la condición de espera  
  - Tenemos que comprobarla después de despertar
  - Y volver al bloqueo, si aún no se cumple
  
## Condition en Java  
🔸Receptor de la señal:
```java
public void receptor()
{
    try
    {
        cerrojo.lock();
        while (!condicion)
        {
            try
            {
                micondicion.await(); // espera a que le manden una señal
            } catch (Exception e){}
        }
        //código accedido en exclusión mutua (al recurso compartido)
    }
    finally
    {
    cerrojo.unlock();
    }
}
```
El hilo ejecutor se bloquea si la condición no se cumple, esperando a que le manden una señal
🔸Emisor de la señal:
```java
public void emisor()
{
    try
    {
        cerrojo.lock();
        //código en exclusión mutua que cambia condición de estado
        micondicion.signalAll(); //o también micondicion.signal();
    }
    finally
    {
        cerrojo.unlock();
    }
}
```
El hilo ejecutor cambia la condición de estado y lanza una señal a todos los hilos bloqueados
Los hilos que estaban bloqueados vuelven a comprobar su condición (con el bucle while)
