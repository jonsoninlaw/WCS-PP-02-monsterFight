import java.util.Random;

class FireMonster extends Monster {


    public FireMonster(String monsterName, int maxDamage) {
        super(monsterName, maxDamage);
        this.setType("fire");
        this.setAttacks(2, "Flamme");
        this.setAttacks(3, "Armageddon");
    }

    public int takeHit(Monster attackingMonster, int attack) {

        int damage = attackingMonster.getDamage() * (attack + 1);

        int[] proba = {1,1,1,1};

        if(attack>=1) {
             proba[0] = 0;
        }
        if(attack>=2) {
            proba[1] = 0;
        }
        if(attack>=3) {
            proba[2] = 0;
        }
        
        Random random = new Random();
        int j = random.nextInt(proba.length);
        int coeff = proba[j];

        damage = damage*coeff;

        if(attackingMonster.getType().equals("water")) {
            damage = damage*2;   
        }
        else if(attackingMonster.getType().equals("grass")) {
            damage = damage/2; 
        }
        if(damage > this.getLife()){
            damage = this.getLife();
        }

        this.setLife(this.getLife() -damage);

        if(damage>0) {
            System.out.println("\n    " + attackingMonster.getName() + " lance " + attackingMonster.getAttacks()[attack] + ". " + this.getName() + " perd " + damage + " points de vie !");
        }
        else {
            System.out.printf("\n    %s lance %s. Il rate son attaque !\n", attackingMonster.getName(), attackingMonster.getAttacks()[attack]);
        }

        return damage;
        
    }
}