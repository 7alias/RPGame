public class Merchant implements Runnable {
    Hero hero;
    HealthPotion healthPotion;
    ScrollOfPower scrollOfPower;

    public Merchant(Hero hero) {
        this.hero = hero;
        this.healthPotion = hero.healthPotion;
        this.scrollOfPower = hero.scrollOfPower;
    }

    static class HealthPotion extends Bag {
        public HealthPotion() {
            super("Health potion", 50);
        }

        public HealthPotion(int quantity) {
            super("Health potion", 50);
            this.setQuantity(quantity);
        }

        @Override
        void use(Hero hero) {
            if (hero.healthPotion.getQuantity() > 0) {
                if (hero.getHealth() + getIncrement() <= hero.getHealthCap()) {
                    hero.setHealth(hero.getHealth() + getIncrement());
                    setQuantity(getQuantity() - 1);
                    System.out.printf("%s cures by %d points.\n", hero.getName(), getIncrement());
                } else {
                    System.out.printf("%s cures by %d points.\n",
                            hero.getName(), hero.getHealthCap() - hero.getHealth());
                    hero.setHealth(hero.getHealthCap());
                    setQuantity(getQuantity() - 1);
                }
            } else {
                System.out.println("Potions are over!");
            }
        }
    }

    static class ScrollOfPower extends Bag {

        public ScrollOfPower() {
            super("Scroll of power", 10);
        }

        public ScrollOfPower(int quantity) {
            super("Scroll of power", 10);
            this.setQuantity(quantity);
        }

        @Override
        void use(Hero hero) {
            if (hero.scrollOfPower.getQuantity() > 0) {
                hero.setStrength(hero.getStrength() + getIncrement());
                setQuantity(getQuantity() - 1);
                System.out.printf("%s increase strength by %d points.\n", hero.getName(), getIncrement());
            } else {
                System.out.println("Scrolls are over!");
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            System.out.printf("""
                    You are in a trading shop.
                    Gold balance: %d .
                    What would you like to do?
                    1.Buy health potion (20 gold)
                    2.Buy scroll of power (35 gold)
                    3.Check bag
                    4.Return to town
                    """, hero.getGold());

            int command = Main.userInput();
            switch (command) {
                case 1 -> {
                    int healingPotionPrice = 20;
                    if (hero.getGold() - healingPotionPrice >= 0) {
                        healthPotion.setQuantity(healthPotion.getQuantity() + 1);
                        hero.backpack.addItem(new HealthPotion(1));
                        hero.setGold(hero.getGold() - healingPotionPrice);
                        System.out.println("Received health potion.");
                    } else {
                        System.out.println("You don't have enough gold!\n");
                    }
                }
                case 2 -> {
                    int scrollOfPowerPrice = 35;
                    if (hero.getGold() - scrollOfPowerPrice >= 0) {
                        scrollOfPower.setQuantity(scrollOfPower.getQuantity() + 1);
                        hero.backpack.addItem(new ScrollOfPower(1));
                        hero.setGold(hero.getGold() - scrollOfPowerPrice);
                        System.out.println("Received scroll of power.\n");
                    } else {
                        System.out.println("You don't have enough gold!");
                    }
                }
                case 3 -> hero.showItems();
                case 4 -> {
                    return;
                }
                default -> System.out.println("""
                        Incorrect input!
                        Choose option: 1, 2, 3,  4.
                        """);
            }
        }
    }

}
