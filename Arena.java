import java.util.Random;

class Arena {

    public static void main(String[] args) {

        Monster pikachu = new Monster("Pikachu", 5, 20);
        Monster exagide = new Monster("Exagide", 7, 15);
        Monster[] monsters = {pikachu, exagide};

        System.out.println(pikachu.getName() + " a " + pikachu.getLife() + " points de vie !");
        System.out.println(exagide.getName() + " a " + exagide.getLife() + " points de vie !");
        
        while (pikachu.getLife() > 0 && exagide.getLife() > 0) {
            
            Random randomMon = new Random();
            int chosenMon = randomMon.nextInt(2);
            int notChosen = 0;
            if (chosenMon == 0) {
                notChosen = 1;
            }
            else {
                notChosen = 0;
            }

            attack(monsters[chosenMon], monsters[notChosen]);
            checkKo(monsters[notChosen]);
            if (monsters[notChosen].getLife() <= 0) {
                break;
            }
            
            attack(monsters[notChosen], monsters[chosenMon]);
            checkKo(monsters[chosenMon]);
            
        }
        System.out.println("Le combat est terminé !");
        
        
    }
    
    public static void attack(Monster attackingMonster, Monster attackedMonster) {
        
        int damage = attackingMonster.getDamage();
        attackedMonster.takeHit(damage);
        System.out.println(attackingMonster.getName() + " attaque " + attackedMonster.getName() + ". Il lui inflige " + damage + " points de dégats !");
    }

    public static void checkKo(Monster monster) {

        if (monster.getLife() <= 0) {
            System.out.println(monster.getName() + " est KO !");
        }
        else {
            System.out.println(monster.getName() + " a " + monster.getLife() + " points de vie !");
        }
    }
}



// Créer une classe Arena avec une méthode main(). Instancier deux objets de la classe Monster avec des valeurs au choix, puis les faire combattre jusqu’à ce qu’un des deux soit KO.

// Compiler et tester la classe Arena.