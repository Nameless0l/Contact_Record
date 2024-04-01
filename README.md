# Projet Gestion Des Contacts
![Shema de la BD](./src/img.png)
## Fenetre  :
### Enregistrer un contact
![Shema de la BD](./src/img_1.png)
### Liste des contacts
![Shema de la BD](./src/img_2.png)
```mermaid
erDiagram
    CONTACTS {
        code VARCHAR(255)
        nom VARCHAR(255)
        date_naissance VARCHAR(255)
        address VARCHAR(255)
        telNumber VARCHAR(255)
        email VARCHAR(255)
    }

    AGENTS {
        code_agent VARCHAR(255)
        salaire DECIMAL
        statut VARCHAR(255)
        categorie VARCHAR(255)
        indice_salaire VARCHAR(255)
        occupation VARCHAR(255)
        code VARCHAR(255)
    }

    ETUDIANTS {
        code_etudiant VARCHAR(255)
        cycle VARCHAR(255)
        niveau VARCHAR(255)
        code VARCHAR(255)
    }

    ENSEIGNANTS {
        statut VARCHAR(255)
        code_enseignant VARCHAR(255)
        code VARCHAR(255)
    }

    CONTACTS ||--|{ AGENTS : code
    CONTACTS ||--|{ ETUDIANTS : code
    CONTACTS ||--|{ ENSEIGNANTS : code
```
 <h1><center>Shema de la BD</center></h1>

![Shema de la BD](./src/shema_bd.png)


## Comment Lancer le projet
1) Clonner le Projet

2) Sur la racine du projet excecuter la commande
```bash
     java MainFrmApplication
```
