## SESION 1

Hilos(Thread) -> Segmentos de código de un programa que se ejecutan secuencialmente de modo independiente de las otras partes del programa

<img width="1320" height="427" alt="image" src="https://github.com/user-attachments/assets/b49b1a9a-55b0-4297-9886-3fb09c5e46be" />

**Métodos (clase Thread):**  
start() -> Crea un nuevo hilo e inicia su ejecución (llamando a run())
run() -> Contiene el código a ejecutar por el hilo
      -> Cuando termina su ejecución, el hilo se destruye (muere)
join() -> Espera a que el hilo correspondiente termine
sleep() -> El hilo se “duerme” durante un tiempo determinado
