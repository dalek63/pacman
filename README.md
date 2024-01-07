��#   p a c m a n 
 
��# Description du Projet
Bienvenue dans notre projet universitaire : une reconstitution du classique jeu d'arcade Pac-Man !

Pac-Man est un jeu emblématique, apprécié mondialement pour son gameplay captivant et ses personnages colorés. Notre version du jeu permet au joueur de contrôler Pac-Man, le célèbre personnage circulaire, qui se fraye un chemin à travers un labyrinthe rempli de pastilles et de fruits, tout en esquivant des fantômes.
Ce projet a été développé dans le cadre d'un programme universitaire par une équipe d'étudiants en master 2 MIAGE (Méthodes Informatiques Appliquées à la Gestion des Entreprises) par apprentissage. Notre objectif était de reproduire avec précision l'expérience originale de Pac-Man, en mettant l'accent sur le respect de la conception et de la mécanique de jeu classiques.
En tant qu'équipe d'étudiants, nous avons uni nos compétences en développement et notre enthousiasme pour Pac-Man dans le but de rendre hommage à ce jeu intemporel. Notre version de Pac-Man est une célébration de son héritage, offrant une expérience amusante et stimulante qui ravira à la fois les joueurs nostalgiques et les nouveaux venus.

��# Technologies Utilisées :
Notre projet de jeu Pac-Man tire parti d'une gamme variée de technologies modernes, langages de programmation, frameworks et outils pour offrir une expérience utilisateur riche et une architecture robuste. Voici les principales technologies que nous avons utilisées :
Spring Boot : Un framework puissant qui simplifie le développement d'applications Java, utilisé pour créer notre Back-End. Spring Boot facilite la configuration et le déploiement de l'application, tout en offrant une intégration aisée avec diverses dépendances.
Java : Le langage de programmation principal de notre projet, choisi pour sa robustesse, sa portabilité et son écosystème riche. Java nous a permis de construire une application Back-End stable et performante.
Maven : Un outil d'automatisation de gestion de projet utilisé pour gérer les dépendances de notre application Spring Boot. Maven facilite la construction, le test et le déploiement de notre application.
API REST : Nous avons développé une API REST pour faciliter la communication entre le Back-End et le Front-End. Cette approche nous a permis de créer une interface claire et bien définie pour les interactions entre les différentes parties de notre jeu.
Microsoft Azure : Pour le déploiement de notre application, nous avons choisi Microsoft Azure. Cette plateforme cloud nous a offert la flexibilité, la scalabilité et la fiabilité nécessaires pour héberger notre application.
Postman : Utilisé en phase de développement pour tester et valider les fonctionnalités de notre API REST. Postman a été un outil clé pour s'assurer que notre API répond correctement aux requêtes et gère les différents scénarios de manière appropriée.
Git : Système de contrôle de version pour gérer efficacement les différentes versions du code source du projet.
GitHub : Plateforme de gestion de code source et de collaboration, utilisée pour héberger notre répertoire Git et faciliter le travail d'équipe.


Chacune de ces technologies a été sélectionnée pour sa fiabilité, ses performances et sa compatibilité avec notre vision du projet. Ensemble, elles forment le socle sur lequel repose notre jeu Pac-Man, garantissant une expérience utilisateur optimale.

��# Comment Lancer le Jeu :
Comment Lancer le Back-End du Jeu
Pour configurer et lancer le Back-End de notre jeu Pac-Man, veuillez suivre ces instructions :
Prérequis :
Java Development Kit (JDK) : Java 17 est requis pour ce projet. Assurez-vous d'avoir installé JDK 17, car des versions plus récentes (comme JDK 18 ou 19) ne sont pas compatibles avec notre déploiement sur Azure. Vous pouvez télécharger JDK 17 depuis AdoptOpenJDK ou Oracle JDK.
Git : Pour cloner le projet depuis le dépôt Git. Si Git n'est pas installé sur votre machine, vous pouvez le télécharger depuis Git Downloads.

Étapes pour Lancer le Back-End :
Cloner le Répertoire Git : Ouvrez un terminal ou une invite de commande et exécutez la commande suivante :
            git clone [URL du dépôt Git]
Vérifier les Dépendances dans pom.xml : Ouvrez et examinez le fichier pom.xml pour vous assurer que toutes les dépendances nécessaires sont présentes.
Naviguer dans le Répertoire du Projet : Utilisez cette commande pour accéder au répertoire du projet :                                                                                                             
            cd chemin/vers/le/projet
Lancer l'Application Spring Boot : Lancez l'application en utilisant Maven :  ./mvnw spring-boot:run
                                                             ou pour Windows : mvnw spring-boot:run
Accéder à l'API : L'API REST sera accessible via http://localhost:8080/api/ une fois l'application en cours d'exécution.

Dépannage :
Si des problèmes surviennent lors du démarrage, vérifiez que JDK 17 est correctement installé et configuré comme votre JDK par défaut.

��# Collaboration entre les Équipes Front-End et Back-End
Notre projet Pac-Man est le résultat d'une collaboration étroite entre deux équipes spécialisées : notre équipe, qui gère le Back-End, et une équipe partenaire qui se concentre sur le Front-End. Travaillant en tandem, nous avons créé une expérience de jeu fluide et interactive.

Rôle de Notre Équipe (Back-End) :
Développement de la Logique du Jeu : Nous avons construit le cœur du jeu, gérant la logique, l'état du jeu, et le traitement des données.
Mise en Place d'une API REST : Nous avons développé une API REST pour faciliter une communication efficace avec l'équipe Front-End, permettant une interaction dynamique entre les deux parties du jeu.
Transmission des Données de Jeu : Notre API envoie les coordonnées et états de Pac-Man, ainsi que d'autres données essentielles au gameplay.

Rôle de l'Équipe Front-End :
Création de l'Interface Utilisateur : L'équipe Front-End a développé l'interface visuelle du jeu, incluant les graphismes et l'expérience utilisateur.
Interaction avec l'API REST : Ils utilisent notre API pour recevoir les données du jeu et afficher les éléments correspondants à l'écran.
Commandes de Déplacement : Les commandes de déplacement de Pac-Man et les interactions de l'utilisateur sont envoyées via l'API à notre système Back-End pour traitement.
Pour en savoir plus sur le travail de l'équipe Front-End, consultez leur dépôt Git : XXXXXXX

Cette collaboration étroite entre nos équipes assure une synchronisation parfaite entre les actions du joueur dans l'interface graphique et la logique du jeu traitée par notre Back-End. Elle garantit également que l'état actuel du jeu est constamment mis à jour et affiché par le Front-End.


��# Liste des Contributeurs :
Notre projet Pac-Man a été mené à bien grâce à une collaboration étroite et équilibrée entre tous les membres de notre équipe. Chacun a apporté son expertise, ses idées et son énergie, contribuant de manière significative à chaque aspect du projet. Nous tenons à reconnaître et à remercier chaque membre de l'équipe pour leur dévouement et leur travail acharné :
•	Sarah Belhaddad
•	Zakari Boumaza
•	Rémi Sevret

 
