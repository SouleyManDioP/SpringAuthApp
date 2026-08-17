Vues JSP : `src/main/webapp/WEB-INF/jsp/form.jsp`, `liste.jsp`, `login.jsp`.

## Authentification

Deux mécanismes cohabitent, comme demandé dans le sujet :

- **Web (formulaire)** : `/inscriptions/**` protégé par `formLogin()`, session classique.
- **API REST** : `/api/**` protégé par **JWT**, sans session (`stateless`).

Deux utilisateurs sont créés en base :

| Utilisateur | Rôle  |
|-------------|-------|
| Souleymane  | USER  |
| Najad       | ADMIN |

## Lancer le projet

Base de données **MySQL** requise (voir `application.properties`), la table
`inscription` et `utilisateur` sont créées automatiquement au démarrage via `schema.sql`.

```bash
mvn spring-boot:run
```

Puis ouvrir :
- Formulaire : http://localhost:8080/inscriptions/nouveau (authentification par formulaire)
- Liste (tableau) : http://localhost:8080/inscriptions

## API REST

| Méthode | URL                      | Description                              | Protection |
|---------|--------------------------|-------------------------------------------|------------|
| POST    | /api/auth/login          | Authentification, renvoie un token JWT   | Publique   |
| GET     | /api/inscriptions        | Liste toutes les inscriptions            | JWT requis |
| GET     | /api/inscriptions/{id}   | Détail d'une inscription                 | JWT requis |
| POST    | /api/inscriptions        | Crée une inscription (JSON)              | JWT requis |
| DELETE  | /api/inscriptions/{id}   | Supprime une inscription                 | JWT requis |



### Connexion au formulaire web
![Login web](screenshot/login-web.png)

### Obtention du token JWT (Postman)
![JWT Postman](screenshot/jwt-postman.png)

### Accès à inscription
![API protégée](screenshot/inscriptions.png)

### Accès à la liste
![API protégée](screenshot/Liste.png)

### Accès à la page deconnexion
![API protégée](screenshot/deconnection.png)