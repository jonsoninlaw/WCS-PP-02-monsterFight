import java.util.Random;

abstract class Monster {

    private String name;
    private int maxDamage;
    private int life = 30;
    private String type = "normal";
    private String[] normalAttacks = {"Coup d'boule", "Gifle"};
    private String[] specialAttacks = {"", ""};


    public Monster(String monsterName, int maxDamage) {
        this.name = monsterName;
        this.maxDamage = maxDamage;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String monsterName) {
        this.name = monsterName;
    }

    public int getDamage() {
        Random damage = new Random();
        return damage.nextInt(maxDamage);
    }

    public void setDamage(int monsterDamage) {
        this.maxDamage = monsterDamage;
    }

    public int getLife() {
        return this.life;
    }

    public void setLife(int monsterLife) {
        this.life = monsterLife;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String monsterType) {
        this.type = monsterType;
    }

    public String[] getNormalAttacks() {
        return this.normalAttacks;
    }

    public void setNormalAttacks(String[] normalAttacks) {
        this.normalAttacks = normalAttacks;
    }

    public String[] getSpecialAttacks() {
        return this.specialAttacks;
    }

    public void setSpecialAttacks(String[] specialAttacks) {
        this.specialAttacks = specialAttacks;
    }

    public abstract void takeHit(Monster attackingMonster);

}



// De plus, la méthode doit afficher "{name} has {life} points remaining." si le nombre de point de vie est supérieur à zéro, ou "{name} is KO!" sinon.


