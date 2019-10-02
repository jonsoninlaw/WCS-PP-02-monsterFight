import java.util.Random;
import java.util.Scanner;


class Arena {

    static Scanner entree = new Scanner(System.in);
    public static void main(String[] args) {

        String[][] choices = {{"Salamèche", "Pyroli", "Poussifeu", "Bulbizarre", "Boustiflor", "Germignon", "Carapuce", "Poissirène", "Marill"},
        {"feu", "feu", "feu", "herbe", "herbe", "herbe", "eau", "eau", "eau"},
        {"8", "7", "6", "7", "6", "5", "7", "5", "6"}};

        System.out.println("Choisir un pokemon dans la liste ci dessous");

        for ( int i=0; i < choices[0].length; i++) 
        {
            System.out.println("\n" + choices[0][i] + " monstre de type " + choices[1][i]);
        }

        int monsterIndex = - 1;
        while (monsterIndex < 0) {

            String selectedMonster = entree.next();
            for (int i = 0; i < choices[0].length; i++) {
                if (selectedMonster.equals(choices[0][i])) {
                    monsterIndex = i;
                }
            }
            if (monsterIndex < 0) {
                System.out.println("Ce monstre n'est pas disponible !");
            }
        }

        FireMonster firePlayer = new FireMonster(choices[0][monsterIndex], Integer.valueOf(choices[2][monsterIndex]));
        GrassMonster grassPlayer = new GrassMonster(choices[0][monsterIndex], Integer.valueOf(choices[2][monsterIndex]));
        WaterMonster waterPlayer = new WaterMonster(choices[0][monsterIndex], Integer.valueOf(choices[2][monsterIndex]));
        WaterMonster enemy = new WaterMonster("Carapuce", 7);
        Monster[] monsterList= {firePlayer, grassPlayer, waterPlayer};

        if (choices[1][monsterIndex].equals("feu")) {
            fight(monsterList[0], enemy);
        }
        else if (choices[1][monsterIndex].equals("herbe")) {
            fight(monsterList[1], enemy);
        }
        else {
            fight(monsterList[2], enemy);   
        }
        
        
    }
    
    static void fight(Monster player, Monster enemy) {
        
        while (player.getLife() > 0 && enemy.getLife() > 0) {
            
            Random random = new Random();
            int first = random.nextInt(2);

            if (first == 0) {

                enemy.takeHit(player, attack);
                checkLife(enemy);
                if (enemy.getLife() <= 0) {
                    break;
                }
                player.takeHit(enemy);
                checkLife(player);
            }
            else {
                player.takeHit(enemy);
                checkLife(player);
                if (player.getLife() <= 0) {
                    break;
                }
                enemy.takeHit(player);
                checkLife(enemy);
            }  
        }
        
        System.out.println("\nLe combat est terminé !");
        
        
    }
    
    
    public static void checkLife(Monster monster) {
        
        if (monster.getLife() <= 0) {
            System.out.println(monster.getName() + " est KO !");
        }
        else {
            System.out.println(monster.getName() + " a " + monster.getLife() + " points de vie !");
        }
    }

    public static void attack() {
        System.out.println("C'est à votre tour. Quelle attaque " + player.getName() + " doit-il lancer ?");
        System.out.println("1 : " + )
        String attack = entree.next();
    }
}