# curae_project


Projet JEE (Framework Spring) réalisé par Nathan HERTSOEN et Wassim DJAMAA 

Hospitalization API

Contexte : 


L’hôpital de la région possède un système de gestion des hospitalisations catastrophique (papier-crayon). Impossible de savoir si des services sont débordés pour les hospitalisations de nouveaux patients. Vous venez de gagner le contrat pour la mise en place d’une API pour gérer les hospitalisations. L’hôpital souhaite pouvoir gérer différents aspects : 

    ● Les médecins,
    ● Les services,
    ● Les patients, 
    ● Les hospitalisations en cours, 
    ● Les Statistiques à l’instant T.


Objectifs :


    ● Mettre en place une API respectant les principes des WS-RESTfull et l’architecture N-tiers,
    ● Proposer une implémentation de bout-en-bout en respectant les contraintes d’un projet client, 
    ● Développer une API découpée en 3 couches (présentation, métier, persistance), 
    ● Persister les données nécessaires dans une base de donnée (H2), 
    ● Gérer les schémas de BDD à l’aide d’un outil dédié (liquibase), 
    ● Valider / Invalider les entrants (validation des divers éléments composant une nouvelle ressource). 


Spécifications :


    ● Afin de garder un historique et de ne pas avoir de données incohérentes, l'API ne permet de supprimer que les hospitalisations,
    ● Tous les champs des objets doivent être remplis, l'id est généré automatiquement par la base de données (l'id d'une ressource est immuable),
    ● Format de date en entrée et en sortie : DD/MM/YYYY,
    ● Une gestion des erreurs a été mise en place afin de donner seulement les informations utiles et nécessaires en cas d'erreur.


    


