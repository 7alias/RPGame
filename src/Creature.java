public abstract class Creature implements Fighting {
    private final String name;
    private int health;
    private int experience;
    private int strength;
    private int agility;
    private int gold;
    private boolean buff = false;
    private int buffDuration = 0;

    public Creature(String name, int experience, int gold) {
        this.name = name;
        this.health = 100;
        this.experience = experience;
        this.strength = 20;
        this.agility = 25;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public boolean isBuff() {
        return buff;
    }

    public void setBuff(boolean buff) {
        this.buff = buff;
    }

    public int getBuffDuration() {
        return buffDuration;
    }

    public void setBuffDuration(int buffDuration) {
        this.buffDuration = buffDuration;
    }

    @Override
    public void attack(Creature enemy) {
        if (agility * 3 > (int) (Math.random() * 100)) {
            if ((int) (Math.random() * 4) == 1) {
                enemy.health -= strength * 2;
                System.out.println(
                        name + " critical hit " + (strength * 2) + " hp.");
            } else {
                enemy.health -= strength;
                System.out.println(
                        name + " hits " + strength + " hp.");
            }
        } else {
            System.out.println(name + " miss.");
        }
    }
}
