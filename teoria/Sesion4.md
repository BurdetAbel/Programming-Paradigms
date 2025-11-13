INTERBLOQUEOS
---
🔸**DEFINICION**  
Bloqueo permanente de un conjunto de procesos o hilos de ejecución en un sistema concurrente que compiten por recursos del sistema o bien se comunican entre ellos
  - También denominado deadlock o abrazo mortal
<img width="1050" height="470" alt="image" src="https://github.com/user-attachments/assets/a6941d4e-5dcd-4621-9522-98a2af306b12" />

🔸**Condiciones que generan interbloqueo** -> Condiciones de Coffman  
1. Exclusión mutua
    - Al menos existe un recurso compartido, al cual sólo puede acceder un proceso a la vez
2. Asignación parcial de recursos
    - Cada proceso va adquiriendo (y bloqueando) los recursos a medida que los va necesitando
3. No expulsión de recursos
    - Una vez adquirido un recurso, no se libera hasta no haber adquirido el resto
4. Espera circular
    - Cada proceso espera la liberación de un recurso por otro proceso, que a su vez espera un tercero, y así sucesivamente hasta completar el círculo con el primer proceso  

