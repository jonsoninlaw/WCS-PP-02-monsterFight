class GrassMonster extends Monster {


    public GrassMonster(String monsterName, int maxDamage) {
        super(monsterName, maxDamage);
        this.setType("grass");
        this.setSpecialAttacks(new String[] {"Mauvaise herbe", "Tronc d'arbre dans la tronche"});
    }

    public void takeHit(Monster attackingMonster) {

        int damage = attackingMonster.getDamage();

        if(attackingMonster.getType().equals("fire")) {
            damage = damage*2;   
        }
        else if(attackingMonster.getType().equals("water")) {
            damage = damage/2; 
        }
        this.setLife(this.getLife() -damage);
        System.out.println("\n" + attackingMonster.getName() + " attaque " + this.getName() + ". Il lui inflige " + damage + " points de dégats !");
        
    }
}