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

Le système doit permettre de gérer :

`Produits`

Un produit possède :

- un identifiant
- un nom
- un prix

Un produit doit respecter des règles de cohérence métier (prix valide, données consistantes).

--- 

`Commandes`

Une commande :

- est composée de lignes de commande
- possède un statut représentant son cycle de vie (créée, validée, etc.)
- dispose d’une date de création

Une commande ne peut être validée que si elle respecte les règles métier définies.

--- 

`Lignes de commande`

Une ligne de commande associe :

- un produit
- une quantité

Le total d’une ligne dépend du prix du produit et de la quantité.

--- 

`Calculs métier`

- Le total d’une commande correspond à la somme des totaux de ses lignes.
- Les calculs doivent être précis et cohérents (pas de flottants approximatifs).

---

`Cycle de vie`

Une commande suit un cycle de vie simple :

- création
- validation

Certaines actions ne sont possibles que dans un état donné.

---

## Contraintes techniques

- Langage : Java 21
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