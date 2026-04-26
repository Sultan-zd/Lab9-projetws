# Projet de Gestion des Étudiants (Android & Web Services PHP)

Ce projet est une application Android permettant de gérer une base de données d'étudiants via des Web Services PHP. Il permet l'ajout d'étudiants et la consultation de la liste en temps réel depuis un serveur distant ou local (XAMPP/WAMP).

## Fonctionnalités

*   **Ajout d'Étudiants** : Formulaire complet (Nom, Prénom, Ville, Sexe) avec validation.
*   **Liste en Temps Réel** : Affichage des étudiants stockés en base de données dans un `RecyclerView` moderne avec `CardView`.
*   **Communication Réseau** : Utilisation de la bibliothèque **Volley** pour les requêtes HTTP.
*   **Parsing JSON** : Utilisation de **GSON** pour convertir les données entre Java et JSON.
*   **Gestion des Erreurs** : Sécurité renforcée lors du défilement (scroll) pour éviter les crashs en cas de données incomplètes.

## Technologies Utilisées

*   **Android SDK** (Java)
*   **Volley** : Gestion des appels API réseau.
*   **GSON** : Sérialisation/Désérialisation JSON.
*   **RecyclerView & CardView** : Pour une interface utilisateur fluide.
*   **Backend** : PHP 7.4+ / MySQL.
*   **Serveur Local** : XAMPP ou WAMP.

## Structure du Projet Android

*   `MainActivity.java` : Menu principal de l'application.
*   `AddEtudiant.java` : Activité gérant le formulaire d'insertion.
*   `ListEtudiantActivity.java` : Activité affichant la liste récupérée du serveur.
*   `beans/Etudiant.java` : Modèle de données.
*   `adapter/EtudiantAdapter.java` : Adaptateur pour l'affichage personnalisé de la liste.

## Configuration du Backend (XAMPP)

Le projet s'attend à trouver les scripts PHP dans le dossier `htdocs/projet/`.

### Structure des dossiers PHP :
```text
C:\xampp\htdocs\projet\
├── classes\
│   └── Etudiant.php
├── connexion\
│   └── Connexion.php
├── service\
│   └── EtudiantService.php
└── ws\
    ├── createEtudiant.php
    └── loadEtudiant.php
```

### Base de données :
Créez une base de données nommée `school1` avec une table `etudiant` :
```sql
CREATE TABLE etudiant (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(50),
    prenom VARCHAR(50),
    ville VARCHAR(50),
    sexe VARCHAR(10)
);
```

## Installation

1.  Clonez le projet Android dans Android Studio.
2.  Lancez votre serveur **XAMPP** (Apache & MySQL).
3.  Configurez l'adresse IP dans le code Java :
    *   Si vous utilisez l'émulateur Android, l'URL est : `http://10.0.2.2/projet/ws/`
    *   Si vous utilisez un appareil physique, utilisez l'adresse IP de votre PC (ex: `http://192.168.1.5/projet/ws/`).
4.  Compilez et lancez l'application.

## Note sur la Sécurité
L'application utilise l'attribut `android:usesCleartextTraffic="true"` dans le `AndroidManifest.xml` pour permettre les connexions HTTP non sécurisées vers le serveur local de développement.
