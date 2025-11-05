## SESION 3

🔸**Cerrojo con Condition**  
Mecanismo que permite controlar el acceso de varios hilos a una sección crítica y realizar acciones de espera y reanudación mediante una condición  
🔸Crear el cerrojo y el objeto Condition:  
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

**Métodos de sincronización (Condition)**  
Usados sobre la condición, una vez se ha obtenido el cerrojo (cerrojo.lock())  
  - await() -> Ejecuta de forma atómica lo siguiente:
  -     1. El hilo llamante es suspendido y bloqueado
  -     2. Se libera la exclusión mutua sobre el objeto
  -     3. El hilo se coloca en una única cola de espera  
  - signal() -> Uno de los hilos de la cola pasa a listo  
  - signalAll() -> Todos los hilos de la cola son desbloqueados y pasan a listos  
