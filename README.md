# dev-lab-java

## Sommaire

[Démarrage rapide](#démarrage-rapide)  
[Lancer tous les tests (tous modules)](#lancer-les-tests-dun-module-spécifique)  
[Philosophie](#philosophie)

Ce dépôt constitue un **laboratoire de conception et de démonstration en Java**, structuré sous forme de **monorepo
Maven multi-modules**.

Il regroupe plusieurs modules indépendants, chacun ciblant un objectif précis (modélisation métier, tests, API,
persistance, etc.), avec une attention particulière portée à la **qualité du code**, à la **testabilité** et à la *
*lisibilité**.

Ce projet est conçu pour :

- illustrer des bonnes pratiques Java modernes,
- servir de support de démonstration technique,
- faciliter l’évolution vers des projets applicatifs plus complets (Spring Boot, data, sécurité).

---

## Démarrage rapide

### Prérequis

- **Java JDK 17**
- Aucune installation de Maven requise (le projet utilise le Maven Wrapper)

### Cloner le dépôt

```bash
git clone <url-du-repo>
cd dev-lab-java
```

### Lancer tous les tests (tous modules)

```bash
./mvnw test 
```

### Lancer les tests d’un module spécifique

```bash
./mvnw -pl java-core-katas test
```

---

### À propos du Maven Wrapper

Le projet fournit le **Maven Wrapper**, permettant d’exécuter Maven sans installation préalable sur la machine.

Lors de la première exécution, les éléments nécessaires au fonctionnement du projet sont téléchargés et stockés dans le
répertoire local Maven (`.m2`).  
Ils sont ensuite réutilisés lors des exécutions suivantes.

---

## Philosophie

- Un module = un objectif clair
- Tests unitaires systématiques
- Aucune dépendance inutile
- Code métier indépendant de l’infrastructure

Ce dépôt sert de **socle technique évolutif**, avant l’introduction de :

- frameworks applicatifs,
- persistance des données,
- sécurité,
- architecture distribuée.

---

## Licence

Projet à usage personnel, pédagogique et démonstratif.
