# ERecrute-Project
Mettre au profit des recruteurs un outil sécurisé pour simplifier la procédure de recrutement et changement de carrière 
à travers des indicateurs bien déterminés pour pouvoir effectuer des recherches sur des profils à la demande, de façon rapide et précise.
La plateforme ERecrute permet de gérer, de structurer, d’organiser et de centraliser les recrutements. 
En fait pour chaque recrutement, on peut définir un processus adéquat afin d’optimiser la performance de recrutement.
Cette application permet d’affecter une ressource au poste adéquat et permettre aux recruteurs de trouver facilement les CVs 
contenant les compétences exigées pour le poste. Ainsi, l’équipe de développement a mis en place un système de gestion de ressources 
couvrant plusieurs fonctionnalités telles que : La gestion de profil, la CVthèque, le recrutement.

Développement en couches:

Couche présentation (Client) : correspond à la partie de l’application visible et interactive avec les utilisateurs. 
Elle communique avec la couche métier par les web services et le protocole HTTP. 

Couche métier (Business Layer) : correspond à la partie fonctionnelle de l’application, 
qui est responsable de l’implémentation de la « logique », décrivant les opérations que l’application opère sur les données 
en fonction des requêtes des utilisateurs, effectuées au travers de la couche présentation. 

Couche accès aux données (Data Layer) : chargée de l'accès aux données et de leur manipulation, indépendamment du SGBD choisi.
