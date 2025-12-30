# dev-lab-java

Ce dépôt constitue un **laboratoire de conception et de démonstration en Java**, structuré sous forme de **monorepo Maven multi-modules**.

Il regroupe plusieurs modules indépendants, chacun ciblant un objectif précis (modélisation métier, tests, API, persistance, etc.), avec une attention particulière portée à la **qualité du code**, à la **testabilité** et à la **lisibilité**.

Ce projet est conçu pour :
- illustrer des bonnes pratiques Java modernes,
- servir de support de démonstration technique,
- faciliter l’évolution vers des projets applicatifs plus complets (Spring Boot, data, sécurité).

---

## Structure du projet

```
dev-lab-java
├── pom.xml                # POM parent (agrégateur)
├── java-core-katas/       # Module Java pur (fondamentaux et logique métier)
├── spring-boot-api-basics/# Modules Spring Boot (à venir)
└── ...
```

Le projet racine est un **parent Maven (`packaging=pom`)** :
- il ne contient aucun code métier,
- il centralise les versions, standards et plugins,
- il orchestre le build de l’ensemble des modules.

---

## Prérequis

- **Java JDK 17**
- **IntelliJ IDEA** (Community ou Ultimate)
- Aucun Maven système requis (Maven embarqué ou Wrapper)

---

## Démarrage rapide

### Cloner le dépôt
```bash
git clone <url-du-repo>
cd dev-lab-java
```

### Lancer tous les tests (tous modules)
```bash
mvn test
```

### Lancer les tests d’un module spécifique
```bash
mvn -pl java-core-katas test
```

---

## Installation du Maven Wrapper (recommandé)

Le **Maven Wrapper** permet d’utiliser Maven **sans installation préalable**, avec une version maîtrisée et cohérente pour tous les environnements.

### Générer le Wrapper

Depuis la racine du projet :

```bash
mvn -N wrapper:wrapper
```

Cela génère :
- `mvnw`, `mvnw.cmd`
- le dossier `.mvn/`

### Utilisation du Wrapper

À partir de ce moment, utilisez :

```bash
./mvnw test        # Linux / macOS
mvnw.cmd test     # Windows
```

Recommandé pour :
- garantir la reproductibilité,
- faciliter l’exécution en CI/CD,
- éviter toute dépendance locale à Maven.

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
