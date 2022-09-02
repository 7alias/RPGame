public class Goblin extends Creature implements Fighting {

    public Goblin() {
        super("Goblin", 10, 20);
    }


    @Override
    public void attack(Creature enemy) {
        Strengthening strengthening =
                new Strengthening(
                        super.getName(),
                        super.getExperience(),
                        getGold());
        strengthening.strengthening();
        super.attack(enemy);
        strengthening.weakening();
    }
}
