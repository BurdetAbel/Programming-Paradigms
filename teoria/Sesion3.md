## SESION 3

**Cerrojo con Condition**  
Mecanismo que permite controlar el acceso de varios hilos a una sección crítica y realizar acciones de espera y reanudación mediante una condición  
Crear el cerrojo y el objeto Condition:  
java'''
public class Clase()
{
private Lock cerrojo = new ReentrantLock();
private Condition parar = cerrojo.newCondition();
...
}
