import java.util.*;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to  \"Ogre's cave\"!.\n Adventure awaits you!");
        System.out.println("What is the name of your hero:");
        Hero hero = new Hero(scanner.nextLine());
        do {
            System.out.print("""
                    
                    You are in town
                    Where would you go?
                    1. To merchant's shop
                    2. To Tavern
                    3. To dark forest
                    4. To ogre cave
                    5. Check hero hp
                    6. Drink health potion
                    0. Game exit
                    """);
            int command = userInput();
            switch (command) {
                case 1 -> new Merchant(hero).run();
                case 2 -> new Tavern(hero).run();
                case 3 -> new Fight(hero, "forest").run();
                case 4 -> new Fight(hero, "cave").run();
                case 5 -> System.out.print("Hero hp: " + hero.getHealth());
                case 6 -> {if (!hero.backpack.items.isEmpty()){
                    hero.backpack.useItem(hero.healthPotion);
                    hero.setHealth(hero.getHealth()
                            +hero.healthPotion.getIncrement());
                    System.out.println("HP: " + hero.getHealth());}
                else
                    System.out.println("No potions");}
                case 0 -> {
                    System.out.println("Goodbye");
                    return;

                }


                default -> System.out.println(


                        "Choose option 1, 2, 3, 4, 5.\n\n");

            }
        }
        while (hero.getHealth() > 0);
    }


    public static int userInput() {
        Scanner scanner = new Scanner(System.in);
        int command = 0;
        try {
            command = scanner.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println(
                    "Incorrect input! enter number: 1 2 3 4 5.");
        }
        return command;
    }
}




