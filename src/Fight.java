public class Fight implements Runnable {
    Hero hero;
    Hero.Backpack backpack;
    String location;

    public Fight(Hero hero, String location) {
        this.hero = hero;
        this.location = location;
        this.backpack = hero.backpack;
    }

    @Override
    public void run() {
        while (true) {
            Creature enemy;
            if (location.equals("forest")) {
                if ((int) (Math.random() * 3) == 1) {
                    enemy = new Skeleton();
                } else {
                    enemy = new Goblin();
                }
            } else {
                enemy = new Ogre();
            }
            System.out.println(enemy.getName() + " stands in front of you. Battle begins!");
            System.out.println("hp remaining: " + hero.getHealth() + " Strength: " + hero.getStrength() +" Agility:"+ hero.getAgility() );
            boolean isAlive = true;
            int count = 1;
            while (isAlive) {
                System.out.printf("-------[Move %d]-------\n", count);
                System.out.printf("""
                        Your move:
                        1. Attack
                        2. Drink health potion 
                        3. Use a scroll of power
                        """);
                switch (Main.userInput()) {
                    case 1 -> hero.attack(enemy);
                    case 2 -> {hero.healthPotion.use(hero); hero.backpack.useItem(hero.healthPotion); }
                    case 3 -> {hero.scrollOfPower.use(hero); hero.backpack.useItem(hero.scrollOfPower);}
                    default -> System.out.println("Select option: 1, 2, 3");
                }
                ((Fighting) enemy).attack(hero);
                if (enemy.getHealth() > 0 && hero.getHealth() > 0) {
                    System.out.println("-<<<Result>>>-");
                    System.out.printf("Health of %s : %d . Strength %d . Agility %d .\n",
                            enemy.getName(), enemy.getHealth(), enemy.getStrength(), enemy.getAgility());
                    System.out.printf("Health of %s : %d . Strength %d . Agility %d .\n",
                            hero.getName(), hero.getHealth(), hero.getStrength(), hero.getAgility());
                    System.out.println("-<>-");
                    count++;
                    if (hero.isBuff() && hero.getBuffDuration() > 1) {
                        hero.setBuffDuration(hero.getBuffDuration() - 1);
                    } else if (hero.isBuff() && hero.getBuffDuration() == 1) {
                        hero.setBuff(false);
                        hero.setBuffDuration(hero.getBuffDuration() - 1);
                        hero.setStrength(hero.getStrength() - hero.scrollOfPower.getIncrement());
                    }
                } else if (enemy.getHealth() <= 0 && hero.getHealth() > 0) {
                    System.out.println("-<<<Result>>>-");
                    System.out.printf("%s win.\n", hero.getName());
                    System.out.printf("Received %d gold и %d experience.\n", enemy.getGold(), enemy.getExperience());
                    System.out.println("****************************");
                    hero.setGold(hero.getGold() + enemy.getGold());
                    hero.setExperience(hero.getExperience() + enemy.getExperience());
                    isAlive = false;
                } else {
                    System.out.println("-<<<Result>>>-");
                    System.out.printf("%s die.\n", hero.getName());
                    System.out.println("****************************");
                    isAlive = false;
                }
            }
            if (hero.getHealth() > 0) {
                if (hero.getExperience() >= hero.getLevelCap()) {
                    int increment = 3;
                    hero.setLevel(hero.getLevel() + 1);
                    hero.setHealthCap(hero.getHealthCap() + increment * 10);
                    hero.setHealth(hero.getHealthCap());
                    hero.setLevelCap(hero.getLevelCap() * 2);
                    hero.setStrength(hero.getStrength() + increment);
                    hero.setAgility(hero.getAgility() + increment);
                    System.out.printf("%s new level %d! Strength and agility increased by %d . Health: %d\n",
                            hero.getName(), hero.getLevel(), increment, hero.getHealth());
                    System.out.println("****************************");
                }
                System.out.print("Where would you go next?\n1. " +
                        "Return to town\n2. " +
                        "Resume fighting\n");
                if (location.equals("forest")) {
                    System.out.println("3. Go to Ogre cave:");
                } else {
                    System.out.println("3. Go to dark forest:");
                }
                int command = Main.userInput();
                switch (command) {
                    case 1 -> {
                        return;
                    }
                    case 2 -> {
                        if (location.equals("cave")) {
                            location = "forest";
                        }
                    }
                    case 3 -> {
                        if (location.equals("forest")) {
                            location = "cave";
                        }
                    }
                }
            } else {
                break;
            }
        }
    }
}
