# Inscription à un événement — Spring MVC + Spring JDBC + JSP + API REST

## Structure (Model / Repository / Service / Controller)

```
sn.esmt.inscription
├── model         Inscription.java
├── repository    InscriptionRepository (interface) + InscriptionRepositoryImpl (JdbcTemplate)
├── service       InscriptionService (interface) + InscriptionServiceImpl
└── controller    InscriptionWebController (formulaire + tableau JSP)
                  InscriptionRestController (API REST JSON)
```

Vues JSP : `src/main/webapp/WEB-INF/jsp/form.jsp` et `liste.jsp`.

## Lancer le projet

Important : le support JSP avec Tomcat embarqué ne fonctionne fiablement
qu'en lancement via Maven (pas en exécutant le .jar packagé). Donc :

```bash
mvn spring-boot:run
```

Puis ouvrir :
- Formulaire : http://localhost:8080/inscriptions/nouveau
- Liste (tableau) : http://localhost:8080/inscriptions

La base H2 est en mémoire (aucune installation requise) et la table
`inscription` est créée automatiquement au démarrage via `schema.sql`.
Pour passer à MySQL, changez `application.properties` (bloc déjà présent en commentaire)
et ajoutez la dépendance `mysql-connector-j` dans le `pom.xml`.

## API REST

| Méthode | URL                      | Description                    |
|---------|--------------------------|---------------------------------|
| GET     | /api/inscriptions        | Liste toutes les inscriptions  |
| GET     | /api/inscriptions/{id}   | Détail d'une inscription       |
| POST    | /api/inscriptions        | Crée une inscription (JSON)    |
| DELETE  | /api/inscriptions/{id}   | Supprime une inscription       |

Exemple de création via curl :

```bash
curl -X POST http://localhost:8080/api/inscriptions \
  -H "Content-Type: application/json" \
  -d '{
        "nom": "Diop",
        "prenom": "Awa",
        "dateNaissance": "1999-05-12",
        "telephone": "771234567",
        "typeEvenement": "Conférence"
      }'
```

Le formulaire web et l'API REST utilisent le même Service/Repository :
une inscription créée via l'un apparaît aussi dans l'autre.
