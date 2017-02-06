### Projet Java Android

## Soduku-Java

Le sudoku est fonctionnel, 3 écrans sont proposés à l'utilisateurs :

* le premier pour choisir son niveau
* Le second pour choisir un sudoku parmis ceux proposés
* Le 3ème pour jouer (avec le chrono)

#### Appareil supportés : 
Le Sudoku n'est pas fait de manière responsive, mais fonctionne très bien sur Xperia Z4 Tablet

#### Structure de code :
Une activity par écran, 1 implémentation de View pour la grid.

Pour la gestion des cases, des objets Case(permettant de définir son emplacement), et des objets NumberCase permettent de structurer le code du jeux. Ainsi, la grid est un tableau à deux dimension de case, contenant chacune des NumberCase permettant de définir le contenu ainsi que le type (mis par l'utilisateur ou défini au départ de la grille)

#### Todo list : 
* Base de données SQLite, permettant d'enregistrer les états des parties
* Message lors de la fin du jeu
* Message lorsque placé un chiffre n'est pas possible