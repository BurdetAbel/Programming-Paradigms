## Git Hub setting  

**ADD PROJECT TO REPOSITORY**

  - cd project directory
  - (Git Bash)
  -     git init
  -     git branch -M main
  -     git remote add origin https://github.com...
  -     git add project_name (git add .)
  -     git commit -m "comenet"
  - (you should update current project)
  -     git pull --rebase origin main 
  -     git push -u origin main

------ 

*Error: rejected o fetch first*
  -     git pull --rebase origin main
*Error:merge conflict*
  -     git add .
  -     git rebase --continue
  -     git push

------

**GIT BRANCH**
  - Crear y cambiar a nueva rama
  -     git checkout -b nombre_rama
  - Subir rama a GitHub
  -     git push -u origin nombre_rama
  - Cambiar de rama
  -     git checkout otra_rama
  - Fusionar con main
  -     git merge nombre_rama
  - Eliminar rama local
  -     git branch -d nombre_rama
  - Eliminar rama remota
  -     git push origin --delete nombre_rama

**GIT BRANCH NETBEANS**
  - Crear rama	Git → Branch → Create Branch
  - Cambiar rama	Git → Branch → Switch To
  - Fusionar ramas	Git → Merge Changes
  - Subir rama	Git → Remote → Push
  - Eliminar rama	Git → Branch → Delete Branch
