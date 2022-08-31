import java.util.*;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to  \"Ogre cave game\"!.\n Adventure awaits you!");
        System.out.println("What is the name of your hero:");
        Hero hero = new Hero(scanner.nextLine());
        do {
            System.out.print("""
                    You are in town
                    Where would you go?
                    1. To merchant's shop
                    2. To dark forest
                    3. To ogre cave
                    4. Game exit
                    """);
            int command = userInput();
            switch (command) {
                case 1 -> new Merchant(hero).run();
                case 2 -> new Fight(hero, "forest").run();
                case 3 -> new Fight(hero, "cave").run();
                case 4 -> {
                    return;
                }
                default -> System.out.print("Hero hp:" + hero.getHealth()+
                        "Choose option 1, 2, 3, 4.\n\n");
            }
        } while (hero.getHealth() > 0);
    }

    public static int userInput() {
        Scanner scanner = new Scanner(System.in);
        int command = 0;
        try {
            command = scanner.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println(
                    "Incorrect input! enter number.");
        }
        return command;
    }
}





