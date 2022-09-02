public class Strengthening extends Creature implements Fighting {
    public Strengthening(String name, int experience, int gold) {
        super(name, experience, gold);
    }

    public void strengthening() {
        if ((int) (Math.random() * 4) == 1) {
            if (isBuff()) {
                setBuffDuration(getBuffDuration() + 1);
                System.out.printf(
                        "%s extends agility gain for 1 move.\n", getName());
            } else {
                setBuff(true);
                setBuffDuration(getBuffDuration() + 1);
                setAgility(getAgility() + 30);
                System.out.printf("%s agility gained by 30 for 2 moves.\n",
                        getName());
            }
        }
    }

    public void weakening() {
        if (getBuffDuration() > 0) {
            setBuffDuration(getBuffDuration() - 1);
        } else if (isBuff()) {
            setBuff(false);
            setAgility(getAgility() - 30);
            System.out.println("Agility gain is over.");
        }
    }
}
