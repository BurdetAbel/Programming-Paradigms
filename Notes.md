## Git Hub setting  

ADD PROJECT TO REPOSITORY
-------------------------

  - cd project directory
  - (Git Bash)
  - git init
  - git branch -M main
  - git remote add origin https://github.com...
  - git add project_name (git add .)
  - git commit -m "comenet"
  - git pull --rebase origin main (you should update current project)
  - git push -u origin main

------ 

  - Error: rejected o fetch first
  - git pull --rebase origin main
  - Error:merge conflict
  - git add .
  - git rebase --continue
  - git push
