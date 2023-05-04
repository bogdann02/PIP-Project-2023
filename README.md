# PIP-Project-2023

Pasi ca sa urci un Issue pe master
[1] - Intrii pe git alegi un task si ti dai assign

[2] - deschizi git bash in folderul unde lucrezi si scrii comenzile
        [git checkout master]  - Te asiguri ca esti pe branch-ul master
        [git fetch]            - Face un fel de syncronize
        [git pull]             - Trage fisierele updatate la zi de pe git.com/proiect
        In momentul de fata esti cu branch-ul master la zi
        
[3] - incepi sa lucrezi in eclipse sa rezolvi issue-ul (cod/testare/implementare)

[4] - dupa ce ai terminat de rezolvat issue-ul si ai salvat toate documentele deschizi din nou git bash si scrii 
        [git status]           - Iti arata cu rosu fisierele modificate / adaugate
        
[5] - o sa iti scrie cu rosu fisierele modificate / adaugate

[6] - creezi un branch nou (diferit de master) (de obicei cu un nume sugestiv si scurt) (obligatoriu cu litera mica)
   [git branch nume_branch]    - Creeaza un nou branch ex : git branch gui1
   [git checkout nume_branch]  - Te muti cu modificarile pe branch-ul nou creeat
   [git add .]                 - Adauga toate modificarile facute in noul tau branch
   [git commit -m "descriere_sugestiva_issue Closes #id_ticket_luat_de_pe_site"]
   [git push origin nume_branch] - Urca pe site branch-ul pentru a fi trimis spre review
   
[7] - te duci pe git.com pe proiect la sectiunea code si o sa apara scris "create new pull request"

[8] - apesi pe "create new pull request" si in dreapta se pune la review toata lumea (optional)

[9] - daca se poate da merge si daca ai primit review pozitiv apesi pe butonul MERGE

[10] - repeti cu un nou issue
