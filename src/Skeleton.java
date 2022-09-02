public class Skeleton extends Creature implements Fighting {

    public Skeleton() {
        super("Skeleton", 10, 20);
    }

    @Override
    public void attack(Creature enemy) {
        Strengthening strengthening = new Strengthening(getName(), getExperience(), getGold());
        strengthening.strengthening();
        super.attack(enemy);
        strengthening.weakening();
    }
}
