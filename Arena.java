import java.util.Random;
import java.util.Scanner;


class Arena {

    static Scanner entree = new Scanner(System.in);
    public static void main(String[] args) {

        // String[][] choices = {{"Salamèche", "Pyroli", "Poussifeu", "Bulbizarre", "Boustiflor", "Germignon", "Carapuce", "Poissirène", "Marill"},
        // {"feu", "feu", "feu", "herbe", "herbe", "herbe", "eau", "eau", "eau"},
        // {"8", "7", "6", "7", "6", "5", "7", "5", "6"}};
        FireMonster salameche = new FireMonster("Salamèche", 8);
        FireMonster pyroli = new FireMonster("Pyroli", 7);
        FireMonster poussifeu = new FireMonster("Poussifeu", 6);
        GrassMonster bulbizarre = new GrassMonster("Bulbizarre", 7);
        GrassMonster boustiflor = new GrassMonster("Boustiflor", 6);
        GrassMonster germignon = new GrassMonster("Germignon", 5);
        WaterMonster carapuce = new WaterMonster("Carapuce", 7);
        WaterMonster poissirene = new WaterMonster("Poissirène", 5);
        WaterMonster marill = new WaterMonster("Marill", 6);

        Monster[] monsterList= {salameche, pyroli, poussifeu, bulbizarre, boustiflor, germignon, carapuce, poissirene, marill};


        System.out.println("\n Bienvenue dans l'arène ! Voici la liste des pokémons disponibles :\n");

        for ( int i=0; i < monsterList.length; i++) 
        {
            System.out.println("  " + (i + 1) +": " + monsterList[i].getName() + " monstre de type " + monsterList[i].getType());
        }

        System.out.print("\nVeuillez choisir un des pokemons de la liste : ");
        int monsterIndex = -1;
        String selectedMonster = "";
        while (monsterIndex < 0) {

            selectedMonster = entree.next();
            if(selectedMonster.length() == 1)
            {
                if(selectedMonster.charAt(0) >= 49 &&  selectedMonster.charAt(0) <= 57) {
                    int selectMonster = Integer.valueOf(selectedMonster);
                    for (int i = 0; i < monsterList.length; i++) {
                        if (selectMonster == i + 1) {
                            monsterIndex = i;
                        }
                    }
                }
                else {
                    System.out.print("Ce monstre n'est pas disponible ! : ");
                }
            }
            else {
                System.out.print("Ce monstre n'est pas disponible ! : ");
            }
        }


        Random randomEnemy = new Random();
        int enemyChoice = monsterIndex;
        while (enemyChoice == monsterIndex) {
            enemyChoice = randomEnemy.nextInt(monsterList.length);
        }

        fight(monsterList[monsterIndex], monsterList[enemyChoice]);
        
        
        
    }
    
    static void fight(Monster player, Monster enemy) {
        
        while (player.getLife() > 0 && enemy.getLife() > 0) {
            
            Random random = new Random();
            int first = random.nextInt(2);
            int damage = 0;
            int turn = 1;

            if (first == 0) {

                System.out.println("\n ********************** TOUR N°" + turn + " **********************");
                System.out.printf("\n    %s attaque en premier.\n\n", player.getName());
                int attack = attack(player, enemy);
                System.out.println();
                damage = enemy.takeHit(player, attack);
                checkLife(enemy, damage);
                if (enemy.getLife() <= 0) {
                    break;
                }
                attack = random.nextInt(4);
                damage = player.takeHit(enemy, attack);
                checkLife(player, damage);
                turn++;
            }
            else {

                System.out.println("\n ************************** TOUR N°" + turn + " **************************");
                System.out.printf("\n    %s attaque en premier.\n\n", enemy.getName());
                int attack = random.nextInt(4);
                damage = player.takeHit(enemy, attack);
                checkLife(player, damage);
                if (player.getLife() <= 0) {
                    break;
                }
                attack = attack(player, enemy);
                System.out.println();
                damage = enemy.takeHit(player, attack);
                checkLife(enemy, damage);
                turn++;
            }  
        }
        
        System.out.println("\nLe combat est terminé !");
        
        
    }
    
    
    public static void checkLife(Monster monster, int damage) {
        
        if (monster.getLife() <= 0) {
            System.out.println("   | " + monster.getName() + " est KO !");
            System.out.println("   ---------------------------------------------------------\n");
        }
        else {
            if (damage > 0) {
                System.out.println("   | " + monster.getName() + " prend cher !");
                System.out.println("   ---------------------------------------------------------\n");
            }
            else {
                System.out.printf("   | %s éclate de rire !\n", monster.getName());
                System.out.println("   ---------------------------------------------------------\n");
            }
        }
    }

    public static int attack(Monster player, Monster enemy) {
        System.out.printf("    %s : %s PV\n", player.getName(), player.getLife());
        System.out.printf("    %s : %s PV\n", enemy.getName(), enemy.getLife());
        System.out.print("\n    Voici les attaques de " + player.getName() + " :");
        System.out.println("\n      1 : " + player.getAttacks()[0] + "     3 : " + player.getAttacks()[2] + "\n      2 : " + player.getAttacks()[1] + "            4 : " + player.getAttacks()[3]);
        System.out.print("\nQuelle attaque doit-il lancer ? : ");
        String answer = "";
        int attack = -1;
        while (attack == -1) {
            answer = entree.next();
            if (answer.length() != 1) {
                System.out.print("\nVeuillez choisir une attaque que " + player.getName() + " connaît ! : ");
                answer = "0";
            }
            switch (answer.charAt(0)) {
                case '0':
                    break;
                case '1' :
                    attack = 0;
                    break;
                case '2' :
                    attack = 1;
                    break;
                case '3' :
                    attack = 2;
                    break;
                case '4' :
                    attack = 3;
                    break;
                default :
                    System.out.print("\nVeuillez choisir une attaque que " + player.getName() + " connaît ! : ");
            }
        }
        return attack;
    }
}