public class Ogre extends Creature implements Fighting {

    public Ogre() {
        super("Ogre", 100, 200);
        setHealth(200);
        setStrength(50);
    }

    private void extraAttack(Creature enemy) {
        if ((int) (Math.random() * 4) == 1) {
            enemy.setHealth(enemy.getHealth() - 5);
            System.out.printf("%s throws big rock at you! %s receive wound -5 hp.\n",
                    getName(), enemy.getName());
        }
    }

    @Override
    public void attack(Creature enemy) {
        extraAttack(enemy);
        super.attack(enemy);
    }
}
