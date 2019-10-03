import java.util.Random;

abstract class Monster {

    private String name;
    private int maxDamage;
    private int life = 100;
    private String type = "normal";
    private String[] attacks = {"Coup d'boule", "Gifle", "", ""};


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
        return this.maxDamage;
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

    public String[] getAttacks() {
        return this.attacks;
    }

    public void setAttacks(int index, String attack) {
        this.attacks[index] = attack;
    }


    public abstract int takeHit(Monster attackingMonster, int attack);

}



// De plus, la méthode doit afficher "{name} has {life} points remaining." si le nombre de point de vie est supérieur à zéro, ou "{name} is KO!" sinon.


