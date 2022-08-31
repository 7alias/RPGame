public class Tavern implements Runnable {

    Hero hero;
int beerPrice = 50;

    public Tavern(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void run() {
        while (true) {
            System.out.printf("""
                    You are in a Tavern <Drunk Goblin>.
                    Gold balance: %d .
                    What would you like to do?
                    1. Drink beer (50 gold) and gain power
                    2.Return to town
                    """, hero.getGold());

            int command = Main.userInput();
            switch (command) {
                case 1 -> {

                    if (beerPrice < hero.getGold()) {
                        hero.setStrength(hero.getStrength() + 10);
                        hero.setAgility(hero.getAgility() - 3);

                        hero.setGold(hero.getGold()-beerPrice);
                        System.out.println("Received alcohol power.");
                    } else {
                        System.out.println("You don't have enough gold!\n");
                    }
                }
                case 2 -> {
                    return;
                }

                default -> System.out.println("""
                        Incorrect input!
                        Choose option: 1 or 2.
                        """);
            }
        }
    }
}
