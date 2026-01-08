# Module Java-core-katas

## Objectif du module

Ce module vise à illustrer et démontrer la maîtrise des fondamentaux du langage Java, à travers un cas métier concret,
sans dépendance à un framework.

L’accent est mis sur :

- la modélisation métier
- la qualité du code
- la lisibilité
- la testabilité
- l’utilisation des fonctionnalités modernes du langage Java

Les règles métier sont validées exclusivement par des tests unitaires.

## Contexte métier

Une entreprise souhaite mettre en place un noyau métier de gestion de commandes, destiné à servir de base à une future
application e-commerce.

Dans cette première phase, le périmètre est volontairement limité au cœur métier, sans base de données, sans interface
graphique et sans API.

L’objectif est de concevoir un modèle métier robuste, indépendant de toute infrastructure technique.

## Périmètre fonctionnel

Le système gère les concepts métier suivants :

- Produits
- Commandes
- Lignes de commande

Chaque concept est régi par des règles de cohérence métier.

---
## Cas d’usage (informel)

Le module doit permettre :

- Créer une commande.
- Ajouter ou retirer des lignes de commande.
- Calculer le total d’une commande.
- Valider une commande.
- Refuser toute opération non conforme aux règles métier via des exceptions.

---
## Règles de cycle de vie (informel)

Une commande possède deux états :

- CREATED
- VALIDATED

Transition autorisée :
- CREATED -> VALIDATED

Transitions interdites :
- VALIDATED -> CREATED

La validation d’une commande est impossible si les règles métier ne sont pas respectées
(ex : aucune ligne, quantité invalide, prix invalide).

---
## Critères d’acceptation (tests)

Produits
- Un produit créé avec un prix <= 0 est refusé (exception).
- Un produit valide est instanciable.

Repository in-memory
- Après save(product), findById(product.id) retourne le produit.
- findById(id inconnu) retourne Optional.empty().

Commandes / lignes
- Une ligne avec quantité <= 0 est refusée (exception).
- Le total d’une ligne = prix * quantité (BigDecimal).
- Le total d’une commande = somme des totaux de lignes.

Cycle de vie
- Une commande nouvellement créée est en statut CREATED.
- validate() fait passer CREATED -> VALIDATED.
- validate() est refusée si la commande est invalide (ex: aucune ligne).
- Toute transition interdite déclenche une exception.


---

## Contraintes techniques

- Langage : Java 17
- Frameworks : aucun
- Tests : JUnit 5
- Pas de base de données
- Pas de framework web
- Pas de main() requis

Les règles métier doivent être validées exclusivement par des tests unitaires.

--- 

## Organisation du module

- Le code métier est situé dans src/main/java
- Les tests sont situés dans src/test/java
- Chaque règle métier importante doit être couverte par au moins un test

--- 

`Résultat attendu`

À la fin de ce module, le projet doit démontrer :

- une bonne maîtrise du Java de base et moderne
- une utilisation correcte :
    - des collections
    - des streams
    - des exceptions
    - de l’immutabilité
    - de Optional (sans abus)
    - de java.time
- un code lisible, structuré et testable
- une couverture fonctionnelle cohérente par les tests

--- 

## Positionnement

Ce module s’adresse à un développeur Java capable de concevoir un cœur métier autonome, testable et indépendant de toute
infrastructure technique.

Il constitue une base de travail solide avant l’introduction de :

- frameworks applicatifs (Spring Boot)
- persistance des données
- sécurité
- ou architecture distribuée.

---

## Note

Ce document décrit le contexte et les attentes fonctionnelles.
Les choix d’implémentation, la structure du code et les solutions techniques relèvent de la responsabilité du
développeur.