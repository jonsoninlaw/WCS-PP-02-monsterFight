class WaterMonster extends Monster {


    public WaterMonster(String monsterName, int maxDamage) {
        super(monsterName, maxDamage);
        this.setType("water");
        this.setSpecialAttacks(new String[] {"Jet d'eau", "Tsunami"});
    }

    public void takeHit(Monster attackingMonster) {

        int damage = attackingMonster.getDamage();

        if(attackingMonster.getType().equals("grass")) {
            damage = damage*2;   
        }
        else if(attackingMonster.getType().equals("fire")) {
            damage = damage/2; 
        }
        this.setLife(this.getLife() -damage);
        System.out.println("\n" + attackingMonster.getName() + " attaque " + this.getName() + ". Il lui inflige " + damage + " points de dégats !");
        
    }
}