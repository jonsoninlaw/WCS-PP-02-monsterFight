import java.util.Random;

class Monster {

    private String name;
    private int maxDamage;
    private int life;

    public Monster(String monsterName, int maxDamage, int monsterLife) {
        this.name = monsterName;
        this.maxDamage = maxDamage;
        this.life = monsterLife;
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

    public void takeHit(int enemyDamage) {
        this.life -= enemyDamage;

    }

}



// De plus, la méthode doit afficher "{name} has {life} points remaining." si le nombre de point de vie est supérieur à zéro, ou "{name} is KO!" sinon.


