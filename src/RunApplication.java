import java.util.Scanner;

public class RunApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Select the console type");
        System.out.println("1) PS5");
        System.out.println("2) XBOX");
        System.out.println("3) SWITCH");
        System.out.println();

        int choice = 0;
        while (choice < 1 || choice > 3) {
            try {
                choice = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                choice = 0;
            }
            if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice. Please enter 1, 2 or 3:");
            }
        }

        String consoleType;
        switch (choice) {
            case 1:  consoleType = "PS5";    break;
            case 2:  consoleType = "XBOX";   break;
            default: consoleType = "SWITCH"; break;
        }

        System.out.print("Enter the store: ");
        String store = input.nextLine();

        int totalSales = -1;
        while (totalSales < 0) {
            System.out.print("Enter the total sales of " + consoleType
                    + " consoles for " + store + ": ");
            try {
                totalSales = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                totalSales = -1;
            }
            if (totalSales < 0) {
                System.out.println("Please enter a valid whole number.");
            }
        }

        ConsoleSales sales = new ConsoleSales(consoleType, store, totalSales);
        sales.printReport();

        input.close();
    }
}

