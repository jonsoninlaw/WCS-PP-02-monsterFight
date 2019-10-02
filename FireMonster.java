class FireMonster extends Monster {


    public FireMonster(String monsterName, int maxDamage) {
        super(monsterName, maxDamage);
        this.setType("fire");
        this.setSpecialAttacks(new String[] {"Flamme", "Armageddon"});
    }

    public void takeHit(Monster attackingMonster) {

        int damage = attackingMonster.getDamage();

        if(attackingMonster.getType().equals("water")) {
            damage = damage*2;   
        }
        else if(attackingMonster.getType().equals("grass")) {
            damage = damage/2; 
        }
        this.setLife(this.getLife() -damage);
        System.out.println("\n" + attackingMonster.getName() + " attaque " + this.getName() + ". Il lui inflige " + damage + " points de dégats !");
        
    }
}