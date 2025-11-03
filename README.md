# Programming-Paradigms

Hilos(Threads) -> Segmentos de codigo de un programa que se ejecutan secuencialmente de modo independiente de las otras partes del programa 

<img width="1326" height="416" alt="image" src="https://github.com/user-attachments/assets/df5b516f-e90d-4e62-9a7b-894df5c515cf" />

Métodos (clase Thread):
start() -> Crea un nuevo hilo e inicia su ejecución (llamando a run())
run() -> Contiene el código a ejecutar por el hilo
      -> Cuando termina su ejecución, el hilo se destruye (muere)
join() -> Espera a que el hilo correspondiente termine
sleep() -> El hilo se “duerme” durante un tiempo determinado

Creación de hilos en Java:
1. Heredar de la clase Thread
2. Implementar la interfaz Runnable
En ambos casos hay que definir el método run()

Creación heredando de Thread:
public class EjemploHilo extends Thread {
  public void run()
  {
    // Código del hilo
  }
}

Para instanciarlo y ejecutarlo:
EjemploHilo t = new EjemploHilo();
t.start();

Creación implementando Runnable:
  public class EjemploHilo implements Runnable {
    public void run()
    {
        // Código del hilo
  }
}

Para instanciarlo y ejecutarlo:
Thread t = new Thread(new EjemploHilo());
t.start();
